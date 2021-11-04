
/**
 *  Clase de pruba para el resto de clases
 * 
 * @author  Aritz Ciriza
 * @version  
 */
public class TestEnvio
{

    /**
     *  
     */
    public static void main(String[] args){
        Paquete paquete1 = new Paquete(); 
        Paquete paquete2 = new Paquete​(40, 60, 40);
        Envio envio =  new Envio();
        envio.addPaquete(paquete1);
        envio.addPaquete(paquete2);
        System.out.println(envio.toString());
        Paquete paquete3 = new Paquete(new Dimension(50,50,70),13);
        envio.addPaquete(paquete3);
        System.out.println(envio.toString());
        paquete2.obtenerCopia();
        envio.addPaquete (paquete2.obtenerCopia());
    }
}