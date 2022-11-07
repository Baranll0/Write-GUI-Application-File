import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Person implements ActionListener {
    JFrame window=new JFrame("Giris Formu");
    JTextField nameSurname=new JTextField();
    JTextField bolum =new JTextField();
    JTextField userName=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel nameLabel=new JLabel("Ad:");
    JLabel bolumLabel=new JLabel("Soyad:");
    JLabel userNameLabel=new JLabel("Kullanici Adi");
    JLabel passwordLabel=new JLabel("Sifre");
    JButton signUpButton=new JButton("Giris Yap");
    JLabel blank=new JLabel();
    FileWriter fileWriter;

    public Person()
    {
        GridLayout g1=new GridLayout();
        g1.setColumns(2);
        g1.setRows(5);
        window.setLayout(g1);
        signUpButton.addActionListener(this);
        window.add(userNameLabel);
        window.add(userName);
        window.add(nameLabel);
        window.add(nameSurname);
        window.add(bolumLabel);
        window.add(bolum);
        window.add(passwordLabel);
        window.add(password);
        window.add(blank);
        window.add(signUpButton);
        window.setSize(300,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand()==signUpButton.getActionCommand())
        {
            try{
                fileWriter=new FileWriter("file.txt");
                fileWriter.write(userNameLabel.getText()+": "+userName.getText());
                fileWriter.write("\n"+passwordLabel.getText()+": "+password.getText());
                fileWriter.write("\n"+nameLabel.getText()+": "+nameSurname.getText());
                fileWriter.write("\n"+bolumLabel.getText()+": "+bolum.getText());
                fileWriter.close();
                JOptionPane.showMessageDialog(null,"Dosyaya yazıldı.");
            }catch (Exception ev)
            {
                JOptionPane.showMessageDialog(null,ev+"");


            }
        }
    }
}
