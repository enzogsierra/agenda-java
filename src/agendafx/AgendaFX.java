package agendafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * author alexander baikalov
 */
public class AgendaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("view/AgendaFXML.fxml"));
        
        Scene scene = new Scene(root);

        stage.setTitle("Agenda con Java y MySQL");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }

}