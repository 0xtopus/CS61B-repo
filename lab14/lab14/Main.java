package lab14;

import lab14lib.Generator;
import lab14lib.GeneratorPlayer;

public class Main {
	public static void main(String[] args) {
		/** Your code here. */
		Generator generator = new SineWaveGenerator(200);
		GeneratorPlayer gp = new GeneratorPlayer(generator);
		gp.play(1000000);
	}
}