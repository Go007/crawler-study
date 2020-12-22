package com.hong.crawler.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author wanghong
 * @desc:
 * @date 2020/12/22:47
 **/
public class Demo2 {

    public static void main(String[] args) throws Exception{
        String url = "http://221.214.94.51:8081/icity/ipro/projectlist";
        Document doc = Jsoup.connect(url).userAgent("Mozilla").cookie("is_click", "1").timeout(10000).get();
        Elements span = doc.select("#w-d-x-1").select("span[class=btn btn-sm btn-warning]");
        System.out.println(span);
        String onclick = span.attr("onclick");
        System.out.println(onclick);
    }
}
