package com.hong.crawler.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author ：wanghong
 * @date ：2020-12-21 18:16
 * @description： 使用Jsoup实现简单的网络爬虫
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {
       // test0();
        test1();
    }

    private static void test0() throws Exception{
        //从URL加载HTML
        Document document = Jsoup.connect("http://www.baidu.com").get();
        String title = document.title();
        //获取html中的标题
        System.out.println("title :"+title);

        //获取html中的head
        System.out.println(document.head());
        //获取html中的body
        System.out.println(document.body());

        //获取HTML页面中的所有链接
        Elements links = document.select("a[href]");
        for (Element link : links){
            System.out.println("link : "+ link.attr("href"));
            System.out.println("text :"+ link.text());
        }
    }

    private static void test1() throws Exception{
        Document document = Jsoup.connect("https://passport.lagou.com").get();

        System.out.println(document.head());
        //获取URL的元信息
        String description = document.select("meta[name=description]").get(0).attr("content");
        System.out.println("Meta description : " + description);

        String keywords = document.select("meta[name=keywords]").first().attr("content");
        System.out.println("Meta keyword : " + keywords);

        //获取拉勾网登入页面的body
        //System.out.println(document.body());
        //根据class名称获取表单
        Elements formElement = document.getElementsByClass("form_body");
        System.out.println(formElement.html());
        //获取URL的元信息
        for (Element inputElement : formElement) {
            String placeholder = inputElement.getElementsByTag("input").attr("placeholder");
            System.out.println(placeholder);
        }
    }

}
