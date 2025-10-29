public class ColaSimple {
    private Persona primera;
    private int cantidadPersonas;
    private boolean vacia;

    public ColaSimple() {
        this.primera = null;
        this.cantidadPersonas = 0;
        this.vacia = true;
    }

    public boolean vacia() {
        if (cantidadPersonas > 0) {
            this.vacia = false;
        }
        else {
            this.vacia = true;
        }
        return this.vacia;
    }

    public void agregar(String nombre) {
        Persona p = new Persona(nombre);
        if (this.vacia()) {
            this.primera = p;
            cantidadPersonas++;
        }
        else {
            Persona actual = this.primera;
            for (int i=2; i<cantidadPersonas; i++) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(p);
            cantidadPersonas++;
        }
    }

    public String sacar() {
        String nombre = null;
        if (this.vacia()) {
            System.out.println("¡Esta cola ya se encuentra vacía!");
        }
        else {
            nombre = this.primera.getNombre();
            this.primera = this.primera.getSiguiente();
            cantidadPersonas--;
        }
        return nombre;
    }
}
