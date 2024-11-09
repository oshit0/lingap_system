package com.lingap;

import com.lambdaworks.crypto.SCryptUtil;

/*
 * Re-used class from java backend I did.
 *
 * @author  Mark Gerald
 */


public class Encryption {

    String hashedPassword;

    public Encryption() {
    }

    public String encrypt(String password) {
        this.hashedPassword = SCryptUtil.scrypt(password, 8192, 16, 1);
        return this.hashedPassword;
    }
}
