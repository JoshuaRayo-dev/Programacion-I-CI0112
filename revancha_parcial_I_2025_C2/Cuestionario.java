public class Cuestionario {
    private PreguntaAleatoria[] preguntas;

    public Cuestionario(int n) {
        this.preguntas = new PreguntaAleatoria[n];
        for (int i=0; i<preguntas.length; i++) {
            preguntas[i] = new PreguntaAleatoria();
            preguntas[i].setCorrecto();
            preguntas[i].inicializarOpciones();
            preguntas[i].setEnunciado();
            preguntas[i].shuffleOpciones();
        }
    }

    public void imprimirPregunta(int i) {
        System.out.println(preguntas[i].toString());
    }

    public PreguntaAleatoria[] getPreguntas() {
        return preguntas;
    }

    public boolean respondioCorrecto(PreguntaAleatoria p, int respuesta) {
        boolean correcto = false;
        if (respuesta-1 == p.getIndexCorrecto()) {
            correcto = true;
        }
        return correcto;
    }

    public int getPreguntaIndex(PreguntaAleatoria pregunta) {
        int index = 0;
        while (preguntas[index] != pregunta) {
            index++;
        }
        return index;
    }
}
