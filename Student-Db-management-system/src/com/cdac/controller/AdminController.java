package com.cdac.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Admin;
import com.cdac.dto.Faculty;
import com.cdac.service.AdminService;
import com.cdac.service.FacultyService;
import com.cdac.validator.AdminValidator;
import com.cdac.validator.FacultyValidator;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminValidator adminValidator;
	
	
	@RequestMapping(value="/prep_login_form_admin.htm" , method = RequestMethod.GET)
	public String prepLoginForm(ModelMap map,HttpSession session) {
		
		//if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
		//	return "index";
		//}else {
			map.put("admin", new Admin());
			return "login_form_admin";
		//}
	
	}
	
	@RequestMapping(value="/admin_login.htm",method = RequestMethod.POST)
	public String loginAdmin(Admin admin ,BindingResult result, ModelMap map , HttpSession session) {
		
		adminValidator.validate(admin, result);
		if(result.hasErrors()) {
			return "login_form_admin";
		}		
		boolean b = adminService.validateAdmin(admin);

		if(b) {
			//Faculty f = facultyService.selectFaculty(faculty.getFacultyId());
			Admin a = adminService.selectAdim(admin.getAdminId());
			
			session.setAttribute("admin", a);
			return "admin_home";
					
		}else {
			map.put("admin", new Admin());
			return "login_form_admin";
		}
				
	}
	
	@RequestMapping(value = "/logoutAdmin.htm",method = RequestMethod.GET )
	public String logOutForm(ModelMap map , HttpSession session,HttpServletResponse response) {
		//session.invalidate();
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache");
		return "index";
	}

	
	
	
}
