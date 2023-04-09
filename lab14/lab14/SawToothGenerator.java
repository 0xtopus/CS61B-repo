package lab14;

import lab14lib.Generator;

public class SawToothGenerator implements Generator {
    private int period;
    private int state;

    public SawToothGenerator(int period) {
        this.period = period;
        state = 0;
    }

    @Override
    public double next() {
        if (state == (period - 1)) {
            state = 0;
        }
        return normalize(state++);
    }
 
    private double normalize(int state) {
        double amplification = -1;
        amplification += (2.0 / (period - 1)) * state; 
        return amplification;
    }
}