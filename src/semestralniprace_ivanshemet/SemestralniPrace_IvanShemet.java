
package semestralniprace_ivanshemet;

import java.util.Scanner;


/**
 * 8.Program sorts the points by their distance from the zero coordinate point
 * (0;0;0) in ascending order. Ivan Shemet
 *
 * @author mcivko04
 */
public class SemestralniPrace_IvanShemet {
    
    /**
     * Main metoda semestrální práce.
     */

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        char choice;
        boolean work = true, work2;
        while (work) {
            System.out.println("Pokracovat ve zpracovani\n1 - Semestralni prace\n2 -  Vanocni uloha\n0 - end");
            choice = s.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    work2 = true;
                    while (work2) {
                        System.out.println("Pokracovat ve zpracovani (a/n):");
                        char c0ntinue = s.next().charAt(0);
                        switch (c0ntinue) {
                            case 'a', 'A':
                                System.out.println("Zadej pocet bodu:");
                                int numOfPnts = s.nextInt();

                                if (numOfPnts > 0) {
                                    sortPoints(numOfPnts);
                                } else {
                                    System.out.println("! " + numOfPnts + " - nemuze byt poctem bodu !");
                                }
                                break;
                            case 'N', 'n':
                                work2 = false;
                                break;

                            default:

                                break;
                        }
                    }
                    break;
                case '0':
                    work = false;
                    break;
                case '2':
                    XmasToy();
                    break;
                default:
                    System.out.println("!Spatny vyber, zkuste to znovu!");
                    break;
            }

        }

    }

    /**
     * Tato metoda vytvoří 2D pole a vyplní ho souřadnicemi bodů, které chcete
     * postupně zadat. 
     * Souřadnice n-tého bodu se souřadnicemi (x; y; z) budou
     * uloženy ve třech proměnných (array[n][0]; array[n][1]; array[n][2]).
     * Třídění se provádí najednou výpočtem vzdáleností ve
     * dvou proměnných typu double (distance1, distance2). 
     * V definici proměnné distance1 jsou použity body z pole s indexem "i" 
     * a v definici proměnné distance2 s "j" (j=i+1). 
     * Třídění se provádí pomocí vnitřní podmínky "if (distance1 > distance2)". 
     * Pak podmínka "if (distance1 > distance2)"
     * prohodí hodnoty distance1 a distance2.
     * 
     * @param numOfPnts amount of points 
     */

    
    public static void sortPoints(int numOfPnts) {

        Scanner n = new Scanner(System.in);

        double[][] array = new double[numOfPnts][3];

        System.out.println("Zadej souradnice bodu:");

        for (int i = 0; i < numOfPnts; i++) {
            array[i][0] = n.nextDouble();
            array[i][1] = n.nextDouble();
            array[i][2] = n.nextDouble();

        }

        double distance1;
        double distance2;
        double[] temp;
        for (int i = 0; i < numOfPnts - 1; i++) {
            for (int j = i + 1; j < numOfPnts; j++) {
                distance1 = Math.sqrt((0 - array[i][0]) * (0 - array[i][0]) + (0 - array[i][1]) * (0 - array[i][1]) + (0 - array[i][2]) * (0 - array[i][2]));
                distance2 = Math.sqrt((0 - array[j][0]) * (0 - array[j][0]) + (0 - array[j][1]) * (0 - array[j][1]) + (0 - array[j][2]) * (0 - array[j][2]));
                if (distance1 > distance2) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Setridene body:");

        for (int i = 0; i < numOfPnts; i++) {
            System.out.println(array[i][0] + "\t" + array[i][1] + "\t" + array[i][2]);
        }

    }

    /**
     * Metoda vytvoří obrázek vánoční koule s rozměry zadanými uživatelem.
     * První část metody zobrazuje obraz háčku.
     * Druhá část zobrazuje obrázek koule.
     */

    
    public static void XmasToy() {

        int xcord, ycord, radius, diameter, point;
        Scanner sc = new Scanner(System.in);
        System.out.println(" Zadejte radius:");
        radius = sc.nextInt();

        System.out.println(" Zadejte symbol:");
        char symbol = sc.next().charAt(0);

        System.out.println(" Chcete hacek?(napiste true nebo false):");
        boolean hacek = sc.nextBoolean();

        diameter = 2 * radius;

        if (hacek == true) {
            for (int y = 0; y < 1; y++) {
                for (int x = 0; x < diameter + 1; x++) {
                    if (x == radius + radius - 1) {
                        System.out.println("_");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
        if (hacek == true) {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < diameter + 1; x++) {
                    if (x == radius + radius) {
                        System.out.println("|");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }

        for (int i = 0; i <= diameter; i++) {
            for (int j = 0; j <= diameter; j++) {
                xcord = radius - i;
                ycord = radius - j;
                point = xcord * xcord + ycord * ycord;

                if (point <= radius * radius + 1) {
                    System.out.print(symbol + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
