import java.util.Scanner;
public class Vacaciones{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String nombre = "", clave="",departamento="";
    int antiguedad = 0, dias=0;

    System.out.println("Cual es su nombre? ");
    nombre = in.nextLine();
    System.out.println("Cual es su clave? ");
    clave = in.nextLine();
    System.out.println("Cual es su antiguedad (años)? ");
    antiguedad = in.nextInt();

    if(antiguedad <= 1 ){
      dias = clave.equals("clave 1")?6:(clave.equals("clave 2")?7:(clave.equals("clave 3")?10:0));
    } else if(antiguedad<=6){
      dias = (clave.equals("clave 1")?14:(clave.equals("clave 2")?15:(clave.equals("clave 3")?20:0)));
    }  else if(antiguedad >= 7){
      dias = clave.equals("clave 1")?20:(clave.equals("clave 2")?22:(clave.equals("clave 3")?30:0));
    } else {
      System.out.println("Error!!");
    }
    if(dias > 0){
      System.out.println("El trabajador " + nombre + " con " + clave + " tiene " + antiguedad + " años de antiguedad y merece " + dias + " dias de vacaciones." );
    }
  }
}
