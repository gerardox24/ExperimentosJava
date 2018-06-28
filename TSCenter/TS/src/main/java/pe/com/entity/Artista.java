package pe.com.entity;

import java.io.Serializable;
import java.util.Objects;

public class Artista implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idArtista;
	private String nombre;
	private String tipoDocumento;
	private String DNI;
	private String fechaNac;
	private String sexo;
	private String genero;

	public Artista() {
		super();
	}

	public Artista(Integer idArtista) {
		super();
		this.idArtista = idArtista;
	}

	public Artista(Integer idArtista, String nombre, String tipoDocumento
			, String DNI, String fechaNac, String sexo, String genero) {
		super();
		this.idArtista = idArtista;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.DNI = DNI;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.genero = genero;
	}

	public Integer getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Artista other = (Artista) obj;
		return Objects.equals(this.idArtista, other.idArtista);
	}
}
