package com.springmvc.service;

import com.springmvc.dao.AccountDAO;
import com.springmvc.entities.Account;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Data
@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public Account checkCorrectUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    public Account checkCorrectAccount(Account account){
        if(checkCorrectUsername(account.getUsername())!=null){
            return  accountDAO.checkCorrectPassword(account);
        }
       return null;
    }

    public String updateLoginFailed(Account account){
        int count = account.getTimesLoginFailed();
        account.setTimesLoginFailed(count+=1);
        boolean flag = false;
        if(account.getTimesLoginFailed()>=5){
            account.setStatus(Account.Status.DEACTIVED.getValue());
            account.setTimeBlocked(Date.from(Instant.now().plusSeconds(300)));
            flag = true;
        }
        accountDAO.update(account);
        if(flag){
            return "Tài khoản bị khóa đến: "+account.getTimeBlocked();
        }
        return null;
    }

    public void updateLoginSuccess(Account account){
        account.setTimesLoginFailed(0);
        account.setStatus(Account.Status.ACTIVED.getValue());
        accountDAO.update(account);
    }
}
