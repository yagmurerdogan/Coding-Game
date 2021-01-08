public class Formulas {
    public double converter(String loc) {
        return Math.toRadians(Double.parseDouble(loc.replace("," , ".")));
    }

    public double findDistance(double longitudeDefib, double latitudeDefib, double longitudeUser, double latitudeUser) {
        double x = (longitudeDefib - longitudeUser) * Math.cos((latitudeUser + latitudeDefib) / 2);
        double y = (latitudeDefib - latitudeUser);
        double d = (Math.sqrt(Math.pow(x,2) + Math.pow(y,2))) * 6371;
        return d;
    }
}
