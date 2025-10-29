public class Motor {

    public static void main(String[] args) {
        LectorArchivos.leerReglas(args[1]);
        LectorArchivos.leerDistribucion(args[2]);

        Sala sala = new Sala(args[0]); 

        Inspector inspector = new Inspector(); 

        Acomodador acomodador = new Acomodador(args[2]);

        acomodador.acomodarDesdeArchivo(sala, inspector);

        inspector.inspeccionarSala(sala);

        sala.visualizador();

        LogCreator log = new LogCreator(args[0], args[1], args[2], inspector, sala);
        log.escribirLog(args[0]+" "+args[1]+" "+args[2], args[0], args[1], args[2], inspector, sala);
    }
}
