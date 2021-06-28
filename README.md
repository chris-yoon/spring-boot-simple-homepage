## xml 에 정의된 Beans

- 스프링 3 이전에는 XML이 빈 정의의 유일한 방법이었다.
- 스프링 3에서 JavaConfig가 도입되었다. 하지만, 여전히 XML 설정이 사용되고 있다.

### # JavaConfig 장점

1. type-safe
2. 유지관리 용이

## 스프링과 스프링부트 차이점

스프링부트는 기본적으로 스프링의 확장으로, 스프링 애플리케이션을 설정하는 데 필요한 기본골격을 제공하여 개발자로 하여금 설정을 최소화한다.

- 의존성 관리: 스프링이 제공하는 특정 모듈을 사용할 수 있도록 관련 라이브러리 의존성 미리 정의하여 제공
- 자동설정(AutoConfiguration): 별도의 설정이 없이 Bean들을 자동으로 등록하는 기능
- Actuator: 스프링부트로 개발된 시스템을 외부에서 모니터링 가능하도록 데이터 제공

### spring-boot-dependencies-2.2.6.RELEASE.pom

> https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-dependencies/2.2.6.RELEASE/spring-boot-dependencies-2.2.6.RELEASE.pom

### starter

스프링부트는 다양한 스타터를 spring-boot-starter-{모듈명} 으로 다양한 모듈을 제공한다.

- spring-boot-starter-web
- spring-boot-starter-test

#### spring-boot-starter-web

spring-boot-starter-web 스타터를 추가하면 WebMvc 를 사용하여 웹 애플리케이션을 만드는 데 필요한 기본적인 요소들을 별도로 설정하지 않아도 기본 탑재되어 있는 내장 톰캣에서 구동된다.

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

spring-boot-starter-web 2.2.6.RELEASE 는 mvn dependency:tree 명령어로 살펴보면 다음과 같은 종속성을 갖고 있음을 알 수 있다.

- spring-boot-starter : spring core 5.2.5.RELEASE, logging, annotation
- spring-boot-starter-json : jackson 관련
- spring-boot-starter-tomcat
- spring-boot-starter-validation : jakarta validation, hibernate validation
- spring-web : beans
- spring-webmvc : aop, expression

```
$ mvn dependency:tree

[INFO] com.springboot:sht-webapp:jar:1.0.0
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:2.2.6.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:2.2.6.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.2.6.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.12.1:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.30:compile
[INFO] |  |  +- jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile
[INFO] |  |  +- org.springframework:spring-core:jar:5.2.5.RELEASE:compile
[INFO] |  |  |  \- org.springframework:spring-jcl:jar:5.2.5.RELEASE:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.25:runtime
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:2.2.6.RELEASE:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.10.3:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.10.3:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.10.3:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.10.3:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.10.3:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.10.3:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:2.2.6.RELEASE:compile
[INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.33:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-validation:jar:2.2.6.RELEASE:compile
[INFO] |  |  +- jakarta.validation:jakarta.validation-api:jar:2.0.2:compile
[INFO] |  |  \- org.hibernate.validator:hibernate-validator:jar:6.0.18.Final:compile
[INFO] |  |     +- org.jboss.logging:jboss-logging:jar:3.4.1.Final:compile
[INFO] |  |     \- com.fasterxml:classmate:jar:1.5.1:compile
[INFO] |  +- org.springframework:spring-web:jar:5.2.5.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-beans:jar:5.2.5.RELEASE:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:5.2.5.RELEASE:compile
[INFO] |     +- org.springframework:spring-aop:jar:5.2.5.RELEASE:compile
[INFO] |     \- org.springframework:spring-expression:jar:5.2.5.RELEASE:compile
[INFO] +- org.springframework.boot:spring-boot-devtools:jar:2.2.6.RELEASE:compile (optional)
[INFO] |  +- org.springframework.boot:spring-boot:jar:2.2.6.RELEASE:compile
[INFO] |  \- org.springframework.boot:spring-boot-autoconfigure:jar:2.2.6.RELEASE:compile
[INFO] +- org.apache.tomcat.embed:tomcat-embed-jasper:jar:9.0.33:compile
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.33:compile
[INFO] |  |  \- org.apache.tomcat:tomcat-annotations-api:jar:9.0.33:compile
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:9.0.33:compile
[INFO] |  \- org.eclipse.jdt:ecj:jar:3.18.0:compile
[INFO] +- org.egovframe.rte:org.egovframe.rte.ptl.mvc:jar:4.0.0:compile
[INFO] |  +- org.egovframe.rte:org.egovframe.rte.fdl.cmmn:jar:4.0.0:compile
[INFO] |  |  +- org.springframework:spring-context-support:jar:5.2.5.RELEASE:compile
[INFO] |  |  +- org.springframework:spring-tx:jar:5.2.5.RELEASE:compile
[INFO] |  |  +- org.aspectj:aspectjweaver:jar:1.9.5:compile
[INFO] |  |  +- org.aspectj:aspectjrt:jar:1.9.5:compile
[INFO] |  |  \- org.apache.commons:commons-lang3:jar:3.9:compile
[INFO] |  +- org.springmodules:spring-modules-validation:jar:0.9:compile
[INFO] |  +- commons-validator:commons-validator:jar:1.6:compile
[INFO] |  |  +- commons-beanutils:commons-beanutils:jar:1.9.2:compile
[INFO] |  |  \- commons-digester:commons-digester:jar:1.8.1:compile
[INFO] |  \- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] +- org.egovframe.rte:org.egovframe.rte.psl.dataaccess:jar:4.0.0:compile
[INFO] |  +- org.egovframe.rte:org.egovframe.rte.fdl.logging:jar:4.0.0:compile
[INFO] |  |  +- org.apache.logging.log4j:log4j-core:jar:2.12.1:compile
[INFO] |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.12.1:compile
[INFO] |  |  +- org.apache.logging.log4j:log4j-slf4j-impl:jar:2.12.1:compile
[INFO] |  |  |  \- org.slf4j:slf4j-api:jar:1.7.30:compile
[INFO] |  |  +- org.slf4j:jcl-over-slf4j:jar:1.7.30:compile
[INFO] |  |  \- org.slf4j:log4j-over-slf4j:jar:1.7.30:compile
[INFO] |  +- org.springframework:spring-orm:jar:5.2.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-context:jar:5.2.5.RELEASE:compile
[INFO] |  +- javax:javaee-api:jar:7.0:compile
[INFO] |  |  \- com.sun.mail:javax.mail:jar:1.5.0:compile
[INFO] |  |     \- javax.activation:activation:jar:1.1:compile
[INFO] |  +- org.apache.ibatis:ibatis-sqlmap:jar:2.3.4.726:compile
[INFO] |  +- org.mybatis:mybatis:jar:3.5.3:compile
[INFO] |  +- org.mybatis:mybatis-spring:jar:2.0.3:compile
[INFO] |  \- commons-collections:commons-collections:jar:3.2.2:compile
[INFO] +- org.egovframe.rte:org.egovframe.rte.fdl.idgnr:jar:4.0.0:compile
[INFO] +- org.egovframe.rte:org.egovframe.rte.fdl.property:jar:4.0.0:compile
[INFO] |  \- org.springframework:spring-jdbc:jar:5.2.5.RELEASE:compile
[INFO] +- org.egovframe.rte:org.egovframe.rte.fdl.string:jar:4.0.0:compile
[INFO] +- javax.servlet:servlet-api:jar:2.5:provided
[INFO] +- javax.servlet:jstl:jar:1.2:compile
[INFO] +- commons-dbcp:commons-dbcp:jar:1.4:compile
[INFO] |  \- commons-pool:commons-pool:jar:1.6:compile
[INFO] +- commons-codec:commons-codec:jar:1.9:compile
[INFO] +- taglibs:standard:jar:1.1.2:compile
[INFO] +- cglib:cglib:jar:3.1:compile
[INFO] |  \- org.ow2.asm:asm:jar:4.2:compile
[INFO] +- org.antlr:antlr:jar:3.5:compile
[INFO] |  +- org.antlr:antlr-runtime:jar:3.5:compile
[INFO] |  |  \- org.antlr:stringtemplate:jar:3.2.1:compile
[INFO] |  |     \- antlr:antlr:jar:2.7.7:compile
[INFO] |  \- org.antlr:ST4:jar:4.0.7:compile
[INFO] +- org.apache.commons:commons-compress:jar:1.8.1:compile
[INFO] +- org.hsqldb:hsqldb:jar:2.3.2:compile
[INFO] +- commons-fileupload:commons-fileupload:jar:1.3.1:compile
[INFO] |  \- commons-io:commons-io:jar:2.2:compile
[INFO] +- javax.servlet.jsp:jsp-api:jar:2.2:provided
[INFO] \- com.ibm.icu:icu4j:jar:53.1:compile
```

### 스프링부트에서의 DispatcherServlet

스프링 애플리케이션 개발 시 DispatcherServlet 은 모든 HTTP 요청을 수신하여 Controller 클래스에 위임한다.
web.xml 파일에 DispatcherServlet 를 등록하거나, 프로그래밍으로 ServletContainerInitializer 를 사용하여 servlet을 등록할 수 있다.
하지만, 스프링부트는 spring-boot-starter-web 스타터를 사용하면 자동설정을 통해 DispatcherServlet을 자동으로 등록하고 구성한다.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

스프링부트에서는 web.xml을 사용하지 않고, 대신, application.properties 에 server.servlet를 사용하여 URL 패턴을 지정할 수 있다.
DispatcherServlet listens at http://localhost:8080/demo/baeldung

```
server.servlet.context-path=/demo
spring.mvc.servlet.path=/baeldung
```

## 실행 가능한 jar 파일로 패키징

### Spring Boot Maven Plugin

> https://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/maven-plugin/

Spring Boot Maven Plugin 은 독립적으로 실행 가능한 jar 또는 war 로 패키징한다.

```
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

메인 클래스가 2 개 이상일 경우에는 어떤 클래스를 실행할 지 지정한다.

```
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<executions>
					<execution>
							<goals>
									<goal>repackage</goal>
							</goals>
							<configuration>
									<classifier>spring-boot</classifier>
									<mainClass>
										com.springboot.main.EgovBootApplication
									</mainClass>
							</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

```
mvn clean package
```

### jar 파일 내부 구성 보기

```
jar tf target/sht-webapp-1.0.0.jar
jar tvf target/sht-webapp-1.0.0.jar
```

- t: table of contents of the JAR file
- v: verbose output 즉, 추가적인 정보를 보여달라는 옵션
- f: files

### jar 파일 실행하기

```
java -jar target/sht-webapp-1.0.0.jar
```

## 스프링부트에서 jsp를 사용하려면...

spring-boot-starter-web 은 내장 톰켓을 포함하고 있지만, 내장 톰켓 패키지에는 jsp 를 포함하고 있지 않기에 tomcat-embed-jasper 의존성을 별도로 추가해 주어야 한다.

```
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
```

```
# application.yml
spring.mvc.view.prefix=/pages/
spring.mvc.view.suffix=.jsp
server.port=9898
```

### Template Engines

> https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.developing-web-applications.spring-mvc.template-engines

- FreeMarker
- Groovy
- Thymleaf
- Mustache

### JSP Limitations

Undertow 는 JSP를 지원하지 않는다.

> https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.developing-web-applications.embedded-container.jsp-limitations

## Unconditional classes

- org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration
- org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration
- org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration

## HSQLDB 연결

```
		<dependency>
			<groupId>org.hsqldb</groupId>
			<artifactId>hsqldb</artifactId>
			<version>2.3.2</version>
		</dependency>
```