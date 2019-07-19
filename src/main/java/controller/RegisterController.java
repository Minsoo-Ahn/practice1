package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	private MemberRegisterService memberRegisterService;
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		// TODO Auto-generated method stub
			this.memberRegisterService = memberRegisterService;
	}
	@RequestMapping(value= "/register/step1",
			method=RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	
	@RequestMapping(value= "/register/step2",
			method=RequestMethod.POST)
	public ModelAndView handleStep2(
		@RequestParam(value="agree",defaultValue = "false") Boolean agree,
		ModelAndView mav) {
		if(!agree) {
			mav.setViewName("register/step1");
		}
		mav.addObject("formData", new RegisterRequest());
		mav.setViewName("register/step2"); 
		return mav;
	}
	
	@RequestMapping(value = "/register/step2", method = RequestMethod.GET)
	public String handeStep2() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value="/register/step3",method = RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "register/step2";
		}
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email","duplicate");
			return "register/step2";
		}
	}
}
