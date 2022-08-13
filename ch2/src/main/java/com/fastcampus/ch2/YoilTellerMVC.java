/*package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
    public ModelAndView main(int year, int month, int day) throws IOException {
    	//public String main(int year, int month, int day, Model model) throws IOException {
    	
    	
    	ModelAndView mv = new ModelAndView();
    	    	
    	// 1. 유효성 검사
		/*
		 * if(!isValid(year, month, day)) return "yoilError";
		 
    	// 2. 요일 계산
        char yoil = getYoil(year, month, day);
        
        // 3. 계산한 결과를 model에 저장
//        model.addAttribute("year",year);
  //     model.addAttribute("month",month);
   //     model.addAttribute("day",day);
   //     model.addAttribute("yoil",yoil);
        
        mv.addObject("year",year);
        mv.addObject("month",month);
        mv.addObject("day",day);
        mv.addObject("yoil",yoil);
        
        // 4. 결과를 보여줄 view를 지정
        mv.setViewName("yoil");
        
        return mv;
        
       // return "yoil"; // /WEB-INF/views/yoil.jsp
    }

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
	}
}*/
package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC
    public String main(int year, int month, int day, Model model) {
 
        // 1. 유효성 검사
    	if(!isValid(year, month, day)) 
    		return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동
    	
        // 2. 처리
    	char yoil = getYoil(year, month, day);

        // 3. Model에 작업 결과 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        // 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil"; // /WEB-INF/views/yoil.jsp
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}