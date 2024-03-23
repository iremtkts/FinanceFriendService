package iremt.finance_friend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iremt.finance_friend.business.abstracts.FinancialTransactionService;
import iremt.finance_friend.dataAccess.abstracts.CategoryDao;
import iremt.finance_friend.dataAccess.abstracts.FinancialTransactionDao;
import iremt.finance_friend.dataAccess.abstracts.UserDao;
import iremt.finance_friend.entities.concretes.Category;
import iremt.finance_friend.entities.concretes.FinancialTransaction;
import iremt.finance_friend.entities.concretes.User;
import iremt.finance_friend.entities.dtos.FinancialTransactionDto;

@Service
public class FinancialTransactionManager implements FinancialTransactionService {
	private FinancialTransactionDao financialTransactionDao;
	private UserDao userDao; 
	private CategoryDao categoryDao; 


	@Autowired
	public FinancialTransactionManager(FinancialTransactionDao financialTransactionDao, UserDao userDao,
			CategoryDao categoryDao) {
		super();
		this.financialTransactionDao = financialTransactionDao;
		this.userDao = userDao;
		this.categoryDao = categoryDao;
	}
	

	@Override
	public List<FinancialTransaction> getAll() {
		// TODO Auto-generated method stub
		return this.financialTransactionDao.findAll();
	}


	@Override
	public FinancialTransaction addFinancialTransaction(FinancialTransactionDto transactionDto) {
        User user = userDao.findById(transactionDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Category category = categoryDao.findById(transactionDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        FinancialTransaction transaction = new FinancialTransaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTransactionDate(transactionDto.getTransactionDate());
        transaction.setUser(user);
        transaction.setCategory(category);

        return financialTransactionDao.save(transaction);
    }

}
