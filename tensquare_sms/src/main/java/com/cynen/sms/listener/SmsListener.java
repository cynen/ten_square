package com.cynen.sms.listener;


import com.cynen.sms.utils.SmsUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 监听注册消息的短信通知.
 * 推送到MQ上的消息需要是 Map类型.
 * {
 *     "mobile":"189XXXXXXXX",
 *     "checkcode":"XXXXXX"
 * }
 *
 */
@Component
@RabbitListener(queues = "registry_sms" )
public class SmsListener {

    @Autowired
    private SmsUtils smsUtils;

    // 从配置文件直接读取参数
    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;


    /**
     * 此Map为MQ中存储的 MAP对象,并且必须带有mobile和checkcode
     *
     * 短信发送服务不做校验,有MQ消息就进行发送.
     * @param map
     */
    @RabbitHandler
    public void listener(Map<String,String> map){
        String mobile = map.get("mobile");
        String checkcode = map.get("checkcode");

        System.out.println("手机号 :" + mobile  + "; 验证码: " + checkcode);
        smsUtils.sendSms(mobile,template_code,"{\"code\":\""+checkcode+"\"}",sign_name);

    }
}
