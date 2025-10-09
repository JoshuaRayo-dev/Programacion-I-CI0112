import java.util.Random;

public class Agente {
    private static int contador;
    private int id;
    private Mensaje mensaje;
    private int x, y;
    private ColaDeMensajes cola;
    private boolean seMovioAnterior;

    public Agente() {
        Random rn = new Random();
        this.x = rn.nextInt(1000);
        this.y = rn.nextInt(1000);
        this.id = contador;
        contador++;
        this.mensaje = null;
        this.cola = null;

    }

    public int getID() {
        return this.id;
    }

    public void crearMensaje() {

    }

    public void recibirMensaje() {

    }

    public Mensaje enviarMensaje() {
        Mensaje nuevoMensaje = null;
        return nuevoMensaje;
    }

    public Mensaje sacarMensaje(ColaDeMensajes cola) {
        Mensaje mensajeRetornado = null;
        if (cola.getMensaje(0) == null){
            System.out.println("La cola se encuentra vacía.");
        }
        else {
            if (this.id == cola.getMensaje(0).getIdDestinatario()) {
                mensajeRetornado = cola.getMensaje(0);
            }
            else {
                System.out.println("Solo el destinatario puede sacar el mensaje de a cola.");
            }            
        }
        return mensajeRetornado;
    }
}
