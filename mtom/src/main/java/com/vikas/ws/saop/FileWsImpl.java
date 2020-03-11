package com.vikas.ws.saop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWS {

	@Override
	public void upload(DataHandler attachment) {

		try (InputStream inputStream = attachment.getInputStream();
				OutputStream outputStream = new FileOutputStream(
						new File("F:\\STSWorkspace\\mtom\\file\\uploaded\\test.jpg"))) {

			byte[] b = new byte[100000];
			int bytesRead = 0;

			while ((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(new File("F:\\STSWorkspace\\mtom\\file\\uploaded\\test.jpg")));
	}

}
