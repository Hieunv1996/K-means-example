package com.hieunv.kmeans;

import java.util.Set;
import java.util.Vector;

/**
 * Created by hieunv on 15/03/2017.
 */
public class Clustor {
    private int id;
    private Vector<Double> data;
    private Set<Integer> items;

    public Clustor(int id, Vector<Double> data, Set<Integer> items) {
        this.id = id;
        this.data = data;
        this.items = items;
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

    public Set<Integer> getItems() {
        return items;
    }

    public void setItems(Set<Integer> items) {
        this.items = items;
    }
}

