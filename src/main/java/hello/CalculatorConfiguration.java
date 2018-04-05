package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("hello.wsdl");
        return marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller){
        CalculatorClient calculatorClient = new CalculatorClient();
        calculatorClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        calculatorClient.setMarshaller(marshaller);
        calculatorClient.setUnmarshaller(marshaller);
        return calculatorClient;
    }
}
