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
    private String cidade;
    private String pais;
    private float preco;
    private String descricao;
    private int arquibancada;

    
    public Ingresso(String nome,String data,String cidade,String pais,float preco,String descricao,int arquibancada){
        this.nome = nome;
        this.data = data;
        this.cidade=cidade;
        this.pais=pais;       
        this.preco=preco;
        this.descricao=descricao;
        this.arquibancada=arquibancada;      
    }
    public Ingresso(){
        this("","","","",0,"",0);
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
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
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
    
    
}
