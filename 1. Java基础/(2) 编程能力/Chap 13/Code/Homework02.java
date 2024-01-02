package com.tybxx;

import java.util.Scanner;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String name, pwd, mail;


        try {
            System.out.print("输入姓名：");
            name = myScanner.next();
            if(name.length() < 2 || name.length() > 4){
                throw new UserNameFormatException("用户名输入应该在 2~4位");
            }
            System.out.print("输入密码：");
            pwd = myScanner.next();
            if(pwd.length() != 6){
                throw new UserNameFormatException("用户名密码应为6位");
            }
            System.out.print("输入邮箱：");
            for (int i = 0; i < pwd.length(); i++) {
                if(pwd.charAt(i) < '0' || pwd.charAt(i) > '9'){
                    throw new UserNameFormatException("用户名密码应该为数字");
                }
            }
            mail = myScanner.next();
            for (int i = 0; i < mail.length(); i++) {
                if(mail.charAt(i) == '@' && mail.charAt(i + 1) == '.'){
                    return;
                }
            }
            throw new UserNameFormatException("应该包含@.字符");
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
}

class UserNameFormatException extends RuntimeException{
    public UserNameFormatException(String message){
        super(message);
    }
}
