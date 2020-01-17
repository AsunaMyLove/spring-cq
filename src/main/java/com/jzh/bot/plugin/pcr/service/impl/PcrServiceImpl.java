package com.jzh.bot.plugin.pcr.service.impl;

import com.jzh.bot.plugin.pcr.common.PcrUrl;
import com.jzh.bot.plugin.pcr.entity.CharacterRank;
import com.jzh.bot.plugin.pcr.mapper.CharacterRankMapper;
import com.jzh.bot.plugin.pcr.service.PcrService;
import com.jzh.bot.util.HttpUtil;
import com.jzh.bot.util.translate.TranslateUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.plugin.pcr.service.impl
 * @className: PcrServiceImpl
 * @description: PcrService实现类
 * @date 2020/1/17 11:20
 */
@Service
public class PcrServiceImpl implements PcrService {

    private Logger logger = LoggerFactory.getLogger(PcrServiceImpl.class);

    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private TranslateUtil translateUtil;

    @Autowired
    private CharacterRankMapper characterRankMapper;

    @Override
    public void updateRank() {
        Document doc = httpUtil.connect(PcrUrl.GET_RANK);
        Elements es = doc.getElementsByTag("h3");
        List<String> ids = characterRankMapper.selectAllCharacterId();
        for (Element e:es) {
            if(e.text().matches("ランク(.*)推奨キャラの解説と注意点")){
                String rank = e.text().replaceAll("ランク","").replaceAll("推奨キャラの解説と注意点","");
                System.out.println("----------------"+rank+"-----------------");
                Element table = e.previousElementSibling().previousElementSibling();
                Elements as = table.getElementsByTag("a");
                for (Element a:as) {
                    CharacterRank character = new CharacterRank();
                    character.setRank(rank);
                    String href = a.attr("href");
                    character.setUrl(href);
                    character.setId(href.substring(href.lastIndexOf("/")+1,href.length()));
                    String name = a.text();
                    character.setName(name);
                    character.setChineseName(translateUtil.translate(name,"jp","zh"));
                    String imgUrl = a.getElementsByTag("img").get(0).attr("data-original");
                    character.setImgUrl(imgUrl);
                    if(ids.contains(character.getId())){
                        logger.info("更新的角色:{}",character);
                        characterRankMapper.updateById(character);
                    }else{
                        logger.info("新增加的角色:{}",character);
                        characterRankMapper.insert(character);
                    }
                }
            }
        }
    }

    @Override
    public void updateHeadPic() {
        List<CharacterRank> list = characterRankMapper.selectAll();
        for (CharacterRank cr:list) {
            //一个一个获取头像图
            logger.info("获取角色id{},名字{}的图片...",cr.getId(),cr.getName());
            httpUtil.savePicFromUrlToBase(cr.getImgUrl(),cr.getId());
        }

    }

    @Override
    public String recommendRank(String rank) {
        List<CharacterRank> list = characterRankMapper.selectByRank(rank);
        StringBuilder sb = new StringBuilder();
        for (CharacterRank cr:list) {
            sb.append(cr.getName()).append(",");
        }
        return sb.toString();
    }
}
