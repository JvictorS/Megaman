/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author */


public class GameFrame extends JFrame{
    private JPanel contentPane;
    //private final AudioClip audioClip = Applet.newAudioClip(this.getClass().getResource("resource\\gameAudio.wav"));
    
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }
    
    public GameFrame(){
        this.setTitle("Megaman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(716, 390);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        /*try{
        audioClip.loop();
        }catch(Exception e){
        e.printStackTrace();
        }*/
        
        Nivel1 nivel1 = new Nivel1();
        add(nivel1);
        nivel1.start();
        
    }
}
