package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	Repo repo;
	@GetMapping("/emp")
	public List<Emp> show()
	{
		return this.repo.findAll();
	}
	@PostMapping("/emp")
	public Emp add(@RequestBody Emp e)
	{
		return this.repo.save(e);
	}
	@PutMapping("/emp")
	public Emp update(@RequestBody Emp e)
	{
		return this.repo.save(e);
	}
	@DeleteMapping("/emp/{id}")
    public String delete(@PathVariable int id)
	{
        repo.deleteById(id);
        return "Employee with ID " + id + " deleted successfully";
    }
	@GetMapping("/emp{id}")
	public Emp getById(@PathVariable int id)
	{
        return repo.findById(id).orElse(null);
	}
}
