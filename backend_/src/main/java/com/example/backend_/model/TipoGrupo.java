package com.example.backend_.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Grupo> grupos;

    public TipoGrupo(){}
    public TipoGrupo(Long id, String name){
        this.id=id;
        this.name=name;
    }
    
    public Long getId(){return id;}
    public String getName(){return name;}
    public List<Grupo> getGrupos(){return grupos;}


    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setGroupss(List<Grupo> grupos) {
        this.grupos = grupos;
    }

}
