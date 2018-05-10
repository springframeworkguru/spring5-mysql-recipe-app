package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "classpath:persistence-${envTarget:dev}.properties" })
public class Spring5RecipeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5RecipeAppApplication.class, args);
	}
}
