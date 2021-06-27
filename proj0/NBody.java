public class NBody {
    public static double readRadius(String s){
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String s){
        In in = new In(s);
        //read the another two data
        int number = in.readInt();
        in.readDouble();
        //read the planets information
        Planet[] planets = new Planet[number];
        for(int i = 0; i < number; ++i){
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }
    public static void main(String[] args){
        double T = 0, dt = 0;
        String fileName = "";
        if(args.length == 3){
            T = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            fileName = args[2];
        }
        double radius = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        //System.out.println(radius);
        String setting = "images/starfield.jpg";
        //StdDraw.setCanvasSize(256,256);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,setting);
        for(Planet P : planets){
            P.imgFileName = "images/"+P.imgFileName;
            P.draw();
        }
        StdDraw.enableDoubleBuffering();
        int time = 0;
        while(time < T){
            double[] xForces = new double[]{0,0,0,0,0};
            double[] yForces = new double[]{0,0,0,0,0};
            for(int i = 0; i < 5; ++i){
                for(int j = 0; j < 5; ++j){
                    xForces[i] += planets[i].calcForceExertedByX(planets[j]);
                    yForces[i] += planets[i].calcForceExertedByY(planets[j]);
                }

            }
            for(int i = 0; i < 5; ++i)
                planets[i].update(dt,xForces[i],yForces[i]);
            StdDraw.picture(0,0,setting);
            for(Planet P : planets){
                P.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
