package com.example.bank_transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BankTransactionsApplication {

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

}
