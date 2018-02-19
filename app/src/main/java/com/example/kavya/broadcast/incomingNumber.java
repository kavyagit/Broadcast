package com.example.kavya.broadcast;

/**
 * Created by kavya on 2/5/2018.
 */

public class incomingNumber {


private int id;
private String number;
public incomingNumber(int id,String number)

    {
        this.setId(id);
        this.setNumber(number);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}


