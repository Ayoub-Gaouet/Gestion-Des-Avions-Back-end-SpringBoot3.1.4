package com.ayoub.avions.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idCom;
    protected String nomCom;
    protected String descriptionCom;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Avions> avions;
    public Company() {}
    public Company(String nomCom, String descriptionCom, List<Avions> avions)
    {
        super();
        this.nomCom = nomCom;
        this.descriptionCom = descriptionCom;
        this.avions = avions;
    }
    public Long getIdCom() {
        return idCom;
    }
    public void setIdCom(Long idCom) {
        this.idCom = idCom;
    }
    public String getNomCom() {
        return nomCom;
    }
    public void setNomCom(String nomCom) {
        this.nomCom= nomCom;
    }
    public String getDescriptionCom() {
        return descriptionCom;
    }
    public void setDescriptionCom(String descriptionCom) {
        this.descriptionCom = descriptionCom;
    }
    public List<Avions> getAvions() {
        return avions;
    }
    public void setAvions(List<Avions> avions) {
        this.avions = avions;
    }
}