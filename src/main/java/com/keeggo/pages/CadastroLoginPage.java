package com.keeggo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.keeggo.conexao.Conexao.getDriver;
import static com.keeggo.conexao.Utilidades.*;

public class CadastroLoginPage {
    private static String loginUser;
    private static int numAleatorio;

    public static void inputRegisterUsername(String user) throws InterruptedException {
        numAleatorio = new Random().ints(1, 0, 100000).findFirst().getAsInt();
        loginUser = user + numAleatorio;
        digitar(By.name("usernameRegisterPage"), loginUser);
        System.out.println(">>>> " + loginUser);
    }

    public static String inputRegisterUsernameMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[@id='formCover']//div[div[text()='Username']]/label"));
    }

    public static String inputRegisterPasswordMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[@id='formCover']//div[div[text()='Password']]/label"));
    }

    public static String inputRegisterConfirmPasswordMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[@id='formCover']//div[div[text()='Confirm password']]/label"));
    }

    public static String inputRegisterEmailMensagem() throws InterruptedException {
        return getTexto(By.xpath("//div[@id='formCover']//div[div[text()='Email']]/label"));
    }

    public static void inputRegisterEmail(String email) throws InterruptedException {
        email = numAleatorio+email;
        digitar(By.name("emailRegisterPage"), email);
    }

    public static void inputRegisterPassword(String pass) throws InterruptedException {
        digitar(By.name("passwordRegisterPage"), pass);
    }

    public static void inputRegisterConfirPassword(String comPass) throws InterruptedException {
        digitar(By.name("confirm_passwordRegisterPage"), comPass);
    }

    public static void inputRegisterEmailTab() throws InterruptedException {
        getDriver().findElement(By.name("emailRegisterPage")).sendKeys(Keys.TAB);
    }

    public static void inputRegisterPasswordTab() throws InterruptedException {
        getDriver().findElement(By.name("passwordRegisterPage")).sendKeys(Keys.TAB);
    }

    public static void inputRegisterConfirmPasswordTab() throws InterruptedException {
        getDriver().findElement(By.name("confirm_passwordRegisterPage")).sendKeys(Keys.TAB);
    }

    public static void inputRegisterUsernameTab() throws InterruptedException {
        getDriver().findElement(By.name("usernameRegisterPage")).sendKeys(Keys.TAB);
    }

    public static void inputRegisterFirstName(String firstName) throws InterruptedException {
        firstName = firstName + numAleatorio;
        digitar(By.name("first_nameRegisterPage"), firstName);
    }

    public static void inputRegisterLastName(String lastName) throws InterruptedException {
        lastName = lastName + numAleatorio;
        digitar(By.name("last_nameRegisterPage"), lastName);
    }

    public static void inputRegisterPhone(String phone) throws InterruptedException {
        digitar(By.name("phone_numberRegisterPage"), phone);
    }

    public static void inputRegisterCity(String city) throws InterruptedException {
        digitar(By.name("cityRegisterPage"), city);
    }

    public static void inputRegisterAddress(String address) throws InterruptedException {
        digitar(By.name("addressRegisterPage"), address);
    }

    public static void inputRegisterStateProvinceRegion(String opcao) throws InterruptedException {
        digitar(By.name("state_/_province_/_regionRegisterPage"), opcao);
    }

    public static void inputRegisterCodePostal(String codePostal) throws InterruptedException {
        digitar(By.name("postal_codeRegisterPage"), codePostal);
    }

    public static void inputRegisterOffers() throws InterruptedException {
        clicar(By.name("allowOffersPromotion"));
    }

    public static void inputRegisterIAgree() throws InterruptedException {
        clicar(By.name("i_agree"));
    }

    public static void selectRegisterCountry() throws InterruptedException {
        select(By.name("countryListboxRegisterPage"), new Random().ints(1, 0, 200).findFirst().getAsInt());
    }

    public static void botaoRegister() throws InterruptedException {
        clicar(By.id("register_btnundefined"));
    }

    public static void linkAlreadyAccount() throws InterruptedException {
        clicar(By.xpath("//a[text()='ALREADY HAVE AN ACCOUNT?']"));
    }

    public static String botaoRegisterStatus() throws InterruptedException {
        return getAttribute(By.xpath("//button[text()='REGISTER']"), "class");
    }

}
