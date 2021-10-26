/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agendafx.controller;

import agendafx.model.domain.Contacto;
import agendafx.model.repository.ContactoRepository;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author enzom
 */
public class AgendaFXMLController implements Initializable {

    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TextField txtBuscador;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<Contacto> tbvContactos;
    
    // Instancia del repositorio
    ContactoRepository repo = new ContactoRepository();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbvContactos.getItems().addAll((List<Contacto>)repo.all());
    }    

    @FXML
    private void nuevoOnAction(ActionEvent event) {
    }

    @FXML
    private void editarOnAction(ActionEvent event) {
    }

    @FXML
    private void borrarOnAction(ActionEvent event) {
    }

    @FXML
    private void buscarOnAction(ActionEvent event) 
    {
        String text = txtBuscador.getText().trim(); // Obtener el texto en el buscador
        tbvContactos.getItems().clear(); // Limpiar el table
        tbvContactos.getItems().addAll((List<Contacto>)repo.findBy(text)); // Mostrar los contactos que coincidan con la búsqueda
        txtBuscador.selectAll(); // Seleccionar todos los rows del table
    }
}
