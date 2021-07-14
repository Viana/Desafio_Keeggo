package com.keeggo.conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(".\\src\\main\\resources\\config.properties");
        props.load(file);
        return props;
    }
}
