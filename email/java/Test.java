package com.qhit.utils;

import com.qhit.utils.email.SendEmail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XinGe on 2018/12/8.
 */
@RestController
@RequestMapping("/test")
public class Test {



    @RequestMapping("email")
    public Map<String, Object>  email(String addressee) throws GeneralSecurityException {
        SendEmail sendEmail = new SendEmail();
        Map<String, Object> map = sendEmail.emailUtil(addressee);
        boolean flag = (boolean) map.get("flag");
        Object yanzhengma = map.get("yanzhengma");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("message",flag?"发送成功":"发送失败");
        map1.put("yanzhengma",yanzhengma);
        map1.put("flag",flag);
        return map1;
    }

}
