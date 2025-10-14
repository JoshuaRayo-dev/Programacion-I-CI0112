public class Acomodador {
    private String[][] personasAcomodar;

    public Acomodador(String archivoDistribucion) {
        this.personasAcomodar = LectorArchivos.leerDistribucion(archivoDistribucion);
    }


    //Metodo para acomodar una persona dentro de un asiento
    public void acomodar(Sala sala, Persona persona, Inspector inspector,int fila, int columna)
    {
        if (persona != null) {
            if (fila < sala.getFilas() && columna < sala.getColumnas()) {
                if (sala.getAsientos()[fila][columna].getEsPasillo() == false) {
                    if (sala.getAsientos()[fila][columna].getOcupado() == false) {
                        sala.getAsientos()[fila][columna].acomodarPersona(persona);
                        System.out.println(persona.getNombre() + " se ha sentado en el asiento (" + fila + "," + columna + ").");
                        //inspector.borrarPersona(persona);  
                    }
                    else {
                        System.out.println("El asiento (" + fila + "," + columna + ") ya está ocupado.");
                    }
                }
                else {
                    System.out.println("El asiento (" + fila + "," + columna + ") es un pasillo.");
                }
            }
            else {
                System.out.println("El asiento (" + fila + "," + columna + ") no existe en la sala.");
            }
        }
        else
        {
            System.out.println("La persona no existe o ya ha sido acomodada por primera vez.");
        }
    }
    public void acomodarDesdeArchivo(Sala sala, Inspector inspector) {
        Persona[] listaPersonas = inspector.getListaPersonas();

        for (int fila = 0; fila < personasAcomodar.length; fila++) {
            for (int columna = 0; columna < personasAcomodar[fila].length; columna++) {
                String nombre = personasAcomodar[fila][columna];

                if (nombre != null && !nombre.isEmpty()) {
                    Persona personaAcomodar = null;

                    // Buscar la persona por nombre en la lista del inspector
                    for (int i = 0; i < listaPersonas.length; i++) {
                        if (listaPersonas[i] != null && listaPersonas[i].getNombre().equals(nombre)) {
                            personaAcomodar = listaPersonas[i];
                            break;
                        }
                    }

                    if (personaAcomodar != null) {
                        acomodar(sala, personaAcomodar, inspector, fila, columna);
                    } else {
                        System.out.println("No se encontró la persona con nombre " + nombre + " en la lista del inspector.");
                        System.out.println("El inspector no le deja pasar.");
                    }
                }
            }
        }
    }
}
