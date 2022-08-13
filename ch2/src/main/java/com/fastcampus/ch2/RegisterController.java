package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RegisterController {
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) // get, post 둘 다 허용
	//@RequestMapping("/register/add")
	/*@GetMapping("/register/add")*/
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
	//@RequestMapping("/register/save", method=RequestMthod.POST) // 아래 동일
	@PostMapping("/register/save") // 4.3부터 // 위보다 간단함
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력함","utf-8");
			
			m.addAttribute("msg",msg);
			return "forward:/register/add"; // redirect : 재요청 , 스프링이 자동으로 아랫줄로 바꿈
			//return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting) , 위의 두 줄과 동일
		}
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
