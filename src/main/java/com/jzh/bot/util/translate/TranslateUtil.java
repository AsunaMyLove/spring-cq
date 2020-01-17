package com.jzh.bot.util.translate;

import com.alibaba.fastjson.JSONArray;
import com.jzh.bot.util.translate.baidu.TransApi;
import com.jzh.bot.util.translate.baidu.vo.Rsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.util.translate
 * @className: TranslateUtil
 * @description: 百度翻译api调用
 * @date 2020/1/16 15:46
 */
@Component
public class TranslateUtil {

    private Logger logger = LoggerFactory.getLogger(TranslateUtil.class);

    @Value("${baiduApi.appId}")
    private String appId;
    @Value("${baiduApi.securityKey}")
    private String securityKey;

    public String translate(String query, String from, String to) {
        TransApi api = new TransApi(appId, securityKey);
        String result = api.getTransResult(query, from, to);
        logger.info("Baidu Translate API Rsp:{}",result);
        Rsp rsp = JSONArray.parseObject(result, Rsp.class);
        return rsp.getTrans_result()[0].getDst();
    }

}
