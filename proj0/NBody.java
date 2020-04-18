public class NBody {

    public static double readRadius(String FilePath){
        In in = new In(FilePath);
        int n = in.readInt();
        double raduis = in.readDouble();
        return raduis;
    }

    public static Planet[] readPlanets(String FilePath){
        In in = new In(FilePath);
        int n = in.readInt();
        if (n == 0){
            return null;
        }
        Planet[] Planets = new Planet[n];
        int i = 0;
        double raduis = in.readDouble();
        while(!in.isEmpty() && i < n){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            i = i + 1;
        }

        return Planets;

    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = NBody.readRadius(filename);
        Planet[] Planets = NBody.readPlanets(filename);

        StdDraw.setScale(-Radius, Radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (Planet p:Planets
             ) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double t = 0;
        while(t <= T){
            double[] xForce = new double[Planets.length];
            double[] yForce = new double[Planets.length];
            for(int i = 0; i < Planets.length; i++){
                xForce[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForce[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for(int i = 0; i < Planets.length; i++){
                Planets[i].update(dt, xForce[i], yForce[i]);
            }

            StdDraw.picture(0,0,"images/starfield.jpg");

            for (Planet p:Planets
            ) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t = t + dt;
        }
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", Radius);
        for(int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
    }

    }
}
