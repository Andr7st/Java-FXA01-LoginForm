package org.andr7st.fx;
/**
 * @author Andrés Segura
 * */
// https://github.com/Andr7st/index/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
      //  Parent root = FXMLLoader.load(getClass().getResource("vista/LoginScene.fxml"));

      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/andr7st/fx/vista/LoginScene.fxml")));


        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 320,500));
        primaryStage.setResizable(false);
        Main.agregarIcono(primaryStage, "vista/favicon.png");
        primaryStage.show();
    }

    public static void agregarIcono(Stage stage, String srcIcon) {
        // Agregar Icono a la ventana, si el icono no lo encuentra simplemente carga el default poner error.
        try {
            stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream(srcIcon))));
        } catch (Exception ex) { //..

        }
    }
}
