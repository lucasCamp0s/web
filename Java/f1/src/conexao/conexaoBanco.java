/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ConexaoBanco {
    
    public static Connection criaConexao(){
        
        Connection connection = null;
        String servidor="10.87.100.6:3306";
        String dataBase = "formula1";
        String user = "aluno";
        String senha="Senai1234";
        String url="jdbc:mysql://"+servidor+"/"+dataBase;
        
        
       
        try {
            //String drivername="com.mysql.cj.jdbc.Driver";
            //Class.forName(drivername);
        
            //criando conexao
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
			"formula1?user=root&password=" + 
			"&useSSL=false&useTimezone=true&serverTimezone=UTC");
			
        
        
        
               //   connection = DriverManager.getConnection(url,user,senha);
        
        //testa conexao
        if(connection != null){
            System.out.println("Connectado com sucesso");
            return connection;
        }else{
            System.out.println("não foi possivel realizar conexao");
             return null;
        }
        
       
        } catch (SQLException ex) {
            System.err.println("erro com sql");
        }
        return null;
    }
    
    
    
}
