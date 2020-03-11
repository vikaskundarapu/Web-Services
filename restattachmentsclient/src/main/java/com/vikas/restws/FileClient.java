package com.vikas.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {

		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=Angular.txt");

		Attachment attachment = new Attachment("root",
				new FileInputStream(new File("C:\\Users\\Vikas\\Desktop\\Angular.txt")), cd);

		client.post(attachment);
	}

}
