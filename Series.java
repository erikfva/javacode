public class Series{
  public static void serie1(){
    for(int i=1;i<=10;i++){
      System.out.print(i);
      if(i<10){
        System.out.print(",");
      }
    }
  }
  public static void serie2(){
    int i = 1;
    while(i<=5){
      System.out.print(i + ", " + (100 - i));
      if(i<5){
        System.out.print(", ");
      }
      i++;
    }
  }
  public static void serie3(){
    int valor1 = 0;
    int valor2 = 1;
    int aux = 0;


    do{
      if(valor1==0){
        System.out.print(valor1 + ", " + valor2 + ", ");
      }
      System.out.print(valor1 + valor2);
      aux = valor2;
      valor2 = valor1 + valor2;
      valor1 = aux;

      if(valor2 < 34){
        System.out.print(", ");
      }
    } while(valor2 < 34);
  }
  public static void main(String[] args){
    System.out.println("La primer serie es: ");
    serie1();
    System.out.println("");
    System.out.println("La segunda serie es: ");
    serie2();
    System.out.println("");
    System.out.println("La tercer serie es: ");
    serie3();
  }
}
