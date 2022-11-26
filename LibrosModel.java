/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregables4;

import com.csvreader.CsvReader;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joan_2k2
 */
public class LibrosModel extends DBUtil {

    public ArrayList<Libro> mostrarTodo() {
        ArrayList<Libro> alma = new ArrayList();
        try {
            PreparedStatement smt = this.getConexion().prepareStatement("SELECT titulo,autor,anyo_nacimiento,anyo_publicado,editorial,numero_de_paginas FROM libro");
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String anyo_publicado = rs.getString("anyo_publicado");
                String anyo_nacimiento = rs.getString("anyo_nacimiento");
                String editorial = rs.getString("editorial");
                String numero_de_paginas = rs.getString("numero_de_paginas");
                Libro l = new Libro(titulo, autor, anyo_nacimiento, anyo_publicado, editorial, numero_de_paginas);
                alma.add(l);

            }

        } catch (Exception e) {

        }

        return alma;
    }

    public ArrayList<Libro> importarCSV(char caracter, String archivo) {
        ArrayList<Libro> alma = new ArrayList();
        try {
            CsvReader leerLibros = new CsvReader(archivo);
                leerLibros.readHeaders();
            leerLibros.setDelimiter(caracter);

            while (leerLibros.readRecord()) {
                String titulo = leerLibros.get(0);
                String autor = leerLibros.get(1);
                String anyo_nacimiento = leerLibros.get(2);
                String anyo_publicado = leerLibros.get(3);
                String editorial = leerLibros.get(4);
                String num_paginas = leerLibros.get(5);

                alma.add(new Libro(titulo, autor, anyo_nacimiento, anyo_publicado, editorial, num_paginas));
            }

            leerLibros.close();

        } catch (Exception e) {

        }

        return alma;
    }

    public void insertarBDD(Libro l) throws SQLException {
       
        try{
         PreparedStatement smt = this.getConexion().prepareStatement("INSERT INTO libro titulo,autor,anyo_nacimiento,anyo_publicado,editorial,numero_de_paginas values(?,?,?,?,?,?)");
      //  for(int i=0;i<libros.size();i++){
        
        smt.setString(1, l.getTitulo());
        smt.setString(2, l.getAutor());
        smt.setString(3, l.getAnyo_nacimiento());
        smt.setString(4, l.getAnyo_publicado());
        smt.setString(5, l.getEditorial());
        smt.setString(6, l.getNum_paginas());
        
        smt.executeQuery();
        
       // }
        
        smt.close();
        }catch(Exception e){
        
        }
        
        
       
        
        
        

    }

}
