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
public class MShoot extends ObjectShot{
    private boolean visible;
    private final ImageIcon reference_Mshoot = new ImageIcon("resource//MTesteBeam.gif");
    private Image Mshoot = reference_Mshoot.getImage();
    
    private int MshootW = reference_Mshoot.getIconWidth();
    private int MshootH = reference_Mshoot.getIconHeight();

    
    public MShoot(int x, int y){
        super(x, y);
        visible = true;
    }
    
    public void Movement(){
        x -= 3;
        if(x <= 0){
            visible = false;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getMshoot() {
        return Mshoot;
    }

    public void setMshoot(Image Mshoot) {
        this.Mshoot = Mshoot;
    }

    public int getMshootW() {
        return MshootW;
    }

    public void setMshootW(int MshootW) {
        this.MshootW = MshootW;
    }

    public int getMshootH() {
        return MshootH;
    }

    public void setMshootH(int MshootH) {
        this.MshootH = MshootH;
    }
    
}
