package cs2031.utec.edu.pe.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public TipoGrupo(){}
    public TipoGrupo(Long id, String name){
        this.id=id;
        this.name=name;
    }
    
    public Long getId(){return id;}
    public String getNmae(){return name;}

    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name=name;}
}
