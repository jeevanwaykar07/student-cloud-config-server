package springcloudconfigserverstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerStudentApplication.class, args);
	}

}
