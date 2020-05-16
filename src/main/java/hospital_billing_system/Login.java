package hospital_billing_system;


import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
 

public  class Login extends JFrame
{

    public Login()
    {
      
        
        JFrame loginFrame = new JFrame("Hospital Billing System");
        JLabel l_name=new JLabel("Username");
	JLabel l_pass=new JLabel("Password");
        JTextField t_name=new JTextField(20);
        JPasswordField t_pass=new JPasswordField(20);
        JButton l_button = new JButton("Login");
        l_button.setForeground(Color.BLACK);
        l_button.setBackground(Color.ORANGE);
        
        l_button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String username=t_name.getText();
                String password=t_pass.getText();
        if(username.equals("admin") && password.equals("pass")){
                    Homepage obj = new Homepage();
                    obj.setVisible(true);
                    loginFrame.dispose();
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
        }
                
                
            }
        });
	loginFrame.add(l_name);
        loginFrame.add(t_name);
        loginFrame.add(l_pass);
        loginFrame.add(t_pass);
        loginFrame.add(l_button);
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
	loginFrame.setVisible(true);
        loginFrame.setSize(600,600);
        loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l_name.setFont(new Font("Verdana", Font.PLAIN, 20));
        l_name.setForeground(Color.WHITE);
        l_pass.setFont(new Font("Verdana", Font.PLAIN, 20));
        l_pass.setForeground(Color.WHITE);
        l_button.setFont(new Font("Verdana", Font.PLAIN, 12));
        loginFrame.getContentPane().setBackground(new java.awt.Color(33, 36, 61));
     }

    

   
}    
