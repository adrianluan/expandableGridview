package com.example.fuxinl.example1;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * Created by fuxinl on 5/25/17.
 */

public class Book implements Parent<Detail> {


    private String name;
    private List<Detail> details;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }



    public Book(String name, List<Detail> details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public List<Detail> getChildList() {
        return details;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
