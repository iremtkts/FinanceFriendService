package iremt.finance_friend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iremt.finance_friend.business.abstracts.FinancialTransactionService;
import iremt.finance_friend.entities.concretes.FinancialTransaction;
import iremt.finance_friend.entities.dtos.FinancialTransactionDto;

@RestController
@RequestMapping("/api/financialtransactions")
public class FinancialTransactionController {
	private FinancialTransactionService financialTransactionService;

	@Autowired
	public FinancialTransactionController(FinancialTransactionService financialTransactionService) {
		super();
		this.financialTransactionService = financialTransactionService;
	}
	
	@GetMapping("/getall")
	public List<FinancialTransaction> getAll(){
		return this.financialTransactionService.getAll();
		
	}
	
	@PostMapping("/add")
    public ResponseEntity<FinancialTransaction> addFinancialTransaction(@RequestBody FinancialTransactionDto financialTransactionDto) {
        FinancialTransaction newTransaction = financialTransactionService.addFinancialTransaction(financialTransactionDto);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
