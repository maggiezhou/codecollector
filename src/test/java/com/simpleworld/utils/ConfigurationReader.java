package com.simpleworld.utils;


public class ConfigurationReader{
    String baseURI = System.getProperty("BaseURI", "http://eac-easoapp50.eac.ad.ea.com");
    Integer port = Integer.parseInt(System.getProperty("Port", "10093"));
    String basePath = System.getProperty("BasePath", "/_collector/v1/");
    String apikey = System.getProperty("Apikey", "7");
    String sku = System.getProperty("Sku", "TESTING");
}
