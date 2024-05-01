package com.pfe.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name = "reclamation_id")
    private Reclamation reclamation;
    public Photo() {

    }

    
    @Override
	public String toString() {
		return "Photo [id=" + id + ", url=" + url + ", reclamation=" + reclamation + "]";
	}


	public Reclamation getReclamation() {
		return reclamation;
	}


	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}


	public Photo(Long id, String url, Reclamation reclamation) {
		super();
		this.id = id;
		this.url = url;
		this.reclamation = reclamation;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}