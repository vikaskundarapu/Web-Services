package com.vikas.ws.saop;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface FileWS {

	public void upload(@WebParam(name = "file") DataHandler attachment);

	public @WebResult(name = "downloadedFile") DataHandler download();
}
