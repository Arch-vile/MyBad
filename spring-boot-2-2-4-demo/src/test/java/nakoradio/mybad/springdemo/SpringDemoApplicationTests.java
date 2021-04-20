package nakoradio.mybad.springdemo;

import static io.restassured.RestAssured.when;

import nakoradio.mybad.springdemo.SpringDemoApplication.SimpleForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class SpringDemoApplicationTests {

	@Test
	void contextLoads() {

		SimpleForm formData = new SimpleForm();
		formData.name = "too long name";

		when().post("/form", formData)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value());






	}

}
