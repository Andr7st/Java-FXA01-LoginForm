package org.andr7st.fx.controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class Scena1Control implements Initializable {

    @FXML private AnchorPane  root        ;
    @FXML private Label       lblProjectID;
    @FXML private Label       lblAndr7st  ;
    @FXML private TextArea    taAreaTexto ;
    @FXML private Button      btnMensaje  ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Agregar css al Panel actual.
        this.root.getStylesheets().add("/org/andr7st/fx/vista/LoginScene.css");

        //
        String srcFuente  = "file:rsrc/fonts/NotoSans-Regular.ttf";
        String srcFuente1 = "file:rsrc/fonts/NotoSans-SemiBold.ttf";
        String srcFuente2 = "file:rsrc/fonts/NotoSans-SemiCondensedExtraBoldItalic.ttf";

        this.lblProjectID .setFont(Font.loadFont(srcFuente ,12));
        this.lblAndr7st   .setFont(Font.loadFont(srcFuente1,12));
        this.taAreaTexto.  setFont(Font.loadFont(srcFuente2,28));

    }

    @FXML
    private void mensajear(ActionEvent event) {

        switch (Scena1Control.pulsacion) {
            case 0:  this.setLblTexto("Hola Mundo!!!");       break;
            case 1:  this.setLblTexto("mi nombre es");        break;
            case 2:  this.setLblTexto("Andrés Segura");       break;
            case 3:  this.setLblTexto("y estoy practicándo"); break;
            case 4:  this.setLblTexto("interfaces UI/GUI");   break;
            case 5:  this.setLblTexto("en el lenguaje ");     break;
            case 6:  this.setLblTexto("de programación ");    break;
            case 7:  this.setLblTexto("Java con OpenJDK ");   break;
            case 8:  this.setLblTexto("https://github.com/Andr7st/index");   break;

            default :
                this.taAreaTexto.setText("JavaFX");
                Scena1Control.pulsacion = 0;
                break;
        }

    }

    public static int pulsacion = 0;

    private void setLblTexto(String txt) {
        this.taAreaTexto.setText(txt);
        Scena1Control.pulsacion++;
    }
}
