package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class AtosProyect1Application.
 */
@SpringBootApplication
public class AtosProyect1Application implements CommandLineRunner{
	
	
    /** The password enconder. */
    private BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AtosProyect1Application.class, args);
	}

	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {
		String password = "123456";

        for (int i = 0; i < 4; i++) {
            String passwordBCrpyt = passwordEnconder.encode(password);
            System.out.println(passwordBCrpyt);

        }
	}

}
