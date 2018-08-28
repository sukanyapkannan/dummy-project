package com.sinergia.middleware;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinergia.dao.userDao;
import com.sinergia.model.User;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	userDao udao;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		
		udao.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}

	 @RequestMapping(value="/login",method=RequestMethod.POST)
		public ResponseEntity<User> login(@RequestBody User user,HttpSession http)
	 
	 {
		
		 		System.out.println(user.getEmail());
				 User tempuser=udao.getUserbyemail(user.getEmail());
				 System.out.println("login success");
			http.setAttribute("currentuser",tempuser);	
			return new ResponseEntity<User>(tempuser,HttpStatus.OK);
			
	 }
	 
	 
	 @RequestMapping(value="/logout/{email}",method=RequestMethod.GET)
		public ResponseEntity<String> logout(@PathVariable("email") String email)
	 {
		 System.out.println(email); 
		 String emaill=email+".com";
		 System.out.println(emaill);
		 User tempuser=udao.getUserbyemail(emaill);
		 return new ResponseEntity<String>("Logout success",HttpStatus.OK);		 
}
	 
}
