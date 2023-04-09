package lab14;

import lab14lib.Generator;

public class AcceleratingSawToothGenerator implements Generator {

    private int period;
    private double factor;
    private int state;

    public AcceleratingSawToothGenerator(int period,double factor) {
        state = 0;
        this.factor = factor;
        this.period = period;
    }

    @Override
    public double next() {
        if (state == period - 1) {
            state = 0;
            period *= factor;
        } 
        return normalize(state++);
    }

    private double normalize(int state) {
        double amplification = -1 + 2.0 / (period - 1) * state;
        return amplification;
    }
}