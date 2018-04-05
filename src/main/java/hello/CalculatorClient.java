package hello;

import hello.wsdl.Add;
import hello.wsdl.AddResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculatorClient extends WebServiceGatewaySupport{



    public AddResponse getAddition(final int numberOne, final int numberTwo){

        Add addition = new Add();
        addition.setIntA(numberOne);
        addition.setIntB(numberTwo);
        //addition.equals(true);

        AddResponse addResponse = (AddResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx?wsdl",
                                                addition,
                                                new SoapActionCallback("http://tempuri.org/Add"));

        return addResponse;
    }
}
