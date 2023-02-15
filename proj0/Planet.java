public class Planet{
    double xxPos;   
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV,
     double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    /* 
     * culculate the distance between two planet
     */
    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /* 
     * The force on the planet 
     */
    public double calcForceExertedBy(Planet p) {
        return 6.67 * Math.pow(10,-11) * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
    }

    /* 
     * The force on the planet on the x-axis
     */
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
    }

    /* 
     * The force on the planet on the y-axis
     */
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }

    /* 
     * calculate net forces on x-axis
     */
    public double calcNetForceExertedByX(Planet[] AllPlanets){
        double sumXForce = 0;
        for(Planet p: AllPlanets){
            if(this.equals(p)){
                continue;
            } 
            sumXForce += this.calcForceExertedByX(p); 
        }
        return sumXForce;
    }
    
    /* 
     * calculate net forces on y-axis
     */
    public double calcNetForceExertedByY(Planet[] AllPlanets){
        double sumYForce = 0;
        for(Planet p: AllPlanets){
            if(this.equals(p)){
                continue;
            } 
            sumYForce += this.calcForceExertedByY(p); 
        }
        return sumYForce;
    }

    public static void main(String[] args) {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        System.out.println(p1.calcForceExertedBy(p2));
    }
}