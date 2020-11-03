package com.example.recyclerviewexample;

import android.widget.ImageView;

public class Item {
    ImageView img;
    String title;
    String content;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
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
}
