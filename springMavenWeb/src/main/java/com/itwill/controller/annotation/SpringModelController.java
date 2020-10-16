package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트 데이타");
		return "/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_map.do")
	public String map(Map map) { //map을 선언하면 생성한 후 request에 붙여서 보내준다
		map.put("map", "맵 데이타");
		return "/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_model.do")
	public String model(Model model) {
		model.addAttribute("model", "모델데이타");
		return "/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap.do")
	public String modelmap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap", "모델맵데이타");
		return "/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelandview.do")
	public ModelAndView modelView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("modelAndView", "모델앤뷰");
		mv.setViewName("/WEB-INF/views/spring_model.jsp");
		return mv;
	}
	@RequestMapping("/model_all.do")
	public String model_all(HttpServletRequest request,
							Model model,
							Map map,
							ModelMap modelMap) {
		request.setAttribute("req", "리퀘스트 데이타");
		map.put("map", "맵 데이타");
		model.addAttribute("model", "모델데이타");
		modelMap.addAttribute("modelmap", "모델맵데이타");
		return "/WEB-INF/views/spring_model.jsp";
	}
}
