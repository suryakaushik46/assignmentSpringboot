package com.assignment.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    WebScrapping web;
      int count=0;
//    @GetMapping("blogs")
//    public List<Blog> getBlogs(){
//        List<Blog> blogs=web.getBlogs();
//        List<Blog> FirstDraft=new ArrayList<>();
//        for(int i=0;i<count+10;i++){
//            FirstDraft.add(blogs.get(i));
//        }
//        return web.getBlogs();
//    }
   @GetMapping("/blogs")
   public String getBlogs(ModelMap modelMap){
        List<Blog> blogs=web.get10Blogs();
       modelMap.put("blogVar",blogs);
        return "blogs";
   }
   @GetMapping("/get10more")
   public String get10Blogs(ModelMap modelMap){
       List<Blog> blogs=web.next10Blogs();
       modelMap.put("blogVar",blogs);
       return "blogs";
   }

  @GetMapping("/showBlog/{id}")
  public String showBlog(@PathVariable String id,ModelMap modelMap){

       Blog blog=web.getBlog(id);
       modelMap.put("blog",blog);
       return "showBlog";
  }

   @PostMapping("/blogs")
    public String gettingTag(ModelMap modelMap, @RequestParam String tagName){
        web.gettingTag(tagName);
        return "blogs";
   }
}
