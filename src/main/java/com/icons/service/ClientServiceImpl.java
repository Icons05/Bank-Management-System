package com.icons.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icons.exceptions.ClientNotFoundException;
import com.icons.exceptions.ClientExistsException;
import com.icons.model.Client;
import com.icons.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService
{
	@Autowired
	private ClientRepository repository;
	
	public Client find(int id)
	{
		Optional<Client> o=repository.findById(id);
		
		if(o.isPresent()) 
        {			
			return o.get();
        }
		return null;
	}
	
	public List<Client> findAll()
	{
		return repository.findAll();
	}
	
	public void save(Client client)
	{
		
		repository.save(client);
	}
	
	public void delete(int id)
	{
        Optional<Client> o = repository.findById(id);
        
        if(o.isPresent()) 
        {
            repository.deleteById(id);
        }
        else
        {
        	throw new ClientNotFoundException("clientId: "+id);
        }

	}

	public void update(Client client)
	{
		System.out.println("In service, from browser: "+client);
		
        Optional<Client> o = repository.findById(client.getClientId());
        
        System.out.println("In service, from db: "+o.get());      
        if(o.isPresent()) 
        {
            repository.save(client);
        }
        else
        {
        	throw new ClientNotFoundException("clientId: "+client.getClientId());
        }
 	}

}




