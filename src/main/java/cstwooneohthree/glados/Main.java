package cstwooneohthree.glados;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import cstwooneohthree.glados.components.MainWindow;
import cstwooneohthree.glados.enums.UiType;

/**
 * A GUI for Glados using FXML.
 */
public class Main extends Application {

    private Glados duke = new Glados(UiType.GRAPHICAL_USER_INTERFACE);

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setGlados(duke);  // inject the Glados instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
