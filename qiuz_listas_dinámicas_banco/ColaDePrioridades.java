public class ColaDePrioridades {
    private ColaSimple adultosMayores;
    private ColaSimple embarazadas;
    private ColaSimple especiales;
    private ColaSimple regular;
    private int totalPersonas;
    private boolean vacia;

    public ColaDePrioridades() {
        this.adultosMayores = new ColaSimple();
        this.embarazadas = new ColaSimple();
        this.especiales = new ColaSimple();
        this.regular = new ColaSimple();
    }

    public boolean vacia() {
        if (totalPersonas > 0) {
            this.vacia = false;
        }
        else {
            this.vacia = true;
        }
        return this.vacia;
    }

    public void agregar(String nombre, int prioridad) {
        switch (prioridad) {
            case 1:
                adultosMayores.agregar(nombre);
                totalPersonas++;
                break;
            case 2:
                embarazadas.agregar(nombre);
                totalPersonas++;
                break;
            case 3:
                especiales.agregar(nombre);
                totalPersonas++;
                break;
            default:
                regular.agregar(nombre);
                totalPersonas++;
                break;
        }
    }

    public String sacar() {
        String nombre = null;
        if (this.vacia()) {
            System.out.println("Ya no queda ninguna persona hacienda cola.");
        }
        else {
            if (!adultosMayores.vacia()) {
                nombre = adultosMayores.sacar();
                totalPersonas--;
                System.out.println("Se ha atendido a una persona de la cola prioritaria de Adultos Mayores.");
            }
            else if (!embarazadas.vacia()) {
                nombre = embarazadas.sacar();
                totalPersonas--;
                System.out.println("Se ha atendido a una persona de la cola prioritaria de Embarazadas.");

            }
            else if (!especiales.vacia()) {
                nombre = especiales.sacar();
                totalPersonas--;
                System.out.println("Se ha atendido a una persona de la cola prioritaria de Necesidades Especiales.");

            }
            else {
                nombre = regular.sacar();
                totalPersonas--;
                System.out.println("Se ha atendido a una persona de la cola Regular.");

            }
            System.out.println("Ha salido la persona llamada: "+nombre);
        }
        return nombre;
    }

    public String sacarNoAtendidos() {
        String nombre = null;
        if (this.vacia()) {
            System.out.println("Ya no queda ninguna persona hacienda cola.");
        }
        else {
            if (!adultosMayores.vacia()) {
                nombre = adultosMayores.sacar();
                totalPersonas--;
            }
            else if (!embarazadas.vacia()) {
                nombre = embarazadas.sacar();
                totalPersonas--;
            }
            else if (!especiales.vacia()) {
                nombre = especiales.sacar();
                totalPersonas--;
            }
            else {
                nombre = regular.sacar();
                totalPersonas--;
            }
        }
        return nombre;
    }

    public void imprimirPersonasRestantes() {
        String nombre;
        while (!this.vacia()) {
            while (!adultosMayores.vacia()) {      
                nombre = sacarNoAtendidos();
                System.out.println("No se ha podido atender a la persona "+nombre+" de la cola de Adultos Mayores.");          
            }
            while (!embarazadas.vacia()) {      
                nombre = sacarNoAtendidos();
                System.out.println("No se ha podido atender a la persona "+nombre+" de la cola de Embarazadas.");          
            }
            while (!especiales.vacia()) {      
                nombre = sacarNoAtendidos();
                System.out.println("No se ha podido atender a la persona "+nombre+" de la cola de Necesidades Especiales.");          
            }
            while (!especiales.vacia()) {      
                nombre = sacarNoAtendidos();
                System.out.println("No se ha podido atender a la persona "+nombre+" de la cola Regular.");          
            }
        }
     }
}
