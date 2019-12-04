package com.fantasticCode.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fantasticCode.entities.Account;

//interfaz de usuario (cuenta del admin) 
//todas las cosas que podra realizar

public interface AccountService {
	public List<Account> findAll(int page);

	public Account findOne(Integer code);

	public long countAll();

	public void save(Account account);

	public void delete(Account account);

	public boolean findOneUser(String username, String password) throws DataAccessException;

	public boolean findOneUserActive(String username, String password) throws DataAccessException;
	
	public boolean findOneUsername(String username) throws DataAccessException;

	public Account findOneUserByUsernamePassword(String username, String password);
}
