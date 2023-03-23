package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    private double[] percolateTimes;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (T <= 0 || N <= 0) {
            throw new java.lang.IllegalArgumentException("T or N is too small!");
        }

        percolateTimes = new double[T];
        // perform T times the experiment
        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            percolateTimes[i] = percolateTimesCalculator(p, N);
            System.out.println(percolateTimes[i]);
        }
    }
    
    private int percolateTimesCalculator(Percolation p, int N) {
        int openTimes = 0;
        while (!p.percolates()) {
            int randomRow = StdRandom.uniform(N);
            int randomCol = StdRandom.uniform(N);
            if (!p.isOpen(randomRow, randomCol)) {
                p.open(randomRow, randomCol);
                openTimes++;
            }
        }
        return openTimes;
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolateTimes);
    }                                          

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percolateTimes);
    }                                        
    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - (1.96 * stddev()) / Math.pow(percolateTimes.length, 0.5);
    }                                 

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + (1.96 * stddev()) / Math.pow(percolateTimes.length, 0.5);
    }                                

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(20, 10, pf);
        System.out.println("means: " + ps.mean());
        
        System.out.println(ps.stddev());
        System.out.println(ps.confidenceHigh());
    }
}
