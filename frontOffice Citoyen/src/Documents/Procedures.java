package Documents;

import java.util.List;

public abstract class Procedures {
	protected int id_procedure;
	
	private  String nom;
	private String description;
	private int nombre_etapes;
	private boolean est_archive;
	private String matricule;
	
	public int getId_procedure() {
		return id_procedure;
	}

	public void setId_procedure(int id_procedure) {
		this.id_procedure = id_procedure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNombre_etapes() {
		return nombre_etapes;
	}

	public void setNombre_etapes(int nombre_etapes) {
		this.nombre_etapes = nombre_etapes;
	}

	public boolean isEst_archive() {
		return est_archive;
	}

	public void setEst_archive(boolean est_archive) {
		this.est_archive = est_archive;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Procedures(int id_procedure, String nom, String description, int nombre_etapes, boolean est_archive,
			String matricule) {
		super();
		this.id_procedure = id_procedure;
		this.nom = nom;
		this.description = description;
		this.nombre_etapes = nombre_etapes;
		this.est_archive = est_archive;
		this.matricule = matricule;
	}

	public Procedures() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	

}
