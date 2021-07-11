package com.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/rest")
@Validated
public class HomeController {
	
	/*@RequestMapping(path="/home", method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("name", "Anil Jesrani");
		return "index";
	}*/
	
	
	@RequestMapping("/home")
	public ModelAndView home(@PathParam("data") @NotNull String data)
	{
		System.out.println("HomeController:home()");
		
		ModelAndView mNv = new ModelAndView();
		mNv.setViewName("index");
		mNv.addObject("name", "Nitin Gore");

		List<String> alist=new ArrayList<String>(
	            Arrays.asList("Pratap", "Peter", "Harsh"));
		mNv.addObject("names", alist);
		
		return mNv;
	}
	
	/*// This will be called before any handler method
	@ModelAttribute
	public void messages(Model m)
	{
		m.addAttribute("name", "Anil Jesrani");
		m.addAttribute("Gender", "Male");
	}*/
	
	// @PathVariable annotation is used to bind method parameter to URI template variable
	@RequestMapping("/book/{id}")
	public String handler(@PathVariable int id)
	{
		System.out.println("id: " + id);
		return "login";
	}


	@RequestMapping("/login")
	public String login(Model model)
	{
		//model.addAttribute("auth", new Authentication());
		return "login";
	}
	
	/*@RequestMapping(path="/process", method=RequestMethod.POST)
	public String process(@RequestParam(name="user", required=true) String user, 
				@RequestParam("password") String password)
	{
		System.out.println("Username: " + user + " | Password: " + password);
		return "Welcome";
	}*/
	
	@RequestMapping(path="/process", method=RequestMethod.POST)
	//public String process(@Valid @ModelAttribute("auth") Authentication auth, Errors error)
	public String process(@Valid @ModelAttribute("auth") Authentication auth, BindingResult error)
	{
		if(error.hasErrors()) {
			System.out.println(error);
			return "login";
		}
		
		System.out.println(auth);
		if(auth.getUser().equals("aoadmin")) {
			return "Welcome";
		}
		else {
			return "redirect:/rest/login";
		}
	}
	
	@RequestMapping("/active")
	public RedirectView toLogin()
	{
		RedirectView rv = new RedirectView();
		rv.setUrl("login");
		return rv;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) {
    	
		System.out.println("Same as Spring Boot");
        return "Welcome";    	
    }
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	/*@ExceptionHandler({NullPointerException.class, ArrayIndexOutOfBoundsException.class})*/
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler()
	{
		return "errorPage";
	}

}
