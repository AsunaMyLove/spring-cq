package com.jzh.bot.service.impl;

import com.jzh.bot.entity.heros.Info;
import com.jzh.bot.entity.heros.Match;
import com.jzh.bot.entity.heros.MatchInfo;
import com.jzh.bot.plugin.heros.common.UrlConstants;
import com.jzh.bot.plugin.heros.util.ConvetUtil;
import com.jzh.bot.plugin.heros.util.FormatUtil;
import com.jzh.bot.service.S300Report;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public String getListByName(String name) {
        Document doc = connect(UrlConstants.LIST+name);

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
        Document doc = connect(UrlConstants.MATCH+id);

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


    private Document connect(String url) {
        try {
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            connect(url);
        }
        return null;
    }
}
