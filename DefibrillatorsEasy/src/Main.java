import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        in.nextLine();

        List<String> defibrilateurs = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String Defib = in.nextLine();
            defibrilateurs.add(Defib);
        }

        String answer = "";
        double distance = Double.MAX_VALUE; // aşağıdakiler tekrar ettiği için daha iyisini yapmamız lazım REFACTORING

        double longitudeUser = Math.toRadians(Double.parseDouble(LON.replace("," , ".")));
        double latitudeUser = Math.toRadians(Double.parseDouble(LAT.replace("," , ".")));

        for (String defib : defibrilateurs) {
            double longitudeDefib = Math.toRadians(Double.parseDouble(defib.split(";")[4].replace("," , "."))); //4. indedksin  null olup olmaması kontrol edilecek böyle bir indeks var mı?
            double latitudeDefib = Math.toRadians(Double.parseDouble(defib.split(";")[5].replace("," , ".")));

            double x = (longitudeDefib - longitudeUser) * Math.cos((latitudeUser + latitudeDefib) / 2);
            double y = (latitudeDefib - latitudeUser);
            double d = (Math.sqrt(Math.pow(x,2) + Math.pow(y,2))) * 6371;

            if (d < distance) {
                distance = d;
                answer = defib.split(";")[1];
            }
        }


        System.out.println(answer);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
}
