public class GuitarHero {
    private static double[] CONCERT = new double[37];

    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        for (int i = 0; i < CONCERT.length; i++) {
            CONCERT[i] = 440.0 * Math.pow(2, ((double) i - 24) / 12);
        }

        /* create all 37 strings */
        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new synthesizer.GuitarString(CONCERT[i]);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    strings[keyboard.indexOf(key)].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < strings.length; i++) {
                strings[i].tic();
            }
        }
    }
}
