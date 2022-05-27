package com.example.demo.dto;

public class Board {

    private int CRUD_idx;
    private String title;
    private String content;
    private String writer;
    private String date;

    public int getCRUD_idx() {
        return CRUD_idx;
    }

    public void setCRUD_idx(int CRUD_idx) {
        this.CRUD_idx = CRUD_idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
