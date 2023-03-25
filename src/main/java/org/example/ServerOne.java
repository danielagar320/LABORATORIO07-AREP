package org.example;

import static spark.Spark.*;

public class ServerOne {

    public static void main(String[] args) {

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), getPwdKeyStore(), null, null);

        port(getPort());
        get("/hello", (req, res) -> "Hello Server 1");
        get("/Remote", (req, res) -> URLReader.readSecureUrl("https://ec2-44-201-16-129.compute-1.amazonaws.com:4566/hello",getKeyServerTwo(), getPwdKeyStore()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystoreAWS.p12";
    }

    static String getKeyServerTwo() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystoreAWS2.p12";
    }

    static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "123456";
    }
}
// Abrir en: http://localhost:4567/hello

//keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650