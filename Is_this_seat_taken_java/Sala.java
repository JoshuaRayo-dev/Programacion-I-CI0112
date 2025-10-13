public class Sala {
    private String parametros;
    private int filas; //Parámetro A
    private int columnas; //Parámetro B
    private int pasillos;  //Parámetro C
    private Asiento[][] asientos;
    public Sala(String parametros) {
        try {
            this.parametros = parametros;
            // Arreglo con los parametros divididos por cada "x"
            String[] parametrosDivididos = parametros.split("x");
            if (parametrosDivididos.length < 2) {
            throw new IllegalArgumentException("Debe especificar al menos filas y columnas.");
            }

            // Array tipo int para almacenar los parametros luego parseados
            int[] parametrosParseados = new int[parametrosDivididos.length];

            // Convierte los strings a ints
            for (int i=0; i<parametrosDivididos.length; i++) {
                parametrosParseados[i] = Integer.parseInt(parametrosDivididos[i]);
            }

            // Asigna los valores a sus respectivos campos
            this.filas = parametrosParseados[0];
            this.columnas = parametrosParseados[1];
            if (parametrosParseados.length == 3) {
                this.pasillos = parametrosParseados[2];
            }
            else {
                this.pasillos = 0;
            }

            // Evita que haya mas pasillos que columnas
            if (pasillos >= columnas) {
                System.out.println("No puede haber mas pasillos que columnas.\nInicializando pasillos en 0.");
                this.pasillos = 0;
            }

            // Define cuantos bloques hay y cual va a ser su tamano
            int bloques = pasillos+1;
            int tamanoBloque = columnas/bloques;

            // Inicializar matriz (de momento sin pasillos)
            asientos = new Asiento[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    asientos[i][j] = new Asiento(false);
                }
            }
            
            // Coloca los pasillos
            for (int i = 1; i <= pasillos; i++) {
                int columnaPasillo = tamanoBloque * i + (i - 1);
                for (int fila = 0; fila < filas; fila++) {
                    asientos[fila][columnaPasillo] = new Asiento(true);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El número de pasillos frente a las columnas ha causado desbordamiento.");
            System.out.println("Dividiento la sala en las partes iguales más cercanas.");
        }
        catch(Exception e) {
            System.out.println("Un error inesperado ha ocurrido.");
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
}
