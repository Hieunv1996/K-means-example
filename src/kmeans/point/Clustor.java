package kmeans.point;

import java.util.Set;

/**
 * Created by Hieu Nguyen on 3/19/2017.
 */
public class Clustor {
    private double x;
    private double y;
    private Set<Integer> items;

    public Clustor(double x, double y, Set<Integer> items) {
        this.x = x;
        this.y = y;
        this.items = items;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Set<Integer> getItems() {
        return items;
    }

    public void setItems(Set<Integer> items) {
        this.items = items;
    }
}
