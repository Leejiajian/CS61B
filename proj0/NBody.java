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
        double T, dt;
        String fileName = "";
        if(args.length == 3){
            T = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            fileName = args[2];
        }
        double radius = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        //System.out.println(radius);

    }
}
