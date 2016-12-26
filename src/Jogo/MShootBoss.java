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
public class MShootBoss {
    private static int x, y;
    private boolean visible;
    private final ImageIcon reference_MShootBoss = new ImageIcon("resource//MBossShoot.gif");
    private Image shootBoss = reference_MShootBoss.getImage();
    
    private int shootBossW = reference_MShootBoss.getIconWidth();
    private int shootBossH = reference_MShootBoss.getIconHeight();
    
    public MShootBoss(){
        this.x = 340;
        this.y = 150;
        visible = true;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        MShootBoss.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        MShootBoss.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getShootBoss() {
        return shootBoss;
    }

    public void setShootBoss(Image shootBoss) {
        this.shootBoss = shootBoss;
    }

    public int getShootBossW() {
        return shootBossW;
    }

    public void setShootBossW(int shootBossW) {
        this.shootBossW = shootBossW;
    }

    public int getShootBossH() {
        return shootBossH;
    }

    public void setShootBossH(int shootBossH) {
        this.shootBossH = shootBossH;
    }
    
    
}
