import java.util.Random;

public class MatrizConComida {
    private int[][] comida;

    public MatrizConComida() {
        this.comida = new int[1000][1000];
    }

    public void asignarComida(int fila, int columna) {
        int x = verificarComidaVecinos(fila, columna);
        if (comida[fila][columna] == 0 && x == 0) {
            comida[fila][columna] = 1;
        }
        else {
            comida[fila][columna] += x;
        }
    }

    public int verificarComidaVecinos(int fila, int columna) {
        int sumatoriaVecinos = 0;
        try {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    else {
                        sumatoriaVecinos += comida[fila + dx][columna + dy];
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }
        catch (Exception e) {

        }
        return sumatoriaVecinos;
    }

    public void asignarACeldasAleatorias()
    {
        int límite = 1000;
        Random rn = new Random();
        int numeroRandom1;
        int numeroRandom2;
        for (int i = 0; i < 200; i++) {
            numeroRandom1 = rn.nextInt(límite);
            numeroRandom2 = rn.nextInt(límite);
            asignarComida(numeroRandom1, numeroRandom2);
        }
    }
}
