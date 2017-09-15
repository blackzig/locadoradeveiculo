/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoradeveiculo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Michel
 */
public class Conexao {
    
    static Connection con = null;
    
    public static Connection conectar(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost/Locadora","postgres","root");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção!!!", 1);
        }
        
        return con;
    }
    
}
