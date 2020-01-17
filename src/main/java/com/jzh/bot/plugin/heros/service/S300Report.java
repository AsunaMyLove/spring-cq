package com.jzh.bot.plugin.heros.service;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.service
 * @className: S300Report
 * @description: 查询300的接口
 * @date 2020/1/7 15:12
 */
public interface S300Report {

    /**
     * 根据名字查询战绩等信息  list
     * @param name 名字
     * @return
     */
    String getListByName(String name);

    /**
     * 根据比赛id查询单局比赛信息   match
     * @param id id
     * @return
     */
    String getMatchById(String id);

    /**
     * 更新英雄列表
     * @return
     */
    int updateHeroList();
}
