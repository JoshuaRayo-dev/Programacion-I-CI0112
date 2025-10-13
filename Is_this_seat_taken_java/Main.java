public class Main {
    public static void main(String[] args) {
        LectorArchivos.leerReglas("Reglas.csv");

        for (Persona p : LectorArchivos.getPersonas()) {
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Fila: " + p.getFila());
            System.out.println("Columna: " + p.getColumna());
            System.out.println("Huele a " + p.getHueleA());
            System.out.println("Tiene: " + p.getTiene());
            System.out.println("Al lado: " + p.getAlLado());
            System.out.println("Odia olor: " + p.getOdiaOlor());
            System.out.println("--------------------");
        }

        Sala sala = new Sala("8x10x1");
        sala.visualizador();
    }
}