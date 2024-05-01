package com.pfe.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateReclamation;
    private String heureReclamation;
    @ManyToOne
    @JoinColumn(name = "type_reclamation_id")
    private TypeReclamation typeReclamation;
    public Reclamation() {
     
    }
    @OneToMany(mappedBy = "reclamation")
    private List<Degat> degats;
    

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "reclamation_moyen_transport",
            joinColumns = @JoinColumn(name = "reclamation_id"),
            inverseJoinColumns = @JoinColumn(name = "moyen_transport_id")
    )
    private Set<MoyenTransport> moyensTransport;
    @OneToOne(mappedBy = "reclamation") 
    private SourceInfo sourceInfo; 
    
    @OneToMany(mappedBy = "reclamation")
    private Set<Photo> photos;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getHeureReclamation() {
        return heureReclamation;
    }

    public void setHeureReclamation(String heureReclamation) {
        this.heureReclamation = heureReclamation;
    }


	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}



	public List<Degat> getDegats() {
		return degats;
	}

	public void setDegats(List<Degat> degats) {
		this.degats = degats;
	}

	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}


	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", dateReclamation=" + dateReclamation + ", heureReclamation="
				+ heureReclamation + ", typeReclamation=" + typeReclamation + ", degats=" + degats
				+ ", moyensTransport=" + moyensTransport + ", sourceInfo=" + sourceInfo + ", photos=" + photos + "]";
	}

	public SourceInfo getSourceInfo() {
		return sourceInfo;
	}

	public void setSourceInfo(SourceInfo sourceInfo) {
		this.sourceInfo = sourceInfo;
	}

	public Reclamation(Long id, Date dateReclamation, String heureReclamation, TypeReclamation typeReclamation,
			List<Degat> degats, Set<MoyenTransport> moyensTransport, SourceInfo sourceInfo, Set<Photo> photos) {
		super();
		this.id = id;
		this.dateReclamation = dateReclamation;
		this.heureReclamation = heureReclamation;
		this.typeReclamation = typeReclamation;
		this.degats = degats;
		this.moyensTransport = moyensTransport;
		this.sourceInfo = sourceInfo;
		this.photos = photos;
	}

	public Set<MoyenTransport> getMoyensTransport() {
		return moyensTransport;
	}

	public void setMoyensTransport(Set<MoyenTransport> moyensTransport) {
		this.moyensTransport = moyensTransport;
	}


	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}


}