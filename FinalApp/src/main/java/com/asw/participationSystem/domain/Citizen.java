package com.asw.participationSystem.domain;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Clase del modelo Citizen
 */

@Entity
@Table(name = "USUARIOS")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // JPA
    private String nombre;
    private String apellidos;

    @Email(message="*Introduzca un email válido")
    private String email;
    private Date fecha_nacimiento;
    private String direccion_postal;
    private String nacionalidad;
    private String numero_identificativo; // Clave natural
    private String contrasena;
    @Transient
    private String contrasena_NC;
    @OneToMany(mappedBy="usuario",cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;
    @OneToMany(mappedBy="usuario",cascade = CascadeType.ALL)
    private Set<Sugerencia> sugerenciasQueHace;
    @ManyToMany(mappedBy="usuario",fetch = FetchType.EAGER)
    private Set<Sugerencia> sugerenciasQueVota;
    private boolean isAdmin;
    
    
    
   /*
    @OneToMany
    List<Sugerencia> sugerencias; //ANa set y get  de esto
*/

   
	public Citizen() {
    }

    public Citizen(String nombre, String apellidos, String email, Date fecha_nacimiento, String direccion_postal, String nacionalidad,
                   String numero_identificativo) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion_postal = direccion_postal;
        this.nacionalidad = nacionalidad;
        this.numero_identificativo = numero_identificativo;
    }

    public Citizen(String nombre, String apellidos, String email, Date fecha_nacimiento, String direccion_postal,
                   String nacionalidad, String numero_identificativo, String contrasena) {
        this(nombre, apellidos, email, fecha_nacimiento, direccion_postal, nacionalidad, numero_identificativo);
        this.contrasena = DigestUtils.sha512Hex(contrasena);
        this.contrasena_NC = contrasena;
    }

    public Citizen(String nombre, String apellidos, String email, Date fecha_nacimiento, String direccion_postal, String nacionalidad, String numero_identificativo, String contrasena, boolean isAdmin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion_postal = direccion_postal;
        this.nacionalidad = nacionalidad;
        this.numero_identificativo = numero_identificativo;
        this.contrasena = DigestUtils.sha512Hex(contrasena);
        this.contrasena_NC = contrasena;
        this.isAdmin = isAdmin;

    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public void setApellidos(String surname) {
        this.apellidos = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNacimiento(Date birthdate) {
        this.fecha_nacimiento = birthdate;
    }

    public void setDireccionPostal(String address) {
        this.direccion_postal = address;
    }

    public void setNacionalidad(String nationality) {
        this.nacionalidad = nationality;
    }

    public void setNumeroIdentificativo(String nif) {
        this.numero_identificativo = nif;
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public String getDireccionPostal() {
        return direccion_postal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNumeroIdentificativo() {
        return numero_identificativo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getContrasenaNC() {
        return contrasena_NC;
    }

    public void setContrasena(String password) {
        this.contrasena = DigestUtils.sha512Hex(password);
        this.contrasena_NC = password;
    }

    public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public Set<Sugerencia> getSugerenciasQueHace() {
		return sugerenciasQueHace;
	}
	
	public Set<Sugerencia> getSugerenciasQueVota() {
		return sugerenciasQueVota;
	}
	
	public void addSugerenciaHaVotado(Sugerencia sug){
		sugerenciasQueVota.add(sug);
	}

	public boolean haEscrito(Sugerencia sugerencia){
		return sugerenciasQueHace.contains(sugerencia);
	}
	
	public boolean haVotado(Sugerencia sugerencia){
		return sugerenciasQueVota.contains(sugerencia);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        return numero_identificativo != null ? numero_identificativo.equals(citizen.numero_identificativo) : citizen.numero_identificativo == null;
    }

    @Override
    public int hashCode() {
        return numero_identificativo != null ? numero_identificativo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Citizen{" + "id=" + id + ", name='" + nombre + '\'' + ", surname='" + apellidos + '\'' + ", email='" + email
                + '\'' + ", birthdate=" + fecha_nacimiento + ", address='" + direccion_postal + '\'' + ", nationality='" + nacionalidad
                + '\'' + ", nif='" + numero_identificativo + '\'' + ", password='" + contrasena + '\'' + '}';
    }
}