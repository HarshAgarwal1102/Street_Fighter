package com.owner.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RyuPlayer extends Sprite  {
	private BufferedImage walkImages [] = new BufferedImage[6];
	private BufferedImage damageImages [] = new BufferedImage[2];
	private BufferedImage standingImages [] = new BufferedImage[8];
	private BufferedImage kickImages [] = new BufferedImage[6];
	private BufferedImage punchImages [] = new BufferedImage[6];
	public RyuPlayer() throws IOException {
		x = 100;
		y = FLOOR - h;
		speed = 0;
		currentMove = STANDING;
		image = ImageIO.read(RyuPlayer.class.getResource(RYU_IMAGE));
		
		loadWalkImages();
		loadStandingImages();
		loadKickImages();
		loadPunchImages();
		loadDamageImages();
	}
	
	public void jump() {
		if(!isJump) {
		force = DEFAULT_FORCE;
		y = y + force;
		isJump = true;
		}
	}
	
	public void fall() {
		if(y>= (FLOOR - h)) {
			isJump = false;
			return ;
		}
		force = force + GRAVITY;
		y = y + force;
	}
	
	private void loadWalkImages() {
		walkImages[0]  = image.getSubimage(60, 236,77,98);
		walkImages[1]  = image.getSubimage(142, 235,77,98);
		walkImages[2]  = image.getSubimage(225,236,60,98);
		walkImages[3]  = image.getSubimage(304, 233,58,98);
		walkImages[4]  = image.getSubimage(377, 234,59,99);
		walkImages[5]  = image.getSubimage(453, 239,65,96);
	}
	
	private void loadStandingImages() {
		standingImages[0] = image.getSubimage(14, 4, 73, 106);
		standingImages[1] = image.getSubimage(87, 4, 68, 107);
		standingImages[2] = image.getSubimage(164, 4, 72, 108);
		standingImages[3] = image.getSubimage(241,1,72,110);
		standingImages[4] = image.getSubimage(321, 6, 70, 107);
		standingImages[5] = image.getSubimage(396, 4, 61, 105);
		standingImages[6] = image.getSubimage(464, 4, 62, 109);
		standingImages[7] = image.getSubimage(534, 4, 63, 109);
	}
	
	private void loadKickImages() {
		kickImages[0] = image.getSubimage(40, 1047, 67, 94);
		kickImages[1] = image.getSubimage(121,1046,65,94);
		kickImages[2] = image.getSubimage(200, 1051, 118, 90);
		kickImages[3] = image.getSubimage(330, 1048, 64, 94);
		kickImages[4] = image.getSubimage(409, 1051, 63, 90);
		kickImages[5] = image.getSubimage(485, 1049, 86, 94);
				
	}
	
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(27, 823, 66, 94);
		punchImages[1] = image.getSubimage(106, 822, 73, 96);
		punchImages[2] = image.getSubimage(189, 823, 110, 93);
		punchImages[3] = image.getSubimage(311, 822, 80, 93);
		punchImages[4] = image.getSubimage(404, 822, 103, 92);
		punchImages[5] = image.getSubimage(516, 822, 79, 94);
	}
	
	private void loadDamageImages() {
		damageImages[0] = image.getSubimage(247, 2534, 73, 92);
		damageImages[1] = image.getSubimage(333, 2533, 74, 91);
	}
	
	public BufferedImage damageImage() {
		if(imageIndex>=2) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = damageImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage walkImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage kickImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage punchImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage standingImage() {
		if(imageIndex>7) {
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