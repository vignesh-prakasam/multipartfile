package com.anpi.fileapp.controller;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class FileController {
	String fPath = "";
	ClassPathResource resource = new ClassPathResource("config.properties");

	@RequestMapping(method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody
    String showMessage() {
		System.out.println("from controller");
		return "File testing Get....";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/xml")
	public @ResponseBody
	String updloadFile(@RequestParam("file") org.springframework.web.multipart.MultipartFile multipartFile, @RequestParam String userId, @RequestParam String enterpriseId) throws IOException {
	System.out.println("File size" + multipartFile.getSize());
	System.out.println("Ent id:" + enterpriseId + "  user id" + userId);
	
	Properties p = new Properties();
	p.load(resource.getInputStream());
	fPath = (String)p.getProperty("directory").trim();
	
    File file = new File(fPath+enterpriseId+"_"+userId+".txt");
    
    multipartFile.transferTo(file);
    
	return fPath+enterpriseId+"_"+userId+".txt";
	}


}
