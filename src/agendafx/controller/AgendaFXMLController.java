package agendafx.controller;

import agendafx.model.domain.Contacto;
import agendafx.model.dto.ContactoDTO;
import agendafx.model.repository.ContactoRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * author alexander baikalov
 */
public class AgendaFXMLController implements Initializable {

    private NuevoContactoController nuevoContactoController;
    private EditarContactoController editarContactoController;

    @FXML
    private TextField txtBuscador;
    @FXML
    public TableView<Contacto> tbvContactos;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    public TableView tvContactos;

    // Instancia del repositorio
    ContactoRepository repo = new ContactoRepository();



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbvContactos.getItems().addAll((List<Contacto>)repo.all());

        btnEditar.setDisable(true);
        btnBorrar.setDisable(true);

        tbvContactos.setOnMouseClicked(event -> {
            if (tbvContactos.getSelectionModel().getSelectedIndex() != -1) {
                btnEditar.setDisable(false);
                btnBorrar.setDisable(false);
            }


                });
    }    

    @FXML
    private void nuevoOnAction(ActionEvent event) {
        // Mostrar formulario de nuevo contacto
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agendafx/view/NuevoContacto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            nuevoContactoController = loader.getController();
            nuevoContactoController.setParent(this);

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    private void editarOnAction(ActionEvent event) {
        // Mostrar formulario de nuevo contacto

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agendafx/view/EditarContacto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            List<ContactoDTO> contactos = (List<ContactoDTO>) repo.all();
            /*tbvContactos.getItems().remove(contactos.get(tbvContactos.getSelectionModel().getSelectedIndex()));
            repo.delete(contactos.get(tbvContactos.getSelectionModel().getSelectedIndex()));*/

            editarContactoController = loader.getController();
            editarContactoController.setParent(this, contactos.get(tbvContactos.getSelectionModel().getSelectedIndex()));

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void borrarOnAction(ActionEvent event) {

        List<ContactoDTO> contactos = (List<ContactoDTO>) repo.all();
        tbvContactos.getItems().remove(contactos.get(tbvContactos.getSelectionModel().getSelectedIndex()));
        repo.delete(contactos.get(tbvContactos.getSelectionModel().getSelectedIndex()));

        ContactoRepository contactoRepository = new ContactoRepository();
        tbvContactos.getItems().clear();
        tbvContactos.getItems().addAll((List<Contacto>) contactoRepository.all());
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
