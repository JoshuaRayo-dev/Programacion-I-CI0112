public class Sala {

    private String parametros;
    private int filas; //Parámetro A
    private int columnas; //Parámetro B
    private int pasillos;  //Parámetro C
    private Asiento[][] asientos;

    public Sala(String argumentos) {
        try {
            int[] parametros = parsearParametros(argumentos);
            this.filas = parametros[0];
            this.columnas = parametros[1];
            if (parametros.length > 2) {
                this.pasillos = parametros[2];
            }
            else {
                this.pasillos = 0;
            }

            validarParametros();
            inicializarAsientos();
            colocarPasillos();
            establecerCentrales();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ha ocurrido un error de desbordamiento." + e.getMessage() + "\nDividiendo la sala en partes iguales más cercanas.");
        }
        catch(Exception e) {
            System.out.println("Un error inesperado ha ocurrido." + e.getMessage());
        }
    }

    // Metodos exclusivos para el constructor
    private int[] parsearParametros(String parametros) {
        try {
            String[] partes = parametros.split("x");

            if (partes.length < 2) {
                throw new IllegalArgumentException("Tiene que especificar correctamente la cantidad de filas y columnas.");
            }

            if (partes.length > 3) {
                throw new IllegalArgumentException("Ha indicado más de tres parámetros. Por favor, ingréselos con cuidado.");
            }

            int[] partesInt = new int[partes.length];

            for (int i=0; i<partes.length; i++) {
                partesInt[i] = Integer.parseInt(partes[i]);
            }
            return partesInt;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ha ocurrido un error procesando los parámetros. Asegurese de que sean números enteros.");
        }
    }

    private void validarParametros() {
        if (filas < 0 || columnas < 0 || pasillos < 0) {
            throw new IllegalArgumentException("No pueden haber parámetros negativos.");
        }
        if (pasillos >= columnas) {
            System.out.println("No puede haber más pasillos que columnas. Inicializando pasillos en 0.");
            pasillos = 0;
        }
    }

    private void inicializarAsientos() {
        asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(false);
            }
        }
    }

    private void colocarPasillos() {
        if (pasillos == 0) return;

        int bloques = pasillos + 1;

        // Solo si las columnas pueden dividirse equitativamente entre bloques
        if ((columnas + 1) % bloques != 0) {
            System.out.println("La sala no puede dividirse equitativamente en " + bloques + " bloques. No se colocarán pasillos.");
            pasillos = 0;
            return;
        }

        int tamanoBloque = columnas / bloques;
        // Coloca los pasillos reemplazando columnas existentes
        for (int i = 0; i <= pasillos; i++) {
            int columnaPasillo = tamanoBloque * (i + 1) + i;  // índice del pasillo
            if (columnaPasillo >= columnas) { // Evita IndexOOB
                continue;
            }
            for (int fila = 0; fila < filas; fila++) {
                asientos[fila][columnaPasillo] = new Asiento(true);
            }
        }
    }

    private void establecerCentrales() {
        int centro = columnas / 2;
        for (int fila = 0; fila < filas; fila++) {
            // Asiento central principal
            if (!asientos[fila][centro].getEsPasillo()) {
                asientos[fila][centro].setEsCentral(true);
            }
            // Extiende hacia la izquierda
            for (int col = centro - 1; col >= 0 && !asientos[fila][col].getEsPasillo(); col--) {
                asientos[fila][col].setEsCentral(true);
            }

            // Extiende hacia la derecha
            for (int col = centro + 1; col < columnas && !asientos[fila][col].getEsPasillo(); col++) {
                asientos[fila][col].setEsCentral(true);
            }
        }
    }

    public void visualizador()
    {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                String asiento = asientos[i][j].estadoAsiento();
                System.out.print(asiento + " ");
            }
            System.out.println();
        }
    }

    public Asiento[][] getAsientos() {
        return this.asientos;
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }
}
