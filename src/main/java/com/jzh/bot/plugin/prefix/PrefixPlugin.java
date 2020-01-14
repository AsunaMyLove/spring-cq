package com.jzh.bot.plugin.prefix;

import com.jzh.cq.event.message.CQGroupMessageEvent;
import com.jzh.cq.event.message.CQPrivateMessageEvent;
import com.jzh.cq.robot.CQPlugin;
import com.jzh.cq.robot.CoolQ;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 这个插件用于预处理消息，如指令前缀
@Component
@Order(value = 3)
public class PrefixPlugin extends CQPlugin {
    // 指令前缀 /
    private String prefix = "/";

    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        String msg = event.getMessage();
        if (msg.startsWith(prefix)) {
            // 指令以 prefix 开头，去除prefix，并继续执行下一个插件
            msg = msg.substring(prefix.length());
            event.setMessage(msg);
            return MESSAGE_IGNORE;
        } else {
            // 指令不以 prefix 开头，结束，不执行下一个插件
            return MESSAGE_BLOCK;
        }
    }

    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        String msg = event.getMessage();
        if (msg.startsWith(prefix)) {
            // 指令以 prefix 开头，去除prefix，并继续执行下一个插件
            msg = msg.substring(prefix.length());
            event.setMessage(msg);
            return MESSAGE_IGNORE;
        } else {
            // 指令不以 prefix 开头，结束，不执行下一个插件
            return MESSAGE_BLOCK;
        }
    }
}
