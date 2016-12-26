/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Guilherme
 */
public class Boss {
    private static int x, y;
    private static int health = 100;
    private boolean mirror = false, moving = false, hit = false, special = false;
    private static Image boss;
    
    
    private final ImageIcon reference_BossStand = new ImageIcon("resource\\BossStand.gif");
    private final ImageIcon reference_BossSpecial = new ImageIcon("resource\\BossSpecial.gif");
    private final ImageIcon reference_BossHit = new ImageIcon("resource\\BossRecievingShoot.gif");
    
    //Mirro
    private final ImageIcon reference_MBossStand = new ImageIcon("resource\\MBossStand.gif");
    private final ImageIcon reference_MBossSpecial = new ImageIcon("resource\\MBossSpecial.gif");
    private final ImageIcon reference_MBossHit = new ImageIcon("resource\\MBossRecievingShoot.gif");
    
    
    private int SonicW = reference_BossStand.getIconWidth();
    private int SonicH = reference_BossStand.getIconHeight();
    
    public Boss() {
        this.x = 500;
        this.y = 90;
        this.boss = reference_BossStand.getImage();
    }
    
    public void animacao(){
        if(hit && mirror){
            this.boss = reference_MBossHit.getImage();
        }else if(hit){
            this.boss = reference_BossHit.getImage();
        }else if(!moving && mirror){
            this.boss = reference_MBossStand.getImage();
        }else if(!moving){
            this.boss = reference_BossStand.getImage();
        }
        
        if(special && mirror){
            this.boss = reference_MBossSpecial.getImage();
        }else if(special){
            this.boss = reference_BossSpecial.getImage();
        }
    }
    
    public void MoveRight(){
        animacao();
        x += 2;
        moving = true;
    } 
    
    public void MoveLeft(){
        animacao();
        x -= 2;
        moving = true;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Boss.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Boss.y = y;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Boss.health = health;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public static Image getBoss() {
        return boss;
    }

    public static void setBoss(Image boss) {
        Boss.boss = boss;
    }

    public int getSonicW() {
        return SonicW;
    }

    public void setSonicW(int SonicW) {
        this.SonicW = SonicW;
    }

    public int getSonicH() {
        return SonicH;
    }

    public void setSonicH(int SonicH) {
        this.SonicH = SonicH;
    }

    
    
    
}
