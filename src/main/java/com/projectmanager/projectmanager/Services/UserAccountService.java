package com.projectmanager.projectmanager.Services;

import com.projectmanager.projectmanager.Dao.Entities.UserAccount;
import com.projectmanager.projectmanager.Dao.UserAccountRepo;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private UserAccountRepo userAccountRepo;

    public UserAccountService(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    public UserAccount saveUser(UserAccount userAccount){
        return userAccountRepo.save(userAccount);
    }
}
