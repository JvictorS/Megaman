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
public final class LifeBar {
    static int x, y;
    
    
    private static final ImageIcon reference_playerLifeBar100 = new ImageIcon("resource//playerLifeBar100.png");
    private static final ImageIcon reference_playerLifeBar90 = new ImageIcon("resource//playerLifeBar90.png");
    private static final ImageIcon reference_playerLifeBar80 = new ImageIcon("resource//playerLifeBar80.png");
    private static final ImageIcon reference_playerLifeBar70 = new ImageIcon("resource//playerLifeBar70.png");
    private static final ImageIcon reference_playerLifeBar60 = new ImageIcon("resource//playerLifeBar60.png");
    private static final ImageIcon reference_playerLifeBar50 = new ImageIcon("resource//playerLifeBar50.png");
    private static final ImageIcon reference_playerLifeBar40 = new ImageIcon("resource//playerLifeBar40.png");
    private static final ImageIcon reference_playerLifeBar30 = new ImageIcon("resource//playerLifeBar30.png");
    private static final ImageIcon reference_playerLifeBar20 = new ImageIcon("resource//playerLifeBar20.png");
    private static final ImageIcon reference_playerLifeBar10 = new ImageIcon("resource//playerLifeBar10.png");
    
    private static Image lifeBar;
    
    private final static LifeBar instance = new LifeBar();
        
    private LifeBar(){
        lifeBar = reference_playerLifeBar100.getImage();
        x = 10;
        y = 20;
    }
    
    public static LifeBar getInstance(){
        return instance;
    }

    public static Image getLifeBar() {
        return lifeBar;
    }
    
    public static void lifeUpdate(int n){
        switch(n){
            case 90:
                lifeBar = reference_playerLifeBar90.getImage();
                break;
            case 80:
                lifeBar = reference_playerLifeBar80.getImage();
                break;
            case 70:
                lifeBar = reference_playerLifeBar70.getImage();
                break;
            case 60:
                lifeBar = reference_playerLifeBar60.getImage();
                break;
            case 50:
                lifeBar = reference_playerLifeBar50.getImage();
                break;
            case 40:
                lifeBar = reference_playerLifeBar40.getImage();
                break;
            case 30:
                lifeBar = reference_playerLifeBar30.getImage();
                break;
            case 20:
                lifeBar = reference_playerLifeBar20.getImage();
                break;
            case 10:
                lifeBar = reference_playerLifeBar10.getImage();
                break;
            case 0:
                Controls.gameJFrame.dispose();
                break;
            default:break;
        }
    }
}
