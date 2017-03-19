package com.hieunv.kmeans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by hieunv on 15/03/2017.
 */
public class Runner {
    public static void main(String[] args) {
        String path = "E:\\CyberSpace\\Data\\train.csv";
        ArrayList<DataItem> products = new ArrayList<>();

        DataReader dataReader = new DataReader(path, products);
        dataReader.readData();
        ArrayList<Clustor> clustors = new ArrayList<>();
        TrainModal trainModal = new TrainModal(products, 9, clustors);
        trainModal.initClustors();
        System.out.println();
        boolean check = false;
        while (!check) {
            check = trainModal.computeItems();
            trainModal.updateCentros();
        }
        trainModal.outputResult("E:\\CyberSpace\\Data\\result");
    }
}
