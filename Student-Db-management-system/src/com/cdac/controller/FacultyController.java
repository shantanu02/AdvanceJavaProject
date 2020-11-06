package com.cdac.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.dto.Admin;
import com.cdac.dto.Faculty;
import com.cdac.dto.Student;
import com.cdac.service.FacultyService;
import com.cdac.validator.FacultyValidator;
import com.cdac.validator.FacultyValidatorRegistration;



@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyValidator facultyValidator;
	
	@Autowired
	private FacultyValidatorRegistration facultyValidatorRegistration;
	
	
	
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(value="/prep_login_form.htm" , method = RequestMethod.GET)
	public String prepLoginForm(ModelMap map,HttpSession session) {
		
		//if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
		//	return "index";
		//}else {
			map.put("faculty", new Faculty());
			return "login_form";
		//}

		
		
	}
	
	@RequestMapping(value="/faculty_login.htm",method = RequestMethod.POST)
	public String loginFaculty(Faculty faculty ,BindingResult result, ModelMap map , HttpSession session) {
		
		facultyValidator.validate(faculty, result);
		if(result.hasErrors()) {
			return "login_form";
		}		
		boolean b = facultyService.validateFaculty(faculty);
		System.out.println(b);

		if(b) {
			Faculty f = facultyService.selectFaculty(faculty.getFacultyId());
			session.setAttribute("faculty", f);
			return "faculty_home";
					
		}
		else {
			
			map.put("faculty", new Faculty());
			map.addAttribute("Wrong_Credentials","Wrong_Credentials");
			return "login_form";
		}
		
		
				
	}
	
	@RequestMapping(value="/add_faculty_form.htm",method = RequestMethod.GET)
	public String prepAddFacultyForm(ModelMap map,HttpSession session) {
		if (session.getAttribute("admin") == null || session.getAttribute("admin").equals("")) {
			return "index";
		}else {
			map.put("faculty", new Faculty());	
			return "faculty_add_form";
		}
		
		
		

	}
	
	@RequestMapping(value="/add_faculty.htm",method = RequestMethod.POST)
	public String addTheFaculty(Faculty faculty,BindingResult result,ModelMap map,HttpSession session) {
		
		facultyValidatorRegistration.validate(faculty, result);
		if(result.hasErrors()) {
			return "faculty_add_form";
		}	
		
		
		facultyService.addFaculty(faculty);
		
		
		
		
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("cdacmumbai3@gmail.com");  
	        message.setTo(faculty.getFacultyEmail());  
	        message.setSubject("Your Details for login :");  
	        message.setText("Login Email :"+faculty.getFacultyEmail() + " Login Password :" + faculty.getFacultyPassword() );  
	        //sending message   
	        mailSender.send(message);
			
		
		
		
		
		return "admin_home";	
	
	}
	
	
	
	
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET )
	public String logOutForm(ModelMap map , HttpSession session,HttpServletResponse response) {
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache");

		//session.removeAttribute("faculty");
		return "index";
	}

	@RequestMapping(value = "/forgot_password.htm", method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String facultyEmail,ModelMap map) {		
			
		String pass = facultyService.forgotPassword(facultyEmail);
		String msg = "you are not registered";
		
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("cdacmumbai3@gmail.com");  
	        message.setTo(facultyEmail);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	        mailSender.send(message);
			msg = "check the mail for password";
			map.put("faculty", new Faculty());
			map.addAttribute("msg", "Check your mail for Password");
			return "forgot_password";
			
		}else {
			map.addAttribute("msg", msg);
			return "forgot_password";

		}
		
		
	}
	
	@RequestMapping(value = "/upload_file.htm", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file,HttpSession session,HttpServletRequest request,ModelMap map) {
		String fileName = "0";

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				
				fileName = file.getOriginalFilename();
				//extension is taken 
				fileName = fileName.substring(fileName.lastIndexOf("."));
				
				Faculty user = (Faculty)session.getAttribute("faculty");
				
				fileName = user.getFacultyId()+fileName;
				
				

				// Creating the directory to store file
				String rootPath = request.getServletContext().getRealPath("/");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				
				//C:\Users\dell\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\
				//wtpwebapps\Student-Db-management-system\images\1.jpeg
				String filePath = dir.getAbsolutePath()+ File.separator +fileName;
				
				//System.out.println("Server File Location= "+ filePath );
				
				File serverFile = new File(filePath);
				
						
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				facultyService.uploadImage(fileName, user.getFacultyId());
				
				user.setProfilePic(fileName);
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return "faculty_home";
	}
	
	
	
	
	
}
