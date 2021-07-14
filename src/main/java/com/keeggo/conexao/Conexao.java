package com.keeggo.conexao;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.keeggo.conexao.Utilidades.executarComandoServico;

public class Conexao {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            Browser browser;
            if (System.getProperty("browser") == null) {
                browser = Browser.CHROME;
            } else {
                browser = Browser.valueOf(System.getProperty("browser").toUpperCase());
            }
            try {
                driver = browser.getBrowser();
                driver.manage().window().setSize(new Dimension(1980, 1080));
//                driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                    public void run() {
                        try {
                            fecharBrowser();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }));
            }
        }

        return driver;
    }

    public static void fecharBrowser() throws IOException {
        try {
            if (null != driver) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (UnreachableBrowserException ignore) {
        }
        driver = null;
    }
}
