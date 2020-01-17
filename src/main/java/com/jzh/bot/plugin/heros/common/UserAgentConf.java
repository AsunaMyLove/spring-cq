package com.jzh.bot.plugin.heros.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.heros.common
 * @className: UserAgentConf
 * @description: 随机userAgent
 * @date 2020/1/14 16:53
 */
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties(UserAgentConf.class)
public class UserAgentConf {

    @Getter
    @Setter
    private Map<String, String> userAgentMap = new HashMap<>();
}
