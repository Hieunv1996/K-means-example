package kmeans.point;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hieu Nguyen on 3/19/2017.
 */
public class DataCreater {
    private ArrayList<DataItem> points;
    private final int MAX_VALUE = 1000;

    public DataCreater(ArrayList<DataItem> points) {
        this.points = points;
    }

    public void makeData(int size){
        int index = 0;
        int x,y;
        Random random = new Random();
        for (int i = 0;i < size;i++){
            points.add(new DataItem(index,random.nextInt(MAX_VALUE)+1,random.nextInt(MAX_VALUE)+1));
            index++;
        }
    }
}
