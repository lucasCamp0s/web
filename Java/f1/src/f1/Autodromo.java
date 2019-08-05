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
public class Autodromo {
    private int id_autodromo;
    private String nome;
    private String endereco;
    private String cidade;
    private String pais;
    private String descricao;
    private String imagem;
    
    
    
    public Autodromo(String nome,String endereco,String cidade,String pais,String descricao,String imagem){
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.pais = pais;
        this.descricao = descricao;
        this.imagem = imagem;
    }
    public Autodromo(){
        this("","","","","","");
    }

    /**
     * @return the id_autodromo
     */
    public int getId_autodromo() {
        return id_autodromo;
    }

    /**
     * @param id_autodromo the id_autodromo to set
     */
    public void setId_autodromo(int id_autodromo) {
        this.id_autodromo = id_autodromo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }
    
    
          
}
