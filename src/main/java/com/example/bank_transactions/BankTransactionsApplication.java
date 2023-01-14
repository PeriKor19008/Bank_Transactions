package com.example.bank_transactions;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.service.AccountService;

import com.example.service.AccountServiceImpl;
import com.example.service.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class BankTransactionsApplication {

    // Annotation

    private TransactionService transactionService = new TransactionService();
    private AccountServiceImpl accountService = new AccountServiceImpl();

    public static void main(String[] args) {

        SpringApplication.run(BankTransactionsApplication.class, args);

    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @RequestMapping(value="/transfer/{src}/{tar}/{amm}",method = RequestMethod.GET)
    public String transfer(@PathVariable int src,@PathVariable int tar, @PathVariable double amm ){
        return String.format("SRC->%d Tar->%d AMM->%f",src,tar,amm);
    }
    @RequestMapping(value = "/transaction",method =RequestMethod.POST)
    public void transaction(@RequestBody Transaction transaction){
        transactionService.getTransaction(transaction);
    }




    @GetMapping(value="/accounts")
    public List<Account> fetchAccountList()
    {
        List<Account> a=accountService.fetchAccountList();
        System.out.println(a);
        return a;
    }

}
