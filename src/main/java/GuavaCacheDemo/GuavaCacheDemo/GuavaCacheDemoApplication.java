package GuavaCacheDemo.GuavaCacheDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GuavaCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuavaCacheDemoApplication.class, args);
	}

}
