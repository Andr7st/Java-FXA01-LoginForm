package org.andr7st.fx.controls;
/**
 * @author Andrés Segura
 * */
// https://github.com/Andr7st/index/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.text.Font;

public class LoginControl implements Initializable {

    @FXML private ImageView      imgImagen       ;
    @FXML private Pane           root            ;
    @FXML private Label          lblAndr7st      ;
    @FXML private Label          lblUsername     ;
    @FXML private Label          lblPassword     ;
    @FXML private Label          lblProjectID    ;
    @FXML private PasswordField  campoContrasena ;
    @FXML private TextField      campoUsuario    ;
    @FXML private Button         btnIngresar     ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Agregar css al Panel actual.
        this.root.getStylesheets().add("/org/andr7st/fx/vista/LoginScene.css");

        // Agregar imagen, la imagen queda dentro del código/src.

        try {

            this.imgImagen.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/org/andr7st/fx/vista/Logo.png"))));
        }
        catch (Exception e) {
            //..
        }


        // Fuentes/tipografías.
        String srcFuente  = "file:rsrc/fonts/NotoSans-Regular.ttf";
        String srcFuente1 = "file:rsrc/fonts/NotoSans-SemiBold.ttf";

        Font forLabels = Font.loadFont(srcFuente,12);

        this.btnIngresar.setText("Ingresar");
        this.btnIngresar.setFont(Font.loadFont(srcFuente,11));

        // Agregando tipografia:
        this.lblAndr7st   .setFont(Font.loadFont(srcFuente1,11));
        this.lblUsername  .setFont(forLabels);
        this.lblPassword  .setFont(forLabels);
        this.lblProjectID .setFont(forLabels);

        //
        this.lblAndr7st   .setText("By Andrés Segura.");
        this.lblUsername  .setText("Usuario");
        this.lblPassword  .setText("Contraseña");
        this.lblProjectID .setText("Project ID: Java-FXA01");

    }

    public void ingresar(ActionEvent event) throws Throwable {

        new AccionLogin(this.campoUsuario.getText(),  this.campoContrasena .getText(), event);
    }

    protected static void errorAlert(String error, String mensaje) {

        // Alerta
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(error);
        alert.setTitle(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
