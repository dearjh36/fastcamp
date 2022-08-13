package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RegisterController {
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) // get, post �� �� ���
	//@RequestMapping("/register/add")
	/*@GetMapping("/register/add")*/
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
	//@RequestMapping("/register/save", method=RequestMthod.POST) // �Ʒ� ����
	@PostMapping("/register/save") // 4.3���� // ������ ������
	public String save(User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է���","utf-8");
			
			m.addAttribute("msg",msg);
			return "forward:/register/add"; // redirect : ���û , �������� �ڵ����� �Ʒ��ٷ� �ٲ�
			//return "redirect:/register/add?msg="+msg; // URL ���ۼ�(rewriting) , ���� �� �ٰ� ����
		}
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
