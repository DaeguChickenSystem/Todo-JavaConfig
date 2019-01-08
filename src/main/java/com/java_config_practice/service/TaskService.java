package com.java_config_practice.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface TaskService {
	
	public List<LinkedList> list(Map data) throws Exception;
	
	public Map add(Map data) throws Exception;

	public Map update(Map data) throws Exception;
	
	public void delete(Map data) throws Exception;
	
	public void move(Map data) throws Exception;
	
	public Map read(Map data) throws Exception;
	
	
	
}
