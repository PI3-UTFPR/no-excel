package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.dao.CustomerDAO;

public class CustomerService extends AbstractService<Long, Customer>{
	
	public CustomerService(){
		dao = new CustomerDAO();
	}
}
