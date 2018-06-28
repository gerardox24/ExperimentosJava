package pe.com.test.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pe.com.bean.ArtistaBean;
import pe.com.business.ArtistaBusiness;
import pe.com.entity.Artista;


public class AppTest {
	
	private final ArtistaBusiness artistaBusiness = new ArtistaBusiness();
	private static Artista artista;
	
	@BeforeClass
	public void inicioClase() {
		System.out.println("**********************Inicio Clase ArtistaTest**********************");
	}

	@AfterClass
	public void finClase() {
		System.out.println("**********************Fin Clase ArtistaTest**********************");
	}
	
	@BeforeTest
	public void inicioMetodo() {
		System.out.println("**********************Inicio Metodo ArtistaTest**********************");
	}

	@AfterTest
	public void finMetodo() {
		System.out.println("Id Artista: " + artista.getIdArtista());
		System.out.println("Nombre: " + artista.getNombre());
		System.out.println("**********************Fin Metodo ArtistaTest**********************\n\n");
	}
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados() {
		return new Object[][] { { new ArtistaBean("Luis Fonsi","DNI","74976315","19/08/85","M","Baladas")}, {new ArtistaBean("Marcelo Motta","DNI","74976315","19/08/81","M","Rock") } };
	}
	
	@Test
	public void insertar() {
		try{
			System.out.println("Metodo Insertar");
			artista = new Artista();
			artista.setNombre("Axl Rose");
            artista.setTipoDocumento("Prueba");
            artista.setDNI("Prueba");
            artista.setFechaNac("Prueba");
            artista.setSexo("Prueba");
            artista.setGenero("Prueba");
			artistaBusiness.insertar(artista);
			Assert.assertTrue(artista.getIdArtista()>0);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "datosEntrada")
	public void insertarDataProvider(ArtistaBean artistaBean) {
		try {
			System.out.println("Metodo Insertar");
			artista = new Artista();
			artista.setNombre(artistaBean.getNombre());
            artista.setTipoDocumento(artistaBean.getTipoDocumento());
            artista.setDNI(artistaBean.getDNI());
            artista.setFechaNac(artistaBean.getFechaNac());
            artista.setSexo(artistaBean.getSexo());
            artista.setGenero(artistaBean.getGenero());
			artistaBusiness.insertar(artista);
			Assert.assertTrue(artista.getIdArtista() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods={"insertar"})
	public void actualizar() {
		try{
			System.out.println("Metodo Actualizar");
			artista.setNombre("Prueba Actualizada");
			artista.setTipoDocumento("Prueba");
            artista.setDNI("Prueba");
            artista.setFechaNac("Prueba");
            artista.setSexo("Prueba");
            artista.setGenero("Prueba");
			artistaBusiness.actualizar(artista);
			Assert.assertTrue(artista.getIdArtista()>0);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods={"actualizar"})
	public void obtener(){
		try{
			System.out.println("Metodo Obtener");
			//System.out.println(artista.getIdArtista());
			Artista artistaBuscada = artistaBusiness.obtener(artista.getIdArtista());
			
			//System.out.println(artistaBuscada.getIdArtista());
			Assert.assertEquals(artista, artistaBuscada);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods={"obtener"})
	public void eliminar(){
		try{
			System.out.println("Metodo Eliminar");
			artistaBusiness.eliminar(artista);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	

}
