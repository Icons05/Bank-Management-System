package com.icons.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icons.model.Client;
import com.icons.service.ClientService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
  
@RequestMapping("/clients")
public class ClientController 
{
	@Autowired
	private ClientService service;
	
	@PostMapping("/insert")
	public HttpStatus insert(@RequestBody Client client)
	{
		
		try
		{
			service.save(client);
			return HttpStatus.CREATED;
		}
		catch(Exception e)
		{
			return HttpStatus.FOUND;
		}
	}

	@PutMapping("/update")
	public HttpStatus update(@RequestBody Client client)
	{
		System.out.println(client);		
		try
		{
			service.update(client);
			return HttpStatus.OK;
		}
		catch(Exception e)
		{
			return HttpStatus.NOT_FOUND;
		}
	}

	@GetMapping("/findAll")
	public List<Client> findAll()
	{
		return service.findAll();
	}

	@GetMapping("/find/{id}")
	public Object find(@PathVariable int id)
	{
		try
		{
			Client stock=service.find(id);
			return stock;
		}
		catch(Exception e)
		{
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable int id)
	{
		try
		{
			service.delete(id);
			return HttpStatus.OK;
		}
		catch(Exception e)
		{
			return HttpStatus.NOT_FOUND;
		}
	}

}


