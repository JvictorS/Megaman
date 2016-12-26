/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author 
 */
public class Menu extends JFrame implements ActionListener{
    static String name;
    //private final AudioClip audioclip = Applet.newAudioClip(this.getClass().getResource("resource\\gameAudio.wav"));
    
    public Menu() {
        final JPanel contentPane;
        
        this.setTitle("Megaman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 550);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton JBPlay = new JButton("Play");
        JBPlay.setBackground(Color.BLACK);
        JBPlay.setForeground(Color.BLUE);
        JBPlay.setBounds(168, 261, 245, 34);
        JBPlay.addActionListener(this);
        JBPlay.setActionCommand("Play");
        contentPane.add(JBPlay);
        
        /*try{
        audioclip.loop();
        Applet.newAudioClip(this.getClass().getResource("resource\\gameAudio.wav")).loop();
        }catch(Exception e){
        e.printStackTrace();
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Play")){
            this.dispose();
            Controls.gameJFrame = new GameFrame();
            Controls.gameJFrame.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        Menu frame = new Menu();
        frame.setVisible(true);
    }
}
