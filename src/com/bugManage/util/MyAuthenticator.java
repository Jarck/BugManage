package com.bugManage.util;

import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;  
  
/**
 * 邮件地址验证
 * @author lou-jiandong
 * @date 2013-5-18
 */
public class MyAuthenticator extends Authenticator {  
    private String username;  
    private String password;  
  
    public MyAuthenticator(String username, String password) {  
        super();  
        this.username = username;  
        this.password = password;  
    }  
  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(username, password);  
    }  
}  