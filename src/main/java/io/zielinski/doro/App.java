package io.zielinski.doro;

import javax.swing.*;

import java.awt.Color;
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
    JTextArea cryptedMessageTextArea;
    JLabel instructionLabel;
    JLabel inputLabel; 
    JLabel outputLabel; 
    JLabel offsetLabel;  
    JButton encryptButton = new JButton("Verschlüsseln");
    JButton closeButton = new JButton("Schließen");
    JButton decryptButton = new JButton("Entschlüsseln");
    
    App (){
        // CaesarEncryption caesarEncryption = new CaesarEncryption();
        
        
        frame.setTitle("Schnelle Ceasar-Verschlüsselung");
        //frame.setSize(300, 300);
        frame.setResizable(true);
        frame.setLocation(1000, 500);
        frame.setVisible(true);
        

        instructionLabel=new JLabel("Bitte ausfüllen");
        instructionLabel.setBounds(50,30,150,30);
        //h1.setBorder(BorderFactory.createEmptyBorder());
        frame.add(instructionLabel);
        
        
        
        inputLabel=new JLabel("Ihr Text");  
        inputLabel.setBounds(10,100, 100,30);  
        frame.add(inputLabel); 

        messageTextArea=new JTextArea();  
        messageTextArea.setBounds(100,100, 175,30);  
        frame.add(messageTextArea);
        frame.setLayout(null);  
        frame.setVisible(true);  

        
        outputLabel=new JLabel("Ergebnis");  
        outputLabel.setBounds(10,150, 100,30);  
        frame.add(outputLabel); 

        cryptedMessageTextArea= new JTextArea();
        cryptedMessageTextArea.setEditable(false);
        cryptedMessageTextArea.setBackground(Color.lightGray);
        cryptedMessageTextArea.setBounds(100, 150, 175, 30);
        frame.add(cryptedMessageTextArea);
        frame.setLayout(null);  
        frame.setVisible(true);  
        
         
        
        offsetLabel=new JLabel("Verschiebung");  
        offsetLabel.setBounds(10,200, 100,30); 
        frame.add(offsetLabel);  
        frame.setSize(350,300);  
        frame.setLayout(null); 

        textFieldOffset=new JTextField();  
        textFieldOffset.setBounds(100,200, 50,30);  
        frame.add(textFieldOffset);  

        
        
        encryptButton.setBounds(1, 250, 115, 25);
        encryptButton.addActionListener(this);

        decryptButton.setBounds(117, 250, 115, 25);
        decryptButton.addActionListener(this);

        closeButton.addActionListener(this);
        closeButton.setBounds(232, 250, 115, 25);
        
        frame.add(encryptButton);
        frame.add(closeButton);
        frame.add(decryptButton);
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
                cryptedMessageTextArea.setText(encryptedMessage);

            }
            
        }
        

        if (e.getActionCommand().equals("Entschlüsseln")){
            String messageText = messageTextArea.getText();

            Integer offset = Integer.valueOf(textFieldOffset.getText());
            

            if (messageText.isBlank() || messageText.isEmpty()){
                System.out.println("Invalid input");
            } else {
                String decryptedMessage = "LIES MICH";
                decryptedMessage = CaesarDecryption.decrypt(messageText, offset);
                cryptedMessageTextArea.setText(decryptedMessage);

            }
            
        }

        if (e.getActionCommand().equals("Schließen")){
            System.exit(0);
        }
        
        
        
    }
}
