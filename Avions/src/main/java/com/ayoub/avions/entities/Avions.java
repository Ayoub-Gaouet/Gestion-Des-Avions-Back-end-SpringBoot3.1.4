package com.ayoub.avions.entities;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Avions{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvions;
    private String nomAvions;
    private Double prixAvions;
    private Date dateCreation;
    @ManyToOne
    private Company company;
    @OneToOne
    private Image image;
    public Avions(){
        super();
    }
    public Avions(String nomAvions, Double prixAvions, Date dateCreation) {
        super();
        this.nomAvions = nomAvions;
        this.prixAvions = prixAvions;
        this.dateCreation = dateCreation;
    }
    public Avions(Long idAvions, String nomAvions, Double prixAvions, Date dateCreation, Company company) {
		super();
		this.idAvions = idAvions;
		this.nomAvions = nomAvions;
		this.prixAvions = prixAvions;
		this.dateCreation = dateCreation;
		this.company = company;
	}
    
    public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Long getIdAvions() {
        return idAvions;
    }
    public void setIdAvions(Long idAvions) {
        this.idAvions = idAvions;
    }
    public String getNomAvions() {
        return nomAvions;
    }
    public void setNomAvions(String nomAvions) {
        this.nomAvions = nomAvions;
    }
    public Double getPrixAvions() {
        return prixAvions;
    }
    public void setPrixAvions(Double prixAvions) {
        this.prixAvions = prixAvions;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Avions [idAvions=" + idAvions + ", nomAvions=" +
                nomAvions + ", prixProduit=" + prixAvions
                + ", dateCreation=" + dateCreation + "]";
    }
}