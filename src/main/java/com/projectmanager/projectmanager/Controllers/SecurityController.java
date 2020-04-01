package com.projectmanager.projectmanager.Controllers;

import com.projectmanager.projectmanager.Dao.Entities.UserAccount;
import com.projectmanager.projectmanager.Services.UserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private BCryptPasswordEncoder passwordEncoder;
    private UserAccountService userAccountService;

    public SecurityController(BCryptPasswordEncoder passwordEncoder, UserAccountService userAccountService) {
        this.passwordEncoder = passwordEncoder;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model,UserAccount userAccount){
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        userAccountService.saveUser(userAccount);
        return "redirect:/";
    }
}
