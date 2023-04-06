package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ImprimirProductosTest {

	private WebDriver driver;
	IngresarProducto acceder;
	String mensaje = "Mercado Libre México - Donde comprar y vender de todo"; 
	String titulo = "Busqueda Realizada";
	@Before
	public void setUp() throws Exception {
		acceder = new IngresarProducto(driver);	
		driver = acceder.ChromeDriverConnection();
		acceder.visit("https://www.mercadolibre.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AccederyBuscar() throws InterruptedException {
		acceder.AccederMenuMexico();
		acceder.BuscarProducto();
		assertEquals(titulo, acceder.FiltrarProductos());

	}
	
	

}
