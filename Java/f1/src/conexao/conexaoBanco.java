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
 * @author Protegido
 */
public class ConexaoBanco {
    public static Connection criaConexao(){
        
        Connection connection = null;
        String servidor="regulus";
        String dataBase = "bd18306";
        String user = "BD18306";
        String senha="Ddjc132456981016213";
        String url="jdbc:sqlserver://"+servidor+";DatabaseName="+dataBase;        
        url+= ";user="+user+";password="+senha;
       
        try {
            String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(drivername);
        
            //criando conexao
//            connection = DriverManager.getConnection("jdbc:mysql://venus/" +
//			"BD18306?user=BD18306&password=BD18306" + 
//			"&useSSL=false&useTimezone=true&serverTimezone=UTC");

            connection = DriverManager.getConnection(url);
			
        
        
        
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
   
    public static void main(String[] args) {
        ConexaoBanco.criaConexao();
     
    }
}
