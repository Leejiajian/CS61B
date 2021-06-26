public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public final static double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        this(p.xxPos, p.yyPos,p.xxVel,p.yyVel, p.mass, p.imgFileName);
    }
    /** calculate the distance between two planet */
    public double calcDistance(Planet anotherPlanet){
        if(this.equals(anotherPlanet))
            return 0;
        double xDistance = anotherPlanet.xxPos-this.xxPos;
        double yDistance = anotherPlanet.yyPos-this.yyPos;
        return Math.sqrt(xDistance*xDistance+yDistance*yDistance);

    }
    public double calcForceExertedBy(Planet another){
        if(this.equals(another))
            return 0;
        double distance = this.calcDistance(another);
         return G*this.mass*another.mass/(distance*distance);
    }
    public double calcForceExertedByX(Planet another){
        if(this.equals(another))
            return 0;
        double dx = another.xxPos-this.xxPos;
        return this.calcForceExertedBy(another)*dx/this.calcDistance(another);
    }
    public double calcForceExertedByY(Planet another){
        if(this.equals(another))
            return 0;
        double dy = another.yyPos-this.yyPos;
        return this.calcForceExertedBy(another)*dy/this.calcDistance(another);
    }
    public void update(double dt, double xF,double yF){
        double aX = xF/this.mass;
        double aY = yF/this.mass;
        this.xxVel = this.xxVel + aX*dt;
        this.yyVel = this.yyVel + aY*dt;
        this.xxPos = this.xxPos + this.xxVel*dt;
        this.yyPos = this.yyPos + this.yyVel*dt;
    }
}
