package com.hong.crawler.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author wanghong
 * @desc:
 * @date 2020/12/22:47
 **/
public class Demo2 {

    public static void main(String[] args) throws Exception{
        String url = "http://221.214.94.51:8081/icity/ipro/projectlist";
        Document document = Jsoup.connect(url).get();

    }
}
