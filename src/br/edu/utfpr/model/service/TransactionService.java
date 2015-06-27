package br.edu.utfpr.model.service;

import java.util.List;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.dao.CustomerDAO;
import br.edu.utfpr.model.dao.TransactionDAO;

public class TransactionService extends AbstractService<Long, Transaction>{
	public TransactionService(){
		dao = new TransactionDAO();
	}	
}
