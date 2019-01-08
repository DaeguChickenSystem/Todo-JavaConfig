package com.java_config_practice.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardSerivce")
public class BoardServiceImpl implements BoardService {

	@Autowired
	TaskServiceImp taskService;
	
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		try {
			taskService.list.add(new LinkedList());
		}catch(Exception e){
			
		}
		return true;
	}

}
