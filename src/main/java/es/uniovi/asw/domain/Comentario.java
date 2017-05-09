package es.uniovi.asw.domain;

import javax.persistence.*;

@Entity
@Table(name="COMENTARIO")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	@ManyToOne
	@JoinColumn(name="sugerencia_id")
	private Sugerencia sugerencia;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	public Citizen usuario;

	public Comentario(){}


	public Comentario(String comentario, Sugerencia sugerencia) {
		super();
		this.contenido = comentario;
		this.sugerencia=sugerencia;
//		Association.PoseerComentario.link(sugerencia, this);
	}

	public Comentario(String contenido, Sugerencia sugerencia, Citizen usuario) {
		this.contenido = contenido;
		this.sugerencia = sugerencia;
		this.usuario = usuario;
	}

	
	public Long getId() {
		return id;
	}
	
	public Sugerencia getSugerencia(){
		return sugerencia;
	}

	

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String comentario) {
		this.contenido = comentario;
	}

	public Citizen getUsuario() {
		return usuario;
	}

	public void setUsuario(Citizen usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Comentario [contenido=" + contenido + ", sugerencia=" + sugerencia + ", usuario=" + usuario + "]";
	}

}
