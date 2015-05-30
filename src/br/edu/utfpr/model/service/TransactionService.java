package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.dao.TransactionDAO;

public class TransactionService extends AbstractService<Long, Transaction>{
	public TransactionService(){
		dao = new TransactionDAO();
	}
}
