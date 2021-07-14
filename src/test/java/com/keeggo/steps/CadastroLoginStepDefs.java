package com.keeggo.steps;

import com.keeggo.pages.CadastroLoginPage;
import com.keeggo.pages.LoginPage;
import com.keeggo.pages.TelaPrincial;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.util.List;
import java.util.Map;

import static com.keeggo.conexao.Utilidades.takeScreenShot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroLoginStepDefs {
    private Scenario scenario;
    private static String loginUsuarioCadastrado;

    @Before
    public void getScenarios(Scenario scenario) {
        this.scenario = scenario;
    }

    @E("^para criar uma nova conta$")
    public void paraCriarUmaNovaConta() throws InterruptedException {
        LoginPage.botaoCreateNewAccount();
    }

    @Quando("^na tela da cadastro passar pelos campos obrigatórios sem preenchê-los$")
    public void naTelaDaCadastroPassarPelosCamposObrigatóriosSemPreenchêLos() throws InterruptedException {
        CadastroLoginPage.inputRegisterUsernameTab();
        CadastroLoginPage.inputRegisterPasswordTab();
        CadastroLoginPage.inputRegisterEmailTab();
        CadastroLoginPage.inputRegisterConfirmPasswordTab();
    }

    @Então("^os campos da tela devem conter uma mensagem \"([^\"]*)\"$")
    public void osCamposDaTelaDevemConterUmaMensagem(String mensagem) throws Throwable {
        try {
            assertTrue(CadastroLoginPage.inputRegisterUsernameMensagem().contains(mensagem));
            assertTrue(CadastroLoginPage.inputRegisterPasswordMensagem().contains(mensagem));
            assertTrue(CadastroLoginPage.inputRegisterConfirmPasswordMensagem().contains(mensagem));
            assertTrue(CadastroLoginPage.inputRegisterEmailMensagem().contains(mensagem));
        } finally {
            takeScreenShot(scenario);
        }
    }

    @E("^o botão REGISTER deve ficar desabilitado$")
    public void oBotãoREGISTERDeveFicarDesabilitado() throws InterruptedException {
        try {
            assertTrue(CadastroLoginPage.botaoRegisterStatus().contains("invalid"));
        } finally {
            takeScreenShot(scenario);
        }
    }

    @E("^aceito as condições de uso e aviso de privacidade$")
    public void aceitoAsCondiçõesDeUsoEAvisoDePrivacidade() throws InterruptedException {
        try {
            CadastroLoginPage.inputRegisterIAgree();
        } finally {
            takeScreenShot(scenario);
        }
    }

    @Quando("^na tela da cadastro eu preencher os campos obrigatórios:$")
    public void naTelaDaCadastroEuPreencherOsCamposObrigatórios(List<Map<String, String>> dados) throws InterruptedException {
        loginUsuarioCadastrado = dados.get(0).get("Username");
        try {
            CadastroLoginPage.inputRegisterUsername(dados.get(0).get("Username"));
            CadastroLoginPage.inputRegisterEmail(dados.get(0).get("Email"));
            CadastroLoginPage.inputRegisterPassword(dados.get(0).get("Password"));
            CadastroLoginPage.inputRegisterConfirPassword(dados.get(0).get("Password"));
        } finally {
            takeScreenShot(scenario);
        }
    }


    @Quando("^na tela da cadastro eu preencher os campos:$")
    public void naTelaDaCadastroEuPreencherOsCampos(List<Map<String, String>> dados) throws InterruptedException {
        loginUsuarioCadastrado = dados.get(0).get("Username");
        try {
            CadastroLoginPage.inputRegisterUsername(dados.get(0).get("Username"));
            CadastroLoginPage.inputRegisterEmail(dados.get(0).get("Email"));
            CadastroLoginPage.inputRegisterPassword(dados.get(0).get("Password"));
            CadastroLoginPage.inputRegisterConfirPassword(dados.get(0).get("Password"));
            CadastroLoginPage.inputRegisterFirstName(dados.get(0).get("FirstName"));
            CadastroLoginPage.inputRegisterLastName(dados.get(0).get("LastName"));
            CadastroLoginPage.inputRegisterPhone(dados.get(0).get("Phone"));
            CadastroLoginPage.selectRegisterCountry();
            CadastroLoginPage.inputRegisterPhone(dados.get(0).get("Phone"));
            CadastroLoginPage.inputRegisterCity(dados.get(0).get("City"));
            CadastroLoginPage.inputRegisterAddress(dados.get(0).get("Address"));
            CadastroLoginPage.inputRegisterStateProvinceRegion(dados.get(0).get("State"));
            CadastroLoginPage.inputRegisterCodePostal(dados.get(0).get("Postal Code"));
        } finally {
            takeScreenShot(scenario);
        }
    }

    @E("^clicar REGISTER$")
    public void clicarREGISTER() throws InterruptedException {
        CadastroLoginPage.botaoRegister();
    }

    @Então("^o username do usuário  deve ser apresentado na tela$")
    public void oUsernameDoUsuárioDeveSerApresentadoNaTela() throws InterruptedException {
        try {
            assertTrue(TelaPrincial.getLoginUsuario().contains(loginUsuarioCadastrado));
            ;
        } finally {
            takeScreenShot(scenario);
        }
    }


}
