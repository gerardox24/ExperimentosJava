package pe.com.bean;

public class ArtistaBean {

	private String nombre;
	private String tipoDocumento;
	private String DNI;
	private String fechaNac;
	private String sexo;
	private String genero;
	
	public ArtistaBean(String nombre,String tipoDocumento,
			String DNI,String fechaNac,String sexo,String genero) {
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.DNI = DNI;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.genero = genero;
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
	public String toString() {
		return "ArtistaBean: " + this.nombre;
	}
}
