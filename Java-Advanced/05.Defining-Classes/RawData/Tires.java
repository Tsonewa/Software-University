package RawData;

import com.sun.source.tree.BreakTree;

public class Tires {
    private double[] tires;

    public Tires(double[] tires) {
        this.tires = tires;
    }

    public double[] getTires() {
        return tires;
    }

    public boolean checkTirePressure(Tires tires) {
        double sum = 0;
        for (int i = 0; i < this.tires.length; i++) {
            double currentTire = tires.tires[i];
            sum += currentTire;
        }
        if (sum / 4 > 1) {
            return false;
        }
        return true;
    }
}