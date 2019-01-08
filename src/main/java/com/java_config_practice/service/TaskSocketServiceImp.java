package com.java_config_practice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value="/task/{task}")
public class TaskSocketServiceImp extends SocketService{

    private Session session;
    private static Set<TaskSocketServiceImp> chatEndpoints
            = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();
    private Thread taskThread ;
	
	@Override
	public void onOpen(Session session,  @PathParam("task") String article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(Session session, Map article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClose(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Session session, Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

}
