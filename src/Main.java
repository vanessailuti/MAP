import java.util.ArrayList;

class Noten {

    public static void main(String[] args) {
        int[] noten = {29, 37, 38, 41, 84, 67};
        ArrayList<Integer> ergebniss_nichtAusreichend = nichtAusreichendeNoten(noten);
        double ergebniss_durchschnitt = durchschnitt(noten);
        ArrayList<Integer> ergebniss_aberundeteNoten = abgerundeteNoten(noten);
        System.out.println(ergebniss_nichtAusreichend);
        System.out.println(ergebniss_durchschnitt);
        System.out.println(ergebniss_aberundeteNoten);
    }

    public static ArrayList<Integer> nichtAusreichendeNoten(int[] noten) {
        ArrayList<Integer> nichtAusreichend = new ArrayList<>();

        for (int note : noten) {
            if (note >= 38) {
                int multipleVon5 = ((note / 5) + 1) * 5;
                if (multipleVon5 - note < 3) {
                    note = multipleVon5;
                }
            }

            if (note < 40) {
                nichtAusreichend.add(note);
            }
        }
        return nichtAusreichend;
    }

    public static double durchschnitt(int[] noten){
        int summe = 0;

        for (int note : noten) {
            summe += note;
        }
        return (double) summe / noten.length;
    }
    public static ArrayList<Integer> abgerundeteNoten(int[] noten){
        ArrayList<Integer> abgerundeteNoten = new ArrayList<>();
        for (int note : noten) {
            if (note >= 38) {
                int multipleVon5 = ((note / 5) + 1) * 5;
                if (multipleVon5 - note < 3) {
                    note = multipleVon5;
                }
            }

            abgerundeteNoten.add(note);

        }
        return abgerundeteNoten;
    }
}


