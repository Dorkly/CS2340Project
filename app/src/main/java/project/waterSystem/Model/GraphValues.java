package project.waterSystem.Model;

/**
 * Created by Jim Helm  on 3/29/17.
 *
 * GraphValues class used for Graph Value information
 */
public class GraphValues {

    private int _month;
    private Double _ppm;

    public GraphValues(int month, Double ppm) {
        _month = month;
        _ppm = ppm;
    }

    public int getMonth() {return _month;}

    public Double getPpm() {return _ppm;}
}
