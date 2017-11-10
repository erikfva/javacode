import javax.swing.*;
import java.awt.event.*;
public class Formulario3 extends JFrame implements ActionListener{
  private JTextField text1;
  private JLabel label1;
  private JButton boton1;
  public Formulario3(){
    setLayout(null);
    label1 = new JLabel("Ingrese nombre: ");
    label1.setBounds(20,100,150,30);
    add(label1);
    text1 = new JTextField();
    text1.setBounds(190,100,200,30);
    add(text1);
    boton1 = new JButton("Colocar titulo");
    boton1.setBounds(150,260,150,30);
    boton1.addActionListener(this);
    add(boton1);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==boton1){
      String texto = text1.getText();
      setTitle(texto);
    }
  }
  public static void main(String args[]){
    Formulario3 frm = new Formulario3();
    frm.setBounds(0,0,550,400);
    frm.setVisible(true);
    frm.setResizable(false);
    frm.setLocationRelativeTo(null);
  }
}
