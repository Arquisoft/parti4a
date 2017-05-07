package hello.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SUGERENCIA")
public class Sugerencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int votosPositivos;
	private int votosNegativos;
	private String nombre;
	private String contenido;
	@OneToMany(mappedBy = "sugerencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Comentario> comentarios;
	@ManyToMany
	@JoinTable(name = "voto", joinColumns = {
			@JoinColumn(name = "SUGERENCIA_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CITIZEN_ID", nullable = false, updatable = false) })
	private Set<Citizen> ciudadanosQueVotan;
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Citizen usuario;
	private Date fechaCreacion;
	private boolean consiguioElMinimo;

	public Sugerencia() {
	}

	public Sugerencia(String nombre, String contenido, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.contenido = contenido;
		this.categoria = categoria;
		// Association.PoseerSugerencia.link(categoria, this);

	}

	public Sugerencia(String nombre, String contenido, Categoria categoria, Citizen usuario) {
		super();
		this.nombre = nombre;
		this.contenido = contenido;
		this.categoria = categoria;
		this.usuario = usuario;
		this.votosPositivos = 0;
		this.votosNegativos = 0;
		this.fechaCreacion = new Date();
		this.ciudadanosQueVotan = new HashSet<>();
	}

	public Sugerencia(Set<Citizen> ciudadanosQueVotan, Categoria categoria, Citizen usuario, Date fechaCreacion) {
		this.ciudadanosQueVotan = ciudadanosQueVotan;
		this.categoria = categoria;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
	}

	public Sugerencia(int votosPositivos, int votosNegativos, String nombre, String contenido, Set<Comentario> comentarios,
			Set<Citizen> ciudadanosQueVotan, Categoria categoria, Citizen usuario, Date fechaCreacion) {
		this.votosPositivos = votosPositivos;
		this.votosNegativos = votosNegativos;
		this.nombre = nombre;
		this.contenido = contenido;
		this.comentarios = comentarios;
		this.ciudadanosQueVotan = ciudadanosQueVotan;
		this.categoria = categoria;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
	}

	public Citizen getUsuario() {
		return usuario;
	}

	public void setUsuario(Citizen usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getVotosPositivos() {
		return votosPositivos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void addComentario(Comentario c) {
		this.comentarios.add(c);
	}

	public Set<Comentario> getComentarios() {
		return new HashSet<Comentario>(comentarios);
	}

	public Set<Citizen> getCiudadanosQueVotan() {
		return new HashSet<Citizen>(ciudadanosQueVotan);
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void incrementarVotosPositivos() {
		this.votosPositivos++;
	}
	
	public void incrementarVotosNegativos() {
		this.votosNegativos++;
	}

//	public void decrementarVotos() {
//		this.votos--;
//	}

	public void addCiudadanoHaVotado(Citizen ciudadano) {
		ciudadanosQueVotan.add(ciudadano);
		ciudadano.addSugerenciaHaVotado(this);
	}

	public boolean checkCiudadano(Citizen citizen) {
		return ciudadanosQueVotan.contains(citizen);
	}

	public boolean isConsiguioElMinimo() {
		return consiguioElMinimo;
	}

	public void setConsiguioElMinimo(boolean consiguioElMinimo) {
		this.consiguioElMinimo = consiguioElMinimo;
	}

	public int getVotosNegativos() {
		return votosNegativos;
	}

	public void setVotosNegativos(int votosNegativos) {
		this.votosNegativos = votosNegativos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((ciudadanosQueVotan == null) ? 0 : ciudadanosQueVotan.hashCode());
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + (consiguioElMinimo ? 1231 : 1237);
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + votosNegativos;
		result = prime * result + votosPositivos;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sugerencia other = (Sugerencia) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (ciudadanosQueVotan == null) {
			if (other.ciudadanosQueVotan != null)
				return false;
		} else if (!ciudadanosQueVotan.equals(other.ciudadanosQueVotan))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (consiguioElMinimo != other.consiguioElMinimo)
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (votosNegativos != other.votosNegativos)
			return false;
		if (votosPositivos != other.votosPositivos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugerencia [id=" + id + ", votos=" + votosPositivos + ", votosNegativos=" + votosNegativos + ", nombre=" + nombre + ", contenido=" + contenido
				+ ", categoria=" + categoria + ", usuario=" + usuario + ", fechaCreacion=" + fechaCreacion
				+ ", consiguioElMinimo=" + consiguioElMinimo + "]";
	}



}
