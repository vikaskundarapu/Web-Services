package com.vikas.runtimeapi.example;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter stringWriter = new StringWriter();

			Patient patient = new Patient();
			patient.setName("Vikas");
			patient.setId(123);
			marshaller.marshal(patient, stringWriter);
			System.out.println(stringWriter.toString());

			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(stringWriter.toString());
			Patient patient2 = (Patient) unmarshaller.unmarshal(reader);
			System.out.println(patient2.getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
