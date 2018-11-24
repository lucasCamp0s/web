/*
 * @author Lucas Campos
 */
package f1;



public class Circuito {
 
    //atributos
    private int id;
    private String nome_circuito;
    private int total_corredoes;
    private String data;
    private String descricao;
    private byte[] img;
    
    //construtores
    
     public Circuito(String id_circuito,int  total_corredoes,String data,String descricao,byte[] img){
        this.nome_circuito = id_circuito;
        this.total_corredoes = total_corredoes;
        this.data = data;
        this.descricao = descricao;
        this.img = img;
    }
     
    public Circuito(String id_circuito,int  total_corredoes,String data,String descricao){
    
    this(id_circuito,total_corredoes,data,descricao,null);
    }
    public Circuito(){
        this("",0,"","",null);
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
    public String getData() {
        return data;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the img
     */
    public byte[] getImg() {
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

}
