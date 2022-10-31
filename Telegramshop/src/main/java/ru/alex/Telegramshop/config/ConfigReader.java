package ru.alex.Telegramshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Component
public class ConfigReader {

  private static Properties properties;

  static {
    try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\Desktop\\TELE\\Telegramshop\\src\\main\\resources\\application.properties")) {
      properties = new Properties();
      properties.load(fileInputStream);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Unable to find configuration.properties file!");
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}