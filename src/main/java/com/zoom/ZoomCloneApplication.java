package com.zoom;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZoomCloneApplication {
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    public static void main(String[] args) {
        SpringApplication.run(ZoomCloneApplication.class, args);
    }
}
