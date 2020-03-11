package com.vikas.ws.saop;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandler;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.stax.ext.WSSConstants;

import com.bharath.ws.soap.CreditCardInfo;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;
import com.bharath.ws.soap.PaymentProcessorResponse_Type;

public class PaymentWsClient {

	public static void main(String[] args) throws MalformedURLException {

		PaymentProcessorImplService service = new PaymentProcessorImplService(
				new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
		PaymentProcessorResponse port = service.getPaymentProcessorImplPort();

		Client client = ClientProxy.getClient(port);
		Endpoint endpoint = client.getEndpoint();

		HashMap<String, Object> props = new HashMap<>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "vikas");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTClientPasswordCallback.class.getName());
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wssOut);

		PaymentProcessorResponse_Type response = port.processPayment(new PaymentProcessorRequest());
		System.out.println(response.isResult());

	}

}
