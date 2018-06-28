package pe.com.business;

import java.util.List;

import pe.com.dao.ArtistaDao;
import pe.com.entity.Artista;


public class ArtistaBusiness {

	private final ArtistaDao artistaDao = new ArtistaDao();
	
	public void insertar(Artista artista) throws Exception{
		this.artistaDao.insertar(artista);
	}
	
	public void actualizar(Artista artista) throws Exception{
		this.artistaDao.actualizar(artista);
	}
	
	public void eliminar(Artista artista) throws Exception{
		this.artistaDao.eliminar(artista);
	}
	
	public Artista obtener(Integer idArtista)throws Exception{
		return this.artistaDao.obtener(new Artista(idArtista));
	}
	
	public List<Artista> listar() throws Exception{
		return this.artistaDao.listar();
	}
	
	
}
