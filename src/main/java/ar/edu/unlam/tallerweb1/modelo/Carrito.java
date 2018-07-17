package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	// RELACION CON EVENTO
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	
	// RELACION CON USUARIO
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	
	
	public Carrito() {
	}

	public Carrito(Evento evento, Usuario usuario) {
		this.evento = evento;
		this.usuario = usuario;
	}
	
	public Carrito(Long id, Evento evento, Usuario usuario) {
		this.id = id;
		this.evento = evento;
		this.usuario = usuario;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
	
	
	