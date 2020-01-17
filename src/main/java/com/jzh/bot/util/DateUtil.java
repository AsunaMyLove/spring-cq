package com.jzh.bot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.util
 * @className: DateUtil
 * @description: 日期工具类
 * @date 2020/1/15 18:36
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getYesterday() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,-1);
        return sdf.format(c.getTime());
    }

    public static String getToday() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return sdf.format(c.getTime());
    }
}
