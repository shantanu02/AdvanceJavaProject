package com.cdac.controller;

import java.util.List;

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

import com.cdac.dto.Faculty;
import com.cdac.dto.Student;
import com.cdac.service.StudentService;
import com.cdac.validator.StudentValidatoRegistration;
import com.cdac.validator.StudentValidator;
import com.cdac.validator.StudentValidatorSearch;




@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentValidator studentValidator;
	
	@Autowired
	private StudentValidatoRegistration studentValidatoRegistration;
			
	@Autowired 
	private StudentValidatorSearch studentValidatorSearch;
	
	@Autowired
	private MailSender mailSender;
	
	
	@RequestMapping(value="/add_student_form.htm",method = RequestMethod.GET)
	public String prepAddStudentForm(ModelMap map,HttpSession session) {
		if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
			return "index";
		}else {
			map.put("student", new Student());	
			return "student_add_form";
		}
		
		
		

	}
	
	@RequestMapping(value="/add_student.htm",method = RequestMethod.POST)
	public String addTheStudent(Student student,BindingResult result,ModelMap map,HttpSession session) {
		int facultyId = ((Faculty) session.getAttribute("faculty")).getFacultyId();
		student.setFacultyId(facultyId);
		
		studentValidatoRegistration.validate(student, result);
		
		if(result.hasErrors()) {
			return "student_add_form";
		}
		
		
		
		boolean b = studentService.addStudent(student);
		
		if(b) {

			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("cdacmumbai3@gmail.com");  
	        message.setTo(student.getStudentEmail());  
	        message.setSubject("Your Details for login :");  
	        message.setText("Login Email :"+student.getStudentEmail() + " Login Password :" + student.getStudentPassword() );  
	        //sending message   
	        
	        mailSender.send(message);
	        
			return "faculty_home";
		}else {
			map.addAttribute("Student_already_exists", "Student_already_exists");
			
			return "student_add_form";
		}
		
		
	
	}
	
	
	@RequestMapping(value = "/student_list.htm",method = RequestMethod.GET)
	public String allStudent(ModelMap map,HttpSession session) {
		
		if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
			return "index";
		}else {
			int facultyId = ((Faculty)session.getAttribute("faculty")).getFacultyId();
			List<Student> li = studentService.getAllStudent(facultyId);
			map.put("studentList", li);
			return "student_list";
		}

	}
	
	
	@RequestMapping(value = "/student_delete.htm",method = RequestMethod.GET)
	public String studentDelete(@RequestParam int studentId,ModelMap map,HttpSession session) {
		
		if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
			return "index";
		}else {

			studentService.deleteStudent(studentId);
			Faculty f = (Faculty) session.getAttribute("faculty"); 
			int facultyId = f.getFacultyId();
			List<Student> li = studentService.getAllStudent(facultyId);
			map.put("studentList", li);
			return "student_list";
		}
		
		
	}
	
	@RequestMapping(value = "/student_update_form.htm",method = RequestMethod.GET)
	public String studentUpdateForm(@RequestParam int studentId,ModelMap map,HttpSession session) {
		
		if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
			return "index";
		}else {

			Student stu = studentService.searchStudent(studentId);
			//stu.setStudentId(studentId);
			map.put("student", stu);
			
			return "student_update_form";
		}
		
		
		
	
	}
	
	
	
	@RequestMapping(value = "/student_up_form.htm",method = RequestMethod.POST)
	public String studentUpdate(Student student,BindingResult result,ModelMap map,HttpSession session) {
		
studentValidatoRegistration.validate(student, result);
		
		if(result.hasErrors()) {
			return "student_update_form";
		}
		
		
		
		Faculty f = (Faculty)session.getAttribute("faculty");
		int facultyId = f.getFacultyId();
		student.setFacultyId(facultyId);
		
		studentService.modifyStudent(student);
		
		List<Student> list = studentService.getAllStudent(facultyId);
		map.put("studentList", list);
		

		SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom("cdacmumbai3@gmail.com");  
        message.setTo(student.getStudentEmail());  
        message.setSubject("Your Updated Details for login :");  
        message.setText("Login Email :"+student.getStudentEmail() + " Login Password :" + student.getStudentPassword() );  
        //sending message   
        
        mailSender.send(message);
		
		
		return "student_list";
	}
	
	
	@RequestMapping(value="/search_stu.htm",method=RequestMethod.GET)
	public String prepNameSearchForm(ModelMap map ,HttpSession session) {
		

		if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
			return "index";
		}else {

			//Student stu = studentService.getStudentByName(studentName);
			map.put("student", new Student());
			return "search";
		}
		
		
		
	}
	
	@RequestMapping(value="/search_student.htm",method = RequestMethod.POST)
	public String nameSearch(Student student,BindingResult result,ModelMap map,HttpSession session) {
		
		studentValidatorSearch.validate(student, result);
		
		if(result.hasErrors()) {
			return "search";
		}
		
		int facultyId = ((Faculty) session.getAttribute("faculty")).getFacultyId();
		student.setFacultyId(facultyId);
		
		List<Student> list = studentService.getAllStudent(facultyId);
		
		boolean f = false;
		for(Student s : list) {
			if(s.getStudentName().equals(student.getStudentName())) {
				f=true;	
				break;
			}
		}
		
		
		if(f==true) {
			Student stu = studentService.getStudentByName(student.getStudentName());
			map.put("student", stu);
			return "info";
		}else {
			map.addAttribute("Student_Not_Present", "Student_Not_Present");
			return "search";
		}
		
		
		
		
	}
	
	
	//==================================
	
	/*
	@RequestMapping(value="/search_byrollno.htm",method=RequestMethod.GET)
	public String prepRollSearchForm(ModelMap map ) {
		//Student stu = studentService.getStudentByRollNo(studentRollNo);
		map.put("student", new Student());
		return "search";
	}
	*/
		
	@RequestMapping(value="/search_by_roll.htm",method = RequestMethod.POST)
	public String rollSearch(Student student,ModelMap map,HttpSession session) {
		
		
		int facultyId = ((Faculty) session.getAttribute("faculty")).getFacultyId();
		student.setFacultyId(facultyId);
		
		
		List<Student> list = studentService.getAllStudent(facultyId);
		
		boolean f = false;
		for(Student s : list) {
			if(s.getStudentRollNo() == student.getStudentRollNo()) {
				f=true;	
				break;
			}
		}
		
		if(f==true) {
			Student stu = studentService.getStudentByRollNo(student.getStudentRollNo());
			map.put("student", stu);
			return "info";	
		}else {
			map.addAttribute("Student_Not_Present", "Student_Not_Present");
			return "search";
		}

	}
	
	
	
	
	//------------------------------------Student functionality
	
	@RequestMapping(value="/prep_student_form.htm" , method = RequestMethod.GET)
	public String prepStudentLogin(ModelMap map,HttpSession session) {
		

		//if (session.getAttribute("faculty") == null || session.getAttribute("faculty").equals("")) {
		//	return "index";
		//}else {

			map.put("student", new Student());
			return "login_form_student";
		//}
		
		
	}
	
	@RequestMapping(value="/student_login.htm",method = RequestMethod.POST)
	public String loginStudent(Student student ,BindingResult result, ModelMap map , HttpSession session) {
		
		studentValidator.validate(student, result);
		if(result.hasErrors()) {
			return "login_form_student";
		}
		
		boolean b = studentService.validateStudent(student);
		
		
		
		if(b) {
			//Faculty f = facultyService.selectFaculty(faculty.getFacultyId());
			Student s = studentService.searchStudent(student.getStudentId());
			//System.out.println(s);
			session.setAttribute("student", s);
			return "student_info";
					
		}else {
			map.put("student", new Student());
			map.addAttribute("Wrong_Credentials","Wrong_Credentials");
			return "login_form_student";
		}
				
	}
	
	@RequestMapping(value = "/logoutStudent.htm",method = RequestMethod.GET )
	public String logOutFormStudent(ModelMap map , HttpSession session,HttpServletResponse response) {
		//session.invalidate();
		//session.removeAttribute("student");
		//session.invalidate();
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache");
		return "index";
	}
	
	@RequestMapping(value = "/forgot_password_student.htm", method = RequestMethod.POST)
	public String forgotPasswordStudent(@RequestParam String studentEmail,ModelMap map) {		
			
		String pass = studentService.forgotPassword(studentEmail);
		String msg = "you are not registered";
		
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("cdacmumbai3@gmail.com");  
	        message.setTo(studentEmail);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	        mailSender.send(message);
			msg = "check the mail for password";
			map.put("student", new Student());
			map.addAttribute("msg", "Check your mail for Password");
			return "forgot_password_stu";
			
		}else {
			map.addAttribute("msg", msg);
			return "forgot_password_stu";

		}
		
		
	}
	
	

	
}
