public class ColaDeMensajes {
    private Mensaje[] cola;

    public ColaDeMensajes() {
        this.cola = new Mensaje[0];
    }

    public int getDestinatarioNextMensaje() {
        int nextDestinatario = 0;
        if (cola[0] != null) {
            nextDestinatario = cola[0].getIdDestinatario();
        }
        else {
            System.out.println("La cola se encuentra vacía.");
        }
        return nextDestinatario;
    }

    public void actualizarCola() {
        for (int i=1; i<cola.length; i++) {
            cola[i-1] = cola[i];
        }
        cola[cola.length - 1] = null;
    }

    public void agregarMensaje(Mensaje mensaje) {
        int n = 0;
        while (n < cola.length && cola[n] != null) {
            n++;
        }
        if (n == cola.length) {
            System.out.println("La cola se encuentra llena.");
        }
        else {
            cola[n] = mensaje;
        }
    }

    public Mensaje getMensaje(int i) {
        return cola[i];
    }
}
