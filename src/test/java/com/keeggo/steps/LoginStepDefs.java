package com.keeggo.steps;

import com.keeggo.pages.LoginPage;
import com.keeggo.pages.TelaPrincial;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.keeggo.conexao.Conexao.getDriver;
import static com.keeggo.conexao.Utilidades.elementIsPresent;
import static com.keeggo.conexao.Utilidades.takeScreenShot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefs {
    private Scenario scenario;
    String loginEsperado = null;

    @Before
    public void getScenarios(Scenario scenario) {
        this.scenario = scenario;
    }

    @Dado("^que acessei a url \"([^\"]*)\"$")
    public void queAcesseiAUrl(String url) throws Throwable {
        getDriver().get(url);
        while (true) {
            if (elementIsPresent(By.xpath("//body/div[@class='loader' and normalize-space(@style)='display: none; opacity: 0;']"))) {
                break;
            }
        }
    }

    @E("^acessei a tela de login$")
    public void acesseiATelaDeLogin() throws InterruptedException {
        TelaPrincial.clicarBotaoLogar();
    }


    @Quando("^tentar logar com login \"([^\"]*)\" pelo usuário do facebook$")
    public void tentarLogarComLoginPeloUsuárioDoFacebook(String login) throws Throwable {
        loginEsperado = login;
        try {
            LoginPage.loginFacebook();
        } finally {
            takeScreenShot(scenario);
        }
    }

    @Então("^o  login do usuário deve ser apresentado na tela$")
    public void oLoginDoUsuárioDeveSerApresentadoNaTela() throws InterruptedException {
        try {
            String loginTela = TelaPrincial.getLoginUsuario();
            assertEquals(loginEsperado, loginTela);
        } finally {
            takeScreenShot(scenario);
        }
    }


    @Quando("^passar pelos campos obrigatórios sem preenchê-los$")
    public void passarPelosCamposObrigatóriosSemPreenchêLos() throws InterruptedException {
        LoginPage.inputUsernameTab();
        LoginPage.inputPasswordTab();
    }

    @Então("^os campos devem conter uma mensagem \"([^\"]*)\"$")
    public void osCamposDevemConterUmaMensagem(String mensagem) throws Throwable {
        try {
            assertTrue(LoginPage.inputUsernameMensagem().contains(mensagem));
            assertTrue(LoginPage.inputPasswordMensagem().contains(mensagem));
        } finally {
            takeScreenShot(scenario);
        }
    }

    @E("^o botão SIGN IN deve ficar desabilitado$")
    public void oBotãoSIGNINDeveFicarDesabilitado() throws InterruptedException {
        try {
            assertTrue(LoginPage.botaoSingInStatus().contains("invalid"));
        } finally {
            takeScreenShot(scenario);
        }
    }

    @E("^preencher os campos de login:$")
    public void preencherOsCamposDeLogin(List<Map<String, String>> dados) throws InterruptedException {
        LoginPage.inputUsername(dados.get(0).get("Username"));
        LoginPage.inputPassword(dados.get(0).get("Password"));
    }

    @Quando("^clicar SIGN IN$")
    public void clicarSIGNIN() throws InterruptedException {
        LoginPage.botaoSingIn();
    }

    @Então("^a mensagem \"([^\"]*)\" deve ser informada na tela$")
    public void aMensagemDeveSerInformadaNaTela(String mensagemEsperada) throws Throwable {
        try {
            assertEquals(mensagemEsperada, LoginPage.mensagemAlerta());
        } finally {
            takeScreenShot(scenario);
        }
    }


    @Então("^o usuário \"([^\"]*)\" deve ser apresentado na tela$")
    public void oUsuárioDeveSerApresentadoNaTela(String loginEsperado) throws Throwable {
        try {
            assertEquals(loginEsperado, TelaPrincial.getLoginUsuario());
        } finally {
            takeScreenShot(scenario);
        }
    }
}
