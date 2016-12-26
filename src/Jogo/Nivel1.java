/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

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

/**
 *
 * @author 
 */
public class Nivel1 extends JPanel implements ActionListener, Runnable{
    static Thread thread;
    
    private Image background;
    
    private int stage = 1;
    
    private Player Megaman;
    private Rectangle playerBox;
    private int health;
    private LifeBar lifeBar;
    
    private Sonic sonic;
    private List<Sonic> enemySonic;
    private Rectangle sonicBox;
    private int sonicTimerAction;
    
    private Sonic sonic2;
    private List<Sonic> enemySonic2;
    private Rectangle sonicBox2;
    
    private Rectangle shootCollisionBox;
    private Rectangle mShootCollisionBox;
    
    private Timer timer;
    
    private boolean toBack = false, toBack2 = false;
    private boolean inGame;
    
    
    public Nivel1(){
        setFocusable(true);
        addKeyListener(new keyAdapter());
        setDoubleBuffered(true);
        
        ImageIcon reference = new ImageIcon("resource\\background03.jpg");
        background = reference.getImage();
        
        timer = new Timer(5, this);
        
        Megaman = new Player();
        lifeBar = LifeBar.getInstance();
        
        generateSonic(stage);
        
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
               Megaman.setDeath(true);
               Megaman.animacao();
               sonic.setMoving(false);
               sonic.animacao();
               try {
                  thread.sleep(5000);
                } catch (InterruptedException ex) {
                  Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                Cenario1 frame = new Cenario1();
                frame.setVisible(true);
                Megaman.setX(50);
                GameFrame frame1 = new GameFrame();
                frame1.setVisible(false);
                frame1.dispose();
                Megaman.setHealth(100);
            } else {
                LifeBar.lifeUpdate(Megaman.getHealth());
               sonicMovement();
               //sonicMovement2();
               collisionTest();
               if(Megaman.getX() >= 680){
                    Cenario2 frame = new Cenario2();
                    frame.setVisible(true);
                    Megaman.setX(50);
                    Megaman.setDx(0);
                    
                    GameFrame frame1 = new GameFrame();
                    frame1.setVisible(false);
                    frame1.dispose();
               }
            }
            this.repaint();
            try {
                thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(background, 0, 0, null);
        grafico.drawImage(Megaman.getCharacter(), Megaman.getX(), Megaman.getY(), this);
        for(int i = 0; i < enemySonic.size(); i++){
            sonic = enemySonic.get(i);
            grafico.drawImage(sonic.getSonic(), sonic.getX(), sonic.getY(), this);
        }
        
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
        
        grafico.drawImage(LifeBar.getLifeBar(), 10, 20, null);
        
        g.dispose();
    }
    
    public void generateSonic(int stage){
        
        enemySonic = new ArrayList<Sonic>();
        
        for(int i = 0; i < 1; i++){
            enemySonic.add(new Sonic());
        }
        
    }
    
    public void collisionTest(){
        playerBox = Megaman.getBounds();
        Megaman.setHit(false);
        for(int k = 0; k < enemySonic.size(); k++){
            sonicBox = enemySonic.get(k).getBounds();
            
            if(sonicBox.intersects(playerBox)){
                Megaman.setHealth(Megaman.getHealth() - 7);
                Megaman.setHit(true);
            }
        }
        
        
        List<Shoot> shoot = Megaman.getTiro();
        for(int i = 0; i < shoot.size(); i++){
            Shoot tShoot = shoot.get(i);
            shootCollisionBox = tShoot.getBounds();
            
            for(int i2 = 0; i2 < enemySonic.size(); i2++){
                sonic = enemySonic.get(i2);
                sonicBox = sonic.getBounds();
            
                if(shootCollisionBox.intersects(sonicBox)){
                    sonic.setHealth(sonic.getHealth() - 5);
                    tShoot.setVisible(false);
                    if(sonic.getHealth() <= 0){
                        sonic.setVisible(false);
                        enemySonic.remove(i2);
                    }
                }
                else if(shootCollisionBox.intersects(sonicBox) && !sonic.isMoving()){
                    sonic.setHealth(sonic.getHealth() - 10);
                    tShoot.setVisible(false);
                    if(sonic.getHealth() <= 0){
                        sonic.setVisible(false);
                        enemySonic.remove(i2);
                    }
                }
            }
        }
        
        List<MShoot> mShoot = Megaman.getMtiro();
        for(int j = 0; j < mShoot.size(); j++){
            MShoot tMShoot = mShoot.get(j);
            mShootCollisionBox = tMShoot.getBounds();
            
            for(int j2 = 0; j2 < enemySonic.size(); j2++){
                sonic = enemySonic.get(j2);
                sonicBox = sonic.getBounds();
                
                if(mShootCollisionBox.intersects(sonicBox)){
                    sonic.setHealth(sonic.getHealth() - 5);
                    tMShoot.setVisible(false);
                    if(sonic.getHealth() <= 0){
                        sonic.setVisible(false);
                        enemySonic.remove(j2);
                    }
                }
                else if(mShootCollisionBox.intersects(sonicBox) && !sonic.isMoving()){
                    sonic.setHealth(sonic.getHealth() - 10);
                    tMShoot.setVisible(false);
                    if(sonic.getHealth() <= 0){
                        sonic.setVisible(false);
                        enemySonic.remove(j2);
                    }
                }
            }
        }
    }
    
    public void sonicMovement(){
        for(int i = 0; i < enemySonic.size(); i++){
            sonic = enemySonic.get(i);
            if(sonic.isVisible()){
                if(Megaman.getX() == 50){
                    sonic.setMoving(false);
                }else if(sonic.getX() > -60 && !toBack){
                    sonic.MoveLeft();
                }else if(sonic.getX() <= -60){
                    sonic.setMoving(false);
                    sonic.animacao();
                    try {
                        thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    toBack = true;
                    sonic.setX(-59);

                }else if(sonic.getX() < 717 && toBack){
                    sonic.MoveRight();
                }else if(sonic.getX() >= 717){
                    sonic.setMoving(false);
                    sonic.animacao();
                    try {
                        thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    toBack = false;
                    sonic.setX(716);

                }else if(sonic.getX() <= 716 && !toBack){
                    sonic.MoveRight();
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
