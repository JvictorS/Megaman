/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author 
 */
public class Nivel2 extends JPanel implements ActionListener, Runnable{
    static Thread thread;
    
    private Image background;
    
    private int stage = 1;
    
    private Player Megaman;
    private Rectangle playerBox;
    private int health;
    private LifeBar lifeBar;
    
    private Batman batman;
    private Rectangle batmanBox;
    private Rectangle batmanShootBox;
    private int batmanTimerAction;
   
    private Rectangle shootCollisionBox;
    private Rectangle mShootCollisionBox;
    
    private Timer timer;
    
    private boolean toBack = false;
    private boolean inGame;
    
    
    public Nivel2(){
        setFocusable(true);
        addKeyListener(new keyAdapter());
        setDoubleBuffered(true);
        
        ImageIcon reference = new ImageIcon("resource\\background03.jpg");
        background = reference.getImage();
        
        timer = new Timer(5, this);
        
        Megaman = new Player();
        lifeBar = LifeBar.getInstance();
        
        batman = new Batman();
        
        timer.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         List<Shoot> tiro = Megaman.getTiro();
            for(int i = 0; i < tiro.size(); i++){
                Shoot s = (Shoot) tiro.get(i);
                if(s.isVisible()){
                    s.Movement();
                } else {
                    tiro.remove(i);
                }
            }
        List<MShoot> Mtiro = Megaman.getMtiro();
            for(int j = 0; j < Mtiro.size(); j++){
                MShoot ms = (MShoot) Mtiro.get(j);
                if(ms.isVisible()){
                    ms.Movement();
                } else {
                    Mtiro.remove(j);
                }
            }
            
        Megaman.mexer();
        repaint();
    }
    
    public void start(){
        thread = new Thread(this);
        thread.start();
    }
    
    public void stop(){
        thread.stop();
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        
        while(true){
            health = Megaman.getHealth();
            if(health <= 0){
                //MORREU
            } else {
               LifeBar.lifeUpdate(Megaman.getHealth());
               batmanMovement();
               if(Megaman.getX() >= 680){
                    Cenario3 frame = new Cenario3();
                    frame.setVisible(true);
                    Megaman.setX(50);
                    Megaman.setDx(0);
                    
                    Cenario2 frame1 = new Cenario2();
                    frame1.setVisible(false);
                    frame1.dispose();
               }
            }
            this.repaint();
            try {
            thread.sleep(50);
            } catch (InterruptedException ex) {
            Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(background, 0, 0, null);
        grafico.drawImage(Megaman.getCharacter(), Megaman.getX(), Megaman.getY(), this);
        grafico.drawImage(batman.getBatman(), batman.getX(), batman.getY(), this);
        
        if(Megaman.getX() != 50){
            List<Shoot> tiro = Megaman.getTiro();
                for(int i = 0; i < tiro.size(); i++){
                    Shoot s = (Shoot) tiro.get(i);
                    grafico.drawImage(s.getShoot(), s.getX(), s.getY(), this);
                }
            List<MShoot> Mtiro = Megaman.getMtiro();
                for(int j = 0; j < Mtiro.size(); j++){
                    MShoot ms = (MShoot) Mtiro.get(j);
                    grafico.drawImage(ms.getMshoot(), ms.getX(), ms.getY(), this);
                }
        }
        
        List<BatmanShoot> BShoot = batman.getBatmanShoot();
            for(int j = 0; j < BShoot.size(); j++){
                BatmanShoot bs = (BatmanShoot) BShoot.get(j);
                grafico.drawImage(bs.getBatmanShoot(), bs.getX(), bs.getY(), this);
            }
            
        grafico.drawImage(LifeBar.getLifeBar(), 10, 20, null);
        g.dispose();
    }
    
    public void collisionTest(){
//        batmanBox = batman.getBounds();
//        
//        for(int k = 0; k < enemySonic.size(); k++){
//            sonicBox = enemySonic.get(k).getBounds();
//            
//            if(sonicBox.intersects(playerBox)){
//                Megaman.setHealth(Megaman.getHealth() - 5);
//                //enemySonic.get(k).setVisible(false);
//               //enemySonic.remove(k);
//            }
//        }
//        
//        
//        //if(batmanBox.intersects(playerBox)){
//          //  Megaman.setHealth(health - 5);
//        //}
//        
//        List<Shoot> shoot = Megaman.getTiro();
//        for(int i = 0; i < shoot.size(); i++){
//            Shoot tShoot = shoot.get(i);
//            shootCollisionBox = tShoot.getBounds();
//            
//            for(int i2 = 0; i2 < enemySonic.size(); i2++){
//                sonic = enemySonic.get(i2);
//                sonicBox = sonic.getBounds();
//            
//                if(shootCollisionBox.intersects(sonicBox)){
//                    sonic.setHealth(sonic.getHealth() - 5);
//                    tShoot.setVisible(false);
//                    System.out.println("acertou");
//                    if(sonic.getHealth() <= 0){
//                        sonic.setVisible(false);
//                        enemySonic.remove(i2);
//                    }
//                }
//                else if(shootCollisionBox.intersects(sonicBox) && !sonic.isMoving()){
//                    sonic.setHealth(sonic.getHealth() - 10);
//                    tShoot.setVisible(false);
//                    System.out.println("acertou");
//                    if(sonic.getHealth() <= 0){
//                        sonic.setVisible(false);
//                        enemySonic.remove(i2);
//                    }
//                }
//            }
//        }
//        
//        List<MShoot> mShoot = Megaman.getMtiro();
//        for(int j = 0; j < mShoot.size(); j++){
//            MShoot tMShoot = mShoot.get(j);
//            mShootCollisionBox = tMShoot.getBounds();
//            
//            for(int j2 = 0; j2 < enemySonic.size(); j2++){
//                sonic = enemySonic.get(j2);
//                sonicBox = sonic.getBounds();
//                
//                if(mShootCollisionBox.intersects(sonicBox)){
//                    sonic.setHealth(sonic.getHealth() - 5);
//                    tMShoot.setVisible(false);
//                    System.out.println("acertou");
//                    if(sonic.getHealth() <= 0){
//                        sonic.setVisible(false);
//                        enemySonic.remove(j2);
//                    }
//                }
//                else if(mShootCollisionBox.intersects(sonicBox) && !sonic.isMoving()){
//                    sonic.setHealth(sonic.getHealth() - 10);
//                    tMShoot.setVisible(false);
//                    System.out.println("acertou");
//                    if(sonic.getHealth() <= 0){
//                        sonic.setVisible(false);
//                        enemySonic.remove(j2);
//                    }
//                }
//            }
//        }
    }
    
    public void batmanMovement(){
        batmanTimerAction = 10;
        if(batman.getHealth() <= 0){
            //MORREU
        }else if(Megaman.getX() == 50){
                batman.setShoot(false); 
        }else {
            batman.Shooting();
            batman.setShoot(true);
            batman.animacao();
            List<BatmanShoot> BShoot = batman.getBatmanShoot();
            for(int j = 0; j < BShoot.size(); j++){
                BatmanShoot bs = (BatmanShoot) BShoot.get(j);
                if(bs.isVisible() && j < 1){
                    bs.Movement();
                } else {
                    BShoot.remove(j);
                }
                
            }
        }
    }
    
    private class keyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent d){
            Megaman.keyPressed(d);
        }
        @Override
        public void keyReleased(KeyEvent d){
            Megaman.keyReleased(d);
        }
    }
    
}
