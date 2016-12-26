/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class Player extends ObjectPlayer{
    
    private int  dx, dy;
    private int health = 100;
    private Image character;
    private boolean shoot = false, mirror = false, isMoving = false, hit = false, death = false;
    private List<Shoot> tiro;
    private List<MShoot> Mtiro;
    
    private final ImageIcon reference_intro = new ImageIcon("resource\\INTRO.gif");
    private final ImageIcon reference_stand = new ImageIcon("resource\\TesteStand.gif");
    private final ImageIcon reference_walk = new ImageIcon("resource\\TesteRunning.gif");
    private final ImageIcon reference_jump = new ImageIcon("resource\\Jumping.png");
    private final ImageIcon reference_shoot = new ImageIcon("resource\\TesteShooting.gif");
    private final ImageIcon reference_hit = new ImageIcon("resource\\TesteRecievingShoot.gif");
    private final ImageIcon reference_death = new ImageIcon("resource\\TesteDeath.gif");
    
    //mirror
    private final ImageIcon reference_Mstand = new ImageIcon("resource\\MTesteStand.gif");
    private final ImageIcon reference_Mwalk = new ImageIcon("resource\\MTesteRunning.gif");
    private final ImageIcon reference_Mjump = new ImageIcon("resource\\MJumping.png");
    private final ImageIcon reference_Mshoot = new ImageIcon("resource\\MTesteShooting.gif"); 
    
    private final int largura = reference_shoot.getIconWidth();
    
    private int MegamanW = reference_stand.getIconWidth();
    private int MegamanH = reference_stand.getIconHeight();
    
    
    public Player(){
        super(50, 60);
        character = reference_intro.getImage();
        tiro = new ArrayList<Shoot>();
        Mtiro = new ArrayList<MShoot>();
    }
    
    public void animacao(){
        if(death){
            this.character = reference_death.getImage();
        }else if(hit){
            this.character = reference_hit.getImage();
        }else if(shoot && mirror && x!=50){
            this.character = reference_Mshoot.getImage();
        }else if(shoot && x!=50){
            this.character = reference_shoot.getImage();
        }else if(x == 50 && dx == 0){
            this.character = reference_intro.getImage();
        }else if(y < 230 && mirror && x!=50){
            this.character = reference_Mjump.getImage();
        }else if(y < 230 && x!=50){
            this.character = reference_jump.getImage();
        }else if(isMoving && mirror){
            character = reference_Mwalk.getImage(); 
        }else if(isMoving){
            character = reference_walk.getImage();
        }else if(!isMoving && mirror){
            character = reference_Mstand.getImage();
        }else if(!isMoving){
            character = reference_stand.getImage();
        }
        
        if(x != 50 && dy == 0){
            super.setY(230);
        }
    }
    
    public void mexer(){
        x += dx;
        y += dy;
        animacao();
        
        if(x <= 0){
            x = 0;
        }
        if(x >= 680){
            x = 680;
        }
        if(y <= 0){
            y = 0;
        }
        if(y >= 230){
            y = 230;
        }
    }
    
    public void Atirar(){
        Shoot s = new Shoot(x+largura/2, y+20);
        /*s.setX(x+largura/2);
        s.setY(y+20);*/
        
        MShoot ms = new MShoot(x, y + 20);
        /*ms.setX(x);
        ms.setY(y+20);*/
        if(!mirror){
            this.tiro.add(s);
        } else {
            this.Mtiro.add(ms);
        }
    }
    
    
    
    public void keyPressed(KeyEvent d){
        int keyCode = d.getKeyCode();
        
        if(keyCode == KeyEvent.VK_UP && x!=50){
            if(y==230){
                dy = -2;
            }
            if(y <= 150){
                keyReleased(d);
            }
        }
        
        if(keyCode == KeyEvent.VK_LEFT){
            this.dx = -1;
            mirror = true;
            isMoving = true;
        }
        
        if(keyCode == KeyEvent.VK_RIGHT){
            this.dx = +1;
            mirror = false;
            isMoving = true;
        }
        
        if(keyCode == KeyEvent.VK_SPACE){
            shoot = true;
            Atirar();
        }
    }
    
    public void keyReleased(KeyEvent d){
        int keyCode = d.getKeyCode();
        
        if(keyCode == KeyEvent.VK_UP && x!=50){
            
            for(int j = 0; j < 5; j++){
                dy = +2;
            }
        }
        
        if(keyCode == KeyEvent.VK_LEFT){
            this.dx = 0;
            isMoving = false;
        }
        
        if(keyCode == KeyEvent.VK_RIGHT){
            this.dx = 0;
            isMoving = false;
        }
        
        if(keyCode == KeyEvent.VK_SPACE){
            shoot = false;
        }
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Image getCharacter() {
        return character;
    }

    public void setCharacter(Image character) {
        this.character = character;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public boolean isIsMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public List<Shoot> getTiro() {
        return tiro;
    }

    public void setTiro(List<Shoot> tiro) {
        this.tiro = tiro;
    }

    public List<MShoot> getMtiro() {
        return Mtiro;
    }

    public void setMtiro(List<MShoot> Mtiro) {
        this.Mtiro = Mtiro;
    }

    public int getMegamanW() {
        return MegamanW;
    }

    public void setMegamanW(int MegamanW) {
        this.MegamanW = MegamanW;
    }

    public int getMegamanH() {
        return MegamanH;
    }

    public void setMegamanH(int MegamanH) {
        this.MegamanH = MegamanH;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

   
    
}
