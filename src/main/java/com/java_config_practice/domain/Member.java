package com.java_config_practice.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Member implements Serializable {

  private String id;
  private int seq;
  private String avt_url ="/pic/"; 

  public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
	this.avt_url += (id+".jpg");	
	this.seq = MainDomain.memberSeq;
	MainDomain.memberSeq+=1;
}
public int getSeq() {
	return seq;
}
public void setSeq(int seq) {
	this.seq = seq;
}
public String getAvt_url() {
	return avt_url;
}
public void setAvt_url(String avt_url) {
	this.avt_url = avt_url;
}

}
