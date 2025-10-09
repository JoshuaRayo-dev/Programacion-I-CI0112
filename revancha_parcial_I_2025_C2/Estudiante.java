public class Estudiante {
    private Cuestionario cuestionario;
    private static int contador = 1;
    private int id;
    private int aciertos;
    private int[] respuestas;
    private int nota;

    public Estudiante (Cuestionario c) {
        this.id = contador;
        contador++;
        this.cuestionario = c;
        this.respuestas = new int[c.getPreguntas().length];
    }

    public void calcularAciertos() {
        for (int respuesta : respuestas) {
            if (respuesta == 1) {
                aciertos++;
            }
        }
    }

    public void calcularNota() {
        this.nota = (int)(((double)aciertos/respuestas.length)*100);
    }

    public void responderPregunta(int i, int respuesta) {
        if (respuesta-1 == cuestionario.getPreguntas()[i].getIndexCorrecto()) {
            respuestas[i] = 1;
        }
        else {
            respuestas[i] = 0;
        }
    }

    public int getID() {
        return this.id;
    }

    public int[] getRespuestas() {
        return respuestas;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getNota() {
        return nota;
    }
}
