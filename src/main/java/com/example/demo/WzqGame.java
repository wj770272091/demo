package com.example.demo;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @NAME: mainTest
 * @USER: 77027
 * @DATE: 2020/10/23
 * @TIME: 14:38
 */
public class WzqGame {
    /**
     * 亨元模式样例
     */
    public static void main(String[] args) {
        new Chessboard();
    }
}

    class Chessboard extends MouseAdapter {
        WeiqiFactory weiqiFactory;
        JFrame jFrame;
        Graphics graphics;
        JRadioButton wz;
        JRadioButton bz;
        private final int x=50;
        private final int y=50;
        private final int w=40;    //小方格宽度和高度
        private final int rw=400;    //棋盘宽度和高度
        Chessboard(){
            weiqiFactory=new WeiqiFactory();
         jFrame=new JFrame("五子棋");
            jFrame.setBounds(100,100,500,550);
            jFrame.setVisible(true);
            jFrame.setResizable(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel jPanel=new JPanel();
            jFrame.add("South",jPanel);
            wz=new JRadioButton("白子");
            bz=new JRadioButton("黑子",true);
            ButtonGroup group=new ButtonGroup();
            group.add(wz);
            group.add(bz);
            jPanel.add(wz);
            jPanel.add(bz);
            JPanel jPanel2=new JPanel();
            jPanel2.setLayout(null);
            jPanel2.setSize(500, 500);
            jPanel2.addMouseListener(this);
            jFrame.add("Center",jPanel2);
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            graphics=jPanel2.getGraphics();
            graphics.setColor(Color.BLUE);
            graphics.drawRect(x, y, rw, rw);
            for(int i=1;i<10;i++)
            {
                //绘制第i条竖直线
                graphics.drawLine(x+(i*w),y,x+(i*w),y+rw);
                //绘制第i条水平线
                graphics.drawLine(x,y+(i*w),x+rw,y+(i*w));
            }
        }
        @Override
        public void mouseClicked(MouseEvent e)
        {
            Point pt=new Point(e.getX()-15,e.getY()-15);
            if(wz.isSelected())
            {
                Chesgoodsieces c1=weiqiFactory.getChesgoodsieces("w");
                c1.DownPieces(graphics,pt);
            }
            else if(bz.isSelected())
            {
                Chesgoodsieces c2=weiqiFactory.getChesgoodsieces("b");
                c2.DownPieces(graphics,pt);
            }
        }
    }

    interface Chesgoodsieces {
        void DownPieces(Graphics g, Point pt);
    }

    class WhitePieces implements Chesgoodsieces {

        @Override
        public void DownPieces(Graphics g, Point pt) {
            g.setColor(Color.WHITE);
            g.fillOval(pt.x, pt.y, 30, 30);
        }
    }

    class BlackPieces implements Chesgoodsieces {

        @Override
        public void DownPieces(Graphics g, Point pt) {
            g.setColor(Color.BLACK);
            g.fillOval(pt.x, pt.y, 30, 30);
        }
    }

    class WeiqiFactory {
        private ArrayList<Chesgoodsieces> qz;

        public WeiqiFactory() {
            qz = new ArrayList<Chesgoodsieces>();
            qz.add(new WhitePieces());
            qz.add(new BlackPieces());

        }

        public Chesgoodsieces getChesgoodsieces(String type) {
            if (type.equalsIgnoreCase("w")) {
                return qz.get(0);
            } else if (type.equalsIgnoreCase("b")) {
                return qz.get(1);
            } else {
                return null;
            }
        }
    }

