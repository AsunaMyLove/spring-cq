package com.jzh.cq;

import com.jzh.bot.plugin.heros.common.UrlConstants;
import com.jzh.bot.plugin.heros.mapper.HeroMapper;
import com.jzh.bot.util.DateUtil;
import com.jzh.bot.util.HttpUtil;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCQApplicationTests {

    @Autowired
    private HeroMapper heroMapper;

    @Test
    public void contextLoads() {
        System.out.println(heroMapper.selectById(1));
    }

    @Autowired
    private HttpUtil httpUtil;
    private static final String GET_MATCH_SELECTOR = "#com > div.divbd_c > div > div.datamsg";
    //66155764-  66156661   66157659  66157661
    @Test
    public void test1() {
        for (Long i = 66156661L; i < 76155647L; i++) {
//            Document doc = httpUtil.connect(UrlConstants.MATCH+i);
            Document doc = null;
            try {
                doc = httpUtil.getConnect(UrlConstants.MATCH+i).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String info = doc.select(GET_MATCH_SELECTOR).text();
            if(info.matches("(.*)竟技场(.*)"+ DateUtil.getToday()+"(.*)")){
                break;
            }
            if(info.matches("(.*)竟技场(.*)"+ DateUtil.getYesterday()+"(.*)")){
                System.out.println(i);
            }
        }
    }
}
