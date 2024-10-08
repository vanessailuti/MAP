import java.util.ArrayList;

class Aufgabe1 {

    public static void main(String[] args) {
        int[] noten = {29, 37, 38, 41, 84, 67};
        ArrayList<Integer> ergebniss_nichtAusreichend = nichtAusreichendeNoten(noten);
        double ergebniss_durchschnitt = durchschnitt(noten);
        ArrayList<Integer> ergebniss_aberundeteNoten = abgerundeteNoten(noten);
        int ergebniss_maximaleNote = maximaleNote(noten);
        System.out.println(ergebniss_nichtAusreichend);
        System.out.println(ergebniss_durchschnitt);
        System.out.println(ergebniss_aberundeteNoten);
        System.out.println(ergebniss_maximaleNote);
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

    public static int maximaleNote(int[] noten){
        int max = 0 ;

        for(int note : noten){
            if (note >= 38) {
                int multipleVon5 = ((note / 5) + 1) * 5;
                if (multipleVon5 - note < 3) {
                    note = multipleVon5;
                }
            }
            if(note > max){
                max = note;
            }
        }
        return max;
    }
}

class Aufgabe2{
    public static void main(String[] args) {
        int[] zahlen = {4, 8, 3, 10, 17};
        int ergebniss_maximaleZahl = maximaleZahl(zahlen);
        int ergebniss_minimaleZahl = minimaleZahl(zahlen);
        int ergebniss_maximaleSumme = maximaleSumme(zahlen);
        int ergebniss_minimaleSumme = minimaleSumme(zahlen);
        System.out.println(maximaleZahl(zahlen));
        System.out.println(minimaleZahl(zahlen));
        System.out.println(maximaleSumme(zahlen));
        System.out.println(minimaleSumme(zahlen));
    }

    public static int maximaleZahl(int[] zahlen){
        int max = Integer.MIN_VALUE;
        for(int zahl: zahlen){
            if(zahl > max){
                max = zahl;
            }
        }
        return max;
    }
    public static int minimaleZahl(int[] zahlen){
        int min = Integer.MAX_VALUE ;
        for(int zahl: zahlen){
            if(zahl < min){
                min = zahl;
            }
        }
        return min;
    }

    public static int maximaleSumme(int[] zahlen){
        int summe = 0;
        int min =  minimaleZahl(zahlen);

        for(int zahl: zahlen){
            summe += zahl;
        }
        return summe - min;
    }

    public static int minimaleSumme(int[] zahlen){
        int summe = 0;
        int max =  maximaleZahl(zahlen);

        for(int zahl: zahlen){
            summe += zahl;
        }
        return summe - max;
    }
}
