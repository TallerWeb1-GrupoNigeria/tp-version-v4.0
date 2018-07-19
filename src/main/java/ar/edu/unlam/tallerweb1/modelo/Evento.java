package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private Date fecha;
	private String horaInicio;
	private String horaFin; 
	private String telefono; 
	private String imagen1;
	private String imagen2;
	private String imagen3;
	private String correo;   
	private String facebook;
	private String twitter;
	private String instagram;
	private String mostrar;
	private String[] etiqueta;
	private String estado;

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@ManyToOne
	private Prestacion prestacion;
	
	
	@ManyToOne
	private Costo costoClasicacion;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)		// RELACION CON DIRECCION
	@JoinColumn(name="direccion_id")
	private Direccion direccion;

	
	@OneToMany(mappedBy="evento")		// RELACION CON CARRITO
	private List<Carrito> carritos = new ArrayList<>();
	
	
	
	public Evento() {
	}

	public Evento(String nombre, String descripcion, Date fecha, String horaInicio, String horaFin) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	public Evento(Long id, String nombre, String descripcion, Date fecha, String horaInicio, String horaFin) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Evento(Long id, String nombre, String descripcion, Date fecha, String horaInicio, String horaFin,
			String telefono, String imagen1, String imagen2, String imagen3, String correo, String facebook,
			String twitter, String instagram, String mostrar, String[] etiqueta, Prestacion prestacion,
			Costo costoClasicacion, Direccion direccion, List<Carrito> carritos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.telefono = telefono;
		this.imagen1 = imagen1;
		this.imagen2 = imagen2;
		this.imagen3 = imagen3;
		this.correo = correo;
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.mostrar = mostrar;
		this.etiqueta = etiqueta;
		this.prestacion = prestacion;
		this.costoClasicacion = costoClasicacion;
		this.direccion = direccion;
		this.carritos = carritos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImagen1() {
		return imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public String[] getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String[] etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Costo getCostoClasicacion() {
		return costoClasicacion;
	}

	public void setCostoClasicacion(Costo costoClasicacion) {
		this.costoClasicacion = costoClasicacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	
}