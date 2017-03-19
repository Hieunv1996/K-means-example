package com.hieunv.kmeans;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hieunv on 15/03/2017.
 */
public class DataReader {
    private String path;
    private ArrayList<DataItem> products;

    public DataReader(String path, ArrayList<DataItem> products) {
        this.path = path;
        this.products = products;
    }

    public void readData() {
        BufferedReader reader;
        int check = 0, id = 0;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = "", label;

            while ((line = (reader.readLine())) != null) {
                if (check == 0) {
                    check = 1;
                    continue;
                }
                id++;
                String[] arr = line.trim().split(",");
                label = (arr[arr.length - 1]);
                Vector<Double> data = new Vector();
                for (int i = 1; i < arr.length - 1; i++) {
                    data.add(Double.parseDouble(arr[i]));
                }
                products.add(new DataItem(id, data, label.toString()));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
