package com.springmvc.controller;

import com.springmvc.entities.Account;
import com.springmvc.entities.Book;
import com.springmvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private Account account;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String redirectRegister(Model model) {
        model.addAttribute("newAccount",account);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegisterRequest(@ModelAttribute("newAccount") Account newAccount
            , Model modelMap) {


        modelMap.addAttribute("newAccount", newAccount);
        return "homepage";
    }
}
