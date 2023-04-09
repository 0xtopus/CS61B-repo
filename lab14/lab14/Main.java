package lab14;

// import java.util.ArrayList;

import lab14lib.Generator;
// import lab14lib.GeneratorAudioAnimator;
import lab14lib.GeneratorAudioVisualizer;
// import lab14lib.GeneratorDrawer;
// import lab14lib.GeneratorPlayer;
// import lab14lib.MultiGenerator;

public class Main {
	public static void main(String[] args) {
		/** Your code here. */
		// Generator g1 = new SawToothGenerator(400);
		// Generator g1 = new AcceleratingSawToothGenerator(200, 0.95);
		// Generator g1 = new StrangeBitwiseGenerator(2000);
		// Generator g2 = new SineWaveGenerator(201);

		// ArrayList<Generator> generators = new ArrayList<Generator>();
		// generators.add(g1);
		// // generators.add(g2);
		// MultiGenerator mg = new MultiGenerator(generators);

		// GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(mg);
		// gav.drawAndPlay(2000, 10000000);
		Generator generator = new StrangeBitwiseGenerator(1024);
		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
		gav.drawAndPlay(128000, 1000000);
	}
}