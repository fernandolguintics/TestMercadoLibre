package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IngresarProducto extends Base {

	public IngresarProducto(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By welcomePage = By.xpath("//h1[@class='ml-logo ml-logo-es']");
	By btnBuscar = By.xpath("//button[@class='nav-search-btn']");
	By listaProductos = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']");
	By filtrarNuevos = By.xpath("//aside[@class='ui-search-sidebar shops__sidebar']/section/div[7]/ul[1]/li[1]/a");
	By filtrarEstado = By.xpath("//section[@class='ui-search-filter-groups shops__filter-groups']/div[14]/ul/li[1]/a");
	By abrirListaOrden = By.xpath("//button[@class='andes-dropdown__trigger']");
	By selectCountry = By.id("MX");
	By selectMenorPrecio = By.id("andes-dropdown-más-relevantes-list-option-price_asc");
	By textboxBuscarProducto = By.id("cb1-edit");
	By mensajeInicio = By.className("nav-logo");
	By productosDisponibles = By.tagName("h2");
	By precios = By.xpath("//div[@class='ui-search-price ui-search-price--size-medium shops__price']/div/span[1]/span[1]");


	public void AccederMenuMexico() throws InterruptedException {
		if(IsDisplayed(welcomePage)) {
			Click(selectCountry);
			Thread.sleep(2000);
		}else {
			System.out.println("No se encontro la pagina");
		}
	}
	
	public void BuscarProducto() throws InterruptedException {
		if(IsDisplayed(mensajeInicio)) {
			Type("Playstation 4",textboxBuscarProducto);
			Click(btnBuscar);
			Thread.sleep(2000);
			
		}else {
			System.out.println("No se encontro la pagina");
		}
	}
	
	public String FiltrarProductos() throws InterruptedException {
		if(IsDisplayed(listaProductos)) {
			 Click(abrirListaOrden);
			 Thread.sleep(2000);
			 Click(selectMenorPrecio);
			 Thread.sleep(2000);
			 visit(FindElement(filtrarNuevos).getAttribute("href"));
			 Thread.sleep(2000);
			 visit(FindElement(filtrarEstado).getAttribute("href"));
			 Thread.sleep(2000);
			 ImprimirProductos();
			 return "Busqueda Realizada";
		}else {
			return "Busqueda Fallida";
		}
	}
	
	public void ImprimirProductos(){
		List<WebElement> productos = FindElements(productosDisponibles);
		List<WebElement> preciosProductos = FindElements(precios);
		 System.out.println("Producto:"+GetText(productos.get(0))+"\n"+"Precio:"+GetText(preciosProductos.get(0))+"\n");
		 System.out.println("Producto:"+GetText(productos.get(1))+"\n"+"Precio:"+GetText(preciosProductos.get(1))+"\n");
		 System.out.println("Producto:"+GetText(productos.get(2))+"\n"+"Precio:"+GetText(preciosProductos.get(2))+"\n");
		 System.out.println("Producto:"+GetText(productos.get(3))+"\n"+"Precio:"+GetText(preciosProductos.get(3))+"\n");
		 System.out.println("Producto:"+GetText(productos.get(4))+"\n"+"Precio:"+GetText(preciosProductos.get(4))+"\n");
	}
	

}
