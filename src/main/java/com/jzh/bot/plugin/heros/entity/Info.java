package com.jzh.bot.plugin.heros.entity;

import lombok.Data;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.vo
 * @className: Info
 * @description: list接口  保存近5场比赛
 * @date 2020/1/6 20:03
 */
@Data
public class Info {

    /**
     * 比赛id
     */
    private String id;
    /**
     * 比赛类型
     */
    private String matchType;
    /**
     * 使用英雄
     */
    private String hero;
    /**
     * 比赛结果
     */
    private String result;
    /**
     * 比赛时间
     */
    private String time;

    @Override
    public String toString() {
        return matchType+id+"-"+hero+"-"+result+"-"+time;
    }
}
