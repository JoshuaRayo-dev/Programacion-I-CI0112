public class Agente {
    private static int contador;
    private int id;
    private Mensaje mensaje;

    public Agente() {
        this.id = contador;
        contador++;
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
