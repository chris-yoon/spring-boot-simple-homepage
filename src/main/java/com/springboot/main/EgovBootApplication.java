package com.springboot.main;

import com.springboot.config.AspectConfig;
import com.springboot.config.DatasourceConfig;
import com.springboot.config.IdGenConfig;
import com.springboot.config.MapperConfig;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/egovframework/spring/com/*.xml")
@Import({
	AspectConfig.class,
	DatasourceConfig.class,
	IdGenConfig.class,
	MapperConfig.class
})

// @Import(EgovBootInitialization.class)
public class EgovBootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EgovBootApplication.class, args);

		System.out.println("##### EgovSampleBootApplication Start #####");

		SpringApplication springApplication = new SpringApplication(EgovBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setLogStartupInfo(false);
		springApplication.run(args);

		System.out.println("##### EgovSampleBootApplication End #####");
	}

}
