package parseo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import elementos.Fondo;
import plataformas.*;
import enemigos.*;
import powerUps.*;
import juego.*;
import observers.AdaptadorPosicionPixel;

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
		
		try {
			 BufferedImage mapImage = ImageIO.read(new File("imagenes/mapaRGBtest.png"));
	        // Obtengo las dimensiones de la imagen
	        int ancho = mapImage.getWidth();
	        int alto = mapImage.getHeight();
			
			int jugador = new Color(255, 0, 0).getRGB();
		  
			int bloqueTransparente = new Color(30, 110, 110).getRGB();
			int ladrilloSolido = new Color(0, 0, 255).getRGB();
			int vacio = new Color(110,60,0).getRGB();
			int preguntaMoneda = new Color(0, 255, 0).getRGB();
			int preguntaSuperChampi = new Color(255, 100, 0).getRGB();
			int preguntaChampiVerde = new Color(0, 100, 0).getRGB();
			int preguntaFlorDeFuego = new Color(0, 255, 255).getRGB();
			int preguntaEstrella = new Color(115, 0, 255).getRGB();
			int tuberiaSinPiranha = new Color(255,255,0).getRGB();
			//int tuberiaRelleno = new Color(200,255,0).getRGB();
			
			int goomba = new Color(255, 0, 255).getRGB();
			int koopa = new Color(255, 255, 255).getRGB();
			//int lakitu = new Color(60, 255, 150).getRGB();
			int buzzy = new Color(255, 125, 125).getRGB();
			int spiny = new Color(255,200,125).getRGB();
			
			/* int bloqueSolido = new Color(255, 0, 0).getRGB();
			int tuberiaPiranha = new Color(250, 50, 100).getRGB();	
			*/
			//Colores provisorios, testeo de power ups
			int moneda = new Color(255, 180, 0).getRGB();
			int superChamp = new Color(24, 16, 112).getRGB();
			int florFuego = new Color(16, 112, 104).getRGB();
			int estrella = new Color(115, 0, 60).getRGB();
			int champVerde = new Color(25, 135, 50).getRGB();
			
			
			double multiplicadorPixel = 36.8;
		    for (int x = 0; x < ancho; x++) {
		    	for (int y = 0; y < alto; y++) {
	
		            int colorPixelActual = mapImage.getRGB(x, y);
		            
		            int xLocation = AdaptadorPosicionPixel.transformarX((int) (x*multiplicadorPixel));
		            int yLocation = AdaptadorPosicionPixel.transformarY((int) (y*multiplicadorPixel));
		            //int xLocation = (int) (x*multiplicadorPixel);
		            //int yLocation = (int) (y*multiplicadorPixel);
		
		            if (colorPixelActual == jugador) {
		            	Jugador jugadorCreado = fabrica.crearJugador(xLocation, yLocation);
	                	nivelCreado.agregarJugador(jugadorCreado);
	                	jugadorCreado.setNivel(nivelCreado);
	                	
	                }else if (colorPixelActual == ladrilloSolido) {
	                	LadrilloSolido ladrilloCreado = fabrica.crearLadrilloSolido(xLocation,yLocation);
	                	nivelCreado.agregarPlataforma(ladrilloCreado);
	                	
	                }else if (colorPixelActual == goomba) {
	                    Goomba goombaCreado = fabrica.crearGoomba(xLocation, yLocation);
	                    nivelCreado.agregarEnemigo(goombaCreado);
	                }else if (colorPixelActual == preguntaMoneda) {
	                	BloqueDePregunta bloqueCreado = fabrica.crearBloqueDePregunta(xLocation, yLocation);
	                	bloqueCreado.setPowerUp("Moneda");
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }else if (colorPixelActual == tuberiaSinPiranha) {
	                	Tuberia tuberiaCreada = fabrica.crearTuberias(xLocation, yLocation + 36);
	                	tuberiaCreada.poseePiranha(false);
	                	nivelCreado.agregarPlataforma(tuberiaCreada);
	                }		            
	                else if (colorPixelActual == preguntaSuperChampi) {
	                	BloqueDePregunta bloqueCreado = fabrica.crearBloqueDePregunta(xLocation, yLocation);
	                	bloqueCreado.setPowerUp("SuperChampiñon");
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }
	                else if (colorPixelActual == preguntaChampiVerde) {
	                	BloqueDePregunta bloqueCreado = fabrica.crearBloqueDePregunta(xLocation, yLocation);
	                	bloqueCreado.setPowerUp("ChampiñonVerde");
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }	                
	                else if (colorPixelActual == vacio) {
	                   Vacio vacioCreado = fabrica.crearVacio(xLocation, yLocation + 3);
	                   nivelCreado.agregarPlataforma(vacioCreado);
	                }
	                else if (colorPixelActual == preguntaFlorDeFuego) {
	                	BloqueDePregunta bloqueCreado = fabrica.crearBloqueDePregunta(xLocation, yLocation);
	                	bloqueCreado.setPowerUp("FlorDeFuego");
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }
	                else if(colorPixelActual == preguntaEstrella){
	                	BloqueDePregunta bloqueCreado = fabrica.crearBloqueDePregunta(xLocation, yLocation);
	                	bloqueCreado.setPowerUp("Estrella");
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }
	                else if(colorPixelActual == koopa) {
	                	Koopa koopaCreado = fabrica.crearKoopa(xLocation, yLocation + 13);
	                	nivelCreado.agregarEnemigo(koopaCreado);
	                }
	                else if(colorPixelActual == bloqueTransparente) {
	                	BloqueSolido bloqueCreado = fabrica.crearBloqueSolido(xLocation, yLocation);
	                	nivelCreado.agregarPlataforma(bloqueCreado);
	                }/*
	                else if(colorPixelActual == lakitu) {
	                	Lakitu lakituCreado = fabrica.crearLakitu(xLocation, yLocation);
	                	nivelCreado.agregarEnemigo(lakituCreado);
	                }*/
	                else if(colorPixelActual == buzzy) {
	                	Buzzy buzzyCreado = fabrica.crearBuzzy(xLocation, yLocation);
	                	nivelCreado.agregarEnemigo(buzzyCreado);
	                }
	                else if(colorPixelActual == spiny) {
	                	Spiny spinyCreado = fabrica.crearSpiny(xLocation, yLocation);
	                	nivelCreado.agregarEnemigo(spinyCreado);
	                }
	                else if(colorPixelActual == moneda) {
	                	Moneda monedaCreada = fabrica.crearMoneda(xLocation, yLocation);
	                	nivelCreado.agregarPowerUp(monedaCreada);
	                }
	                else if(colorPixelActual == superChamp) {
	                	SuperChampiñon superChampCreado = fabrica.crearSuperChampiñon(xLocation, yLocation);
	                	nivelCreado.agregarPowerUp(superChampCreado);
	                }
	                else if(colorPixelActual == florFuego) {
	                	FlorDeFuego florFuegoCreada = fabrica.crearFlorDeFuego(xLocation, yLocation);
	                	nivelCreado.agregarPowerUp(florFuegoCreada);
	                }
	                else if(colorPixelActual == estrella) {
	                	Estrella estrellaCreada = fabrica.crearEstrella(xLocation, yLocation);
	                	nivelCreado.agregarPowerUp(estrellaCreada);
	                }
	                else if(colorPixelActual == champVerde) {
	                	ChampiñonVerde champiñonVerdeCreado = fabrica.crearChampiñonVerde(xLocation, yLocation);
	                	nivelCreado.agregarPowerUp(champiñonVerdeCreado);
	                }
	            }
	        }
		}  catch (IOException e) {
           System.out.println("Error al cargar la imagen: " + e.getMessage());
		}
		
	}

	
	public Nivel getNivel() {
		return this.nivelCreado;
	}
	
	
}
