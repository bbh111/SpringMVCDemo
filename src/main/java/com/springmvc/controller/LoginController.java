package com.springmvc.controller;

import com.springmvc.entities.Account;
import com.springmvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String confirmLogin(@RequestParam(name = "username") String username,
                               @RequestParam("password") String password, Model model) {
        Account account = new Account(username, password);
        if (accountService.checkCorrectAccount(account) != null) {
            account = accountService.checkCorrectAccount(account);
            if (account.isActive() || (!account.isActive()&&account.isBeforeNow())) {
                accountService.updateLoginSuccess(account);
                return "homepage";
            } else {
                model.addAttribute("lockMess", account.timeBlockedRemain());
                return "login";
            }
        } else {
            if (accountService.checkCorrectUsername(username) != null) {
                account = accountService.checkCorrectUsername(username);
                String lockMess = accountService.updateLoginFailed(account);
                if (account.getTimesLoginFailed() < 5) {
                    model.addAttribute("errMess", "Mật khẩu không đúng, bạn còn "
                            + (5 - account.getTimesLoginFailed()) + " lần thử");
                }
                model.addAttribute("lMess", lockMess);
            } else {
                model.addAttribute("errMess", "Tài khoản không tồn tại");
            }
            return "login";
        }
    }
}
