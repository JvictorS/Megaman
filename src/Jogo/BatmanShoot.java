/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Danilo
 */
public class BatmanShoot{
    private int x, y;
    private boolean visible;
    private final ImageIcon reference_Boomerang = new ImageIcon("resource//BatmanBoomerang.gif");
    private Image batmanShoot = reference_Boomerang.getImage();
    
    private int BatmanShootW = reference_Boomerang.getIconWidth()/2;
    private int BatmanShootH = reference_Boomerang.getIconHeight();

    
    public BatmanShoot(){
        this.x = 580;
        this.y = 230;
        visible = true;
    }
    
    public void Movement(){
        x -= 10;
        if(x <= 0){
            visible = false;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getBatmanShoot() {
        return batmanShoot;
    }

    public void setBatmanShoot(Image batmanShoot) {
        this.batmanShoot = batmanShoot;
    }

    public int getBatmanShootW() {
        return BatmanShootW;
    }

    public void setBatmanShootW(int BatmanShootW) {
        this.BatmanShootW = BatmanShootW;
    }

    public int getBatmanShootH() {
        return BatmanShootH;
    }

    public void setBatmanShootH(int BatmanShootH) {
        this.BatmanShootH = BatmanShootH;
    }

    
    
}
