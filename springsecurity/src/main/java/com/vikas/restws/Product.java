package com.vikas.restws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	private long id;
	private String descrition;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

}
