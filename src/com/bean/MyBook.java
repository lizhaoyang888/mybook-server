package com.bean;

import java.io.Serializable;
import java.util.Date;

public class MyBook implements Serializable {
    private Integer book_id;
    private String book_name;
    private String book_author;			// 作者
    private String press;		// 出版社
    private Long publishdate;	// 出版日期
    private Integer pagenum;
    public MyBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Long getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Long publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Book [id=" + book_id + ", name=" + book_name + ", author=" + book_author + ", publishdate=" + publishdate + ", press="
                + press + ", pagenum=" + pagenum + "]";
    }

}
