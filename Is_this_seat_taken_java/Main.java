public class Main {
    public static void main(String[] args) {
        LectorArchivos.leerReglas("Reglas.csv"); //args[1]

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

        Sala sala = new Sala("2x2x1"); //args[0]
        sala.visualizador();
    }
}