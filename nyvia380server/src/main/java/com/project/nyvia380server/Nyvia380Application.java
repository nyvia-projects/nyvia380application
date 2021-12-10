package com.project.nyvia380server;

import com.project.nyvia380server.common.chat.MessageDB;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
@SpringBootApplication
public class Nyvia380Application extends SpringBootServletInitializer {

    public static MessageDB messageDB = new MessageDB();


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Nyvia380Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Nyvia380Application.class, args);
        /*
        System.setProperty("webdriver.chrome.driver", "src/main/resources/static/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");*/
//        LaunchBrowserTo("http://localhost:8080/");

    }



  //  @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent() {
        log.info("Server running... launching browser...");
        LaunchBrowserTo("http://localhost:8080/");
    }

    public static void LaunchBrowserTo(String url) {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
