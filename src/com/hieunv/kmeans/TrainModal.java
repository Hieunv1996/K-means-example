package com.hieunv.kmeans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by hieunv on 15/03/2017.
 */
public class TrainModal {
    private ArrayList<DataItem> products;
    private int k;
    private ArrayList<Clustor> clustors;

    public TrainModal(ArrayList<DataItem> products, int k, ArrayList<Clustor> clustors) {
        this.products = products;
        this.k = k;
        this.clustors = clustors;
    }

    public void initClustors() {
        Set<Integer> arr = new HashSet<>();
        int id = 0;
        while (arr.size() < k) {
            arr.add(ThreadLocalRandom.current().nextInt(0, products.size()));
        }
        for (int x : arr) {
            id++;
            clustors.add(new Clustor(id,products.get(x).getData(), new HashSet<Integer>()));
        }
    }

    public void updateCentros(){
        for (Clustor clustor : clustors){
            Set<Integer> dataItem = clustor.getItems();
            Vector<Double> vector = new Vector<>();
            for (Integer i : dataItem){
                Vector<Double> item = products.get(i).getData();
                for (int j = 0;j < item.size();j++){
                    if(vector.size() == j) vector.add(0.0);
                    vector.set(j,vector.elementAt(j)+item.elementAt(j));
                }
            }
            int ms = dataItem.size();
            for (int j = 0;j < vector.size();j++){
                vector.set(j,vector.elementAt(j)/ms);
            }
            clustor.setData(vector);
        }
    }

    public boolean computeItems(){
        int count  = 0;
        double minVal,val;int index,contain;
        for (int i = 0; i < products.size(); i++) {
            DataItem dataItem = products.get(i);
            minVal = 9999999;
            index = -1;
            contain = -1;
            for (int j = 0; j < clustors.size(); j++) {
                Clustor clustor = clustors.get(j);
                val = distance(dataItem.getData(), clustor.getData());
                if (val < minVal) {
                    minVal = val;
                    index = j;
                }
                if (clustor.getItems().contains(i)) {
                    contain = j;
                }
            }
            if(index != contain){
                count++;
                if(contain != -1){
                    Set<Integer> temp = clustors.get(contain).getItems();
                    temp.remove(i);
                    clustors.get(contain).setItems(temp);
                }
                Set<Integer> temp1 = clustors.get(index).getItems();
                temp1.add(i);
                clustors.get(index).setItems(temp1);
            }
        }
        System.out.println(count);
        return count == 0;
    }

    public double distance(Vector<Double> v1, Vector<Double> v2) {
        double ans = 0;
        for (int i = 0;i < v1.size(); i++) {
            ans += Math.pow((v1.elementAt(i) - v2.elementAt(i)), 2);
        }
        return Math.sqrt(ans);
    }

    public void outputResult(String path){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path));

            for (Clustor clustor : clustors){
                Set<Integer> temp = clustor.getItems();
                for(Integer i : temp){
                    writer.write(products.get(i).getId() + " " + products.get(i).getLabel() + "=" + clustor.getId());
                    writer.newLine();
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
