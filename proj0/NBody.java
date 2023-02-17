/* 
 * desc: try to run this like this in command line:
 * java NBody 157788000.0 25000.0 data/planets.txt
 * 
 * By inputting differet third parameter above(data/planets.txt)  will trigger different simulation effect.
 * You can find all options of this parameter in directory ./data
 */
public class NBody {
    /* 
     * Read Radius of your universe
     */
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    /* 
     * get all planets' infomation 
     */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        
        /* get the num of planets */
        int num = in.readInt();
        in.readDouble();
        
        /* params of planet */
        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String img;
        Planet p;
        
        /* init planet array */
        Planet[] planets = new Planet[num];
        for(int i=0; i<num; i++){
            xxPos = in.readDouble(); 
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            img = in.readString();
            p = new Planet(xxPos, yyPos,xxVel, yyVel, mass, img);
            planets[i] = p;
        }
        
        return planets;
    }
    
    public static void main(String[] args) {
        // get input args from commandline 
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        
        // init draw panel
        double scale = NBody.readRadius(filename);
        StdDraw.setScale(-scale,scale);
        StdDraw.clear();

        // draw background
        StdDraw.picture(0, 0, "images/starfield.jpg");

        // get planets
        Planet[] planets = NBody.readPlanets(filename);
        
        // draw all planets
        for (Planet p: planets) {
            // System.out.println(p.imgFileName);
            p.draw();
        }

        // Enable this to avoid flicking animation
        StdDraw.enableDoubleBuffering();

        // Function my universe in a time span T
        for(double currT = 0; currT != T; currT+=dt){
            // arrays for x- and y-NetForces of each planet
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            // update arrays for x- and y-NetForces for all planets
            for(int i = 0; i<planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // update each planet
            for(int i=0; i<planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw background again
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // draw all planets
            for (Planet p: planets) {
                p.draw();
            }

            // draw offscene things to your scene
            StdDraw.show();

            // pause 10 milliseconds
            StdDraw.pause(10);
        }

        // output result for autograde
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", scale);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
