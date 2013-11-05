package fetcher;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.mype.prismandr.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Vitaliy Gerya
 */
public class CompleteFetcher {
    private final static Logger logger = LoggerFactory.getLogger(CompleteFetcher.class);
    @Inject
    private PrismaticService service;

    private String basedir = "./";

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PrismaticModule());
        CompleteFetcher fetcher = injector.getInstance(CompleteFetcher.class);
        fetcher.fetchAll();
    }

    private void fetchAll() {
        UserCredential user = null;
        try {
            user = service.readUserHomeCredentials();
        } catch (IOException e) {
            logger.error("Unable to read user credential.", e);

            return;
        }

        Session session;
        try {
            session = service.login(user);
        } catch (PrismaticAuthenticationException ex) {
            logger.error("Can not login.", ex);
            return;
        }

        int requestCount = 0;
        int failedRequestCount = 0;
        NextRequest request = null;
        while (true) {
            File file = createFile(request);
            try {
                try (BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream(file));) {
                    Post post = service.fetch(session, request);
                    request = post.getNext();
                    baos.write(service.convertToJson(post).getBytes());
                    baos.flush();
                }
            } catch (Exception ex) {
                logger.error("error posting {}", request);
                try (BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream(new File(file.getName()
                                                                                                            .replace(".json", ".log"))));) {
                    baos.write(ex.getMessage().getBytes());
                    baos.write("\n".getBytes());
                    baos.write(ex.getCause().getMessage().getBytes());
                    baos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ex.printStackTrace();
                failedRequestCount++;
            }
            requestCount++;

            System.out.println("Success=" + requestCount + " Failed=" + failedRequestCount);

            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException ignore) {

            }
        }
    }

    private File createFile(final NextRequest request) {
        final String fileName;
        if (request == null) {
            fileName = "prism-init.json";
        } else {
            fileName = "prism-" + request.getQueryParams().getFirstArticleIdx() + "-" + request.getQueryParams()
                                                                                               .getLastArticleIdx() + "-[" + request
                    .getQueryParams().getLastFeedID() + "].json";
        }

        return new File(basedir, fileName);
    }
}
