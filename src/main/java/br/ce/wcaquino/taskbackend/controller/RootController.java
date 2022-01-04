package br.ce.wcaquino.taskbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RootController {

	
	@GetMapping
	public String hello() {
		return "Hello World!";
	}
}
