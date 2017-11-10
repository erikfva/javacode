import javax.swing.*;
import java.awt.event.*;
public class Formulario2 extends JFrame implements ActionListener{
  private JButton boton1;
  public Formulario2(){
    boton1 = new JButton("Aceptar");
    setLayout(null);
    boton1.setBounds(100,200,150,30);
    boton1.addActionListener(this);
    add(boton1);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
      System.exit(0);
    }
  }
  public static void main(String args[]){
    Formulario2 frm = new Formulario2();
    frm.setBounds(0,0,400,300);
    frm.setVisible(true);
    frm.setResizable(false);
    frm.setLocationRelativeTo(null);
  }
}
