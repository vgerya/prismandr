package fetcher;

import com.google.inject.AbstractModule;
import edu.mype.prismandr.client.PrismaticService;
import edu.mype.prismandr.service.Prismatic;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PrismaticService.class).annotatedWith(Prismatic.class).to(PrismaticService.class);
    }
}
