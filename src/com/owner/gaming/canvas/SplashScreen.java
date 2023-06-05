package com.owner.gaming.canvas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import jaco.mp3.player.MP3Player;

public class SplashScreen extends JWindow{
	private JLabel label = new JLabel();
	
	private MP3Player player;
	private void playSound() {
		player = new MP3Player(SplashScreen.class.getResource("sound.mp3"));
		player.play();
	}
	
	public SplashScreen() {
		setSize(1440,900);
		String img = "/Users/rachitagarwal/eclipse-workspace/Street_Fighter/src/com/owner/gaming/canvas/Splash.png";
		ImageIcon icon = new ImageIcon(img);
		label.setIcon(icon);
		this.add(label);
		setLocationRelativeTo(null);
		setVisible(true);
		playSound();
		try {
			Thread.sleep(5000);
			setVisible(false);
			dispose();
			player.stop();
			new GameFrame();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SplashScreen();
	}

}