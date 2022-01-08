package com.assignment.assignment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WebScrapping {
    List<Blog> blogs=new ArrayList<>();
    List<Blog> firstBlogs=new ArrayList<>();
    WebDriver driver;

    static int count=0;
    public WebScrapping() {






    }

    //    Document doc;
//
//    private static final String url="https://medium.com/tag/";
//
//    WebDriver driver;

//
//    public List<Blog> get100Blogs(){
//        return null;
//    }

    //   String tagName;
//
//    public WebScrapping(String tagName) {
//        try {
//            this.doc = Jsoup.connect("https://medium.com/tag/"+tagName).get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//       String ti="";
//        String au="";
//        String de="";
//        List<Blog> blgs=new ArrayList<>();
//       for(Element ele:class_ae_fu){//"az em hi hj bz hk ca cb cc cd ce bc hl"
//            Elements e1=ele.getElementsByClass("az em hj hk bz hl ca cb cc cd ce bc hm");
//           Elements e2=ele.getElementsByClass("az be hq hr hs bi ht hu hv bm hw hx hy bq hz ia ib bu ic id ie by bz ca cb if cd ce bc");
//           Elements e3=ele.getElementsByClass("az b hj eo bz ii ca cb cc cd ce fp");
//          // Elements e4=ele.getElementsByClass("ih ae t");
//
//           System.out.println(e1.size()+"  size of class");
//           System.out.println(e2.size()+"  size of class");
//          System.out.println(e3.size()+"  size of class");
//          // System.out.println(e4.size()+"  size of class");
//
//           for(Element ee:e1){
//                System.out.println(ee.text());
//               au=ee.text();
//
//            }
//           //System.out.println("ended the 1st elemenet");
//
//           for(Element ee:e2){
//               System.out.println(ee.text());
//               ti=(String) ee.text();
//
//           }
//          // System.out.println("ended the 2nd elemenet");
//
//
//           for(Element ee:e3){
//               System.out.println(ee.text());
//               de=ee.text();
//
//           }
//          // System.out.println("ended the 3rd elemenet");
//           System.out.println("-----------------------------element ended -----------------------------");
////           for(Element ee:e4){
////               Elements e5=ee.getElementsByTag("p");
////               System.out.println(e5.size()+" nwhdfytef ");
////               for (Element ee1:e5) {
////                   System.out.println(ee1.text());
////               }
////
////
////           }
//          // Blog blg1=new Blog(authorName,title,details);
//           blgs.add(new Blog(au,ti,de));
////
//    }
    //return blgs;
//}
    public List<Blog> getBlogs(){
        return blogs;
    }

    public  List<Blog> get10Blogs(){
        firstBlogs.clear();
        count=0;
        for(int i=0;i<blogs.size();i++){
            count++;
            if(count==10)break;
            firstBlogs.add(blogs.get(i));
        }

        return firstBlogs;
    }
    public  List<Blog> next10Blogs(){
        int x=count;
        for(int i=count;i<blogs.size();i++){
            count++;
            if(count==10+x)break;
            firstBlogs.add(blogs.get(i));
        }
        return firstBlogs;
    }

    public void gettingTag(String tagName){
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://medium.com/tag/"+tagName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        blogs.clear();
        int count = 0;
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("_____________________" + count + "__________________________________");
        String html_content = driver.getPageSource();
        // System.out.println(html_content);
//        doc= Jsoup.parse(html_content);
        Document doc = Jsoup.parse(html_content);

        Elements class_ae_fu = doc.getElementsByClass("ae fu");
        String title="";
        String authorName="";
        String details="";
        String url="";
//        List<Blog> blogs=new ArrayList<>();
//        System.out.println(class_ae_fu.size());

        for (Element ele : class_ae_fu) {
            Elements e1 = ele.getElementsByTag("h2");
            Elements e2 = ele.getElementsByTag("h4");
//            System.out.println(e2.get(0).text());
            authorName=e2.get(0).text();

            Elements e3 = ele.getElementsByTag("p");
            if (e3.size() > 2) {
//                System.out.println(e3.get(1).text());
                details=e3.get(1).text();
            } else {
//                System.out.println(e3.get(0).text());
                details=e3.get(0).text();

            }
            Elements ex=ele.getElementsByClass("el l");
            Elements e4=ex.get(0).getElementsByClass("ez fa fb fc fd fe ff fg fh fi fj fk fl fm fn");
            Elements e5=e4.get(0).getElementsByTag("a");
            for(Element ee:e5) {
                url = ee.attr("href");
                if(url.charAt(0)=='/'){
                    url="https://medium.com"+url;
                }

            }
            //String url=e5.get(1).attr("href");
            //System.out.println(url);

       //    System.out.println("--------------------------------------------------------------****************************************************");
//            System.out.println(e1.text());
            title=e1.text();

//            System.out.println("------------------------------------------------------");
            blogs.add(new Blog(authorName,title,details,url));
        }

    }
    public Blog getBlog(String id){
        int i=Integer.parseInt(id);
        return firstBlogs.get(i);
    }

}
