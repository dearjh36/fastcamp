package com.fastcampus.ch2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. ������ ����
		session.invalidate();
		// 2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@CookieValue("id") String cookieId, String id, String pwd,String toURL, boolean rememberId, HttpServletResponse response, HttpServletRequest request) throws IOException { // String rememberId �϶� üũ �Ǿ������� on(����Ʈ��)
		// 1. id�� pwd�� Ȯ��
		// 	  ��ġ���� ������ loginForm���� �̵�
		if(!loginCheck(id,pwd)) {
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		// 2. id�� pwd�� ��ġ�ϸ�, 
		// ���� ��ü ���ͼ�
		HttpSession session = request.getSession();
		// ���� ��ü�� id ����
		session.setAttribute("id",id);
		
		if(rememberId) {
			// 		1. ��Ű�� ����
			Cookie ck = new Cookie("id",id);
			// 		2. ���信 ����
			response.addCookie(ck);			
		}else {
			Cookie ck = new Cookie("id",id);
			ck.setMaxAge(0); // ��Ű ����
			response.addCookie(ck);			
		}
		// 		3. Ȩ���� �̵�
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:" + toURL;		
	}
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id)&&"1234".equals(pwd);
	}
}
