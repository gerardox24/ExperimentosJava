package pe.com.test.seleniumwd;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.seleniumwd.fuenteDatos.Excel;
import pe.com.test.seleniumwd.fuenteDatos.MySql;
import pe.com.test.seleniumwd.page.ArtistaPage;
import pe.com.test.seleniumwd.page.IniciarSesionPage;

public class ArtistaWebDriverTest {

	private String urlInicial = "http://localhost:8080/TSWeb/";
	private ArtistaPage artistaPage;
	private IniciarSesionPage iniciarSesionPage;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.artistaPage = new ArtistaPage(this.iniciarSesionPage.getWebDriver());
	}

	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
		datos = Excel.leerExcel(rutaArchivo);
		System.out.println("Datos: " + datos.toString());
		return datos;
	}
	
	@DataProvider(name = "datosEntrada2")
	public static Object[][] datosPoblados2(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo2");
		datos = Excel.leerExcel(rutaArchivo);
		return datos;
	}
	
	@DataProvider(name = "datosEntrada3")
	public static Object[][] datosPoblados3(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo3");
		datos = Excel.leerExcel(rutaArchivo);
		return datos;
	}
	
	@Test(dataProvider = "datosEntrada")
	public void insertarArtista(String usuario, String clave, String nombre,String tipoDocumento,String DNI,String fechaNac,String sexo,String genero, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = artistaPage.insertar(nombre.trim(),tipoDocumento.trim(),DNI.trim(),fechaNac.trim(),sexo.trim(),genero.trim());
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "datosEntrada2",dependsOnMethods = {"insertarArtista"})
	public void actualizarArtista(String usuario, String clave, String nombre, String nombreactualizado,String tipoDocumento,String DNI,String fechaNac,String sexo,String genero,  String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = artistaPage.actualizar(nombre.trim(),nombreactualizado.trim());
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "datosEntrada3",dependsOnMethods = {"actualizarArtista"})
	public void eliminarArtista(String usuario, String clave, String nombre, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = artistaPage.eliminar(nombre.trim());
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@AfterTest
	public void tearDown() throws Exception {
		artistaPage.cerrarPagina();
	}

}
