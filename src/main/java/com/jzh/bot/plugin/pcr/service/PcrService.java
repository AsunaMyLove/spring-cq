package com.jzh.bot.plugin.pcr.service;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.pcr.service
 * @className: PcrService
 * @description: pcr 接口
 * @date 2020/1/16 13:56
 */
public interface PcrService {


    /**
     * 更新pcr推荐rank
     */
    void updateRank();

    /**
     * 更新pcr角色头像
     */
    void updateHeadPic();

    /**
     * 推荐角色rank
     * @param rank
     * @return
     */
    String recommendRank(String rank);
}
