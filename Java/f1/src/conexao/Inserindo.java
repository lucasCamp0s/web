/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
    
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


    
public class Inserindo {
    
    /**
     *
     * @param id_autodromo
     * @param nome
     * @param endereco
     * @param cidade
     * @param pais
     * @param descricao
     */
    public static boolean InserirAutodromo(int id_autodromo, String nome,String endereco,String cidade,String pais,String descricao){
        Connection connection;
        
        connection = ConexaoBanco.criaConexao();
        
        //comando para inserirpessoas
        
        String comandoSql = "insert into autodromo values(?,?,?,?,?,?);";
        
        try {
            PreparedStatement ps = connection.prepareStatement(comandoSql);
        
            //Passagem de valores para cada ? do comando INSERT
            ps.setInt(1, id_autodromo);
            ps.setString(2, nome);
            ps.setString(3, endereco);
            ps.setString(4, cidade);
            ps.setString(5, pais);
            ps.setString(6, descricao);
            
            //Execução do comando no Banco de Dados e teste do que foi retornado
            if(ps.executeUpdate()!=0){
                System.out.println("inserido");
                connection.close();
                return true;
        }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    
    public static boolean InserirCorrida(String id_circuito,int total_corredores,String data,String descricao){
        
        //inserindo circuitos no banco de dados
        Connection connection;
        connection = ConexaoBanco.criaConexao();
        
        //comando para inserir no banco
        String comandoSql = "insert into circuito values(?,?,?,?);";
        
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(comandoSql);
           //populando tabelas
            
            
            
            ps.setString(1, id_circuito);
            ps.setInt(2, total_corredores);
            
            //convertendo de string para tipo date
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
            java.sql.Date dataNova = new java.sql.Date(format.parse(data).getTime());
            
            ps.setDate(3, dataNova);
            ps.setString(4, descricao);
            
            if(ps.executeUpdate()!=0){
                System.out.println("Cadastrado com sucesso");
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                 
                return false;
    }
    
    public static boolean InserirArquibancada(String id_arquibancada,int totalAssentos){
        Connection connection;
        connection = ConexaoBanco.criaConexao();
        
        String comandoSql = "insert into arquibancada values(?,?)";
        
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(comandoSql);
            
            ps.setString(1,id_arquibancada);
            ps.setInt(2, totalAssentos);
            
            if(ps.executeUpdate()!=0){
                System.out.println("Cadastrado com sucesso");
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
       
    }
    public static void main(String args[]){
         Inserindo.InserirCorrida("formuladrift", 50, "10/10/2018", "deu Certo");
    }
    
}
