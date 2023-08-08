package org.lokesh.Gapp;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PongGame extends JFrame implements ActionListener {
	  private static final long serialVersionUID = 1L;
	  private int x = 0, y = 0, velocityX = 2, velocityY = 2;
	  private Timer timer;

	  public PongGame() {
	    setSize(400, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    timer = new Timer(5, this);
	    timer.start();
	  }

	  public void paint(Graphics g) {
	    g.setColor(Color.RED);
	    g.fillOval(x, y, 50, 50);
	  }

	  public void actionPerformed(ActionEvent e) {
	    x = x + velocityX;
	    y = y + velocityY;
	    if (x < 0 || x > 350) {
	      velocityX = -velocityX;
	    }
	    if (y < 0 || y > 250) {
	      velocityY = -velocityY;
	    }
	    repaint();
	  }

	  public static void main(String[] args) {
	    new PongGame();
	  }
	}


