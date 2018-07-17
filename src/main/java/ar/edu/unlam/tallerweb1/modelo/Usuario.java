package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String nombre;
	private String email;
	private String password;
	private String rol;
	private String foto;

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	// RELACION CON CARRITO
	@OneToMany(mappedBy="usuario")
	private List<Carrito> carritos = new ArrayList<>();
	
	
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nombre, String email, String password, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	
	public Usuario(Long id, String nombre, String email, String password, String rol,
			List<Carrito> carritos) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.rol = rol;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	
}
	