package com.keeggo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.keeggo.conexao.Conexao.getDriver;
import static com.keeggo.conexao.Utilidades.*;

public class LoginPage {

    public static void loginFacebook() throws InterruptedException {
        clicar(By.xpath("//span[text()='SIGN IN WITH FACEBOOK']"));
        Thread.sleep(1000);
    }

    public static void botaoSingIn() throws InterruptedException {
        clicar(By.xpath("//button[text()='SIGN IN']"));
    }

    public static void botaoCreateNewAccount() throws InterruptedException {
        clicar(By.xpath("//a[text()='CREATE NEW ACCOUNT']"));
        aguardarElementoDesaparecer(By.xpath("//div[@class='PopUp']"));
    }

    public static String botaoSingInStatus() throws InterruptedException {
       return getAttribute(By.xpath("//button[text()='SIGN IN']"),"class");
    }

    public static void inputUsername(String user) throws InterruptedException {
        digitar(By.name("username"), user);
    }

    public static void inputPassword(String pass) throws InterruptedException {
        digitar(By.name("password"), pass);
    }

    public static void inputUsernameTab() throws InterruptedException {
        getDriver().findElement(By.name("username")).sendKeys(Keys.TAB);
    }

    public static void inputPasswordTab() throws InterruptedException {
        getDriver().findElement(By.name("password")).sendKeys(Keys.TAB);
    }

    public static String inputUsernameMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[div[text()='Username']]/label"));
    }

    public static String inputPasswordMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[div[text()='Password']]/label"));
    }

    public static String mensagemAlerta() throws InterruptedException {
        return getTexto(By.id("signInResultMessage"));
    }

}
