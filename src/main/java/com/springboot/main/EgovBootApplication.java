package com.springboot.main;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.springboot.config.AspectConfig;
import com.springboot.config.CommonConfig;
import com.springboot.config.DatasourceConfig;
import com.springboot.config.IdGenConfig;
import com.springboot.config.MapperConfig;
import com.springboot.config.PropertiesConfig;

@SpringBootApplication
@ImportResource("classpath:/egovframework/spring/com/*.xml")
@Import({
	AspectConfig.class,
	CommonConfig.class,
	DatasourceConfig.class,
	IdGenConfig.class,
	PropertiesConfig.class,
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
