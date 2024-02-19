package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class NavController
{
   @GetMapping("/log")
	public String login() {
		return "login";
	}
   
   @GetMapping("/reg")
	public String register() {
		return "register";
	}
   
   @GetMapping("/newSong")
	public String newSong() {
		return "newSong";
	}
  
   
}
