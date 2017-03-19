package com.hieunv.kmeans;

import java.util.Vector;

/**
 * Created by hieunv on 15/03/2017.
 */
public class DataItem {
    private int id;
    private Vector<Double> data;
    private String label;

    public DataItem(int id, Vector<Double> data, String label) {
        this.id = id;
        this.data = data;
        this.label = label;
    }

    public DataItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vector<Double> getData() {
        return data;
    }

    public void setData(Vector<Double> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
