package com.assignment.assignment;

public class Blog {
   private String authorName;
    private String title;
    private String details;
    private String Url;


    public Blog() {
    }

    public Blog(String authorName, String title, String details,String Url) {
        this.authorName = authorName;
        this.title = title;
        this.details = details;
        this.Url=Url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }




}
