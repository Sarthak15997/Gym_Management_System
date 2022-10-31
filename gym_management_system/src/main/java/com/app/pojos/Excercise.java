package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "excercise_tbl")
public class Excercise extends BaseEntity{

	@Column(name = "title")
	private String title;
	@Lob
	private byte[] image;

	@Transient
	private String imgUtility;

	public Excercise() {
		super();
	}

	public Excercise(String title, byte[] image) {
		super();
		this.title = title;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getImage());
	       if(encodeBase64 == null)
		    	return "";
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }

	@Override
	public String toString() {
		return "Excercise [title=" + title + ", image=" + Arrays.toString(image) + ", imgUtility=" + imgUtility + "]";
	}
	
	
	
}
