import java.util.Scanner;
public class Suma{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int a = 0, b = 0;
    String nombre = "";
    System.out.println("Cual es su nombre?:");
    nombre = in.nextLine();
    System.out.println("Ingrese el primer numero:");
    a = in.nextInt();
    System.out.println("Ingrese el segundo numero:");
    b = in.nextInt();
    System.out.println(nombre + " su resultado es: " + (a+b) );
  }
}
