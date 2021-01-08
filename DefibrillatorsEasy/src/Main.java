import java.util.*;

public class Main {

    public static void main(String[] args) {

        Formulas formulas = new Formulas();

        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        in.nextLine();
        /*
         integerdan sonra string alınırsa, enter'ı stringi atamaya çalışıyor. Integerdan sonra string alacakken
         bir boşluk bırakıp bu sorunu ortadan kaldırıyoruz
         */


        List<String> defibrilateurs = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String Defib = in.nextLine();
            defibrilateurs.add(Defib);
        }

        String answer = "";
        double distance = Double.MAX_VALUE;

        double longitudeUser = formulas.converter(LON);
        double latitudeUser = formulas.converter(LAT);

        for (String defib : defibrilateurs) {
            double longitudeDefib = formulas.converter(defib.split(";")[4]);
            double latitudeDefib = formulas.converter(defib.split(";")[5]);


            double d = formulas.findDistance(longitudeDefib,latitudeDefib,longitudeUser,latitudeUser);

            if (d < distance) {
                distance = d;
                answer = defib.split(";")[1];
            }
        }

        System.out.println(answer);
    }
}
