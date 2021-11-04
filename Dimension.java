// in java.util.Formatter
/**
 *  Representa una dimensión
 *  
 *  @author - Aritz Ciriza
 */
public class Dimension  
{
    private double alto;
    private double ancho;
    private double largo;

    /**
     * constructor  
     */
    public Dimension(double alto, double ancho, double largo)    {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;

    }   

    /**
     * accesor para  el alto
     */
    public double getAlto()    {
        return alto;
    }

    /**
     * accesor para  el ancho
     */
    public double getAncho()    {
        return ancho;
    }

    /**
     * accesor para  el largo
     */
    public double getLargo()    {
        return largo;
    }

    /**
     * Devuelve una copia exacta al objeto actual
     */
    public Dimension obtenerCopia() {
        Dimension copia = new Dimension(alto, ancho, largo);

        return copia;
    }

    /**
     * Repesentación textual de la dimensión
     * (leer enunciado)
     */
    public String toString() {
        String cadena ="";
        cadena += String.format("%20s" +"%10.2f" + "%-10s","Alto: ",alto,  "(cm)"+ "\n" );
        cadena += String.format("%20s" +"%10.2f" + "%-10s","Ancho: ",ancho,"(cm)" + "\n");
        cadena += String.format("%20s" +"%10.2f" + "%-10s","Largo: ",largo,"(cm)"+ "\n");
        return cadena;
    }

    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Dimension
     */
    public void print() {
        System.out.println(this.toString());
    }

}
