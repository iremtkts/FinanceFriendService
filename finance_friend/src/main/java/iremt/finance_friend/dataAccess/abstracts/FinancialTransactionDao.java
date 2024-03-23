package iremt.finance_friend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import iremt.finance_friend.entities.concretes.FinancialTransaction;

public interface FinancialTransactionDao extends JpaRepository<FinancialTransaction, Integer> {

}
