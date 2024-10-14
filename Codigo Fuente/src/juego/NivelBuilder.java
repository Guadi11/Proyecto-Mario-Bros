package juego;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import elementos.Fondo;
import plataformas.LadrilloSolido;

public class NivelBuilder {
	protected GameFactory fabrica;
	protected Nivel nivelCreado;
	protected int numNivel;
	
	public NivelBuilder(GameFactory factory, int nivelACrear) {
		this.fabrica = factory;
		this.numNivel = nivelACrear;
		this.nivelCreado = new Nivel(); 
		crearNivel();
		
	}
	
	private void crearNivel() {
		/*Fondo fondoCreado = fabrica.crearFondo(0, 0);
    	nivelCreado.agregarFondo(fondoCreado);*/
		
		
		try {
			 BufferedImage mapImage = ImageIO.read(new File("imagenes/mapaRGB.png"));
		

	        // Obtener las dimensiones de la imagen
	        int ancho = mapImage.getWidth();
	        int alto = mapImage.getHeight();
			
			
			int jugador = new Color(255, 0, 0).getRGB();
		  
			int ladrilloSolido = new Color(0, 0, 255).getRGB();
			/* int bloqueSolido = new Color(255, 0, 0).getRGB();
			int vacio = new Color(255, 0, 255).getRGB();
		  
			int tuberiaPiranha = new Color(0, 255, 255).getRGB();
			int tuberiaSinPiranha = new Color(0,0,0).getRGB();
			
			//me encanrgo de crear ambos, setearle el PU al bloque y agregar ambos a nivelCreado
			int preguntaMoneda = new Color(0, 0, 255).getRGB();
			int preguntaSuperChampiñon = new Color(0, 0, 255).getRGB();
			int preguntaChampiñonVerde = new Color(0, 0, 255).getRGB();
			int preguntaEstrella = new Color(0, 0, 255).getRGB();
			int preguntaFlorDeFuego = new Color(0, 0, 255).getRGB();
			
			int goomba = new Color(0, 255, 0).getRGB();
			int koopa = new Color(160, 0, 160).getRGB();
			int lakitu = new Color(160, 0, 160).getRGB();
			int buzzy = new Color(160, 0, 160).getRGB();
			*/
			int multiplicadorPixel = 36;
			System.out.println("LLego hasta antes del for. NivelBuilder");
		    for (int x = 0; x < ancho; x++) {
		    	for (int y = 0; y < alto; y++) {
	
		            int colorPixelActual = mapImage.getRGB(x, y);
		            int xLocation = x*multiplicadorPixel;
		            int yLocation = y*multiplicadorPixel;
		
		            if (colorPixelActual == jugador) {
		            	Jugador jugadorCreado = fabrica.crearJugador(xLocation, yLocation);
	                	nivelCreado.agregarJugador(jugadorCreado);
	                }
	                else if (colorPixelActual == ladrilloSolido) {
	                	LadrilloSolido ladrilloCreado = fabrica.crearLadrilloSolido(xLocation,yLocation);
	                	nivelCreado.agregarPlataforma(ladrilloCreado);
	                } /*
	                else if (colorPixelActual == bloqueSolido) {
	                    
	                }
	                else if (colorPixelActual == vacio) {
	                    
	                }
	                else if (colorPixelActual == goomba) {
	                    
	                }
	                else if (colorPixelActual == koopa) {
	                   
	                }
	                else if (colorPixelActual == mario) {
	                   
	                }
	                else if(colorPixelActual == end){
	                    
	                } */
	            }
	        }
		    System.out.println("LLego hasta despues del for. NivelBuilder");
		}  catch (IOException e) {
           System.out.println("Error al cargar la imagen: " + e.getMessage());
		}
		
	}

	
	public Nivel getNivel() {
		return this.nivelCreado;
	}
	
	
}
