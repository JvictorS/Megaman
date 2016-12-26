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
 * @author 
 */
public class Shoot extends ObjectShot{
    private boolean visible;
    private final ImageIcon reference_shoot = new ImageIcon("resource//TesteBeam.gif");
    private Image shoot = reference_shoot.getImage();
    
    private int ShootW = reference_shoot.getIconWidth();
    private int ShootH = reference_shoot.getIconHeight();
    
    public Shoot(int x, int y){
        super(x, y);
        visible = true;
    }
    
    public void Movement(){    
        x += 3;
        if(x >= 716){
            visible = false;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getShoot() {
        return shoot;
    }

    public void setShoot(Image shoot) {
        this.shoot = shoot;
    }

    public int getShootW() {
        return ShootW;
    }

    public void setShootW(int ShootW) {
        this.ShootW = ShootW;
    }

    public int getShootH() {
        return ShootH;
    }

    public void setShootH(int ShootH) {
        this.ShootH = ShootH;
    }

}
