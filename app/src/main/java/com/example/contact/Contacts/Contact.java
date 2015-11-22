package com.example.contact.Contacts;

import android.graphics.Bitmap;

/**
 * Created by SONY1 on 11/15/2015.
 */
public class Contact {
    private String name, phone, email,address;
    Bitmap imageBitmap;

    public Contact(String name, String phone, String email,String address, Bitmap imageBitmap)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageBitmap = imageBitmap;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }

    public Bitmap getImageBitmap()
    {
        return imageBitmap;
    }
    public void setImageBitmap(Bitmap imageBitmap)
    {
        this.imageBitmap = imageBitmap;
    }
}
