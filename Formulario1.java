import javax.swing.*;
public class Formulario1 extends JFrame{
  private JLabel label1;
  private JLabel label2;
  public Formulario1(){
    setLayout(null);
    label1 = new JLabel("Pruebaa de etiqueta.");
    label1.setBounds(20,20,200,30);
    add(label1);

    label2 = new JLabel("Etiqueta 2");
    label2.setBounds(20,100,200,30);
    add(label2);
  }
  public static void main(String args[]){
    Formulario1 form = new Formulario1();
    form.setBounds(0,0,400,500);
    form.setResizable(false);
    form.setVisible(true);
    form.setLocationRelativeTo(null);
  }

}
