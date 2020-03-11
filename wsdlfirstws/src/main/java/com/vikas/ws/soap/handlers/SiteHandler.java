package com.vikas.ws.soap.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage");
		Boolean isReponse = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);// false if response else true
		if(!isReponse) {
			SOAPMessage soapMessage = context.getMessage();
			try {
				SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Iterator elements = header.getChildElements();
				
				while(elements.hasNext()) {
					Node eachNode = (Node)elements.next();
					String name = eachNode.getLocalName();
					if(name != null && name.equals("SiteName")) {
						System.out.println("Site Name is :: "+eachNode.getValue());
					}
				}
				
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Response is on the way");
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handleFault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("close");
		
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("getHeaders");
		return null;
	}

}
