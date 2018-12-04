/*
 * @author Lucas Campos
 */
package f1;



public class Circuito {
 
    //atributos
    private int id;
    private String nome_circuito;
    private int total_corredoes;
    private String descricao;
    private String img;
    private int id_autodromo;
    
    //construtores
    
     public Circuito(String id_circuito,int  total_corredoesString,String descricao,String img,int id_autodromo){
        this.nome_circuito = id_circuito;
        this.total_corredoes = total_corredoes;
        this.descricao = descricao;
        this.img = img;
        this.id_autodromo = id_autodromo;
    }
   
    public Circuito(){
        this("",0,"","",0);
    }
    
    //get

    /**
     * @return the id_circuito
     */
    public String getNome_circuito() {
        return nome_circuito;
    }

    /**
     * @return the total_corredoes
     */
    public int getTotal_corredoes() {
        return total_corredoes;
    }

    /**
     * @return the data
     */
   

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_autodromo
     */
    public int getId_autodromo() {
        return id_autodromo;
    }
    

}
