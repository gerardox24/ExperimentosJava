package pe.com.test.seleniumwd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.seleniumwd.driver.TSDriver;

public class ArtistaPage {

	private By linkMenu = By.xpath("/html/body/section/div[1]/div");
	
	private By linkModAlmacen = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
	private By linkMntArtista = By.linkText("Mnt. de Artista");
	private By botonNuevo = By.id("btnNuevo");
	private By cajaNombre = By.id("txtNombre");
	private By cajaTipoDocumento = By.id("txtTipoDocumento");
	private By cajaDNI = By.id("txtDNI");
	private By cajaFechaNac = By.id("txtFechaNac");
	private By cajaSexo = By.id("txtSexo");
	private By cajaGenero = By.id("txtGenero");
	private By botonGuardar = By.id("btnGuardar");
	private By mensajeRespuesta = By.id("messages");
	private By botonFiltro = By.id("btnFiltrar");
	private By cajaFiltro = By.id("txtFiltro");
	private By botonActualizar = By.id("btnActualizar");
	private By firstElement = By.xpath("/html/body/section/div[2]/div/div/div/div/div/div[2]/form/div[1]/div[3]/table/tbody/tr[1]/td[1]");
	private By botonEliminar = By.id("btnEliminar");
	private By botonSiEliminar = By.id("btnSi");
	private WebDriver webDriver = null;
	
	public ArtistaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String insertar(String nombre,String tipoDocumento,String DNI,String fechaNac,String sexo,String genero) throws Exception {
		webDriver.findElement(linkMenu).click();
		Thread.sleep(2000);
		webDriver.findElement(linkModAlmacen).click();
		Thread.sleep(2000);
		webDriver.findElement(linkMntArtista).click();
		Thread.sleep(2000);
		webDriver.findElement(botonNuevo).click();
		Thread.sleep(2000);
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		webDriver.findElement(cajaTipoDocumento).clear();
		webDriver.findElement(cajaTipoDocumento).sendKeys(tipoDocumento);
		webDriver.findElement(cajaDNI).clear();
		webDriver.findElement(cajaDNI).sendKeys(DNI);
		webDriver.findElement(cajaFechaNac).clear();
		webDriver.findElement(cajaFechaNac).sendKeys(fechaNac);
		webDriver.findElement(cajaSexo).clear();
		webDriver.findElement(cajaSexo).sendKeys(sexo);
		webDriver.findElement(cajaGenero).clear();
		webDriver.findElement(cajaGenero).sendKeys(genero);
		webDriver.findElement(botonGuardar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public String actualizar(String nombre, String nombreactualizado) throws Exception {
		webDriver.findElement(linkMenu).click();
		Thread.sleep(2000);
		webDriver.findElement(linkModAlmacen).click();
		Thread.sleep(2000);
		webDriver.findElement(linkMntArtista).click();
		Thread.sleep(2000);
		webDriver.findElement(cajaFiltro).clear();
		webDriver.findElement(cajaFiltro).sendKeys(nombre);
		webDriver.findElement(botonFiltro).click();
		Thread.sleep(2000);
		webDriver.findElement(firstElement).click();
		Thread.sleep(2000);
		webDriver.findElement(botonActualizar).click();
		Thread.sleep(2000);
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombreactualizado);
		webDriver.findElement(botonGuardar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public String eliminar(String nombre) throws Exception {
		webDriver.findElement(linkMenu).click();
		Thread.sleep(2000);
		webDriver.findElement(linkModAlmacen).click();
		Thread.sleep(2000);
		webDriver.findElement(linkMntArtista).click();
		Thread.sleep(2000);
		webDriver.findElement(cajaFiltro).clear();
		webDriver.findElement(cajaFiltro).sendKeys(nombre);
		webDriver.findElement(botonFiltro).click();
		Thread.sleep(2000);
		webDriver.findElement(firstElement).click();
		Thread.sleep(2000);
		webDriver.findElement(botonEliminar).click();
		Thread.sleep(2000);
		webDriver.findElement(botonSiEliminar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	public void cerrarPagina(){
		TSDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}

}
