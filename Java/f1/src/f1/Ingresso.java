/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

/**
 *
 * @author Protegido
 */
public class Ingresso {
    private int id_ingresso;
    private String nome;
    private String data;
    private float preco;
    private int arquibancada;
    private String descricao;
    
    public Ingresso(String nome,String data,float preco,String descricao,int arquibancada){
        this.nome = nome;
        this.data = data; 
        this.preco=preco;
        this.arquibancada=arquibancada;      
        this.descricao = descricao;
    }
    public Ingresso(){
        this("","",0,"",0);
    }
    /**
     * @return the id_ingresso
     */
    public int getId_ingresso() {
        return id_ingresso;
    }

    /**
     * @param id_ingresso the id_ingresso to set
     */
    public void setId_ingresso(int id_ingresso) {
        this.id_ingresso = id_ingresso;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

  

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

   
    /**
     * @return the arquibancada
     */
    public int getArquibancada() {
        return arquibancada;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    
    
}
