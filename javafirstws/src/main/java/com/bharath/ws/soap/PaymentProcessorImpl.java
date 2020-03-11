package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException{
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();

		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null
				|| paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0) {
			throw new ServiceException("Invalid Card Number");
		}
			// Business Logic or a call to a Business Logic Class Goes Here.
			paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
