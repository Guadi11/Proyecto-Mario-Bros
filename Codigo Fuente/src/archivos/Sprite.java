package archivos;


public class Sprite {

	protected String rutaImagen;
	
	public Sprite(String ruta) {
		this.rutaImagen = ruta;
	}
	
	public String getRutaImagen() {
		return this.rutaImagen;
	}
	
	public void setSprite(String ruta) {
		this.rutaImagen = ruta;
	}
	/*
	private void cargarImagen() {
		try {
            URL imageUrl = getClass().getClassLoader().getResource(rutaImagen);
            if (imageUrl == null) {
                System.err.println("Error: No se pudo encontrar la imagen en la ruta: " + rutaImagen);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al intentar cargar la imagen: " + rutaImagen);
        }
    }
	*/
}
