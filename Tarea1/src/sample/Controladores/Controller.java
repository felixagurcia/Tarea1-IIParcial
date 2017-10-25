package sample.Controladores;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Modelos.Persona;

import javax.swing.*;

public class Controller {
    public TextField txtNombre;
    public TextField txtBuscar;
    public TextField txtApellido;
    public TextField txtEdad;
    public Button boton;


    private Persona buscarPorNombre(ActionEvent actionEvent) {
        return Persona.buscarPorNombre(txtBuscar.getText());
    }

    public void buscarPersona(ActionEvent actionEvent) {
        Persona persona = this.buscarPorNombre(actionEvent);
        if (persona!=null) {
            txtNombre.setText(persona.nombre);
            txtApellido.setText(persona.apellido);
            txtEdad.setText(String.valueOf(persona.edad));
            deshabilitarCampos();
        }else {
            JOptionPane.showMessageDialog(null,"El nombre "+txtBuscar.getText()+" no existe");
            campoVacio();
        }
    }


    private void deshabilitarCampos(){
        txtApellido.setDisable(true);
        txtNombre.setDisable(true);
        txtEdad.setDisable(true);
    }
    private void campoVacio() {
        txtBuscar.clear();
    }
}

