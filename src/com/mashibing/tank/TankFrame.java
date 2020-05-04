package com.mashibing.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import com.mashibing.tank.Bullet;

/**
 * @author hulinqi
 * @date 2020/4/20 --  19:23
 * @purpuse
 */
public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();
    Tank myTank = new Tank(200,400,Dir.UP,this, Group.GOOD);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> enermies = new ArrayList<>();
    List<Explore> exploreList = new ArrayList<>();
    Explore e = new Explore(100,100,this);
    Bullet bullet = new Bullet(300,300,Dir.DOWN,this,Group.GOOD);
    static final int GAME_WIDTH = 1000 , GAME_HEIGTH = 800;

    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH,GAME_HEIGTH);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListenner());

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image OffScreenImage = null;
    @Override
    public void update(Graphics g){
        if(OffScreenImage == null){
            OffScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGTH);
        }

        Graphics gOffScreen = OffScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGTH);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(OffScreenImage,0,0,null);

    }

    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.drawString("敌人的数量："+enermies.size(),10,80);
        g.drawString("爆炸的数量："+exploreList.size(),10,100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++ ){
           bullets.get(i).paint(g);
        }

        for (int i = 0; i < enermies.size(); i++ ){
            enermies.get(i).paint(g);
        }
        
        for (int i = 0; i < bullets.size(); i++ ){
            for (int j = 0; j < enermies.size(); j++ ){
                bullets.get(i).collideWith(enermies.get(j));
            }
        }

        for (int i = 0; i < exploreList.size(); i++ ){
            exploreList.get(i).paint(g);
        }
    }

    class MyKeyListenner extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;

                default:
                    break;
            }

        }


        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        private void setTankDir() {
            if(!bL && !bU && !bR && !bD) myTank.setMoving(false);
            else{
                myTank.setMoving(true);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bU) myTank.setDir(Dir.UP);
                if(bR) myTank.setDir(Dir.RIGHT);
                if(bD) myTank.setDir(Dir.DOWN);
            }

        }

    }

}
