package com.jzh.bot.plugin.pcr.plg;

import com.jzh.bot.plugin.pcr.service.PcrService;
import com.jzh.cq.event.message.CQGroupMessageEvent;
import com.jzh.cq.event.message.CQPrivateMessageEvent;
import com.jzh.cq.robot.CQPlugin;
import com.jzh.cq.robot.CoolQ;
import com.jzh.cq.utils.CQCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.pcr.plg
 * @className: PcrPlugin
 * @description: pcr查询  数据来自https://gamewith.jp/pricone-re
 * @date 2020/1/16 13:53
 */
@Component
@Order(value = 6)
public class PcrPlugin extends CQPlugin {

    private Logger logger = LoggerFactory.getLogger(PcrPlugin.class);

    @Autowired
    private PcrService pcrService;

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String report = "";
        String msg = event.getMessage();
        if(msg.matches("pcr查询rank=(.*)")){
            try {
                report = pcrService.recommendRank(msg.split("=")[1]);
                if("".equals(report)){
                    report = "该rank没有推荐角色";
                }
            } catch (Exception e) {
                e.printStackTrace();
                report = "找不到角色信息!";
            }
        }
        cq.sendGroupMsg(event.getGroupId(),report,false);
        return MESSAGE_IGNORE;
    }

    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        String report = "";
        String msg = event.getMessage();
        if(msg.equals("pcr更新rank") && event.getUserId() == 1141773341L){
            try {
                pcrService.updateRank();
                report = "更新成功!";
            } catch (Exception e) {
                e.printStackTrace();
                report = "更新失败!";
            }
        }
        if(msg.equals("pcr更新pic") && event.getUserId() == 1141773341L){
            try {
                pcrService.updateHeadPic();
                report = "更新成功!";
            } catch (Exception e) {
                e.printStackTrace();
                report = "更新失败!";
            }
        }
        if(msg.equals("色图") && event.getUserId() == 1141773341L){
            report = CQCode.image("136547.png");
        }
        logger.info(report);
        cq.sendPrivateMsg(event.getUserId(),report,false);
        return MESSAGE_IGNORE;
    }
}
