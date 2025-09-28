public class Sala
{
    private int numeroDeFilas; //Parámetro "A"
    private int numeroDeColumnas; //Parámetro "B"
    private int pasillos; //Parámetro "C"
    private String parametros;
    private Asiento[][] matrizDeAsientos;

    public Sala(String parametros)
    {
        try
        {
            this.parametros = parametros;
            //Arreglo que divide los parametros en Strings individuales
            String[] divisorParametros = parametros.split("x");

            //Arreglo del mismo tamaño que los parámetros divididos
            int[] parametrosConvertidos = new int[divisorParametros.length];

            //Bucle que convierte los strings a ints
            for (int i = 0; i < divisorParametros.length; i++)
            {
                parametrosConvertidos[i] = Integer.parseInt(divisorParametros[i]);
            }

            numeroDeFilas = parametrosConvertidos[0];
            numeroDeColumnas = parametrosConvertidos[1];

            if (parametrosConvertidos.length == 3)
            {
                pasillos = parametrosConvertidos[2];
            }
            else
            {
                pasillos = 0;
            }

            if (pasillos > numeroDeColumnas)
            {
                pasillos = 0;
                System.out.println("¡No puede haber más pasillos que columnas!");
                System.out.println("Ahora hay 0 pasillos.");
            }

            matrizDeAsientos = new Asiento[numeroDeFilas][numeroDeColumnas];

            //Bucle que inicializa todos los Asientos como no pasillos (de momento)
            for (int fila = 0; fila < numeroDeFilas; fila++)
            {
                for (int columna = 0; columna < numeroDeColumnas; columna++)
                {
                    if (matrizDeAsientos[fila][columna] == null)
                    {
                        matrizDeAsientos[fila][columna] = new Asiento(false);
                    }
                }
            }
            //Para simetría, los bloques siempre son pasillos + 1
            int bloques = pasillos + 1;
            int tamañoBloque = numeroDeColumnas / bloques;

            /*if (numeroDeColumnas % bloques != 0)
            {
                pasillos = 0;
                System.out.println("El número de pasillos no permite que los bloques sean iguales.");
                System.out.println("Pasillos descartados.");
            }*/

            //Bucle que SOLO se inicializa si existen pasillos en los parámetros
            if (pasillos != 0)
            {
                for (int i = 0; i < pasillos; i++)
                {
                    int columnaPasillo = tamañoBloque * (i + 1) + i;
                    for (int fila = 0; fila < numeroDeFilas; fila++)
                    {
                    matrizDeAsientos[fila][columnaPasillo] = new Asiento(true);
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("El número de pasillos frente a las columnas ha causado desbordamiento.");
            System.out.println("Dividiento la sala en las partes iguales más cercanas.");
        }
        catch(Exception e)
        {
            System.out.println("Un error inesperado ha ocurrido.");
        }
    }

    //Método que imprime la sala en consola
    public void visualizador()
    {
        for (int i = 0; i < matrizDeAsientos.length; i++)
        {
            for (int j = 0; j < matrizDeAsientos[i].length; j++)
            {
                String asiento = matrizDeAsientos[i][j].estadoAsiento();
                System.out.print(asiento + " ");
            }
            System.out.println();
        }
    }

    //Metodo para acomodar una persona dentro de un asiento
    public void acomodador(Persona persona, int fila, int columna)
    {
        if (fila < numeroDeFilas && columna < numeroDeColumnas)
        {
            if (matrizDeAsientos[fila][columna].getEsPasillo() == false)
            {
                if (matrizDeAsientos[fila][columna].getOcupado() == false)
                {
                    matrizDeAsientos[fila][columna].setOcupado(true);
                    matrizDeAsientos[fila][columna].acomodar(persona);
                    System.out.println(persona.getNombre() + " se ha sentado en el asiento (" + fila + "," + columna + ").");
                }
                else
                {
                    System.out.println("El asiento (" + fila + "," + columna + ") ya está ocupado.");
                }
            }
            else
            {
                System.out.println("El asiento (" + fila + "," + columna + ") es un pasillo.");
            }
        }
        else
        {
            System.out.println("El asiento (" + fila + "," + columna + ") no existe en la sala.");
        }
        visualizador();
    }
    
    //Para debug
    @Override
    public String toString()
    {
        return "Filas: "+numeroDeFilas+"\nColumnas: "+numeroDeColumnas+"\nPasillos: "+pasillos+"\nParametros Recibidos: "+parametros;
    }
}
