package repository.domain;

import javax.persistence.*;

import participationSystem.util.loggercutre.SingletonLoggerCutre;

import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;

@Entity
@Table(name = "CONFIGURACION")
public class Configuration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String PALABRAS_NO_PERMITIDAS;
	private int minimoVotos;

	@Transient
	private String cadenaDePalabrasnoPermitidas; // En la base de datos se
													// guardaran como
													// palabra@@palabra
	@Transient
	private List<String> palabrasNoPermitidas;
	@Transient
	private String separador = "@@";

	public Configuration(Long id) {
		this.id = id;
	}

	public String getPalabraNoPermitida() {
		return PALABRAS_NO_PERMITIDAS;
	}

	public Configuration() {
		// TODO Auto-generated constructor stub
		this.palabrasNoPermitidas = new ArrayList<String>();
		//rellenarListaPalabrasNoPermitidas();
		this.minimoVotos = 0;

	}

	public Configuration(String palabras) {
		this();
		PALABRAS_NO_PERMITIDAS = palabras;
	}

	public void addPalabraNoPermitida(String word) {
		if (!"".equals(word)) {
			//rellenarListaPalabrasNoPermitidas();
//			this.palabrasNoPermitidas.add(word);
			SingletonLoggerCutre.getInstance().getLogger().log(getClass(),
					"Antes de actualizar " + PALABRAS_NO_PERMITIDAS);
//			actualizarCadenaDePalabras();
			StringBuilder sb = new StringBuilder();
			sb.append(this.PALABRAS_NO_PERMITIDAS);
			sb.append(separador + word);
			this.PALABRAS_NO_PERMITIDAS =  sb.toString();

			SingletonLoggerCutre.getInstance().getLogger().log(getClass(),
					"Tras actualizar " + this.PALABRAS_NO_PERMITIDAS);
		}
	}

	public int getMinimoVotos() {
		return minimoVotos;
	}

	public void setMinimoVotos(int minimoVotos) {
		this.minimoVotos = minimoVotos;
	}

	public List<String> getPalabrasNoPermitidas() {
		List<String> listado = new ArrayList<String>();
		String[] aux = this.PALABRAS_NO_PERMITIDAS.split(separador);
		for (String s : aux) {
			listado.add(s);
		}
		return listado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PALABRAS_NO_PERMITIDAS == null) ? 0 : PALABRAS_NO_PERMITIDAS.hashCode());
		result = prime * result + minimoVotos;
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
		Configuration other = (Configuration) obj;
		if (PALABRAS_NO_PERMITIDAS == null) {
			if (other.PALABRAS_NO_PERMITIDAS != null)
				return false;
		} else if (!PALABRAS_NO_PERMITIDAS.equals(other.PALABRAS_NO_PERMITIDAS))
			return false;
		return !(minimoVotos != other.minimoVotos);
	}

}
