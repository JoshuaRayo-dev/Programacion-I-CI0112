public class Inspector {
    private Persona[] listaPersonas;
    private int cantidadAlegres;
    private int cantidadTristes;

    public Inspector() {
        this.listaPersonas = LectorArchivos.getPersonas();
        this.cantidadAlegres = 0;
        this.cantidadTristes = 0;
    }
    // Metodo general de inspeccion
    public void inspeccionarSala(Sala sala) {
        Asiento[][] asientos = sala.getAsientos();
        for (int fila = 0; fila < asientos.length; fila++) {
            for (int col = 0; col < asientos[fila].length; col++) {

                Asiento asiento = asientos[fila][col];
                Persona persona = asiento.getPersona();

                if (!(asiento.getEsPasillo() || persona == null)) {

                    revisarAlLado(asientos, fila, col, persona);
                    revisarTiene(asientos, fila, col, persona);
                    revisarFila(asientos, fila, col, persona);
                    revisarColumna(asientos, fila, col, persona);
                    revisarOlor(asientos, fila, col, persona);
                }
            }
        }
    }
    private void revisarAlLado(Asiento[][] asientos, int fila, int col, Persona persona) {
        if (persona.getAlLado() != null) { // Valida que quiera estar al lado (o no) de alguien
            String nombreVecino = persona.getAlLado();
            for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
                int colVecina = col + desplazamiento;
                if (esPosicionValida(asientos, fila, colVecina)) {
                    Persona vecino = asientos[fila][colVecina].getPersona();
                    if (vecino != null && nombreVecino.equals(vecino.getNombre())) { // Valida si el nombre es igual al esperado
                        persona.setEsFeliz(true);
                    }
                    else if (vecino != null && nombreVecino.equals("!"+vecino.getNombre())) { // Si no, valida que tenga un ! antes (no lo quiere "al_lado")
                        persona.setEsFeliz(false);
                    }
                    else { // Si no la encuentra, lo pone triste
                        persona.setEsFeliz(false);
                    }
                }
            }
        }
    }

    private void revisarTiene(Asiento[][] asientos, int fila, int col, Persona persona) {

    }
    private void revisarFila(Asiento[][] asientos, int fila, int col, Persona persona) {
        String condicionFila = persona.getFila();
        if (condicionFila == null) return;

        int numeroFila = fila + 1; // Fila lógica (1-indexada)
        if (condicionFila.startsWith("!")) {
            int filaProhibida = Integer.parseInt(condicionFila.substring(1));
            if (numeroFila != filaProhibida) persona.setEsFeliz(true);
            else persona.setEsFeliz(false);
        } else {
            int filaDeseada = Integer.parseInt(condicionFila);
            persona.setEsFeliz(numeroFila == filaDeseada);
        }
    }
    private void revisarColumna(Asiento[][] asientos, int fila, int col, Persona persona) {

    }
    private void revisarOlor(Asiento[][] asientos, int fila, int col, Persona persona) {

    }

    private boolean esPosicionValida(Asiento[][] asientos, int fila, int colVecina) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esPosicionValida'");
    }
}
