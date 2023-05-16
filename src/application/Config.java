package application;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    
    public static void build() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
    
}
