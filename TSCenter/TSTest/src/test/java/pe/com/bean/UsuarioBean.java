package pe.com.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String correo;
    private String clave;

    public UsuarioBean() {
    }

    public UsuarioBean(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
