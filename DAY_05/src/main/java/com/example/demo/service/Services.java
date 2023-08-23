package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class Services {

	@Autowired
	BookRepo br;
	
	public Book saveinfo(Book ss) {
		return br.save(ss);
	}
	
	public List<Book> savedetails(List<Book> ss) {
		return (List<Book>)br.saveAll(ss);
	}
	
	public List<Book> showinfo() {
		return br.findAll();
	}
		
	public Optional<Book> showbyid(int id) {
		return br.findById(id);
	}
	
	public String changebyid(int id, Book ss) {
		br.saveAndFlush(ss);
		if(br.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid id";
		}
	}
	
	public void deleteid(int id) {
		br.deleteById(id);
	}
}
