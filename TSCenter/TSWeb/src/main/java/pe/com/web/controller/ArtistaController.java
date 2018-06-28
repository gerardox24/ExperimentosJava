package pe.com.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import pe.com.dao.ArtistaDao;
import pe.com.entity.Artista;
import pe.com.web.util.WebUtil;

@ManagedBean
@SessionScoped
public class ArtistaController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ArtistaController.class);
    private static final long serialVersionUID = 1L;
    private String filtro = "";
    private List<Artista> listaArtista = new ArrayList<Artista>();
    private ArtistaDao artistaDao = new ArtistaDao();
    private Artista artistaGuardar = new Artista();
    private Artista artistaSeleccionada = new Artista();
    private String inicioMantenimiento = "";

    public ArtistaController() {

    }

    private void limpiar() {
        this.listaArtista = new ArrayList<Artista>();
        this.artistaGuardar = new Artista();
        this.artistaSeleccionada = new Artista();
    }

    public void insertar() {
        try {
            this.artistaDao.insertar(artistaGuardar);
            WebUtil.mensajeInformacion(WebUtil.obtenerPropiedad("artistaController.guardarExito"), WebUtil.obtenerPropiedad("artistaController.guardarExito"));
            this.limpiar();
        } catch (Exception exception) {
            String mensaje = WebUtil.controlarError(exception, LOGGER);
            WebUtil.mensajeError(mensaje, mensaje);
        }
    }

    public void actualizar() {
        try {
            this.artistaDao.actualizar(artistaGuardar);
            WebUtil.mensajeInformacion(WebUtil.obtenerPropiedad("artistaController.actualizarExito"), WebUtil.obtenerPropiedad("artistaController.actualizarExito"));
        } catch (Exception exception) {
            String mensaje = WebUtil.controlarError(exception, LOGGER);
            WebUtil.mensajeError(mensaje, mensaje);
        }
    }

    public void eliminar() {
        try {
            if (this.artistaSeleccionada != null && this.artistaSeleccionada.getNombre().length() >= 0) {
                this.artistaDao.eliminar(artistaSeleccionada);
                WebUtil.mensajeInformacion(WebUtil.obtenerPropiedad("artistaController.eliminarExito"), WebUtil.obtenerPropiedad("artistaController.eliminarExito"));
                this.limpiar();
            } else {
                WebUtil.mensajeAdvertencia(WebUtil.obtenerPropiedad("artistaController.noSeleccionado"), WebUtil.obtenerPropiedad("artistaController.noSeleccionado"));
            }
        } catch (Exception exception) {
            String mensaje = WebUtil.controlarError(exception, LOGGER);
            WebUtil.mensajeError(mensaje, mensaje);
        }
    }
    public void buscar() {
        try {
            this.listaArtista = this.artistaDao.listar(this.filtro.trim());
        } catch (Exception exception) {
            String mensaje = WebUtil.controlarError(exception, LOGGER);
            WebUtil.mensajeError(mensaje, mensaje);
        }
    }
    public String irMantenimiento() {
        this.limpiar();
        return "mntAdmArtista";
    }

    public String irNuevo() {
        this.limpiar();
        return "registrarAdmArtista";
    }

    public String irActualizar() {
        String rpta = "";
        if (this.artistaSeleccionada != null && this.artistaSeleccionada.getNombre().length() >= 0) {
            this.artistaGuardar = this.artistaSeleccionada;
            this.listaArtista.clear();
            this.filtro = "";
            rpta = "actualizarAdmArtista";
        } else {
            WebUtil.mensajeAdvertencia(WebUtil.obtenerPropiedad("artistaController.noSeleccionado"), WebUtil.obtenerPropiedad("artistaController.noSeleccionado"));
        }
        return rpta;
    }

    public String getInicioMantenimiento() {
        this.limpiar();
        return inicioMantenimiento;
    }

    public void setInicioMantenimiento(String inicioMantenimiento) {
        this.inicioMantenimiento = inicioMantenimiento;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public Artista getArtistaSeleccionada() {
        return artistaSeleccionada;
    }

    public void setArtistaSeleccionada(Artista artistaSeleccionada) {
        this.artistaSeleccionada = artistaSeleccionada;
    }

    public Artista getArtistaGuardar() {
        return artistaGuardar;
    }

    public void setArtistaDao(ArtistaDao artistaDao) {
        this.artistaDao = artistaDao;
    }

}
