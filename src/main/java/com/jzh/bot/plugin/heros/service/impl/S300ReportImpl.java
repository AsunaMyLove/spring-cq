package com.jzh.bot.plugin.heros.service.impl;

import com.jzh.bot.plugin.heros.entity.Hero;
import com.jzh.bot.plugin.heros.entity.Info;
import com.jzh.bot.plugin.heros.entity.Match;
import com.jzh.bot.plugin.heros.entity.MatchInfo;
import com.jzh.bot.plugin.heros.common.UrlConstants;
import com.jzh.bot.plugin.heros.mapper.HeroMapper;
import com.jzh.bot.plugin.heros.service.S300Report;
import com.jzh.bot.util.ConvetUtil;
import com.jzh.bot.util.FormatUtil;
import com.jzh.bot.util.HttpUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.service
 * @className: S300ReportImpl
 * @description: S300Report实现类
 * @date 2020/1/7 15:15
 */
@Service
public class S300ReportImpl implements S300Report {

    private Logger logger = LoggerFactory.getLogger(S300ReportImpl.class);

    @Autowired
    private HttpUtil httpUtil;

    @Override
    public String getListByName(String name) {
        Document doc = httpUtil.connect(UrlConstants.LIST+name);

        Elements elements2 = doc.getElementsByClass("datatable");
        int index = 1;
        if(elements2.size()==1){
            index = 0;
        }
        Element e1 = elements2.get(index);
        Elements trs = e1.getElementsByTag("tr");

        List<Info> list = new LinkedList<>();
        for (Element info : trs) {
            if(info.hasAttr("onClick")){
                String clickStr = info.attr("onClick");
                Info m = ConvetUtil.changeInfo(info);
                m.setId(clickStr.substring(clickStr.indexOf("=")+1,clickStr.lastIndexOf("'")));

                list.add(m);
            }
        }

        return FormatUtil.formatMatch(list);
    }

    @Override
    public String getMatchById(String id) {
        Document doc = httpUtil.connect(UrlConstants.MATCH+id);

        Elements elements1 = doc.getElementsByClass("datamsg");

        Elements elements2 = doc.getElementsByClass("datatable");

        Element e = elements2.get(0);
        //根据tr找到win的7个人
        List<MatchInfo> winTeam = new ArrayList<>();
        Elements wins = e.getElementsByTag("tr");
        for (Element win:wins) {
            Elements infos = win.getElementsByTag("td");
            if(infos.size()==0){
                continue;
            }
            MatchInfo matchInfo = ConvetUtil.changeMatchInfo(infos);

            winTeam.add(matchInfo);
        }

        Element e1 = elements2.get(1);
        //根据tr找到lose的7个人
        List<MatchInfo> loseTeam = new ArrayList<>();
        Elements loses = e1.getElementsByTag("tr");
        for (Element lose:loses) {
            Elements infos = lose.getElementsByTag("td");
            if(infos.size()==0){
                continue;
            }
            MatchInfo matchInfo = ConvetUtil.changeMatchInfo(infos);

            loseTeam.add(matchInfo);
        }

        //整合一场比赛
        Match match = new Match();
        match.setWin(winTeam);
        match.setLose(loseTeam);
        match.setResult(elements1.text());

        return match.toString();
    }

    @Autowired
    private HeroMapper heroMapper;
    @Value("${heroListStart}")
    private int heroListStart = 0;
    @Value("${heroListEnd}")
    private int heroListEnd = 300;

    @Override
    public int updateHeroList() {
        //获取当前所有
        List<Hero> list = heroMapper.selectByMap(new HashMap<>());
        logger.info("当前库中的英雄数量:{}",list.size());

        for (int i = heroListStart; i < heroListEnd; i++) {
            Document doc = httpUtil.connect(UrlConstants.GET_HERO_BY_RANK.replaceAll("##type##",i+""));
            String name = doc.select(UrlConstants.GET_HERO_NAME_SELECTOR).text();
            if("战绩查询".equals(name)){
                continue;
            }
            name = name.replace("本命排行","");
            Hero h = new Hero();
            h.setId(i);
            h.setName(name);
            if(!list.contains(h)){
                logger.info("新加的英雄:{}",h.toString());
                heroMapper.insert(h);
            }
        }

        return 0;
    }


}
