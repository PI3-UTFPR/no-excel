package br.edu.utfpr.model.dao;

import java.util.List;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.util.JPAUtil;

public class TransactionDAO extends AbstractDAO<Long, Transaction>{
	public TransactionDAO(){
		super();
	}	
}
