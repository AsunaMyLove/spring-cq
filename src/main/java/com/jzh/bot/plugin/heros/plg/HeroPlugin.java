package com.jzh.bot.plugin.heros.plg;

import com.jzh.bot.plugin.heros.service.S300Report;
import com.jzh.cq.event.message.CQGroupMessageEvent;
import com.jzh.cq.robot.CQPlugin;
import com.jzh.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.heros.plg
 * @className: HeroPlugin
 * @description: 300英雄的组件
 * @date 2020/1/13 15:06
 */
@Component
@Order(value = 5)
public class HeroPlugin extends CQPlugin {

    @Autowired
    private S300Report s300Report;

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String report = "";
        String msg = event.getMessage();
        if(msg.matches("查询战绩=(.*)")){
            try {
                report = s300Report.getListByName(msg.split("=")[1]);
            } catch (Exception e) {
                e.printStackTrace();
                report = "找不到角色信息!";
            }
        }
        if(msg.matches("查询比赛=(.*)")){
            try {
                report = s300Report.getMatchById(msg.split("=")[1]);
            } catch (Exception e) {
                e.printStackTrace();
                report = "找不到比赛信息!";
            }
        }
        Long fromQQ = event.getSender().getUserId();
        if("更新英雄列表".equals(msg) && fromQQ == 1141773341L){
            try {
                s300Report.updateHeroList();
                report = "更新英雄列表成功!";
            } catch (Exception e) {
                e.printStackTrace();
                report = "更新英雄列表失败!";
            }
        }
        cq.sendGroupMsg(event.getGroupId(),report,false);
        return MESSAGE_IGNORE;
    }

}
