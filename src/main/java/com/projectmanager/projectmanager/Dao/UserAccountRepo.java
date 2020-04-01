package com.projectmanager.projectmanager.Dao;

import com.projectmanager.projectmanager.Dao.Entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends PagingAndSortingRepository<UserAccount,Long> {
}
