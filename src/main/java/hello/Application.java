package hello;

//import hello.wsdl.GetQuoteResponse;

import hello.wsdl.AddResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(CalculatorClient calculatorClient) {
        return args -> {
            AddResponse response = calculatorClient.getAddition(1,9);
            System.err.println(response.getAddResult());
        };
    }

}