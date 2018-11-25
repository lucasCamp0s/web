/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import conexao.Inserindo;
import conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Campos
 */
public class BDCircuito {
    
  /*
    *@param c
    *@param cn
    */
   
    
    public static List<Circuito> ListarCircuito(Connection c){
        ArrayList<Circuito> listaCircuito = new ArrayList<Circuito>();
        PreparedStatement ps = null;
         ResultSet rs = null ;
        try {
            ps = c.prepareStatement("Select * from circuito");
            rs = ps.executeQuery();
            
           while(rs.next()){
               Circuito cc = new Circuito(rs.getString("nome_circuito"), rs.getInt("total_corredores"), rs.getDate("data").toString(), rs.getString("descricao"), rs.getBytes("imagem"));
               cc.setId(rs.getInt("id_circuito"));
               listaCircuito.add(cc);
               
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
           return listaCircuito;
        }
    
    public static boolean InserirCircuito(Circuito c,Connection cn){
        
        //inserindo circuitos no banco de dados
       
        cn = ConexaoBanco.criaConexao();
        
        //comando para inserir no banco
        String comandoSql = "insert into circuito values(null,?,?,?,?,?);";
        
        PreparedStatement ps;
          
        try {
            ps = cn.prepareStatement(comandoSql);
           //populando tabelas
               
            ps.setString(1, c.getNome_circuito());
            ps.setInt(2, c.getTotal_corredoes());
            
            //convertendo de string para tipo date
       
          SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data = new java.sql.Date(format.parse(c.getData()).getTime());    
             
            ps.setString(3, data.toString());
            ps.setString(4, c.getDescricao());
            ps.setBytes(5, c.getImg());
            if(ps.executeUpdate()!=0){
                System.out.println("Cadastrado com sucesso");
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                 
                return false;
    }
     
    public static void alterarId(String id,String nome,String totalCorredores,String data,String descricao, Connection c )throws SQLException{
       String sql =  "UPDATE circuito SET nome_circuito =?,total_corredores =?,data=?,descricao=? where id_circuito=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1,nome);
       cmd.setInt(2, Integer.parseInt(totalCorredores));
       
       //convertendo String data e tipo data para inserir no banco
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data1 = null;    
        try {
            data1 = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }
       cmd.setString(3, data1.toString());
       cmd.setString(4, descricao);
       cmd.setString(5, id);
       
       cmd.execute();
       cmd.close();
       
       
    }
    public static void alterar(String nome,String totalcorredores,String descricao,String data, Connection c )throws SQLException{
       String sql =  "UPDATE circuito SET descricao=?,data=?,total_corredores=? where nome_circuito=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1,descricao);
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data1 = null;    
        try {
            data1 = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }
       cmd.setString(2, data1.toString());
       cmd.setString(3, totalcorredores);
       cmd.setString(4, nome);
       
       cmd.execute();
       cmd.close();
    }
        
    public static void deletar(String nome, Connection c )throws SQLException{
       String sql =  "DELETE FROM circuito where nome_circuito=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, nome);
       
       cmd.execute();
       cmd.close();
    }
    public static void deletarId(String id, Connection c )throws SQLException{
       String sql =  "DELETE FROM circuito where id_circuito=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       
       cmd.execute();
       cmd.close();
    }
    public static ResultSet consultar(String id, Connection c )throws SQLException{
       String sql =  "SELECT * from circuito WHERE id_circuito=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1,id);
       
       return cmd.executeQuery();
    }
    public static ResultSet consultarNome(String Nome, Connection c )throws SQLException{
        
       String sql =  "SELECT * from circuito WHERE nome_circuito LIKE ?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, '%' + Nome + '%');
       
       return cmd.executeQuery();
    }

}
