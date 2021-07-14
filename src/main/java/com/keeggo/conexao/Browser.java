package com.keeggo.conexao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public enum Browser {
    CHROME {
        @Override
        public WebDriver getBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
            option.addArguments("–incognito");
            option.addArguments("--log-level=3");
            option.addArguments("--silent");
            option.setExperimentalOption("prefs", chromePrefs);
            System.setProperty("webdriver.chrome.silentOutput", "true");
            option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return new ChromeDriver(option);
        }
    }, FIREFOX {
        @Override
        public WebDriver getBrowser() {
            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.download.folderList", 2);
            return new FirefoxDriver(options);
        }
    }, EDGE {
        @Override
        public WebDriver getBrowser() {
            WebDriverManager.edgedriver().setup();
            EdgeOptions op = new EdgeOptions();
            return new EdgeDriver(op);
        }
    };

    public abstract WebDriver getBrowser();
}
