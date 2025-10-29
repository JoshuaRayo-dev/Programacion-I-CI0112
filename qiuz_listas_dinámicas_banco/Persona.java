public class Persona {
    private String nombre;
    private Persona siguiente;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Persona getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Persona p) {
        this.siguiente = p;
    }
}
