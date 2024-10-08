import java.util.ArrayList;

class Noten {

    public static void main(String[] args) {
        int[] noten = {67, 34, 57, 90, 23, 89};
        ArrayList<Integer> ergebniss_nichtAusreichend = nichtAusreichendeNoten(noten);
        double ergebniss_durchschnitt = durchschnitt(noten);
        System.out.println(ergebniss_nichtAusreichend);
        System.out.println(ergebniss_durchschnitt);
    }

    public static ArrayList<Integer> nichtAusreichendeNoten(int[] noten) {
        ArrayList<Integer> nichtAusreichend = new ArrayList<>();

        for (int note : noten) {
            if (note > 38) {
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
}


