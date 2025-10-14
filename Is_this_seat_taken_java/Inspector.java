public class Inspector {

    private Persona[] listaPersonas;
    private int cantidadAlegres;
    private int cantidadTristes;

    public Inspector() {
        this.listaPersonas = LectorArchivos.getPersonas();
        this.cantidadAlegres = 0;
        this.cantidadTristes = 0;
    }

    // Getters de campos

    public int getCantidadAlegres() {
        return this.cantidadAlegres;
    }

    public int getCantidadTristes() {
        return this.cantidadTristes;
    }

    public Persona[] getListaPersonas() {
        return this.listaPersonas;
    }

    // Metodo general de inspeccion
    // Nota: Cuando el caso es feliz(no afecta o es neutro) decidí no llamar a setEstadoAlegria, evita redundancias innecesarias.
    public void inspeccionarSala(Sala sala) {
        Asiento[][] asientos = sala.getAsientos();

        cantidadAlegres = 0;
        cantidadTristes = 0;

        // Primera pasada, realiza un inspección general y hace cambios (feliz o triste)
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

        // Segunda pasada, solo ve quien está feliz o triste y los cuenta.
        for (int fila = 0; fila < asientos.length; fila++) {
            for (int col = 0; col < asientos[fila].length; col++) {

                Asiento asiento = asientos[fila][col];
                Persona persona = asiento.getPersona();

                if (!(asiento.getEsPasillo() || persona == null)) {
                    if (persona.getEsFeliz()) {
                        cantidadAlegres++;
                    }
                    else {
                        cantidadTristes++;
                    }
                }
            }
        }
    }

    // Sub-metodos del metodo general de inspeccion
    private void revisarAlLado(Asiento[][] asientos, int fila, int col, Persona persona) {
        String caso = persona.getAlLado();
        if (caso != null) {
            switch (caso) {
                case "palomitas":
                    revisarAlLadoPalomitas(asientos, fila, col, persona);
                    break;
                case "nadie":
                    revisarAlLadoNadie(asientos, fila, col, persona);
                    break;
                case "infante":
                    revisarAlLadoInfante(asientos, fila, col, persona);
                    break;
                case "adulto":
                    revisarAlLadoAdulto(asientos, fila, col, persona);
                    break;
                default:
                    revisarAlLadoPersona(asientos, fila, col, persona);
                    break;
            }
        }
    }

    private void revisarTiene(Asiento[][] asientos, int fila, int col, Persona persona) {
        String tiene = persona.getTiene();
        if (tiene != null) {
            if (tiene.contains("sombrero")) {
                revisarTieneSombrero(asientos, fila, col, persona);
            }
            else if (tiene.contains("hablada")) {
                revisarTieneHablada(asientos, fila, col, persona);
            }
            else if (tiene.contains("celular_encendido")) {
                revisarTieneCelularEncendido(asientos, fila, col, persona);
            }
        }
    }

    private void revisarFila(Asiento[][] asientos, int fila, int col, Persona persona) {
        String filaDeseada = persona.getFila();
        if (filaDeseada != null) {
            if (filaDeseada.length() == 1) {
                int intFilaDeseada = Integer.parseInt(filaDeseada);
                if (intFilaDeseada - 1 == fila) {
                    // caso feliz
                }
                else {
                    // caso triste
                    persona.setEstadoAlegria("(triste):fila:"+intFilaDeseada+"(fila:"+fila+")", 1);
                }
            }
            else if (filaDeseada.length() == 2) {
                int intFilaNoDeseada = Integer.parseInt(filaDeseada.substring(1));
                if (intFilaNoDeseada == fila) {
                    // caso triste
                    persona.setEstadoAlegria("(triste):fila:"+intFilaNoDeseada+"(fila:"+fila+")", 1);

                }
            }
            else if (filaDeseada.length() > 2 && filaDeseada.equals("primera")) {
                if (fila != 0) {
                    // caso triste
                    persona.setEstadoAlegria("(triste):fila:"+filaDeseada+"(fila:"+fila+")", 1);

                }
                else {
                    // caso feliz
                }
            }
            else if (filaDeseada.length() > 2 && filaDeseada.equals("!primera")) {
                if (fila == 0) {
                    // caso triste
                    persona.setEstadoAlegria("(triste):fila:"+filaDeseada+"(fila:"+fila+")", 1);
                }
                else {
                    // caso feliz
                }
            }
        }
    }

    private void revisarColumna(Asiento[][] asientos, int fila, int col, Persona persona) {
        String columnaARevisar = persona.getColumna();
        if(columnaARevisar != null) {
            if (columnaARevisar.contains("central")) {
                revisarColumnaCentral(asientos, fila, col, persona);
            }
            else if (columnaARevisar.contains("pasillo")) {
                revisarColumnaPasillo(asientos, fila, col, persona);
            }
        }
    }

    private void revisarOlor(Asiento[][] asientos, int fila, int col, Persona persona) {
        String olor = persona.getHueleA();
        if (olor != null) {
            if (olor.contains("sucio")) {
                revisarOlorSucio(asientos, fila, col, persona);
            }
            else if (olor.contains("perfume")) {
                revisarOlorPerfume(asientos, fila, col, persona);
            }
        }
    }

    // Metodo que evita indices fuera del arreglo y ahorra muchos condicionales
    private boolean esPosicionValida(Asiento[][] asientos, int fila, int col) {
        return fila >= 0 && fila < asientos.length && col >= 0 && col < asientos[fila].length;
    }

    // Metodos específicos para revisar Al Lado

    // Metodo indispensable para darle los datos al log
    private String obtenerVecinos(Asiento[][] asientos, int fila, int col) {
        String vecinoIzq = "nadie";
        String vecinoDer = "nadie";
        // Verifica vecino izquierdo
        if (esPosicionValida(asientos, fila, col - 1)) {
            Persona izq = asientos[fila][col - 1].getPersona();
            if (izq != null) {
                vecinoIzq = izq.getNombre();
            }
        }
        // Verifica vecino derecho
        if (esPosicionValida(asientos, fila, col + 1)) {
            Persona der = asientos[fila][col + 1].getPersona();
            if (der != null) {
                vecinoDer = der.getNombre();
            }
        }
        return vecinoIzq + "," + vecinoDer;
    }

    private void revisarAlLadoPalomitas(Asiento[][] asientos, int fila, int col, Persona persona) {
        String vecinos = obtenerVecinos(asientos, fila, col);
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
            int colVecina = col + desplazamiento;
            if (esPosicionValida(asientos, fila, colVecina)) {
                Persona vecino = asientos[fila][colVecina].getPersona();
                if (vecino.getTiene().contains("palomitas")) {
                    // caso feliz, solo basta encontrar 1
                    return;
                }
            }
        }
        // caso triste, no encontró nada
        persona.setEstadoAlegria("(triste):al_lado:palomitas(" + vecinos + ")", 1);

    }

    private void revisarAlLadoNadie(Asiento[][] asientos, int fila, int col, Persona persona) {
        String vecinos = obtenerVecinos(asientos, fila, col);
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
            int colVecina = col + desplazamiento;
            if (esPosicionValida(asientos, fila, colVecina)) {
                Persona vecino = asientos[fila][colVecina].getPersona();
                if (vecino == null) {
                    // caso feliz
                }
                else {
                    // caso triste, basta solo con 1
                    persona.setEstadoAlegria("(triste):al_lado:nadie(" + vecinos + ")", 1);
                    return;
                }
            }
        }
    }

    private void revisarAlLadoInfante(Asiento[][] asientos, int fila, int col, Persona persona) {
        String vecinos = obtenerVecinos(asientos, fila, col);
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
            int colVecina = col + desplazamiento;
            if (esPosicionValida(asientos, fila, colVecina)) {
                Persona vecino = asientos[fila][colVecina].getPersona();
                if (vecino.getEdad() < 18) {
                    // caso feliz, solo basta con 1
                    return;
                }
            }
        }
        // Si no hay nada, triste
        persona.setEstadoAlegria("(triste):al_lado:infante(" + vecinos + ")", 1);

    }

    private void revisarAlLadoAdulto(Asiento[][] asientos, int fila, int col, Persona persona) {
        String vecinos = obtenerVecinos(asientos, fila, col);
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
            int colVecina = col + desplazamiento;
            if (esPosicionValida(asientos, fila, colVecina)) {
                Persona vecino = asientos[fila][colVecina].getPersona();
                if (vecino.getEdad() > 18) {
                    // caso feliz, solo basta con 1
                    return;
                }
            }
        }
        // Si no hay nada, triste
        persona.setEstadoAlegria("(triste):al_lado:adulto(" + vecinos + ")", 1);
    }

    private void revisarAlLadoPersona(Asiento[][] asientos, int fila, int col, Persona persona) {
        String vecinos = obtenerVecinos(asientos, fila, col);
        String nombreVecino = persona.getAlLado();
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento += 2) {
            int colVecina = col + desplazamiento;
            if (esPosicionValida(asientos, fila, colVecina)) {
                Persona vecino = asientos[fila][colVecina].getPersona();
                if (vecino != null && nombreVecino.equals(vecino.getNombre())) { // Valida si el nombre es igual al esperado
                    // Caso Feliz;
                    return;
                }
                else if (vecino != null && nombreVecino.equals("!"+vecino.getNombre())) { // Si no, valida que tenga un ! antes (no lo quiere "al_lado")
                    // Caso Triste
                    persona.setEstadoAlegria("(triste):al_lado:" + persona.getAlLado() + "(" + vecinos + ")", 1);

                }
            }
        }
        // Caso Triste, Si no encuentra a nadie, lo pone triste
        persona.setEstadoAlegria("(triste):al_lado:" + persona.getAlLado() + "(" + vecinos + ")", 1);

    }

    // Metodos especificos para revisar Tiene
    private void revisarTieneSombrero(Asiento[][] asientos, int fila, int col, Persona persona) {
        for (int desplazamiento = fila + 1; desplazamiento<asientos.length; desplazamiento++) {
            if (esPosicionValida(asientos, desplazamiento, col)) {
                Persona afectado = asientos[desplazamiento][col].getPersona();
                if (afectado != null) {
                    // Caso triste
                    afectado.setEstadoAlegria("(triste):tiene:sombrero(" + persona.getNombre() + ")", 1);
                }
            }
        }
    }

    private void revisarTieneHablada(Asiento[][] asientos, int fila, int col, Persona persona) {
        for (int desplazamientoX = -2; desplazamientoX <= 2; desplazamientoX++) {
            for (int desplazamientoY = -2; desplazamientoY <= 2; desplazamientoY++) {
                if (desplazamientoX == 0 && desplazamientoY == 0) continue;
                int nuevaFila = fila + desplazamientoX;
                int nuevaCol = col + desplazamientoY;
                if (esPosicionValida(asientos, nuevaFila, nuevaCol)) {
                    Persona afectado = asientos[nuevaFila][nuevaCol].getPersona();
                    if (afectado != null) {
                        if (afectado.getAlLado() != null && persona.getAlLado() != null &&
                        (afectado.getAlLado().equals(persona.getNombre()) || persona.getAlLado().equals(afectado.getNombre()))) {
                            // La condicinal larga es para que no de errores de valores nulos.
                            // Caso neutro, no afecta porque alguno de los dos se quieren al lado
                            continue;
                        }
                        else {
                            // Caso triste, callen al hablador
                            afectado.setEstadoAlegria("(triste):tiene:hablada(" + persona.getNombre() + ")", 1);
                        }
                    }
                }
            }
        }
    }

    private void revisarTieneCelularEncendido(Asiento[][] asientos, int fila, int col, Persona persona) {
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento++) {
            int filaAtras = fila + 1;
            int nuevaCol = col + desplazamiento;
            if (esPosicionValida(asientos, filaAtras, nuevaCol)) {
                Persona afectado = asientos[filaAtras][nuevaCol].getPersona();
                if (afectado != null) {
                    // Caso triste
                    afectado.setEstadoAlegria("(triste):tiene:celular_encendido(" + persona.getNombre() + ")", 1);
                }
            }
        }
    }

    // Metodos especificos para revisar Fila

    // Metodos especificos para revisar Columna
    private void revisarColumnaCentral(Asiento[][] asientos, int fila, int col, Persona persona) {
        String colCentral = persona.getColumna();
        Asiento esteAsiento = asientos[fila][col];
        if (colCentral.equals("central")) {
            if (esteAsiento.getEsCentral()) {
                // Caso Feliz;
            }
            else {
                // Caso Triste
                persona.setEstadoAlegria("(triste):columna:" + colCentral + "(columna:" + col + ")", 1);

            }
        }
        else if (colCentral.equals("!central")) {
            if (esteAsiento.getEsCentral()) {
                // Caso Triste
                persona.setEstadoAlegria("(triste):columna:" + colCentral + "(columna:" + col + ")", 1);
            }
            else {
                // Caso Feliz
            }
        }
    }

    private void revisarColumnaPasillo(Asiento[][] asientos, int fila, int col, Persona persona) {
        String colPasillo = persona.getColumna();
        for (int desplazamiento = -1; desplazamiento <= 1; desplazamiento++) {
            int nuevaCol = col + desplazamiento;
            if (esPosicionValida(asientos, fila, nuevaCol)) {
                Asiento vecino = asientos[fila][nuevaCol];
                if (colPasillo.equals("pasillo")) {
                    if (vecino.getEsPasillo()) {
                        // Caso Feliz;
                        return;
                    }
                    else {
                        // Caso Triste
                        persona.setEstadoAlegria("(triste):columna:" + colPasillo + "(columna:" + col + ")", 1);
                    }
                }
                else if (colPasillo.equals("!pasillo")) {
                    if (vecino.getEsPasillo()) {
                        // Caso Triste
                        persona.setEstadoAlegria("(triste):columna:" + colPasillo + "(columna:" + col + ")", 1);
                        return;
                    }
                    else {
                        // Caso Feliz;
                        
                    }
                }
            }
        }
    }

    // Metodos especificos para revisar Olor
    private void revisarOlorSucio(Asiento[][] asientos, int fila, int col, Persona persona) {
        for (int desplazamientoX = -1; desplazamientoX <= 1; desplazamientoX++) {
            for (int desplazamientoY = -1; desplazamientoY <= 1; desplazamientoY++) {
                if (desplazamientoX == 0 && desplazamientoY == 0) continue; // Evita afectar a la misma celda (origen)
                int nuevaFila = fila + desplazamientoX;
                int nuevaCol = col + desplazamientoY;
                if (esPosicionValida(asientos, nuevaFila, nuevaCol)) {
                    Persona afectado = asientos[nuevaFila][nuevaCol].getPersona();
                    if (afectado != null) {
                        if (afectado.getOdiaOlor() != null) {
                            if (afectado.getOdiaOlor().contains("sucio") || afectado.getOdiaOlor().contains("todos")) {
                                // Caso triste
                                afectado.setEstadoAlegria("(triste):huele_a:" + persona.getHueleA() + "(" + persona.getNombre() + ")", 1);

                            }
                        }
                    }
                }
            }
        }
    }

    private void revisarOlorPerfume(Asiento[][] asientos, int fila, int col, Persona persona) {
        for (int desplazamientoX = -1; desplazamientoX <= 1; desplazamientoX++) {
            for (int desplazamientoY = -1; desplazamientoY <= 1; desplazamientoY++) {
                if (desplazamientoX == 0 && desplazamientoY == 0) continue; // Evita afectar a la misma celda (origen)
                int nuevaFila = fila + desplazamientoX;
                int nuevaCol = col + desplazamientoY;
                if (esPosicionValida(asientos, nuevaFila, nuevaCol)) {
                    Persona afectado = asientos[nuevaFila][nuevaCol].getPersona();
                    if (afectado != null) {
                        if (afectado.getOdiaOlor() != null) {
                            if (afectado.getOdiaOlor().contains("perfume") || afectado.getOdiaOlor().contains("todos")) {
                                // Caso triste
                                afectado.setEstadoAlegria("(triste):huele_a:" + persona.getHueleA() + "(" + persona.getNombre() + ")", 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
