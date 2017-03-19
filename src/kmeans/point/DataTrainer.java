package kmeans.point;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Hieu Nguyen on 3/19/2017.
 */
public class DataTrainer {
    private ArrayList<DataItem> points;
    private ArrayList<Clustor> clustors;
    private int clustorCount;

    public DataTrainer(ArrayList<DataItem> points, ArrayList<Clustor> clustors, int k) {
        this.points = points;
        this.clustors = clustors;
        this.clustorCount = k;
    }

    public void clustorInit(){
        Set<Integer> temp = new HashSet<>();
        Random random = new Random();
        while (temp.size() < clustorCount){
            temp.add(random.nextInt(points.size()));
        }
        for (Integer i : temp){
            clustors.add(new Clustor(points.get(i).getX(),points.get(i).getY(),new HashSet<Integer>()));
        }
    }

    public boolean computeDistance(){
        int count = 0;
        double minVal,val;int index,contain;
        for (DataItem dataItem : points){
                minVal = 9999999;
                index = -1;
                contain = -1;
            for (int i = 0; i < clustors.size(); i++) {
                Clustor clustor = clustors.get(i);
                val = distance(dataItem, clustor);
                if (val < minVal) {
                    minVal = val;
                    index = i;
                }
                if(clustor.getItems().contains(dataItem.getId())){
                    contain = i;
                }
            }
            if(contain != index){
                count++;
                if(contain != -1){
                    Clustor temp = clustors.get(contain);
                    Set<Integer> set = temp.getItems();
                    set.remove(dataItem.getId());
                    temp.setItems(set);
                    clustors.set(contain,temp);
                }
                Set<Integer> temp = clustors.get(index).getItems();
                temp.add(dataItem.getId());
                clustors.get(index).setItems(temp);
            }
        }
        System.out.println(count);
        return  count == 0;
    }

    public void updateClutorItem(){
        for (Clustor clustor : clustors){
            double x = 0,y = 0;
            Set<Integer> temp = clustor.getItems();
            for (Integer i : temp){
                x += points.get(i).getX();
                y += points.get(i).getY();
            }
            clustor.setX(x/temp.size());
            clustor.setY(y/temp.size());
        }
    }

    public void outputResult(String path){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path));

            for (Clustor clustor : clustors){
                writer.write(clustor.getX() + " - " +clustor.getY());
                writer.newLine();
                Set<Integer> temp = clustor.getItems();
                for(Integer i : temp){
                    writer.write("("+points.get(i).getX()+", "+points.get(i).getY()+")");
                    writer.newLine();
                }
                writer.write("\n---------------------------\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double distance(DataItem dataItem,Clustor clustor){
        return Math.sqrt(Math.pow((clustor.getX() - dataItem.getX()),2) + Math.pow((clustor.getY() - dataItem.getY()),2));
    }
}
