package com.owner.gaming.sprites;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KenPlayer extends Sprite {
	private BufferedImage [] damageImages = new BufferedImage[5];
	private BufferedImage punchImages [] = new BufferedImage[7];
	private BufferedImage walkImages [] = new BufferedImage[12];

	private BufferedImage standingImages [] = new BufferedImage[7];
	private BufferedImage kickImages [] = new BufferedImage[9];
	
	
	public KenPlayer() throws IOException {
		x = GWIDTH - 350;
		
		y = FLOOR - h;
		speed = 0;
		currentMove = STANDING;
		image = ImageIO.read(RyuPlayer.class.getResource(KEN_IMAGE));
		
		loadDamageImage();
		loadWalkImages();
		loadStandingImages();
		loadKickImages();
		loadPunchImages();
		
	}
	
	private void loadDamageImage() {
		damageImages[0] = image.getSubimage(1361, 3275, 67, 93);
		damageImages[1] = image.getSubimage(1437, 3273, 84, 100);
		damageImages[2] = image.getSubimage(1535, 3276, 81, 93);
		damageImages[3] = image.getSubimage(1628, 3277, 70, 96);
		damageImages[4] = image.getSubimage(1709, 3275, 65, 92);
	}
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(2030, 1151, 65, 92);
		punchImages[1] = image.getSubimage(1933, 1151, 94, 92);
		punchImages[2] = image.getSubimage(1866, 1151, 65, 92);
		punchImages[3] = image.getSubimage(1787, 1148, 76, 95);
		punchImages[4] = image.getSubimage(1667, 1148, 109, 95);
		punchImages[5] = image.getSubimage(1590, 1148, 77, 95);
		punchImages[6] = image.getSubimage(1520, 1148, 61, 95);
	}
	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(2037, 871, 53, 83);
		walkImages[1] = image.getSubimage(1966, 866, 62, 89);
		walkImages[2] = image.getSubimage(1893, 866, 64, 89);
		walkImages[3] = image.getSubimage(1819, 866, 63, 89);
		walkImages[4] = image.getSubimage(1754, 866, 58, 89);
		walkImages[5] = image.getSubimage(1689, 866, 52, 89);
		walkImages[6] = image.getSubimage(1620, 866, 61, 89);
		walkImages[7] = image.getSubimage(1551, 866, 59, 89);
		walkImages[8] = image.getSubimage(1480, 865, 60, 90);
		walkImages[9] = image.getSubimage(1408, 864, 61, 91);
		walkImages[10] = image.getSubimage(1337, 864, 60, 91);
		walkImages[11] = image.getSubimage(1265, 864, 61, 91);
	}
	private void loadKickImages() {
		kickImages[0] = image.getSubimage(1691, 1565, 65, 96);
		kickImages[1] = image.getSubimage(1624, 1565, 67, 93);
		kickImages[2] = image.getSubimage(1495, 1565, 117, 92);
		kickImages[3] = image.getSubimage(1428, 1564, 67, 93);
		kickImages[4] = image.getSubimage(1351, 1568, 65, 94);
		kickImages[5] = image.getSubimage(1240, 1567, 95, 95);
		kickImages[6] = image.getSubimage(1105, 1567, 123, 94);
		kickImages[7] = image.getSubimage(990, 1581, 102, 80);
		kickImages[8] = image.getSubimage(887, 1578, 66, 83);
	}
	private void loadStandingImages() {
		standingImages[0] = image.getSubimage(2036, 686, 61, 91);
		standingImages[1] = image.getSubimage(1966, 685, 60, 92);
		standingImages[2] = image.getSubimage(1900, 683, 56, 94);
		standingImages[3] = image.getSubimage(1829, 683, 60, 94);
		standingImages[4] = image.getSubimage(1759, 685, 61, 92);
		standingImages[5] = image.getSubimage(1690, 686, 63, 91);
		standingImages[6] = image.getSubimage(1622, 682, 56, 95);
	}
	
	
	
	public BufferedImage damageImage() {
		if(imageIndex>=5) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = damageImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage punchImage() {
		if(imageIndex>=7) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage walkImage() {
		if(imageIndex>=12) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage kickImage() {
		if(imageIndex>=9) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage standingImage() {
		if(imageIndex>=7) {
			imageIndex=0;
		}
		BufferedImage img = standingImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	@Override
	public BufferedImage defaultImage() {
		if(currentMove == DAMAGE) {
			return damageImage();
		}
		else if (currentMove == WALK) {
			return walkImage();
		}
		else if(currentMove == PUNCH) {
			return punchImage();
		}
		else if (currentMove == KICK) {
			return kickImage();
		}
		
			return standingImage();	
	}
	
}
