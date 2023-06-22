package com.cpfifp.grijander.parkingfinal.integracion.steps;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.clearInvocations;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpfifp.grijander.parkingfinal.core.Repository;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingServiceImpl;
import com.cpfifp.grijander.parkingfinal.integracion.CucumberConfiguration;
import com.cpfifp.grijander.parkingfinal.ticket.domain.Ticket;
import com.cpfifp.grijander.parkingfinal.vehiculo.domain.Vehiculo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.websocket.Endpoint;

@CucumberContextConfiguration
public class CucumberSteps extends CucumberConfiguration {

    private static ChromeDriver driver;
    @MockBean
    private Repository mockedRepository;
    @Spy
    @InjectMocks
    private ParkingServiceImpl mockedService;
    private static Ticket ticket; 
    private static Vehiculo vehiculo;
    @BeforeAll
    public static void prepareWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        vehiculo = new Vehiculo("0000AAA");
        ticket = new Ticket(vehiculo);

    }

    @Value("${local.server.port}")
    private int port;

    @Before
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        MockitoAnnotations.openMocks(this);
        driver = new ChromeDriver(options);
        clearInvocations(mockedRepository);
    }

    @After
    public void quitDriver() {
        driver.quit();

    }

    @Dado("un usuario esta en la pagina {}")
    public void openPage(String pageName) {
        String endPoint = "";

        switch (pageName) {
            case "inicio":
                endPoint = "/";
                break;

            case "vehiculos":
                endPoint = "/vehiculos";
                break;

            case "tickets":
                endPoint = "/tickets";
                break;

            case "aparcar vehiculo":
                endPoint = "/aparcar";
                break;

            case "detalles de ticket":
                endPoint = "/detallesTicket";
                break;

        }

        driver.get("http://localhost:" + port + endPoint);
    }

    @Y("existe un {}")
    public void ticketExistente(String opcion){
        switch(opcion){
            case "ticket":
                //mockedRepository.añadirTicketPasado(ticket);
                break;
            case "vehiculo":
                break;
        }
    }

    @Cuando("clica el enlace con el nombre {} en la barra de navegación")
    public void openPage2(String pageName){
        String endPoint = "";

        switch(pageName){
            case "Vehiculos":
                endPoint = "/vehiculos";
                break;
            case "Tickets":
                endPoint = "/tickets";
                break; 
        }
        driver.get("http://localhost:" + port + endPoint);
    }

    @Cuando("clica el boton de {}")
    public void openPageButton(String pageName){
        String endPoint = "";
        switch(pageName){
            case "aparcar un vehiculo":
                endPoint = "/aparcar";
                break;
            case "detalles":
                endPoint = "/detallesTickets";
                break; 
        }
        driver.get("http://localhost:" + port + endPoint);
    }

    @Entonces("el usuario se encuentra en la pagina de {}")
    public void usuarioEnPagina(String pageName){
        assertTrue(driver.getCurrentUrl().equals(getUrlFromPageName(pageName)));
    }

    @Entonces("se muestra el campo {}")
    public void fieldIsDisplayed(String fieldName) {
        String fieldId = getFieldIdFromName(fieldName);
        WebElement field = driver.findElement(By.id(fieldId));

        assertTrue(field.isDisplayed());
    }

    @Entonces("se muestra el boton de aparcar")
    public void createButtondIsDisplayed() {
        WebElement button = driver.findElement(By.id("button is-primary"));
        assertAll("Create button",
                () -> {
                    assertEquals(button.getTagName().toLowerCase(), "button");
                },
                () -> {
                    assertTrue(button.isDisplayed());
                });
    }

    private String getUrlFromPageName(String pageName) {
        String endPoint = "";
        switch (pageName) {
            case "inicio":
                endPoint = "/";
                break;
            case "vehiculos":
                endPoint = "/vehiculos";
                break;
            case "tickets":
                endPoint = "/tickets";
                break;
            case "aparcar":
                endPoint = "/aparcar";
                break;
            case "detalles de ticket":
                endPoint = "/detallesTickets";
                break;
            default:
                break;
        }
        return getUrlFromEndPoint(endPoint);
    }

    private String getUrlFromEndPoint(String endpoint) {
        return "http://localhost:" + port + endpoint;
    }
    private String getFieldIdFromName(String fieldName) {
        String fieldID = "";
        switch(fieldName){
            case "titulo":
                fieldID = "home-title";
                break;
            case "tabla":
                fieldID = "";
                break;
            case "input de matricula":
                fieldID = "";
                break;
        }
        return fieldID;
    }
}