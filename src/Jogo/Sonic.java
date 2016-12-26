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
 * @author
 */
public class Sonic extends ObjectEnemy{
    private int health = 50;
    private boolean mirror = false, moving = false, hit = false;
    private boolean visible = false;
    private Image sonic;
    
    
    private final ImageIcon reference_SonicStand = new ImageIcon("resource\\SonicStand.gif");
    private final ImageIcon reference_SonicSpinning = new ImageIcon("resource\\SonicSpinning.gif");
    private final ImageIcon reference_hit = new ImageIcon("resource\\TesteRecievingShoot.gif");
    
    private int SonicW = reference_SonicStand.getIconWidth();
    private int SonicH = reference_SonicStand.getIconHeight();
    
    public Sonic() {
        super(600, 230);
        visible = true;
        this.sonic = reference_SonicStand.getImage();
    }
    
    public void animacao(){
        if(hit){
            this.sonic = reference_hit.getImage();
        }else if(!moving){
            this.sonic = reference_SonicStand.getImage();
        }else if(moving){
            this.sonic = reference_SonicSpinning.getImage();
        }
    }
    
    public void MoveRight(){
        animacao();
        x += 10;
        moving = true;
    } 
    
    public void MoveLeft(){
        animacao();
        x -= 10;
        moving = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getSonic() {
        return sonic;
    }

    public void setSonic(Image sonic) {
        this.sonic = sonic;
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
