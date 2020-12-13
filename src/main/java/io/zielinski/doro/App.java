package io.zielinski.doro;

import javax.swing.*;
import java.awt.event.*;  

/**
* Hello world!
*
*/
public class App implements ActionListener
{
    /**
    *
    */
    private static final long serialVersionUID = 4749078888121559089L;
    JFrame frame = new JFrame();
    JTextField textFieldOffset; 
    JTextArea messageTextArea;
    JLabel instructionLabel;
    JLabel inputLabel;  
    JLabel offsetLabel;  
    JButton encryptButton = new JButton("Verschlüsseln");
    JButton closeButton = new JButton("Schließen");
    
    App (){
        // CaesarEncryption caesarEncryption = new CaesarEncryption();
        
        
        frame.setTitle("Schnelle Ceasar-Verschlüsselung");
        //frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setLocation(1000, 500);
        frame.setVisible(true);
        
        
        
        textFieldOffset=new JTextField();  
        textFieldOffset.setBounds(100,150, 50,30);  
        //frame.add(t1); 
        frame.add(textFieldOffset);  
        //frame.setSize(400,400); 
        
        messageTextArea=new JTextArea();  
        messageTextArea.setBounds(100,100, 175,30);  
        frame.add(messageTextArea);
        frame.setLayout(null);  
        frame.setVisible(true);  
        
        
        instructionLabel=new JLabel("Bitte ausfüllen");
        instructionLabel.setBounds(50,50,150,30);
        //h1.setBorder(BorderFactory.createEmptyBorder());
        frame.add(instructionLabel);
        
        
        inputLabel=new JLabel("Ihr Text");  
        inputLabel.setBounds(10,100, 100,30);  
        
        offsetLabel=new JLabel("Verschiebung");  
        offsetLabel.setBounds(10,150, 100,30);  
        frame.add(inputLabel); 
        frame.add(offsetLabel);  
        frame.setSize(300,300);  
        frame.setLayout(null); 
        
        
        
        encryptButton.setBounds(20, 200, 130, 25);
        encryptButton.addActionListener(this);
        closeButton.addActionListener(this);
        
        closeButton.setBounds(150, 200, 130, 25);
        
        frame.add(encryptButton);
        frame.add(closeButton);
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        System.out.println( "Hello World!" );
        new App();
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("event: " + e.getActionCommand());
        
        if (e.getActionCommand().equals("Verschlüsseln")){
            String messageText = messageTextArea.getText();
            Integer offset = Integer.valueOf(textFieldOffset.getText());
            

            if (messageText.isBlank() || messageText.isEmpty()){
                System.out.println("Invalid input");
            } else {
                String encryptedMessage = "LIES MICH NICHT";
                encryptedMessage = CaesarEncryption.encrypt(messageText, offset);
                messageTextArea.setText(encryptedMessage);

            }
            
        }
        
        if (e.getActionCommand().equals("Schließen")){
            System.exit(0);
        }
        
        
        
    }
}
