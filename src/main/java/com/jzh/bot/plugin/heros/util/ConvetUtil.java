package com.jzh.bot.plugin.heros.util;

import com.jzh.bot.entity.heros.Info;
import com.jzh.bot.entity.heros.MatchInfo;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.util
 * @className: ConvetUtil
 * @description: TODO
 * @date 2020/1/6 20:05
 */
public class ConvetUtil {

    public static Info changeInfo(Element info) {
        List<String> list = info.getElementsByTag("td").eachText();
        Info m = new Info();

        m.setMatchType(list.get(0));
        m.setHero(list.get(1));
        m.setResult(list.get(2));
        m.setTime(list.get(3));

        return m;
    }

    /**
     *     <img src="static/images/skill/ico_8026..png" alt="" title="传送" height="32" width="32"/>
     *     <img src="static/images/skill/ico_8035..png" alt="" title="闪现" height="32" width="32"/>
     * 获取title的list
     * @param info
     * @return
     */
    public static List<String> getValueFromImg(Elements imgs) {
        List<String> list = new ArrayList<>();
        for (Element img:imgs) {
            list.add(img.attr("title"));
        }
        return list;
    }

    public static MatchInfo changeMatchInfo(Elements infos) {
        String masterName = infos.get(1).getElementsByTag("a").text();
        String heroName = infos.get(1).text().replace(masterName,"");
        String kda = infos.get(2).text();
        String result = infos.get(3).text();
        String buildDestory = infos.get(4).text();
        String soiderKill = infos.get(5).text();
        String money = infos.get(6).text();
        String score = infos.get(7).text();
        List<String> masterSkill = getValueFromImg(infos.get(8).getElementsByTag("img"));
        List<String> equip = getValueFromImg(infos.get(9).getElementsByTag("img"));
        String perMoneyExp = infos.get(10).text();
        String jc = infos.get(11).text();
        String winRate = infos.get(12).text();

        MatchInfo matchInfo = new MatchInfo();
        matchInfo.setMasterName(masterName);
        matchInfo.setHeroName(heroName);
        matchInfo.setKda(kda);
        matchInfo.setResult(result);
        matchInfo.setBuildDestory(buildDestory);
        matchInfo.setSoiderKill(soiderKill);
        matchInfo.setMoney(money);
        matchInfo.setScore(score);
        matchInfo.setMasterSkill(masterSkill);
        matchInfo.setEquip(equip);
        matchInfo.setPerMoneyExp(perMoneyExp);
        matchInfo.setJc(jc);
        matchInfo.setWinRate(winRate);

        return matchInfo;
    }
}
