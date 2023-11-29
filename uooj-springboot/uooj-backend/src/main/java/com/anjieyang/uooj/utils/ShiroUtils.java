package com.anjieyang.uooj.utils;

import org.apache.shiro.SecurityUtils;
import com.anjieyang.uooj.shiro.AccountProfile;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public class ShiroUtils {

    private ShiroUtils() {
    }

    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}