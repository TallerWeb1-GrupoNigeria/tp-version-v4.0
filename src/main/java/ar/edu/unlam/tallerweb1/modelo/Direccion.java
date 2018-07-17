package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String street_number; 				
	private String route; 						
	private String locality;					
	private String administrative_area_level_1;
	private String country;				
	private String postal_code;
	private String latitud;
	private String longitud;
	private String formatted_address;
	
	
	@OneToOne(mappedBy="direccion")	  // RELACION CON EVENTO
	private Evento evento;
	
	
	
	// CONSTRUCTORES
	
	public Direccion() {

	}
	public Direccion(String street_number, String route, String locality, String administrative_area_level_1,
			String country, String postal_code, String latitud, String longitud, String formatted_address) {
		super();
		this.street_number = street_number;
		this.route = route;
		this.locality = locality;
		this.administrative_area_level_1 = administrative_area_level_1;
		this.country = country;
		this.postal_code = postal_code;
		this.latitud = latitud;
		this.longitud = longitud;
		this.formatted_address = formatted_address;
	}
	
	// GETS SETS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrative_area_level_1() {
		return administrative_area_level_1;
	}

	public void setAdministrative_area_level_1(String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

}
