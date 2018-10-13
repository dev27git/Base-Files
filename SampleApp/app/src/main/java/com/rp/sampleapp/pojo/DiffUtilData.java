package com.rp.sampleapp.pojo;

import android.text.TextUtils;

import com.rp.util.adapter.annotations.ComparableItem;

public class DiffUtilData {

    @ComparableItem
    private int id;

    private String name;

    public DiffUtilData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        DiffUtilData diffUtilData = (DiffUtilData) obj;
        return (this.id == diffUtilData.getId())
                && TextUtils.equals(this.getName(),diffUtilData.getName());
    }
}
