package lab14;

import lab14lib.Generator;

public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;

    public StrangeBitwiseGenerator(int period) {
        this.period = period;
        state = 0;
    }

    @Override
    public double next() {
        state = state + 1;
        return normalize(state);
    }
    
    private double normalize(int state) {
        double amplification = -1;
        // int weirdState = state & (state >>> 3) % period;
        // int weirdState = state & (state >> 3) & (state >> 8) % period;
        int weirdState = state & (state >> 7) % period;
        amplification += (2.0 / period) * weirdState; 
        return amplification;
    }

}
