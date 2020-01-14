package com.jzh.bot.plugin.heros.util;

import com.jzh.bot.entity.heros.Info;

import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.util
 * @className: FormatUtil
 * @description: 格式化工具类
 * @date 2020/1/7 17:12
 */
public class FormatUtil {

    public static String formatMatch(List<Info> list){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size() ; i++) {
            sb.append(list.get(i).toString()).append('\n');
            if(i==4){
                break;
            }
        }
        return sb.toString();
    }

}
