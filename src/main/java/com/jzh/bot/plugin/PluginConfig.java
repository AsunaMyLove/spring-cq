package com.jzh.bot.plugin;

import com.jzh.bot.plugin.heros.plg.HeroPlugin;
import com.jzh.bot.plugin.log.LogPlugin;
import com.jzh.bot.plugin.prefix.PrefixPlugin;
import com.jzh.bot.plugin.status.StatusPlugin;
import com.jzh.bot.plugin.say.SayPlugin;
import com.jzh.cq.robot.CQPlugin;

import java.util.ArrayList;
import java.util.List;

public class PluginConfig {
    public static List<CQPlugin> pluginList = new ArrayList<>();

    static {
        pluginList.add(new StatusPlugin()); // 状态监控插件
        pluginList.add(new LogPlugin()); // 日志插件
        pluginList.add(new PrefixPlugin()); // 前缀处理插件
        pluginList.add(new SayPlugin()); // 说话插件
        pluginList.add(new HeroPlugin()); //300英雄插件
    }

}
