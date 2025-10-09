import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sn = new Scanner(System.in);
            System.out.println("Cantidad de preguntas: ");
            int n = sn.nextInt();
            System.out.println("Cantidad de estudiantes: ");
            int m = sn.nextInt();

            Cuestionario c = new Cuestionario(n);

            Estudiante[] estudiantes = new Estudiante[m];

            for (int i=0;i<estudiantes.length; i++) {
                estudiantes[i] = new Estudiante(c);
            }

            int respuesta;
            for (int i=0;i<estudiantes.length; i++) {
                System.out.println("Turno Estudiante #"+estudiantes[i].getID());
                for (int j=0;j<c.getPreguntas().length; j++) {
                    System.out.println(c.getPreguntas()[j].toString());
                    respuesta = sn.nextInt();
                    estudiantes[i].responderPregunta(j, respuesta);
                }
            }
            for (int i=0;i<estudiantes.length; i++) {
                estudiantes[i].calcularAciertos();
                estudiantes[i].calcularNota();
            }
            System.out.println("Estudiante\tRespuestas\tAciertos");
            for (int i=0; i<estudiantes.length; i++) {
                System.out.print(estudiantes[i].getID()+"\t");
                System.out.print("{ ");
                for (int j=0; j<estudiantes[i].getRespuestas().length; j++) {
                    System.out.print(estudiantes[i].getRespuestas()[j]+", ");
                }
                System.out.print("}\t");
                System.out.print(estudiantes[i].getAciertos()+"/"+estudiantes[i].getRespuestas().length+"\tNota: "+estudiantes[i].getNota());
                System.out.println();
            }
            int sumatoriaNotas = 0;
            for (int i=0; i<estudiantes.length; i++) {
                sumatoriaNotas += estudiantes[i].getNota();
            }
            int notaPromedio = sumatoriaNotas/estudiantes.length;
            System.out.println("\t\t\tNota Promedio: "+notaPromedio);
            sn.close();
        } catch (Exception e) {
            System.out.println("¡Tenga más cuidado al ingresar valores! "+e.getMessage());
        }
    }
}
