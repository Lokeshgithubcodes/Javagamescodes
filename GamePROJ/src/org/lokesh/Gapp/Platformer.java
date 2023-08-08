package org.lokesh.Gapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platformer extends JPanel {
  private int playerX=0;
  private int playerY=0;
  private int playerVelocity=0;
  public Platformer() {
	  addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				playerX -=10;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				playerX +=10;
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				playerVelocity=-20;
			}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
		
		}
	});
	  setFocusable(true);
  }
  public void move() {
	  playerY += playerVelocity;
	  playerVelocity +=2;
	  if(playerY>500) {
		  playerY=500;
		  playerVelocity=0;
	  }
  }
  public void paint(Graphics g) {
	  super.paint(g);
	  g.setColor(Color.RED);
	  g.fillRect(playerX, playerY, 50, 50);
  }
  public static void main(String[] args) {
	JFrame frame=new JFrame("Simple Platformer");
	Platformer game=new Platformer();
	frame.add(game);
	frame.setSize(600, 600);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while(true) {
		game.move();
		game.repaint();
		try {
			Thread.sleep(17);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
