package com.jzh.bot.plugin.heros.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.vo
 * @className: MatchInfo
 * @description: 一场比赛中的一个人的信息
 * @date 2020/1/7 17:51
 */
@Data
public class MatchInfo {

    /**
     <th>召唤师</th>
     <th>杀/死/助</th>
     <th>结果</th>
     <th>建筑摧毁</th>
     <th>小兵击杀</th>
     <th>金钱数</th>
     <th>评分</th>
     <th>召唤师技能</th>
     <th>装备</th>
     <th>金钱/经验奖励</th>
     <th>节操</th>
     <th>胜率</th>
     */
    private String masterName;
    private String heroName;
    private String kda;
    private String result;
    private String buildDestory;
    private String soiderKill;
    private String money;
    private String score;
    private List<String> masterSkill;
    private List<String> equip;
    private String perMoneyExp;
    private String jc;
    private String winRate;

    @Override
    public String toString() {
        return masterName+'-'+heroName+'-'+kda;
    }

    public String toString1() {
        return "MatchInfo{" +
                "masterName='" + masterName + '\'' +
                ", heroName='" + heroName + '\'' +
                ", kda='" + kda + '\'' +
                ", result='" + result + '\'' +
                ", buildDestory='" + buildDestory + '\'' +
                ", soiderKill='" + soiderKill + '\'' +
                ", money='" + money + '\'' +
                ", score='" + score + '\'' +
                ", masterSkill=" + masterSkill +
                ", equip=" + equip +
                ", perMoneyExp='" + perMoneyExp + '\'' +
                ", jc='" + jc + '\'' +
                ", winRate='" + winRate + '\'' +
                '}';
    }
}
