/*lucas
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

/**
 *
 * @author Protegido
 */
public class Arquibancada {
    
    private int id_arquibancada;
    private String setor;
    private int assentos;
    
    
    public Arquibancada(String setor,int assentos){
        this.assentos = assentos;
        this.setor = setor;
                
    }
    public Arquibancada(){
        this("",0);
    }

    /**
     * @return the id_arquibancada
     */
    public int getId_arquibancada() {
        return id_arquibancada;
    }

    /**
     * @param id_arquibancada the id_arquibancada to set
     */
    public void setId_arquibancada(int id_arquibancada) {
        this.id_arquibancada = id_arquibancada;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @return the assentos
     */
    public int getAssentos() {
        return assentos;
    }
    
    
    
    
}
