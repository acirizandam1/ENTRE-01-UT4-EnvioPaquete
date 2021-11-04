
/**
 *  Un objeto de esta clase representa un envío de varios paquetes,
 *  máximo tres
 *  
 * 
 * @author - Aritz Ciriza  
 *  
 */
public class Envio
{
    private final double PRECIO_KILO = 2.2;  // precio coste envío Kg. en euros
    private Paquete paquete1;
    private Paquete paquete2;
    private Paquete paquete3;

    /**
     * Constructor  
     * Inicializa los paquetes a null (inicialmente
     * el envío no tiene paquetes)
     */
    public Envio()    {
        this.paquete1 = null;
        this.paquete2 = null;
        this.paquete3 = null;

    }

    /**
     * accesor para el paquete1
     */
    public Paquete getPaquete1() {
        return paquete1;

    }

    /**
     * accesor para el paquete2
     */
    public Paquete getPaquete2() {
        return paquete2;

    }

    /**
     * accesor para el paquete3
     */
    public Paquete getPaquete3() {
        return paquete3;

    }

    /**
     * Devuelve el nº de paquetes en el envío
     * (dependerá de cuántos paquetes estén a null)
     */
    public int getNumeroPaquetes() {
        int paquetes = 0;
        if(paquete1 != null) {
            paquetes = 1;
        }
        if( paquete2 != null) {
            paquetes = 2;
        }
        if ( paquete3 != null) {
            paquetes =3;
        }
        return paquetes;
    }

    /**
     * Devuelve true si el envío está completo, false en otro caso
     * (tiene exactamente 3 paquetes)
     */
    public boolean envioCompleto() {
        return (paquete1 != null && paquete2 != null && paquete3 != null) ;

    }

    /**
     * Se añade un nuevo paquete al envío
     * Si el envío está completo se muestra
     * el mensaje "No se admiten más paquetes en el envío"
     * Si no está completo se añade el paquete al envío teniendo en cuenta
     * si se añade como primero, segundo o tercero (no han de quedar huecos)
     */
    public void addPaquete(Paquete paquete) {

        if(paquete1 == null) {
            this.paquete1 = paquete;
        }
        else if (paquete2 == null) {
            this.paquete2 = paquete;

        }
        else if(paquete3 == null) {
            this.paquete3 = paquete;

        }
        else if( paquete3 !=null) {
            System.out.println("No se admiten más paquetes en el envio");
        }
    }

    /**
     * Calcula y devuelve el coste total del envío
     * 
     * Para calcular el coste:
     *      - se obtiene el peso facturable de cada paquete 
     *      - se suman los pesos facturables de todos los paquetes del envío
     *      - se calcula el coste en euros según el precio del Kg 
     *      (cada Kg. no completo se cobra entero, 5.8 Kg. se cobran como 6, 5.3 Kg. se cobran como 6)
     *     
     *  
     */
    public double calcularCosteTotalEnvio() {
        double importe = 0 ;
        if(paquete2 == null && paquete3 == null ) {
            importe= Math.ceil(paquete1.calcularPesoFacturable());

        }
        else if (paquete3 == null) {
            importe = Math.ceil(paquete1.calcularPesoFacturable())+ Math.ceil(paquete2.calcularPesoFacturable());
        }
        else {
            importe = Math.ceil(paquete1.calcularPesoFacturable()) + Math.ceil(paquete2.calcularPesoFacturable()) + Math.ceil(paquete3.calcularPesoFacturable());
        }
        double importeTotal = importe * PRECIO_KILO;
        return importeTotal;

    }

    /**
     * Representación textual del envío
     * con el formato exacto indicado
     * (leer enunciado)
     */
    public String toString() {
        // String importe = ( "Coste del envio: " + calcularCosteTotalEnvio() + "€\n");
        // String cadena = ("Nº de paquetes: " + getNumeroPaquetes() + "\n");

        String cadena ="";
        Double costeDeEnvio = calcularCosteTotalEnvio();
        cadena += String.format("%s" + "%-1d" + "\n", "Nº de paquetes: ",getNumeroPaquetes());
        if(getNumeroPaquetes() == 1) {

            cadena += paquete1.toString() +"\n";

        }

        else if (getNumeroPaquetes() == 2) {

            cadena += paquete1.toString() +"\n";
            cadena += paquete2.toString() +"\n";
        }
        else {
            cadena += paquete1.toString() +"\n";
            cadena += paquete2.toString() +"\n";
            cadena += paquete2.toString() + "\n";

        }
        cadena += String.format("%25s" + "%10.2f" + "%-10s", "Coste del Envio = ", costeDeEnvio,"€");
        return cadena;
    }

    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Envio
     */
    public void print() {
        System.out.println(this.toString());
    }

}
