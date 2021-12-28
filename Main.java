import java.io.*;
import java.util.*;

public class Main {

   public static void babelek(int[] tablica, int rozmiar) {
      int tmp;
      int i, j;
            int counter=0;

      for ( i = 1; i < rozmiar; i++ )
         for ( j = 1; j < rozmiar; j++ ) {
            counter++;
            if ( tablica[j-1] > tablica[j] ) {
               tmp = tablica[j-1];
               tablica[j-1] = tablica[j];
               tablica[j] = tmp;
            }
         }

               System.out.println("Iteracje babelek "+counter);

   }

   public static void babel(int[] tablica, int rozmiar) {
      int tmp;
      int i, j;
      int counter=0;
      int zmiana=1;
      
      for ( i = 1; i < rozmiar && zmiana==1; i++ ) {
         zmiana=0;
         for ( j = 1; j < rozmiar - i + 1; j++ ) {
            counter++; 
            if ( tablica[j-1] > tablica[j] ) {
               zmiana=1;
               tmp = tablica[j-1];
               tablica[j-1] = tablica[j];
               tablica[j] = tmp;
            }
         }
          System.out.println("Zmiana w iteracji "+ i +": " + zmiana);
      }
      System.out.println("Iteracje babel "+counter);
   }

   
   
   public static void wczytaj_tablice(int[] tablica, int rozmiar) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      Random rand = new Random();
      for ( int i = 0; i < rozmiar; i++ ) {
         //System.out.println("Podaj liczbe (tablica["+i+"]): ");
         //tablica[i] = Integer.parseInt(in.readLine());
         tablica[i] = rand.nextInt(100);
        //System.out.println("tablica["+i+"]: "+ tablica[i]);

      }
      //tablica[0] = 51;
      //tablica[1] = 65;
      //tablica[2] = 1;
      //tablica[3] = 29;
      //tablica[4] = 83;
      //tablica[5] = 75;
      
   }
   
   public static void wypisz_tablice(int[] tablica, int rozmiar) {
      for ( int i = 0; i < rozmiar; i++ )
         System.out.println("tablica["+i+"] = "+tablica[i]);
   }

   public static void main(String[] args) {
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int r;
         System.out.println("Podaj rozmiar: ");
         r = Integer.parseInt(in.readLine());
         
         //stworz i wygeneruj tablice
         int[] t1 = new int[r];
         wczytaj_tablice(t1, r);
         
         //zrob kopie tej tablicy, zeby testowac rozne algorytmy
          int[] t2 = new int[r];
          int[] t3 = new int[r];

          for (int i=0; i<r; i++) {
            t2[i]=t1[i];
            t3[i]=t1[i];
          }
          
         System.out.println("Tablica przed posortowaniem:");
         wypisz_tablice(t1, r);

         babelek(t1, r);

         babel(t2, r);
         Arrays.sort(t3);
         System.out.println("Tablica posortowana bablem:");
         wypisz_tablice(t2, r);

         System.out.println("Tablica posortowana Array.sort:");
         wypisz_tablice(t3, r);
 
      } catch(IOException e) {
      }
   }
}

/*
 * Cwiczenia:
 * 1. Zastanow sie jak ulepszyc (zmniejszyc liczbe iteracji) 
 * zaproponowana funkcje sortujaca (tzw. sortowanie babelkowe).
 * 2. Sprobuj wykorzystac biblioteczna metode 
 * java.util.Arrays.sort() do posortowania tablicy. 
 * Jaki algorytm sortowania zaimplementowany jest w tej metodzie?
 */
 
