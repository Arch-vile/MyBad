package nakoradio.mybad.springdemo;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@ControllerAdvice
	public static class ExceptionHandlerController extends ResponseEntityExceptionHandler {

		@Override
		protected ResponseEntity<Object> handleExceptionInternal(
				Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
			return super.handleExceptionInternal(ex,body,headers,status,request);
		}

	}
	@RestController
	public static class SampleController {

		@GetMapping("/hello")
		public String hello() {
			return "hello there";
		}

		@PostMapping("/form")
		public String validating(@Valid @RequestBody SimpleForm form) {
			return "OK";
		}
	}

	@Data
	@Valid
	public static class SimpleForm {

		@Size(max = 2)
		public String name;

		@Size(min = 2)
		public String name2;

		public Integer amount;

		@Valid
		public SimpleForm nestedForm;
	}

}
