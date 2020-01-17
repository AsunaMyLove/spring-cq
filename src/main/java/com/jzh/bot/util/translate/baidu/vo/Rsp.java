package com.jzh.bot.util.translate.baidu.vo;

import lombok.Data;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.util.translate.baidu.vo
 * @className: Rsp
 * @description: 百度翻译返回对象
 * @date 2020/1/16 16:25
 */
@Data
public class Rsp {

    private String from;
    private String to;
    private TransResult[] trans_result;
}
