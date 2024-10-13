import java.util.ArrayList;
import java.util.Arrays;

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

class Augabe3{
    public static void main(String[] args) {

        int[] zahlen1 = {1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] zahlen2 = {8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] zahlen3 = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] zahlen4 = {5, 4, 0, 0, 0, 0, 0, 0, 0};
        int[] zahlen5 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int zahlen6 = 2;

        int[] ergebniss_addierenGrosse = addierenGrosse(zahlen1, zahlen2);
        int[] ergebniss_substrachierenGrosse = substrachierenGrosse(zahlen3, zahlen4);
        int[] ergebniss_multiplizierenGrosse = multiplizierenGrosse(zahlen5, zahlen6);
        int[] ergebniss_divisionGrosse = divisionGrosse(zahlen5, zahlen6);
        System.out.println(Arrays.toString(ergebniss_addierenGrosse));
        System.out.println(Arrays.toString(ergebniss_substrachierenGrosse));
        System.out.println(Arrays.toString(ergebniss_multiplizierenGrosse));
        System.out.println(Arrays.toString(ergebniss_divisionGrosse));
    }

    public static int[] addierenGrosse(int[] zahl1, int[] zahl2){
        int len =  zahl1.length;
        int[] result = new int[len + 1];
        int carry = 0;

        for(int i = len - 1; i >= 0; i--){
            int summe = zahl1[i] + zahl2[i] + carry;
            result[i + 1] = summe % 10;
            carry = summe / 10;
        }

        result[0] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

    public static int[] substrachierenGrosse(int[] zahl1, int[] zahl2){
        int len =  zahl1.length;
        int[] result = new int[len];
        int ausleihen = 0;

        for(int i = len - 1; i >= 0; i--){
            int substrachieren = zahl1[i] - zahl2[i] - ausleihen;
            if (substrachieren < 0) {
                substrachieren += 10;
                ausleihen = 1;
            } else{
                ausleihen = 0;
            }
            result[i]= substrachieren;
        }

        int fuehrendeNullenIndex = 0;
        while (fuehrendeNullenIndex < result.length - 1 && result[fuehrendeNullenIndex] == 0) {
            fuehrendeNullenIndex++;
        }

        return Arrays.copyOfRange(result, fuehrendeNullenIndex, result.length);
    }

    public static int[] multiplizierenGrosse(int[] zahl1, int zahl2){
        int len =  zahl1.length;
        int[] result = new int[len + 1];
        int carry = 0;

        for(int i = len - 1; i >= 0; i--){
            int produkt = zahl1[i] * zahl2 + carry;
            result[i + 1] = produkt % 10;
            carry = produkt / 10;
        }

        result[0] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    public static int[] divisionGrosse(int[] zahl1, int zahl2){
        int len =  zahl1.length;
        int[] result = new int[len];
        int carry = 0;

        for(int i = 0; i < len; i++){
            int division = carry * 10 + zahl1[i];
            result[i] =  division / 2;
            carry = division % zahl2;
        }


        int fuehrendeNullenIndex = 0;
        while (fuehrendeNullenIndex < result.length - 1 && result[fuehrendeNullenIndex] == 0) {
            fuehrendeNullenIndex++;
        }

        return Arrays.copyOfRange(result, fuehrendeNullenIndex, result.length);
    }
}

class Aufgabe4{
    public static void main(String[] args) {
        int[] tastaturen = {40, 35, 70, 15, 45};
        int[] tastatur = {15, 20, 10,  35};
        int[] usb = {20, 15, 40, 15};
        int[] usb_buget = {15, 45, 20};
        int buget = 30;

        int ergebniss_tastaturen = billigsteTastatur(tastaturen);
        int ergeebniss_teuersterGegenstand = teuersterGegenstand(tastatur, usb);
        int ergebniss_buget = usbBudget(usb_buget, buget);

        System.out.println(ergebniss_tastaturen);
        System.out.println(ergeebniss_teuersterGegenstand);
        System.out.println(ergebniss_buget);

        int b1 = 60;
        int[] tastaturen1 = {40, 50, 60};
        int[] usbLaufwerke1 = {8, 12};
        System.out.println(maximalerBetrag(b1, tastaturen1, usbLaufwerke1));

        int b2 = 60;
        int[] tastaturen2 = {60};
        int[] usbLaufwerke2 = {8, 12};
        System.out.println(maximalerBetrag(b2, tastaturen2, usbLaufwerke2));

        int b3 = 60;
        int[] tastaturen3 = {40, 60};
        int[] usbLaufwerke3 = {8, 12};
        System.out.println(maximalerBetrag(b3, tastaturen3, usbLaufwerke3));

    }

    public static int billigsteTastatur(int[] preisen){
        int billigste = preisen[0];
        for(int i = 1; i < preisen.length; i++){
            if(preisen[i] < billigste){
                billigste = preisen[i];
            }
        }
        return billigste;
    }
    public static int teuersterGegenstand(int[] tastaturen, int[] usb) {
        int teuerstes = tastaturen[0];

        for (int i = 1; i < tastaturen.length; i++) {
            if (tastaturen[i] > teuerstes) {
                teuerstes = tastaturen[i];
            }
        }

        for (int i = 0; i < usb.length; i++) {
            if (usb[i] > teuerstes) {
                teuerstes = usb[i];
            }
        }

        return teuerstes;
    }

    public static int usbBudget(int[] usb, int budget) {
        int teuerstes = -1;
        for (int i = 0; i < usb.length; i++) {
            if (usb[i] <= budget && usb[i] > teuerstes) {
                teuerstes = usb[i];
            }
        }
        return teuerstes;
    }

    public static int maximalerBetrag(int budget, int[] tastaturen, int[] usbLaufwerke) {
        int maximalerBetrag = -1;

        for (int i = 0; i < tastaturen.length; i++) {
            for (int j = 0; j < usbLaufwerke.length; j++) {
                int gesamtpreis = tastaturen[i] + usbLaufwerke[j];
                if (gesamtpreis <= budget && gesamtpreis > maximalerBetrag) {
                    maximalerBetrag = gesamtpreis;
                }
            }
        }

        return maximalerBetrag;
    }


}