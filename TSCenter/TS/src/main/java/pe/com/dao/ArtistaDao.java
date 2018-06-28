package pe.com.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import pe.com.entity.Artista;


public class ArtistaDao extends Conexion<Artista> {

    @Override
    public Artista insertar(Artista e) throws Exception {
        try {
            cn = obtenerConexion();
            String sql = "INSERT INTO ARTISTA (nombre,tipoDocumento,DNI,fechaNac,sexo,genero) VALUES (?,?,?,?,?,?)";
            pr = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getNombre().toUpperCase());
            pr.setString(2, e.getTipoDocumento().toUpperCase());
            pr.setString(3, e.getDNI().toUpperCase());
            pr.setString(4, e.getFechaNac().toUpperCase());
            pr.setString(5, e.getSexo().toUpperCase());
            pr.setString(6, e.getGenero().toUpperCase());
            pr.executeUpdate();
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdArtista((rs.getInt(1)));
        } finally {
        	rs.close();
            pr.close();
            cn.close();
        }
        return e;
    }

    @Override
    public Artista actualizar(Artista e) throws Exception {
       try{
            cn = obtenerConexion();
            String sql = "UPDATE ARTISTA SET nombre=?,tipoDocumento=?,DNI=?,fechaNac=?,sexo=?,genero=? WHERE idArtista=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, e.getNombre().toUpperCase());
            pr.setString(2, e.getTipoDocumento().toUpperCase());
            pr.setString(3, e.getDNI().toUpperCase());
            pr.setString(4, e.getFechaNac().toUpperCase());
            pr.setString(5, e.getSexo().toUpperCase());
            pr.setString(6, e.getGenero().toUpperCase());
            pr.setInt(7, e.getIdArtista());
            pr.executeUpdate();
        }finally{
            pr.close();
            cn.close();
        }
       return e;
    }

    @Override
    public Artista eliminar(Artista e) throws Exception {
        try{
            cn = obtenerConexion();
            String sql = "DELETE FROM ARTISTA WHERE idArtista=?";
            pr = cn.prepareStatement(sql);
            pr.setInt(1, e.getIdArtista());
            pr.executeUpdate();
        }finally{
            pr.close();
            cn.close();
        }
        return e;
    }

    @Override
    public Artista obtener(Artista e) throws Exception {
    	Artista artista = null;
        try{
            cn = obtenerConexion();
            String sql = "select p.* from artista p WHERE p.idArtista=? ORDER BY nombre";
            pr = cn.prepareStatement(sql);
            pr.setInt(1, e.getIdArtista());
            rs = pr.executeQuery();
            while(rs.next()){
            	artista = new Artista();
            	artista.setIdArtista(rs.getInt("idArtista"));
            	artista.setNombre(rs.getString("nombre").toUpperCase());
            	artista.setTipoDocumento(rs.getString("tipoDocumento").toUpperCase());
            	artista.setDNI(rs.getString("DNI").toUpperCase());
            	artista.setFechaNac(rs.getString("fechaNac").toUpperCase());
            	artista.setSexo(rs.getString("sexo").toUpperCase());
            	artista.setGenero(rs.getString("genero").toUpperCase());
            
            }
        }finally{
            rs.close();
            pr.close();
            cn.close();
        }
        return artista;
    }

    @Override
    public List<Artista> listar() throws Exception {
       List<Artista> artistas = new ArrayList<Artista>();
       Artista artista;
        try{
            cn = obtenerConexion();
            String sql = "select a.* from artista a ORDER BY nombre";
            pr = cn.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
            	artista = new Artista();
            	artista.setIdArtista(rs.getInt("idArtista"));
            	artista.setNombre(rs.getString("nombre").toUpperCase());
            	artista.setTipoDocumento(rs.getString("tipoDocumento").toUpperCase());
            	artista.setDNI(rs.getString("DNI").toUpperCase());
            	artista.setFechaNac(rs.getString("fechaNac").toUpperCase());
            	artista.setSexo(rs.getString("sexo").toUpperCase());
            	artista.setGenero(rs.getString("genero").toUpperCase());
                artistas.add(artista);
            }
        }finally{
            rs.close();
            pr.close();
            cn.close();
        }
        return artistas;
    }
    public List<Artista> listar(String nombre) throws Exception {
		List<Artista> artistas = new ArrayList<>();
		Artista artista;
		try {
			cn = obtenerConexion();
			String sql = "SELECT * FROM ARTISTA ";
			sql += " WHERE UCASE(nombre) LIKE '%" + nombre + "%'";
			sql += " ORDER BY nombre";
			pr = cn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				artista = new Artista();
				artista.setIdArtista(rs.getInt("idArtista"));
				artista.setNombre(rs.getString("nombre").toUpperCase());
				artista.setTipoDocumento(rs.getString("tipoDocumento").toUpperCase());
            	artista.setDNI(rs.getString("DNI").toUpperCase());
            	artista.setFechaNac(rs.getString("fechaNac").toUpperCase());
            	artista.setSexo(rs.getString("sexo").toUpperCase());
            	artista.setGenero(rs.getString("genero").toUpperCase());
				artistas.add(artista);
			}
		} finally {
			rs.close();
			pr.close();
			cn.close();
		}
		return artistas;
	}
    
}
