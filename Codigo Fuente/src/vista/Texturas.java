package vista;

import java.awt.image.BufferedImage;

public class Texturas {

	private final String rutaCarpeta = "/imagenes";
	
	private final int cantidadSpritesGrande = 8;
	private final int cantidadSpritesNormal = 7; 
	
	
	private BufferedImageLoader loader;
	private BufferedImage spritesMario;
	//private BufferedImage spritesMario, spritesSuperMario, spritesFuego, spritesInvencibleGrande, spritesInvencibleNormal;
	private BufferedImage[]	superMario, marioNormal;
	
	public Texturas() {
		superMario = new BufferedImage[cantidadSpritesGrande];
		marioNormal = new BufferedImage[cantidadSpritesNormal];
		//inicializo los otros tiles que tenga
		
		loader = new BufferedImageLoader();
		
		try {
			spritesMario = loader.loadImage(rutaCarpeta + "/animacionesMario.png"); 
			//agregar uno por cada imagen con animaciones que tenga
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		getPlayerTextures();
		
	}
	
	private void getPlayerTextures() {
		int posicionX = 80;
		int posicionY = 1;
		int ancho = 16;
		int alto = 32;
		
		for(int i = 0; i < cantidadSpritesGrande; i++) {
			superMario[i] =  spritesMario.getSubimage(posicionX + i*(ancho+1), posicionY, ancho, alto);
		}
		
		posicionY += alto + 1;
		alto = 16;
		
		for(int i = 0; i < cantidadSpritesNormal; i++) {
			marioNormal[i] = spritesMario.getSubimage(posicionX + i*(ancho+1), posicionY, ancho, alto);
		}
	}

	public BufferedImage[] getSuperMario() {
		return superMario;
	}
	
	public BufferedImage[] getNormal() {
		return marioNormal;
	}
	
	
	
}
