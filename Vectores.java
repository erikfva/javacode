import java.util.Scanner;
public class Vectores{
  public static void main(String args[]){
    int longitud = 0;
    Scanner in = new Scanner(System.in);
    System.out.print("Ingrese la dimension para el vector: ");
    longitud = in.nextInt();
    int v[] = new int[longitud];
    for(int i=0; i<v.length; i++){
      System.out.println("");
      System.out.print("Ingrese el elemento " + (i+1)  + ": ");
      v[i] = in.nextInt();
    }
    for(int i = 0; i<v.length; i++){
      System.out.println("");
      System.out.print("El elemento [" + (i+1) + "]=" + v[i] );
    }
  }
}
