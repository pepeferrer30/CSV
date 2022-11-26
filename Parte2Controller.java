
package entregables4;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Parte2Controller implements Initializable {

    @FXML
    private TextField areaQuery;
    @FXML
    private TextArea AreaMostrar;
    @FXML
    private Button botonMostrar;
    
    ArrayList<Libro> almaLibrosql = new ArrayList();
    LibrosModel lm = new LibrosModel();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void mostrarConsulta(ActionEvent event) throws SQLException {
        AreaMostrar.clear();
        try {

            String consultabaja = areaQuery.getText().toLowerCase();
            if (consultabaja.startsWith("select")) {
                almaLibrosql = lm.MostrarTodo(areaQuery.getText());
                if (almaLibrosql.isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText("Error");
                    a.setContentText("La consulta está mal o está vacia la tabla de datos");
                    a.showAndWait();

                } else {
                    for (Libro l : almaLibrosql) {
                        AreaMostrar.setText(AreaMostrar.getText() + l.toString() + "\n");

                    }

                }

            } else if (consultabaja.startsWith("insert") || consultabaja.startsWith("delete") || consultabaja.startsWith("update")) {
                lm.ejecutar( areaQuery.getText());

            } else {

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Error");
                a.setContentText("La consulta está mal");
                a.showAndWait();

            }

        } catch (Exception e) {

        }

    }

}
