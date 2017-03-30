package project.waterSystem.Model;

/**
 * Created by jimhelm on 3/29/17.
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
