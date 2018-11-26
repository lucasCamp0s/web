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
public class BDIngresso {
        
    public static List<Ingresso> ListarIngresso (Connection c){
        ArrayList<Ingresso> listaIngresso = new ArrayList<Ingresso>();
        PreparedStatement ps = null;
         ResultSet rs = null ;
        try {
            ps = c.prepareStatement("Select * from Ingresso");
            rs = ps.executeQuery();
            
           while(rs.next()){
               Ingresso i = new Ingresso(rs.getString("nome"),rs.getDate("data_evento").toString(), rs.getString("cidade"), rs.getString("pais"), rs.getFloat("preco"),rs.getString("descricao"), rs.getInt("arquibancada_id_arquibancada"));
               i.setId_ingresso(rs.getInt("id_ingresso"));
               listaIngresso.add(i);
               
           }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(BDIngresso.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                c.close();
                ps.close();
                 rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDIngresso.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
           return listaIngresso;
        }
    
    public static boolean InserirIngresso(Ingresso i,Connection cn){
        
        //inserindo circuitos no banco de dados
       
        cn = ConexaoBanco.criaConexao();
        
        //comando para inserir no banco
        String comandoSql = "insert into ingresso values(null,?,?,?,?,?,?,?);";
        
        PreparedStatement ps;
          
        try {
            ps = cn.prepareStatement(comandoSql);
           //populando tabelas
          SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data2 = new java.sql.Date(format.parse(i.getData()).getTime());    
          
          ps.setString(1,i.getNome());
          ps.setString(2,data2.toString());
          ps.setString(3, i.getCidade());
            
            //convertendo de string para tipo date  
            ps.setString(4, i.getPais());
            ps.setFloat(5, i.getPreco());
            ps.setString(6, i.getDescricao());
            ps.setInt(7,i.getArquibancada());
            if(ps.executeUpdate()!=0){
                System.out.println("Cadastrado com sucesso");
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inserindo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BDIngresso.class.getName()).log(Level.SEVERE, null, ex);
        } 
                return false;
    }
     
    public static void alterarId(int id,String nome,String data,String cidade,String pais,Float preco,String descricao,int arquibancada, Connection c  )throws SQLException{
       String sql = "UPDATE ingresso SET nome=?,data_evento=?,cidade=?,pais=?,preco=?,descricao=? where id_ingresso=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1,nome);
       //convertendo String data e tipo data para inserir no banco
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data1 = null;    
        try {
            data1 = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }
       cmd.setString(2, data1.toString());
       cmd.setString(3, cidade);
       cmd.setString(4, pais);
       cmd.setString(5, preco.toString());
       cmd.setString(6, descricao);
       cmd.setInt(7, id);
       
       cmd.execute();
       cmd.close();
       
       
    }
    public static void alterar(String nome,String data,String cidade,String pais,Float preco,String descricao,int arquibancada, Connection c )throws SQLException{
       String sql =  "UPDATE ingresso SET data_evento=?,cidade=?,pais=?,preco=?,descricao=? where nome=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          java.sql.Date data1 = null;    
        try {
            data1 = new java.sql.Date(format.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(BDCircuito.class.getName()).log(Level.SEVERE, null, ex);
        }
       cmd.setString(1, data1.toString());
       cmd.setString(2, cidade);
       cmd.setString(3, pais);
       cmd.setString(4, preco.toString());
       cmd.setString(5, descricao);
       cmd.setString(6,nome);
       cmd.execute();
       cmd.close();
    }
        
    public static void deletar(String nome, Connection c )throws SQLException{
       String sql =  "DELETE FROM ingresso where nome=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, nome);
       
       cmd.execute();
       cmd.close();
    }
    public static void deletarId(String id, Connection c )throws SQLException{
       String sql =  "DELETE FROM ingresso where id_ingresso=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       
       cmd.execute();
       cmd.close();
    }
    public static ResultSet consultar(String id, Connection c )throws SQLException{
       String sql =  "SELECT * from ingresso WHERE id_ingresso=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1,id);
       
       return cmd.executeQuery();
    }
    public static ResultSet consultarNome(String Nome, Connection c )throws SQLException{
        
       String sql =  "SELECT * from ingresso WHERE nome LIKE ?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, '%' + Nome + '%');
       
       return cmd.executeQuery();
    }

    
}
