package org.andr7st.fx.controls;
/**
 * @author Andrés Segura
 * */
// https://github.com/Andr7st/index/
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchSceneLogin(ActionEvent event) throws IOException {

        //Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/andr7st/fx/vista/Scena1.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 514, 280);
        stage.setScene(scene);
        stage.setTitle("Andr7st");
        stage.setResizable(false);

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

        stage.show();
    }
}
