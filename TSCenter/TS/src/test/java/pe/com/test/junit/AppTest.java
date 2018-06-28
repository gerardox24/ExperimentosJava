package pe.com.test.junit;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pe.com.business.ArtistaBusiness;
import pe.com.entity.Artista;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
    
	private final ArtistaBusiness artistaBusiness = new ArtistaBusiness();
    private static Artista artista;
	
     @BeforeClass
    public static void inicioClase() {
        System.out.println("Inicio de la clase");
    }

    @AfterClass
    public static void finClase() {
        System.out.println("Fin de la clase");
    }

    @Before
    public void inicioMetodo() {
        System.out.println("Inicio Metodo");
    }

    @After
    public void finMetodo() {
        System.out.println("Fin Metodo");
    }

    @Test
    public void a_insertar() {
        try {
            System.out.println("Método Insertar");
            artista = new Artista();
            artista.setNombre("Prueba");
            artista.setTipoDocumento("Prueba");
            artista.setDNI("Prueba");
            artista.setFechaNac("Prueba");
            artista.setSexo("Prueba");
            artista.setGenero("Prueba");
            artistaBusiness.insertar(artista);
            Assert.assertTrue(artista.getIdArtista() > 0);
			
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void b_actualizar() {
        try {
            System.out.println("Método Actualiza");
            artista.setNombre("Prueba Actualizada");
            artistaBusiness.actualizar(artista);
            Assert.assertTrue(artista.getIdArtista() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void c_obtener() {
        try {
            System.out.println("Método Obtener");
            artista = artistaBusiness.obtener(artista.getIdArtista());
            Assert.assertNotNull(artista);
            System.out.println("ID: " + artista.getIdArtista());
            System.out.println("Nombre: " + artista.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void d_listar() {
        try {
            System.out.println("Método Listar");
            List<Artista> lista = artistaBusiness.listar();
            Assert.assertTrue(lista.size() > 0);
            for (Artista artista : lista) {
                System.out.println("ID: " + artista.getIdArtista());
                System.out.println("Nombre: " + artista.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void e_eliminar() {
        try {
            System.out.println("Método Eliminar");
            artistaBusiness.eliminar(artista);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
