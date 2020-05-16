
package hospital_billing_system;


import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;   
import java.io.IOException; 


public class Homepage extends JFrame{

    public Homepage(){

   JFrame homeFrame = new JFrame("Hospital Billing Systems");
   homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
   //Main Panel
   JLabel titleLabel = new JLabel("Hospital Billing System");
   titleLabel.setForeground(Color.WHITE);
   JLabel nameLabel= new JLabel("Name ");
   nameLabel.setForeground(Color.WHITE);
   JLabel ageLabel = new JLabel("Age    ");
   ageLabel.setForeground(Color.WHITE);
   JLabel docLabel = new JLabel("Doctor Name");
   docLabel.setForeground(Color.WHITE);
   JLabel serveLabel = new JLabel("Service");
   serveLabel.setForeground(Color.WHITE);
   JLabel bedLabel = new JLabel("Bed Type     ");
   bedLabel.setForeground(Color.WHITE);
   JLabel billLabel = new JLabel("Bill");
   billLabel.setForeground(Color.WHITE);
   
   
   JTextField nameTextField = new JTextField(20);
   JTextField ageTextField = new JTextField(20);
   ageTextField.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
   JTextField billTextField= new JTextField(20);
   billTextField.setEditable(false);
   
   
   JTextArea recieptArea = new JTextArea();
   recieptArea.setPreferredSize(new Dimension(300,300));
   recieptArea.setText("                         *******************************      \n"+"                         ****Hospital Billing System****\n"+" \n\n                      PLEASE ENTER PATIENT'S INFO \n"+"                            AND SELECT SERVICES\n"+"\n                                LOADING BILL");
   recieptArea.setBackground(Color.DARK_GRAY);
   recieptArea.setForeground(Color.WHITE);
   recieptArea.setEditable(false);
 
   JComboBox comboDoc= new JComboBox();
   comboDoc.setPreferredSize(new Dimension(150,25));
   comboDoc.addItem("Dr. Hyder");
   comboDoc.addItem("Dr. Isha");
   comboDoc.addItem("Dr. Sanjib");
   comboDoc.addItem("Dr. Ismat");
   comboDoc.setSelectedItem(null);
   
   JComboBox comboBed = new JComboBox();
   comboBed.setPreferredSize(new Dimension(150,25));
   comboBed.addItem("VIP");
   comboBed.addItem("First Class");
   comboBed.addItem("2nd Class");
   comboBed.addItem("Ward");
   comboBed.setSelectedItem(null);
   
   
   JCheckBox checkFood = new JCheckBox("Food", true);
   JCheckBox checkAmb = new JCheckBox("Ambulance", true);
   JCheckBox checkMed = new JCheckBox("Medicines", true);
   JCheckBox checkPath = new JCheckBox("Pathology",true);
   JCheckBox checkOT = new JCheckBox("OT",true);
   
   JButton buttonConfirm=new JButton("Confirm");
   buttonConfirm.setBackground(Color.ORANGE);
   buttonConfirm.addActionListener(new ActionListener(){  
       @Override
       public void actionPerformed(ActionEvent e){  
                double bill = 0;
                if(comboDoc.getSelectedItem().equals("Dr. Hyder"))
                {
                    bill = bill+500;
                }
                if(comboDoc.getSelectedItem().equals("Dr. Isha"))
                {
                    bill = bill+700;
                }
                if(comboDoc.getSelectedItem().equals("Dr. Sanjib"))
                {
                    bill = bill+1000;
                }
                if(comboDoc.getSelectedItem().equals("Dr. Ismat"))
                {
                    bill = bill+1200;
                }
                if(comboBed.getSelectedItem().equals("VIP"))
                {
                    bill = bill+15000;
                  
                }
                if(comboBed.getSelectedItem().equals("First Class"))
                {
                    bill = bill+8000;
                  
                }
                if(comboBed.getSelectedItem().equals("2nd Class"))
                {
                    bill = bill+3000;
                  
                }
                if(comboBed.getSelectedItem().equals("Ward"))
                {
                    bill = bill+1500;
                  
                }
                
	        
                if(checkFood.isSelected()==true)
		{
			bill= bill+10000;
		}
                if(checkAmb.isSelected()==true)
		{
			bill= bill+10000;
		}
                if(checkMed.isSelected()==true)
		{
			bill= bill+10000;
		}
                if(checkPath.isSelected()==true)
		{
			bill= bill+10000;
		}
                if(checkOT.isSelected()==true)
		{
			bill= bill+10000;
		}
                
                
                recieptArea.setText(Double.toString(bill));
                bill= Double.parseDouble("Bill:\n\n"+recieptArea.getText());
                
                
               
               if (isNullOrEmpty(nameLabel.getText())||isNullOrEmpty(ageLabel.getText())) 
	 { 
             JOptionPane.showMessageDialog(null, "Please Enter All Values","OK",JOptionPane.INFORMATION_MESSAGE);
	 }
       try {
      FileWriter myWriter = new FileWriter("Talha.txt");
      myWriter.write(nameLabel.getText()+"\r\n"+ageLabel.getText()+"\r\n"+bill);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException ex) {
      System.out.println("An error occurred.");
      ex.printStackTrace();
    }          
       
       
       
       
       
       }

       private boolean isNullOrEmpty(String text) {
           throw new UnsupportedOperationException("Not supported yet.");
       }

       
       
                 
   });  
   
   
   //Panel 1
   JPanel panel = new JPanel();
   panel.setPreferredSize(new Dimension(400,700));
   panel.setBackground(new java.awt.Color(33, 36, 61));
   homeFrame.add(panel);
   
   panel.add(nameLabel);
   panel.add(nameTextField);
   panel.add(ageLabel);
   panel.add(ageTextField);
   panel.add(docLabel);
   panel.add(comboDoc);
   panel.add(bedLabel);
   panel.add(comboBed);
   panel.add(serveLabel);
   panel.add(checkFood);
   panel.add(checkAmb);
   panel.add(checkMed);
   panel.add(checkPath);
   panel.add(checkOT);
   panel.add(buttonConfirm);
   panel.add(recieptArea);
   
   panel.setLayout(new FlowLayout(FlowLayout.LEFT,50,50));
   

   //Homeframe
   homeFrame.setSize(600,800);
   homeFrame.setVisible(true);
   titleLabel.setBounds(300,50,250,50);
   //homeFrame.add(titleLabel);
   
   homeFrame.setLayout(new FlowLayout(FlowLayout.LEADING,50,50));
   homeFrame.getContentPane().setBackground(new java.awt.Color(33, 36, 61));
   
   
}
}
