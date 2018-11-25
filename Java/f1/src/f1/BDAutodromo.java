/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import conexao.ConexaoBanco;
import conexao.Inserindo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Protegido
 */
public class BDAutodromo {
    
    
       
    public static ArrayList<Autodromo> ListarAutodromo(Connection c){
        ArrayList<Autodromo> listaAutodromo = new ArrayList<Autodromo>();
        PreparedStatement ps = null;
         ResultSet rs = null ;
        try {
            ps = c.prepareStatement("Select * from autodromo");
            rs = ps.executeQuery();
            
           while(rs.next()){
               Autodromo a = new Autodromo(rs.getString("nome"),rs.getString("endereco"),rs.getString("cidade"),rs.getString("pais"),rs.getString("descricao"));
               a.setId_autodromo(rs.getInt("id_autodromo"));
               listaAutodromo.add(a);
               
           }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                c.close();
                ps.close();
                 rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
           return listaAutodromo;
        }
    
    public static boolean InserirAutodromo(Autodromo a,Connection cn){
        
        //inserindo circuitos no banco de dados
       
        cn = ConexaoBanco.criaConexao();
        
        //comando para inserir no banco
        String comandoSql = "insert into autodromo values(null,?,?,?,?,?);";
        
        PreparedStatement ps;
          
        try {
            ps = cn.prepareStatement(comandoSql);
           //populando tabelas
               
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEndereco()); 
            ps.setString(3, a.getCidade());
            ps.setString(4,a.getPais());
            ps.setString(5, a.getDescricao());
            if(ps.executeUpdate()!=0){
                System.out.println("Cadastrado com sucesso");
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        }       
                return false;
    }
     
    public static void alterarId(String id,String nome,String endereco,String cidade,String pais,String descricao, Connection c )throws SQLException{
       String sql =  "UPDATE autodromo SET nome =?,endereco =?,cidade=?,pais=?,descricao=? where id_autodromo=?";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1,nome);
       ps.setString(2, endereco);
       ps.setString(3, cidade);
       ps.setString(4, pais);
       ps.setString(5, descricao);
       ps.setString(6, id);
       
       ps.execute();
       ps.close();
       
       
    }
    public static void alterar(String nome,String endereco,String cidade,String pais,String descricao, Connection c )throws SQLException{
       String sql =  "UPDATE autodromo SET endereco=?,cidade=?,pais=?,descricao=? where nome=?";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1,descricao);
       ps.setString(2, cidade);
       ps.setString(3, pais);
       ps.setString(4, descricao);
       ps.setString(5, nome);
       
       ps.execute();
       ps.close();
    }
        
    public static void deletar(String nome, Connection c )throws SQLException{
       String sql =  "DELETE FROM autodromo where nome=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, nome);
       
       cmd.execute();
       cmd.close();
    }
    public static void deletarId(String id, Connection c )throws SQLException{
       String sql =  "DELETE FROM autodromo where id_autodromo=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       
       cmd.execute();
       cmd.close();
    }
    public static ResultSet consultar(String id, Connection c )throws SQLException{
       String sql =  "SELECT * from autodromo WHERE id_autodromo=?;";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       
       return cmd.executeQuery();
    }
    public static ResultSet consultarNome(String Nome, Connection c )throws SQLException{
        
       String sql =  "SELECT * from autodromo WHERE nome LIKE? ";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1, '%' +  Nome + '%');
       return ps.executeQuery();
    }
    
}
