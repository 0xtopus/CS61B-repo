public class Planet{
    public double xxPos;   
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /* 
     * planet constructor 1
     */
    public Planet(double xP, double yP, double xV,
     double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /* 
     * planet constructor 2
     */
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

    /* 
     * update planet's position and velocity
     */
    public void update(double dt,double fX,double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX*dt; 
        this.yyVel += aY*dt;
        this.xxPos += xxVel*dt;
        this.yyPos += yyVel*dt; 
    }

    /* 
     * draw a planet
     */
    public void draw(){
        // System.out.println("img/"+imgFileName);
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}