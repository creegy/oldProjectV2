import java.util.Scanner;

public class ZuzycieWody {
    public static final int ileMiesiecy = 12;
    public static float[] tablicaZuzyc;
    public static int miesiacMin;
    public static int miesiacMax;
    public static float srednieZuzycie;
    public static float kwotaDoZaplaty;

    public static void main(String[] args) {
        tablicaZuzyc = new float[ileMiesiecy];
        wczytajZuzycia();
        miesiacMin = znajdzMinZuzycie();
        miesiacMax = znajdzMaxZuzycie();
        srednieZuzycie = policzSrednieZuzycia();
        kwotaDoZaplaty = obliczKwote();
        wypiszInformacje();

    }

    private static void wczytajZuzycia() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < ileMiesiecy; i++) {
            System.out.printf("podaj zuzycie w %d miesiacu:", i + 1);
            tablicaZuzyc[i] = scanner.nextFloat();
        }
    }

    private static int znajdzMinZuzycie() {
        int miesiacMin = 0;
        for (int i = 1; i < ileMiesiecy; i++) {
            if (tablicaZuzyc[miesiacMin] > tablicaZuzyc[i]) {
                miesiacMin = i;
            }
        }
        return miesiacMin + 1;
    }

    private static int znajdzMaxZuzycie() {
        int miesiacMax = 0;
        for (int i = 1; i < ileMiesiecy; i++) {
            if (tablicaZuzyc[miesiacMax] < tablicaZuzyc[i]) {
                miesiacMax = i;
            }
        }
        return miesiacMax + 1;
    }

    private static float policzSrednieZuzycia() {
        float sumaZuzyc = 0.0f;
        for (int i = 0; i < ileMiesiecy; i++) {
            sumaZuzyc += tablicaZuzyc[i];
        }
        return sumaZuzyc / ileMiesiecy;
    }

    private static float obliczKwote() {
        float kwota = 0;
        for (int i = 0; i < ileMiesiecy; i++) {
            if (i < 3) {
                kwota += tablicaZuzyc[i] * 6;
            } else {
                kwota += tablicaZuzyc[i] * 7;
            }
        }
        return kwota;
    }

    private static void wypiszInformacje() {
        System.out.printf("Minimalne zuzycie: %f pojawilo sie w miesiacu: %d", tablicaZuzyc[miesiacMin], miesiacMin);
        System.out.println("");
        System.out.printf("Maksymalne zuzycie: %f pojawilo sie w miesiacu: %d", tablicaZuzyc[miesiacMax], miesiacMax);
        System.out.println("");
        System.out.printf("Srednie zuzycie w calym roku wynioslo: %.2f", srednieZuzycie);
        System.out.println("");
        System.out.printf("Kwota do zaplaty z calego roku wynosi: %.2f", kwotaDoZaplaty);
    }

}