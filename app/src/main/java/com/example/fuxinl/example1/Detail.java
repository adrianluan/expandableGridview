package com.example.fuxinl.example1;

/**
 * Created by fuxinl on 5/25/17.
 */

public class Detail {

    private String author;

    public Detail(String author, String desc) {
        this.author = author;
        this.desc = desc;
    }

    private String desc;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
