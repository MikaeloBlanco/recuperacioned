package com.cpfifp.grijander.parkingfinal.integracion.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cpfifp.grijander.parkingfinal.core.Repository;
import com.cpfifp.grijander.parkingfinal.core.service.ParkingServiceImpl;
import com.cpfifp.grijander.parkingfinal.integracion.CucumberConfiguration;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class CucumberSteps extends CucumberConfiguration {

    private static ChromeDriver driver;
    @MockBean
    private Repository mockedRepository;
    @Spy
    @InjectMocks
    private ParkingServiceImpl mockedService;
    @BeforeAll
    public static void prepareWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

    }

    @Dado("que el alumno esta en junio")
    public void junio() {

    }

    @Cuando("el alumno realice las tareas")
    public void tareas()  {

    }

    @Entonces("el almuno aprobara la asignatura")
    public void aprueba() {
        assertFalse(true);
    }
}