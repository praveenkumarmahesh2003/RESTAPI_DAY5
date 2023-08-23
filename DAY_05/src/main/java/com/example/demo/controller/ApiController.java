package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.Services;

@RestController
public class ApiController {

	@Autowired
	Services sser;
	
	@PostMapping("add")
	public Book add(@RequestBody Book ss) {
		return sser.saveinfo(ss);
	}
	
	@PostMapping("addDetails")
	public List<Book> adddetails(@RequestBody List<Book> ss) {
		return sser.savedetails(ss);
	}
	
	@GetMapping("showDetails")
	public List<Book> show() {
		return sser.showinfo();
	}

	@GetMapping("showid/{id}")
	public Optional<Book> showDetailsById(@PathVariable int id) {
		return sser.showbyid(id);
	}
	
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody Book ss) {
		return sser.changebyid(id, ss);
	}
	
	@DeleteMapping("delid/{id}")
	public String deletemyid(@PathVariable int id) {
		sser.deleteid(id);
		return "Delete successfully";
	}
}
