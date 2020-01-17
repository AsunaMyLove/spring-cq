package com.jzh.bot.util;

import com.jzh.bot.plugin.heros.common.UserAgentConf;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * @author jzh
 * @version V1.0.0
 * @company lhfinance.com
 * @package com.jzh.bot.util
 * @className: HttpUtil
 * @description: http连接工具类
 * @date 2020/1/15 18:38
 */
@Component
public class HttpUtil {

    private Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    @Autowired
    private UserAgentConf userAgentConf;

    public Document connect(String url) {
        String key = "key" + new Random().nextInt(userAgentConf.getUserAgentMap().size());
        String userAgent = userAgentConf.getUserAgentMap().get(key);
        try {
            return Jsoup.connect(url).header("User-Agent",userAgent).timeout(5000).get();
        } catch (IOException e) {
            connect(url);
        }
        return null;
    }

    public Connection getConnect(String url) {
        String key = "key" + new Random().nextInt(userAgentConf.getUserAgentMap().size());
        String userAgent = userAgentConf.getUserAgentMap().get(key);
        return Jsoup.connect(url).header("User-Agent",userAgent).timeout(5000);
    }


    @Value("${pcr.baseHeadPicPath}")
    private String basePath;

    public void savePicFromUrlToBase(String url,String fileName) {
        try {
            //new一个URL对象
            URL u = new URL(url);
            //打开链接
            HttpURLConnection conn = (HttpURLConnection)u.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            InputStream inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            byte[] data = readInputStream(inStream);
            //new一个文件对象用来保存图片，默认保存当前工程根目录
            File imageFile = new File(basePath.replaceAll("##FILE_NAME##",fileName));
            //创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
            //写入数据
            outStream.write(data);
            //关闭输出流
            outStream.close();
        } catch (Exception e) {
            logger.error("HttpUtil.savePicFromUrlToBase() 出错:{}",e.getMessage());
            e.printStackTrace();
        }
    }

    private byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
