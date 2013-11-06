package edu.mype.prismandr.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Vitaliy Gerya
 */
public class PrismaticFX extends Application {
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        Pane pane = new Pane();

        pane.getChildren().add(new TextArea("textArea"));

        Scene scene = SceneBuilder.<SceneBuilder>create().width(800).height(600).root(pane).build();

        stage.setScene(scene);
        stage.show();
    }
}
