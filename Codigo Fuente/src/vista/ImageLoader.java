package vista;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
	public int indX,indY,ancho,largo;
	public int cantidadSpritesGrande=8;
	public int cantidadSpritesNormal=7;
	public BufferedImage[] spritesSuperMario, spritesNormal, spritesFuego, spritesInvencibleGrande, spritesInvencibleNormal;
	private BufferedImage marioSheets= loadImage("/colores estrella.png");
	
	public ImageLoader() {
		spritesSuperMario= new BufferedImage [cantidadSpritesGrande];
    	spritesFuego= new BufferedImage [cantidadSpritesGrande];
    	spritesNormal= new BufferedImage [cantidadSpritesNormal];
    	spritesInvencibleGrande= new BufferedImage [cantidadSpritesGrande];
    	spritesInvencibleNormal= new BufferedImage [cantidadSpritesNormal];
	}
	 public void cargarImagenes() {
	    	setSpritesSuperMario();
	    	setSpritesNormal();
	    	setSpritesFuego();
	    	setSpritesInvencibleGrande();
	    	setSpritesInvencibleNormal();
	    }
	
	public BufferedImage loadImage(String path){
	        BufferedImage imageToReturn = null;

	        try {
	            imageToReturn = ImageIO.read(getClass().getResource("/imagenes" + path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return imageToReturn;
	}

	public BufferedImage loadImage(File file){
	        BufferedImage imageToReturn = null;

	        try {
	            imageToReturn = ImageIO.read(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return imageToReturn;
	}
	public void setSpritesSuperMario() {
        indX=80;
		indY=0;
		ancho=16;
		largo= 31;
		for (int i=0; i<cantidadSpritesGrande-1; i++) {
			spritesSuperMario[i]=marioSheets.getSubimage(indX + i*(ancho+1), indY, ancho, largo); }
	}

	public void setSpritesFuego() {
        indX=80;
		indY=48;
		ancho=16;
		largo= 31;
		for (int i=0; i<cantidadSpritesGrande-1; i++) {
			spritesFuego[i]=marioSheets.getSubimage(indX + i*(ancho+1), indY, ancho, largo);
		}
		spritesFuego[7]=marioSheets.getSubimage(indX + 7*(ancho+1), indY, ancho, largo);
	}

	public void setSpritesNormal() {
        indX=80;
		indY=32;
		ancho=16;
		largo= 15;
		for (int i=0; i<cantidadSpritesNormal; i++) {
			spritesNormal[i]=marioSheets.getSubimage(indX + i*(ancho+1), indY, ancho, largo);
			}
	}

	public void  setSpritesInvencibleGrande() {
        indX=80;
		indY=144;
		ancho=16;
		largo= 32;
		/*int cantidadColores=0;
		while (cantidadColores<3) {*/
		for (int i=0/*+(8*cantidadColores)*/ ; i<cantidadSpritesGrande-1; i++) {
			spritesInvencibleGrande[i]=marioSheets.getSubimage(indX + i*(ancho+1), indY, ancho, largo);
			}
		spritesInvencibleGrande[7]=marioSheets.getSubimage(indX + 7*(ancho+1), indY, ancho, largo);
		indY+=48;
		//cantidadColores++;}
	}
	public void  setSpritesInvencibleNormal() {
        indX=80;
		indY=176;
		ancho=16;
		largo= 16;
		/*int contadorColores=0;
		while (contadorColores<3) {*/
		for (int i=0; i<cantidadSpritesGrande-1; i++) {
			spritesInvencibleNormal[i]=marioSheets.getSubimage(indX + i*(ancho+1), indY, ancho, largo);
			}
		indY+=48;
		//contadorColores++;
		}
	public BufferedImage[] getSpritesSuperMario() {
    	return spritesSuperMario;
    }
    public BufferedImage[] getSpritesNormal() {
    	return spritesNormal;
    }
    public BufferedImage[] getSpritesFuego() {
    	return spritesFuego;
    }
    public BufferedImage[] getSpritesInvencibleGrande() {
    	return spritesInvencibleGrande;
    }
    public BufferedImage[] getSpritesInvencibleNormal() {
    	return spritesInvencibleNormal;
    }
}
