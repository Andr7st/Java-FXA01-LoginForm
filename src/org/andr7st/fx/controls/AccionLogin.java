package org.andr7st.fx.controls;
/**
 * @author Andrés Segura
 * */
// https://github.com/Andr7st/index/
import javafx.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AccionLogin {

    public AccionLogin(String usuario, String contrasena, ActionEvent event) throws Throwable {

        //// MD5 ya es "fácilmente" reversible: https://md5.gromweb.com/ yo usaría otra encriptación en otro caso.
        //   pex = expected password - uex = expected username
        String pex = "dc788d7d68ac223be5e14a57980908ac", uex = "6eea9b7ef19179a06954edd0f6c05ceb";

        if((getHash(usuario,"MD5")).equals(pex) && (getHash(contrasena,"MD5")).equals(uex)) {

            // cambiar a la escena de ingreso
            new SceneController().switchSceneLogin(event);
        }
        else {
            //
            java.awt.Toolkit.getDefaultToolkit().beep();
            LoginControl.errorAlert("Credenciales incorrectos!!!", "usuario y/o contraseña incorrectos.");

        }
    }


    private String getHash(String txt, String hashType) {

        try {

            MessageDigest md = MessageDigest.getInstance(hashType);
            byte[] arr = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < arr.length; ++i) {
                sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {

            System.err.println(e.getMessage());
        }

        return null;
    }
}