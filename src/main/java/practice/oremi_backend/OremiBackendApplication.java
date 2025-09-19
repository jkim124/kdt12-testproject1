package practice.oremi_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OremiBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(OremiBackendApplication.class, args);
    }
	}
@RestController
class MessageController {
  private final MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/message")
  public String message() {
    return messageService.getMessage();
  }
}

@Configuration
class AppConfig{
  @Bean
  public MessageService messageService() {
    return new MessageService();
  }
}

class MessageService {
  public String getMessage() {
    return "Hello from MessageService!";
  }
}




/// /////////////
/*@RestController
class MessageController {
  private final MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/message")
  public String message() {
    return messageService.getMessage();
  }
}*/



/*
@RestController
class Calc{
  @GetMapping("/calc/add")
  public int add(@RequestParam int a, @RequestParam int b , @RequestParam int c) {
    return a + b + c;
  }
  @GetMapping("/calc/subtract")
  public int subtract(@RequestParam int a, @RequestParam int b){
    return a - b;
  }
  @GetMapping("/calc/multiply")
  public int multiply(@RequestParam int a, @RequestParam int b){
    return a * b;
  }
  @GetMapping("/calc/divide")
  public double divide(@RequestParam double a, @RequestParam double b){
    return a / b;
  }
}
*/