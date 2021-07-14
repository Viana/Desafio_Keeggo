package com.keeggo.conexao;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static com.keeggo.conexao.Conexao.getDriver;

public class Utilidades {

    public static void clicar(By locator) throws InterruptedException {
        WebElement obj = elementoDisplayed(locator);
        highLighterMethod(getDriver(), obj);
        obj.click();
    }

    public static void highLighterMethod(WebDriver driver, WebElement obj) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: ; border: 4px solid red;');", obj);
    }

    public static void digitar(By locator, String info) throws InterruptedException {
        WebElement obj = elementoDisplayed(locator);
        highLighterMethod(getDriver(), obj);
        obj.clear();
        obj.sendKeys(info);
    }

    public static String getTexto(By locator) throws InterruptedException {
        WebElement obj = elementoDisplayed(locator);
        highLighterMethod(getDriver(), obj);
        return obj.getText();
    }

    public static WebElement elementoDisplayed(By locator) throws InterruptedException {
        WebElement obj = null;
        aguardarElementoVisivel(locator);
        List<WebElement> locators = getDriver().findElements(locator);
        if (locators.size() > 0) {
            for (WebElement el : locators) {
                if (el.isDisplayed()) {
                    obj = el;
                    scrollElement(locator);
                    break;
                }
            }
        } else {
            obj = getDriver().findElement(locator);
        }
        return obj;
    }

    private static void scrollElement(By locator) throws InterruptedException {
        WebElement obj = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", obj);
        Thread.sleep(200);
    }

    public static void aguardarElementoVisivel(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void aguardarElementoDesaparecer(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void takeScreenShot(Scenario scenario) throws WebDriverException {
        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public static boolean elementIsPresent(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

    public static String getAttribute(By locator, String atributo) throws InterruptedException {
        WebElement obj = elementoDisplayed(locator);
        highLighterMethod(getDriver(), obj);
        return obj.getAttribute(atributo);
    }

    public static void select(By locator, int opcao) {
        Select select = new Select(getDriver().findElement(locator));
        select.selectByIndex(opcao);
    }

    public static void executarComandoServico(String acao, String servico) {
        String[] command = new String[]{"cmd.exe", "/c", "net", acao, servico};

        try {
            Process process = (new ProcessBuilder(command)).start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(2000L);
            }
        } catch (Exception var8) {
            System.out.println("Exception : " + var8);
        }

    }
}
