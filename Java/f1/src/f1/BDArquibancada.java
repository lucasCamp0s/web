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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Protegido
 */
public class BDArquibancada {
     public static ArrayList<Arquibancada> ListarArquibancada(Connection c){
        ArrayList<Arquibancada> listaArquibancada = new ArrayList<Arquibancada>();
        PreparedStatement ps = null;
         ResultSet rs = null ;
        try {
            ps = c.prepareStatement("Select * from arquibancada");
            rs = ps.executeQuery();
            
           while(rs.next()){
               Arquibancada a = new Arquibancada(rs.getString("setor"),rs.getInt("totalAssentos"));
               a.setId_arquibancada(rs.getInt("id_arquibancada"));
               listaArquibancada.add(a);
               
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
           return listaArquibancada;
        }
    
    public static boolean InserirArquibancada(Arquibancada a,Connection cn){
        
        //inserindo circuitos no banco de dados
       
        cn = ConexaoBanco.criaConexao();
        
        //comando para inserir no banco
        String comandoSql = "insert into arquibancada values(null,?,?);";
        
        PreparedStatement ps;
          
        try {
            ps = cn.prepareStatement(comandoSql);
           //populando tabelas
               
            ps.setString(1, a.getSetor());
            ps.setInt(2, a.getAssentos()); 
          
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
     
    public static void alterarId(String id,String setor,int totalAssentos, Connection c )throws SQLException{
       String sql =  "UPDATE arquibancada SET setor =?,totalAssentos =? where id_arquibancada=?";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1,setor);
       ps.setInt(2, totalAssentos);
       ps.setString(3, id);
    
       
       ps.execute();
       ps.close();
       
       
    }
    public static void alterar(String setor,String totalAssento, Connection c )throws SQLException{
       String sql =  "UPDATE arquibancada SET totalAssentos = ? where setor=?";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1,totalAssento);
       ps.setString(2, setor);
       
       ps.execute();
       ps.close();
    }
        
    public static void deletar(String setor, Connection c )throws SQLException{
       String sql =  "DELETE FROM arquibancada where setor=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, setor);
       
       cmd.execute();
       cmd.close();
    }
    public static void deletarId(String id, Connection c )throws SQLException{
       String sql =  "DELETE FROM arquibancada where id_arquibancada=?";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       cmd.execute();
       cmd.close();
    }
    public static ResultSet consultar(String id, Connection c )throws SQLException{
       String sql =  "SELECT * from arquibancada WHERE id_arquibancada=?;";
       PreparedStatement cmd = c.prepareStatement(sql);
       cmd.setString(1, id);
       
       return cmd.executeQuery();
    }
    public static ResultSet consultarNome(String setor, Connection c )throws SQLException{
        
       String sql =  "SELECT * from arquibancada WHERE setor LIKE? ";
       PreparedStatement ps = c.prepareStatement(sql);
       ps.setString(1, '%' +  setor + '%');
       return ps.executeQuery();
    }
}
