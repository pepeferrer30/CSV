/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package entregables4;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insertarMSQL(ActionEvent event) throws SQLException {
        for(Libro l:almaLibro){
        lm.insertarBDD(l);
        }
        
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
