package ar.edu.unlam.tallerweb1.modelo;

public class UbicacionJson {
	private String formatted_address;
	private String latitud;
	private String longitud;
	private String street_number;
	private String route;
	private String locality;
	private String administrative_area_level_1;
	private String country;
	private String postal_code;

	public UbicacionJson() {
		super();
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
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
	
}
