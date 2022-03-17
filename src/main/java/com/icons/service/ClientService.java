package com.icons.service;


import java.util.List;



import org.springframework.stereotype.Service;

import com.icons.model.Client;


@Service
public interface ClientService 
{
	public Client find(int id);
	public List<Client> findAll();
	public void save(Client client);
	public void delete(int id);
	public void update(Client client);
}


