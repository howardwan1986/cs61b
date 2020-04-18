import java.lang.Math;

public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    double mass;
    String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){

        return Math.sqrt(Math.pow(this.xxPos - p.xxPos ,2) + Math.pow(this.yyPos - p.yyPos,2));

    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return G * this.mass * p.mass / Math.pow(r,2);

    }

    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.xxPos - this.xxPos) / r;
    }

    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.yyPos - this.yyPos) / r;
    }

    public double calcNetForceExertedByX(Planet[] p){
        int i = 0;
        int p_len = p.length;
        double NetF = 0;
        while(i < p_len){
            if (!this.equals(p[i])){
                NetF = NetF + calcForceExertedByX(p[i]);
            }
            i = i + 1;
        }
        return NetF;
    }

    public double calcNetForceExertedByY(Planet[] p){
        int i = 0;
        int p_len = p.length;
        double NetF = 0;
        while(i < p_len){
            if (!this.equals(p[i])){
                NetF = NetF + calcForceExertedByY(p[i]);
            }
            i = i + 1;
        }
        return NetF;
    }

    public void update(double dt, double Fx, double Fy){
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;

    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
