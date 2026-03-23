package com.bank.credit.service;

import java.util.List;
import com.bank.credit.entity.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}