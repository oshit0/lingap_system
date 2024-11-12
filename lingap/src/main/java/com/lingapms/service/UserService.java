package com.lingapms.service;

import com.lambdaworks.crypto.SCryptUtil;
import com.lingapms.dao.UserCredentialReadDAO;
import com.lingapms.dao.UserCredentialUpdateDAO;
import com.lingapms.enums.Role;
import com.lingapms.model.User;

/*
 */

public class UserService {

    private UserCredentialReadDAO userRead;
    private UserCredentialUpdateDAO userUpdate;

    public UserService(UserCredentialReadDAO userRead, UserCredentialUpdateDAO userUpdate) {
        this.userRead = userRead;
        this.userUpdate = userUpdate;
    }

    public User authenticate(String username, String password) {
        User user = userRead.searchUser(username);
        if (user != null && SCryptUtil.check(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public boolean registerUser(int userId, String username, String password) {
        User user = new User(username, SCryptUtil.scrypt(password, 16384, 8, 1), userId, Role.PATIENT);
        return userUpdate.addUser(user);
    }

    public boolean updateUser(String username, String newPassword) {
        User user = userRead.searchUser(username);
        if (user != null) {
            user.setPassword(SCryptUtil.scrypt(newPassword, 16384, 8, 1));
            return userUpdate.updateUser(user);
        } else {
            return false;
        }
    }
}
