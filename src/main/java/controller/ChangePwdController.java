package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;

@Controller
@RequestMapping("/edit/changePw")
public class ChangePwdController {
	private ChangePasswordService changePasswordService;
	
	public void setChangePasswordSerivce(
			ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form( 
		@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
		@ModelAttribute("command") ChangePwdCommand pwdCmd,
		Errors errors,
		HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try{
			changePasswordService.changePassword(
					authInfo.getEmail(), pwdCmd.getCurrentPw(), pwdCmd.getNewPw());
			return "edit/changePwd";
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPw", "notMatching");
			return "edit/changePwdForm";
		}
	}
	
}
