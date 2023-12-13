package com.dino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dino.domain.TestVO;
import com.dino.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class SampleController {
	private final SampleService service;

	@GetMapping("/read")
	public String read(@RequestParam("id") int id, Model model) {
		log.info("read-------------");
		log.info("id >>> " + id);
		log.info("service === >>> " + service);
		TestVO vo = service.getOne(id); //vo값을 read.jsp전달하고 싶다.
		model.addAttribute("list", vo);
		
		//log.info("vo>>" + vo);
		return "read";
	}
}
