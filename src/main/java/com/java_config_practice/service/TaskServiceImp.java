package com.java_config_practice.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskServiceImp implements TaskService {

	
	/* DummyData */
	/*List<LinkedList> list = new LinkedList<>(
			Arrays.asList(new LinkedList(Arrays.asList(new HashMap(), new HashMap(), new HashMap())),
					new LinkedList(Arrays.asList(new HashMap(), new HashMap(), new HashMap())),
					new LinkedList(Arrays.asList(new HashMap(), new HashMap(), new HashMap()))));
	*/
	List<LinkedList> list = new LinkedList<>();
	
	
	public Map<String, Object> map = new HashMap();
    static private boolean init=false;
	private Thread thread;
	Random generator = new Random();
	private int task_id =0;
	
	@Override
	public List<LinkedList> list(Map data) throws Exception {
		// TODO Auto-generated method stub

		
		Runnable call = () -> {
			try {
			 if(!init) {
				for (int i = 0; i < list.size(); i++) {
					List list_2 = (LinkedList) list.get(i);
					for (int j = 0; j < list_2.size(); j++) {
						map = (Map) list_2.get(j);
						map.put("title", "test_title_" + i);
						map.put("contents", "test_contents_" + i);
						map.put("status", i);
						map.put("task_id", task_id);
						map.put("date", new Date());
						map.put("order_by", j);
						task_id++;
					}
				}
				init = true;
			 }
			} catch (Exception e) {

			}

		};

		thread = new Thread(call);
		thread.setDaemon(true);
		thread.start();
		return list;
	}

	@Override
	public Map add(Map data) throws Exception {
		
		Map newTask = new HashMap();

		Map test;
		for (int i = 0; i < list.size(); i++) {			
			if (i==Integer.parseInt((String) data.get("board_id"))) {
				Map temp= new HashMap();
				int k=0;
				boolean a=false;
				if(data.get("task_id") != "") {
					 test = retrieve(data);
					System.out.println( list.get(i).size()-1);
					for (int j = 0; j < list.get(i).size(); j++) {		
						temp=(Map) list.get(i).get(j);
						if((int)temp.get("task_id")== Integer.parseInt((String)data.get("task_id"))) {
							 k=(int)temp.get("order_by");

						}else if(((int)temp.get("order_by") >= (int)test.get("order_by"))){
							temp.put("order_by", (int)temp.get("order_by")+1);
							
						
						}						
					}
														
					
					 test.put("order_by", k+1);
					 list.get(i).add(test);
					 quickSorting(list.get(i),0,list.get(i).size()-1);
				}else {
					 data.put("task_id", task_id) ;

					 /*board에 아무것도 없을 때*/
					 if(list.get(i).size() ==0) {
						 data.put("order_by", 0);
						 list.get(i).add(data);						 
					 }else {					 
					    Map map = (HashMap)list.get(i).get(list.get(i).size()-1);
					    data.put("order_by", (int)map.get("order_by")+1);
					    list.get(i).add(data);
					 }
					 task_id++;
				}
				
			
				break;
			}
	
		}
		
		return newTask;
	}

	@Override
	public void delete(Map data) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {			
			Map temp = new HashMap();
			if (i==Integer.parseInt((String) data.get("board_id_from"))) {
				for (int j = 0; j < list.get(i).size(); j++) {				   
					temp = (HashMap)list.get(i).get(j);		
					System.out.println(temp.get("task_id"));
					System.out.println(data.get("task_id_from"));
					
					if((int)temp.get("task_id")==Integer.parseInt((String) data.get("task_id_from"))) {
						list.get(i).remove(j);
					    break;
					} 
					
			}	
		   }
			
		}
		
	}

	@Override
	public void move(Map data) throws Exception {		
		add(data);		
		delete(data);
	}

	@Override
	public Map read(Map data)  {
		// TODO Auto-generated method stub
		int[][] index = new int[1][2];
		for (int i = 0; i < list.size(); i++) {
			List list_2 = (LinkedList) list.get(i);
			for (int j = 0; j < list_2.size(); j++) {
				Map map = (Map) list_2.get(j);
		
				if ((Integer)map.get("task_id")==Integer.parseInt((String) data.get("task_id"))) {
						System.out.println(index[0][0]);			
					index[0][0] = i;
					index[0][1] = j;
					break;
				}
			}
		}

		return (Map) list.get(index[0][0]).get(index[0][1]);
	}

	
	public void quickSorting(List list, int l, int r) {
	   
	   
		Map temp;
		
		Collections.sort(list,  new Comparator<Object>() {

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				 Map after= (HashMap)arg0;
				 Map before= (HashMap)arg1;
				 int result=-1;
				 if((int)before.get("order_by")<(int)after.get("order_by")) 
					 result= 1;
				  if((int)before.get("order_by")>(int)after.get("order_by")) 
					  result= -1;
				
				  return result;
				}});
/*		boolean check = false;
		for (int i =  list.size()-1; i >= 0; i--) {
			if(!check) {
			 before= (HashMap)list.get(i);
			 if(i-1==list.size()) 
				 break;	 
			 
			 after= (HashMap)list.get(i-1);
					 
			
			while((int)before.get("order_by")< (int)after.get("order_by")) {
				temp= (Map)after;
				after=(Map)before;
				before=(Map) temp;
				check=true;
				
			}
			}else {
				break;
			}
		}*/
		
	}
	
	public Map retrieve(Map data) {
		Map temp = new HashMap();
		for (int i = 0; i < list.size(); i++) {	
			if (i==Integer.parseInt((String) data.get("board_id_from"))) {
				for (int j = 0; j < list.get(i).size(); j++) {				   
					temp = (HashMap)list.get(i).get(j);		
					System.out.println(temp.get("task_id"));
					System.out.println(data.get("task_id_from"));					
					if((int)temp.get("task_id")==Integer.parseInt((String) data.get("task_id_from"))) {						
					  break;
					} 					
			}	
		   }
		}
		return temp;

	}

	@Override
	public Map update(Map data) throws Exception {
		Map newTask = new HashMap();
		for (int i = 0; i < list.size(); i++) {			
			if (i==Integer.parseInt((String) data.get("board_id"))) {
				Map temp= new HashMap();
			
					for (int j = 0; i < list.get(i).size(); j++) {		
						temp=(Map) list.get(i).get(j);
						if((int)temp.get("task_id")== Integer.parseInt((String)data.get("task_id"))) {
							((HashMap) list.get(i).get(j)).put("contents",(String) data.get("content"));
						    ((HashMap) list.get(i).get(j)).put("title",(String) data.get("title"));
						
							break;	
						}
					}
					
						
				 quickSorting(list.get(i),0,list.get(i).size()-1);
				break;
			}
	
		}
		
	
		return null;
	}
	
}
