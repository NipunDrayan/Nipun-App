package com.example.android.endeavour;

/**
 * Created by manvi on 04-01-2018.
 */
public class TypeEvents
{

    private int id;
    private String title;
    private int image;

    public TypeEvents(int id, String title, int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public int getImage() {
        return image;
    }
}

