package com.jzh.bot.plugin.say;

import com.jzh.cq.event.message.CQGroupMessageEvent;
import com.jzh.cq.event.message.CQPrivateMessageEvent;
import com.jzh.cq.robot.CQPlugin;
import com.jzh.cq.robot.CoolQ;


public class SayPlugin extends CQPlugin {
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        long user_id = event.getSender().getUserId();
        String msg = event.getMessage();
        if (msg.startsWith("say")) {
            cq.sendPrivateMsg(user_id, msg.substring(3), false);
        }
        return MESSAGE_IGNORE; // 继续执行下一个插件
        // return MESSAGE_BLOCK; // 不执行下一个插件
    }

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String msg = event.getMessage();
        if (msg.startsWith("say")) {
            cq.sendGroupMsg(event.getGroupId(), msg.substring(3), false);
        }
        return MESSAGE_IGNORE; // 继续执行下一个插件
    }
}
