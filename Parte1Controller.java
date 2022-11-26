

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Parte1Controller implements Initializable {

    @FXML
    private TextField ruta;
    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoContrasenya;
    @FXML
    private TextField campoDelimitador;
    @FXML
    private Button botonInsertarBDD;
    @FXML
    private Button botonImportar;
    LibrosModel lm=new LibrosModel();
    ArrayList<Libro>almaLibro=new ArrayList();
    ArrayList<Libro>almaLibrosql=new ArrayList();
    String consulta="SELECT * FROM libro";
    @FXML
    private TextArea areaMostrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       almaLibrosql=lm.MostrarTodo(consulta);
        
        for(Libro l:almaLibrosql){
            areaMostrar.setText(areaMostrar.getText()+l.toString()+"\n");
        
        }
    }    

    @FXML
    private void insertarMSQL(ActionEvent event) throws SQLException {
        DBUtil.getDBUtil().nombreUsuario=campoUsuario.getText();
        DBUtil.getDBUtil().password=campoContrasenya.getText();
        lm.insertarBDD(almaLibro);
        
        
        
    }

    @FXML
    private void importarCSV(ActionEvent event) {
        try{
            char caracter=campoDelimitador.getText().charAt(0);
        almaLibro=lm.importarCSV(caracter,ruta.getText());
        
        
        }catch(Exception e){
        
        }
        
        
        
    }
    
}
