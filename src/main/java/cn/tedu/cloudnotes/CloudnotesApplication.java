package cn.tedu.cloudnotes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tedu.cloudnotes.mapper")
public class CloudnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnotesApplication.class, args);
	}

}
