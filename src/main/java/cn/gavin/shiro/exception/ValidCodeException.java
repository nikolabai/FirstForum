package cn.gavin.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * @author Gavin
 * @2017年7月4日
 */

public class ValidCodeException extends AuthenticationException {

    public ValidCodeException(String msg){
        super(msg);
    }
}
