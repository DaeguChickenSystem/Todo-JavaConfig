package com.java_config_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java_config_practice.service.AuthService;
import com.java_config_practice.service.AuthServiceImp;
import com.java_config_practice.service.BoardService;
import com.java_config_practice.service.MemberService;
import com.java_config_practice.service.TaskServiceImp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ViewController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	BoardService boardService;

	@Autowired
	TaskServiceImp taskService;

	
	@Autowired
	MemberService memberService ;
	
    @RequestMapping(method = RequestMethod.GET)
    public String intro(Model model, HttpSession session) {
     
    	return "redirect:/login";        
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(Model model) {     
        return "login";
    }
    
    @RequestMapping(value="main", method = RequestMethod.GET)
    public String main(Model model) {
    	
    	try {
			model.addAttribute("result", taskService.list(new HashMap())) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "main";
    }

    @RequestMapping(value="modal", method = RequestMethod.POST)
    @ResponseBody
    public Map modal(Model model, @RequestParam Map<String, Object> param) throws Exception {
    	
    	System.out.println(param);    	
    	model.addAttribute("board_idx", param.get("index"));   	 
    	
    	if(param.get("task_id").equals("")) {
    		
    	}else {
    		model.addAttribute("result", taskService.read(param));
    	    model.addAttribute("task_id",param.get("task_id"));	
    	}

        return taskService.read(param);
    }
    
    @RequestMapping(value="mosaic", method = RequestMethod.GET)
    public String mosic(Model model, @RequestParam Map<String, Object> param) throws Exception {    	
    	
       try { 
    	   throw new Exception();
    	   }catch(Exception e) {
    		 System.out.println(e);
    	   }	
	 
        return "mosaic";
    }
    
    @RequestMapping(value="taskUpdate", method = RequestMethod.POST)
    @ResponseBody
    public void taskUpdate(Model model, @RequestParam Map<String, Object> param) throws Exception {    	
    	
       try { 
    	   if(param.get("task_id").equals("")) {
    		   taskService.add(param);
           
    	   }else {
    		   taskService.update(param);
        	   
    	   }
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }	
	 
    }
    
    @RequestMapping(value="taskDrop", method = RequestMethod.POST)
    @ResponseBody
    public void taskDrop(Model model, @RequestParam Map<String, Object> param) throws Exception {    	
    	
       try { 
    	   taskService.move(param);
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }	
	 
    }
    
    @RequestMapping(value="setAvatar", method = RequestMethod.POST)
    public String singleFileUpload(@RequestParam MultipartFile file, Model model)
        {


    	System.out.println(file.getOriginalFilename());
       return "fileUploadForm";
    }

    
    
    @RequestMapping(value="autoComplete", method = RequestMethod.POST)
    @ResponseBody
    public String autoComplete(Model model, @RequestParam Map<String, Object> param)
          throws Exception {
    	
       return memberService.search((String)param.get("name"));
    }

    @RequestMapping(value="react/{menu}", method = RequestMethod.GET)
    public String react(@PathVariable String menu, Model model, @RequestParam Map<String, Object> param) throws Exception {    	
 
        return "reactView/"+menu;
    }
    
    @RequestMapping(value="boardAdd", method = RequestMethod.POST)
    @ResponseBody
    public void boardAdd(Model model, @RequestParam Map<String, Object> param) throws Exception {    	
    	
       try { 
    
    	   boardService.insert();
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }	
	 
    }
    
    
}