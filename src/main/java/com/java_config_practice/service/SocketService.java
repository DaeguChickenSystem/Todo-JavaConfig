package com.java_config_practice.service;

import java.util.Map;

import javax.websocket.Session;

public abstract class SocketService {

	
	public abstract void onOpen(Session session, String article);
	

	public abstract void onMessage(Session session, Map article);
	
	public abstract void onClose(Session session);
	
	public abstract void onError(Session session, Throwable throwable);
}
