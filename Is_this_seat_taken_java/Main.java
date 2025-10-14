public class Main {
    public static void main(String[] args) {

        LectorArchivos.leerDistribucion("Distribucion.csv");
        LectorArchivos.leerReglas("Reglas.csv");

        // 1️⃣ Creamos la sala con parámetros (filas x columnas x pasillos)
        Sala sala = new Sala("5x9x1"); // ejemplo: 5 filas, 8 columnas, 1 pasillo

        // 2️⃣ Creamos el inspector y cargamos las personas desde reglas
        Inspector inspector = new Inspector(); // asume que LectorArchivos.getPersonas() ya carga todo

        // 3️⃣ Creamos el acomodador a partir del archivo CSV
        Acomodador acomodador = new Acomodador("Distribucion.csv"); // tu CSV con nombres

        // 4️⃣ Acomodamos todas las personas según el CSV usando las instancias del inspector
        acomodador.acomodarDesdeArchivo(sala, inspector);

        // 5️⃣ Inspeccionamos la sala (cantidad de felices y tristes)
        inspector.inspeccionarSala(sala);

        // 6️⃣ Mostramos resultados finales
        System.out.println("Cantidad de personas felices: " + inspector.getCantidadAlegres());
        System.out.println("Cantidad de personas tristes: " + inspector.getCantidadTristes());

        // 7️⃣ Visualizamos la sala
        sala.visualizador();

        LogCreator log = new LogCreator("5x8x1", "Reglas.csv", "Distribucion.csv", inspector, sala);
        log.escribirLog("5x8x1 Reglas.csv Distribucion.csv","5x8x1", "Reglas.csv", "Distribucion.csv", inspector, sala);
    }
}