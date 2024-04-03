package woojjam.serversetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ServerSettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSettingApplication.class, args);
	}

}
