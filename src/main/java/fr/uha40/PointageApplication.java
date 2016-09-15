package fr.uha40;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
public class PointageApplication {

    private static final Logger logger = LoggerFactory.getLogger(PointageApplication.class);

    public static void main(String[] args) {
        logger.debug("PASSWORD ADMIN ENCRYPTED : " + BCrypt.hashpw("admin", BCrypt.gensalt()));
        SpringApplication.run(PointageApplication.class, args);
    }
}
