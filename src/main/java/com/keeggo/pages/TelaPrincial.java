package com.keeggo.pages;

import org.openqa.selenium.By;

import static com.keeggo.conexao.Utilidades.clicar;
import static com.keeggo.conexao.Utilidades.getTexto;

public class TelaPrincial {

    public static void clicarBotaoLogar() throws InterruptedException {
        clicar(By.id("menuUserLink"));
    }

    public static String getLoginUsuario() throws InterruptedException {
        return getTexto(By.xpath("//a[@id='menuUserLink']/span"));
    }
}
