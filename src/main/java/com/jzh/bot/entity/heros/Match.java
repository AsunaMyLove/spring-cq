package com.jzh.bot.entity.heros;

import lombok.Data;

import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.vo
 * @className: Match
 * @description: match接口 保存一场比赛的信息
 * @date 2020/1/7 17:48
 */
@Data
public class Match {

    private String result;
    private List<MatchInfo> win;
    private List<MatchInfo> lose;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(result).append('\n');
        sb.append("winners:\n");
        for (MatchInfo info:win) {
            sb.append(info.toString()).append('\n');
        }
        sb.append("losers:\n");
        for (MatchInfo info:lose) {
            sb.append(info.toString()).append('\n');
        }

        return sb.toString();
    }
}
