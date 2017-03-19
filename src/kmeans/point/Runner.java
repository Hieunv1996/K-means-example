package kmeans.point;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by Hieu Nguyen on 3/19/2017.
 */
public class Runner {
    public static void main(String[] args) {
        ArrayList<DataItem> points = new ArrayList<>();
        ArrayList<Clustor> clustors = new ArrayList<>();
        DataCreater creater = new DataCreater(points);

        creater.makeData(1000);


        DataTrainer trainer = new DataTrainer(points,clustors,9);
        trainer.clustorInit();
        boolean isStop = false;
        while (!isStop){
            isStop = trainer.computeDistance();
            trainer.updateClutorItem();
        }
        trainer.outputResult("E:\\CyberSpace\\Data\\result.txt");
    }
}
