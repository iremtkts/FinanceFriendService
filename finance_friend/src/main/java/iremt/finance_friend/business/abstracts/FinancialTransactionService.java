package iremt.finance_friend.business.abstracts;

import java.util.List;

import iremt.finance_friend.entities.concretes.FinancialTransaction;
import iremt.finance_friend.entities.dtos.FinancialTransactionDto;


public interface FinancialTransactionService {
	List<FinancialTransaction> getAll();
	
	FinancialTransaction addFinancialTransaction(FinancialTransactionDto financialTransactionDto);

}
