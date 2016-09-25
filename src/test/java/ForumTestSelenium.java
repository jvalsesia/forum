/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;

/**
 *
 * @author jvalsesia
 */
public class ForumTestSelenium {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://192.168.0.19:8084";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testForumselenium() throws Exception {
        driver.get(baseUrl + "/forum/");
        driver.findElement(By.id("btToCadastro")).click();
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys("Julio Valsesia");
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("jvalsesia");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("jvalsesia@email.com");
        driver.findElement(By.name("senha")).clear();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.id("btCadastrar")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("jvalsesia");
        driver.findElement(By.name("senha")).clear();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.id("btLogin")).click();
        driver.findElement(By.id("btInserirTopico")).click();
        driver.findElement(By.name("titulo")).clear();
        driver.findElement(By.name("titulo")).sendKeys("topico 01");
        driver.findElement(By.name("conteudo")).clear();
        driver.findElement(By.name("conteudo")).sendKeys("conteudo 01");
        driver.findElement(By.id("btNewTopico")).click();
        driver.findElement(By.id("btExibir")).click();
        driver.findElement(By.name("comentario")).clear();
        driver.findElement(By.name("comentario")).sendKeys("comentario 01");
        driver.findElement(By.id("btNovoComentario")).click();
        driver.findElement(By.id("btVoltaTopicos")).click();
        driver.findElement(By.id("btExibir")).click();
        driver.findElement(By.id("btVoltaTopicos")).click();
        driver.findElement(By.id("btExibirRanking")).click();
        driver.findElement(By.id("btVoltaTopicos")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
