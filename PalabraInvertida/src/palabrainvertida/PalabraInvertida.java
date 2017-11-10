package palabrainvertida;

import java.util.Scanner;

public class PalabraInvertida {

    public static void main(String[] args) {
        String palabra = "", palabraInvert = "";
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese la palabra a invertir: ");
        palabra = in.nextLine();
        for(int i = 0; i < palabra.length(); i++){
            palabraInvert += palabra.substring(palabra.length()-(i+1),palabra.length()-i);
        }
        System.out.println("");
        System.out.println("La palabra invertida es: " + palabraInvert);
    }
    
}
