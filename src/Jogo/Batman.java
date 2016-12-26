/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class Batman {
    
    private int x, y;
    private int health = 10;
    private Image batman;
    private boolean shoot=true;
    private List<BatmanShoot> batmanShoot;
    
    private final ImageIcon reference_BatmanStand = new ImageIcon("resource\\BatmanStand.gif");
    private final ImageIcon reference_BatmanLaunching = new ImageIcon("resource\\BatmanLaunching.gif");
    private final ImageIcon reference_Boomerang = new ImageIcon("resource\\BatmanBoomerang.gif");
    
    private final int largura = reference_Boomerang.getIconWidth();
    
    private int BatmanW = reference_BatmanStand.getIconWidth()/2;
    private int BatmanH = reference_BatmanLaunching.getIconHeight();
    
    
    public Batman() {
        this.x = 600;
        this.y = 230;
        batmanShoot = new ArrayList<BatmanShoot>();
        this.batman = reference_BatmanStand.getImage();
    }
    
    
    public void animacao(){
        if(shoot){
            this.batman = reference_BatmanLaunching.getImage();
        }else if(!shoot){
            this.batman = reference_BatmanStand.getImage();
        }
    }
    
    
    public void Shooting(){
        BatmanShoot bs = new BatmanShoot();
        bs.setX(x-largura/4);
        bs.setY(y);
        this.batmanShoot.add(bs);
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
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

    public Image getBatman() {
        return batman;
    }

    public void setBatman(Image batman) {
        this.batman = batman;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public List<BatmanShoot> getBatmanShoot() {
        return batmanShoot;
    }

    public void setBatmanShoot(List<BatmanShoot> batmanShoot) {
        this.batmanShoot = batmanShoot;
    }

    public int getBatmanW() {
        return BatmanW;
    }

    public void setBatmanW(int BatmanW) {
        this.BatmanW = BatmanW;
    }

    public int getBatmanH() {
        return BatmanH;
    }

    public void setBatmanH(int BatmanH) {
        this.BatmanH = BatmanH;
    }

    
}
