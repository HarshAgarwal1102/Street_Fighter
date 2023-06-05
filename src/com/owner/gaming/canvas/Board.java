package com.owner.gaming.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.owner.gaming.sprites.KenPlayer;
import com.owner.gaming.sprites.Power;
import com.owner.gaming.sprites.RyuPlayer;
import com.owner.gaming.utils.GameConstants;
import com.owner.gaming.utils.PlayerConstants;


public class Board extends JPanel implements GameConstants, PlayerConstants {
	BufferedImage imageBg;
	private RyuPlayer ryuPlayer;
	private KenPlayer kenPlayer;
	private Timer timer;
	private Power ryuPower;
	private Power kenPower;
	private boolean isGameOver ; 
	
	public Board() throws IOException  {
		loadBackgroundImage();
		ryuPlayer = new RyuPlayer();
		kenPlayer = new KenPlayer();
		setFocusable(true);
		bindEvents();
		gameLoop();
		loadPower();
	}
	
	private void loadPower() {
		ryuPower = new Power(50, "Ryu".toUpperCase());
		kenPower = new Power(GWIDTH/2+150, "Ken".toUpperCase());
	}
	
	private void paintPower(Graphics pen) {
		ryuPower.printBox(pen);
		kenPower.printBox(pen);
	}
	
	public void collision() {
		if(isCollide()) {
			if(ryuPlayer.isAttacking() && kenPlayer.isAttacking()) {
				kenPlayer.setCurrentMove(DAMAGE);
				kenPower.setHealth();
				ryuPlayer.setCurrentMove(DAMAGE);
				ryuPower.setHealth();
			}
			else if(ryuPlayer.isAttacking()) {
				kenPlayer.setCurrentMove(DAMAGE);
				kenPower.setHealth();
			}
			else if(kenPlayer.isAttacking()) {
				ryuPlayer.setCurrentMove(DAMAGE);
				ryuPower.setHealth();
			}
			if(kenPower.getHealth()<=0 || ryuPower.getHealth()<=0) {
				isGameOver = true;
			}
			ryuPlayer.setCollide(true);
			ryuPlayer.setSpeed(0);
			kenPlayer.setCollide(true);
			kenPlayer.setSpeed(0);
		}
		else {
			ryuPlayer.setSpeed(SPEED);
			kenPlayer.setSpeed(SPEED);
		}
	}
	
	private void printMessage(Graphics pen) {
		pen.setColor(Color.RED);
		pen.setFont(new Font("times",Font.BOLD, 50));
		pen.drawString("Game Over", GWIDTH/2-145, GHEIGHT/2-270);
	}
	
	private boolean isCollide() {
		int xDistance = Math.abs(ryuPlayer.getX() - kenPlayer.getX());
		int yDistance = Math.abs(ryuPlayer.getY() - kenPlayer.getY());
		int maxW = Math.max(ryuPlayer.getW(), kenPlayer.getW());
		int maxH = Math.max(ryuPlayer.getH(), kenPlayer.getH());
		return xDistance<=maxW-10 && yDistance<=maxH;
	}
	
	private void gameLoop() {
		// Thread Trigger
		timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				ryuPlayer.fall();
				collision();
				// TODO Auto-generated method stub
			}
		});
		timer.start();
	}
	
	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				ryuPlayer.setSpeed(0);
				kenPlayer.setSpeed(0);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					ryuPlayer.setSpeed(-SPEED);
					ryuPlayer.setCurrentMove(WALK);
					ryuPlayer.move();
					ryuPlayer.setCollide(false);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(ryuPlayer.isCollide()) {
						ryuPlayer.setSpeed(0);
					}
					else {
						ryuPlayer.setCollide(false);
						ryuPlayer.setSpeed(SPEED);
					}
					ryuPlayer.setCurrentMove(WALK);
					ryuPlayer.move();
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_K) {
					ryuPlayer.setAttacking(true);
					ryuPlayer.setCurrentMove(KICK);
				}
				else if(e.getKeyCode() == KeyEvent.VK_P) {
					ryuPlayer.setAttacking(true);
					ryuPlayer.setCurrentMove(PUNCH);
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					ryuPlayer.jump();
				}
				// Ken 
				else if (e.getKeyCode() == KeyEvent.VK_J) {
					if(kenPlayer.isCollide()) {
						kenPlayer.setSpeed(0);
					}
					else {
						kenPlayer.setCollide(false);
						kenPlayer.setSpeed(-SPEED);
					}
						kenPlayer.move();
						//repaint();
						kenPlayer.setCurrentMove(WALK);
				}
				else if (e.getKeyCode() == KeyEvent.VK_L) {
					kenPlayer.setCollide(false);
					kenPlayer.setSpeed(SPEED);
					kenPlayer.setCurrentMove(WALK);
					kenPlayer.move();
//					repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_F) {
					kenPlayer.setAttacking(true);
					kenPlayer.setCurrentMove(KICK);
				}
				else if(e.getKeyCode() == KeyEvent.VK_G) {
					kenPlayer.setAttacking(true);
					kenPlayer.setCurrentMove(PUNCH);
				}
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics pen) {
		// Rendering / Painting
		super.paintComponent(pen);
		printBackgroundImage(pen);
		ryuPlayer.printPlayer(pen);
		kenPlayer.printPlayer(pen);
		paintPower(pen);
		if(isGameOver) {
			printMessage(pen);
			timer.stop();
		}
	}

	private void printBackgroundImage(Graphics pen) {
		pen.drawImage(imageBg,0,0, GWIDTH,GHEIGHT, null);
	}
	
	private void loadBackgroundImage() {
		try {
			imageBg = ImageIO.read(Board.class.getResource("bg.jpeg"));
			}
			catch(Exception ex) {
				System.out.println("Background Image Loading Fail...");
				System.exit(0);
			
			}
		
	}
}