package org.example;

import static spark.Spark.*;

public class ServerTwo {

    public static void main(String[] args) {

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), getPwdKeyStore(), null, null);

        port(getPort());
        get("/hello", (req, res) -> "Hello Server 2");
        get("/Remote", (req, res) -> URLReader.readSecureUrl("https://ec2-3-236-190-39.compute-1.amazonaws.com:5000/hello",getKeyServerOne(), getPwdKeyStore()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4566 ; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystoreAWS2.p12";
    }

    static String getKeyServerOne() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystoreAWS.p12";
    }

    static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "123456";
    }
}
