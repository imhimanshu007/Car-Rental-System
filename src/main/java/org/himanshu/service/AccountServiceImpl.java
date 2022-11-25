package org.himanshu.service;

import org.himanshu.exceptions.AccountDoesNotExistsException;
import org.himanshu.model.account.Account;
import org.himanshu.model.account.AccountType;
import org.himanshu.repository.AccountRepository;
import org.himanshu.repository.AccountRepositoryFactory;

import java.nio.file.Path;

public class AccountServiceImpl implements AccountService{

    @Override
    public Account createAccount(Account account, AccountType accountType) {
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRespository(accountType);
        return accountRepository.createAccount(account);
    }

    @Override
    public void resetPassword(String userId, String password, AccountType accountType) throws AccountDoesNotExistsException {
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRespository(accountType);
        accountRepository.resetPassword(userId, password);
    }
}
