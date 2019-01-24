package com.example.android.endeavour;

/**
 * Created by manvi on 04-01-2018.
 */
public class TypeCorporate
{
    private int id;
    private String title;
    private String price;
    private int prize;
    private int image;

    public TypeCorporate(int id, String title, String price,int prize,int image) {
        this.id = id;
        this.title = title;
        this.price=price;
        this.prize=prize;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice(){ return price;}

    public int getImage() {
        return image;
    }

    public int getPrize(){ return prize;}

}
