import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivos 
{
    private static Persona[] personas;
    private static int cantidadPersonas;

    // Método que recibe el nombre del archivo y lo lee línea por línea
    public static void leerReglas(String archivoReglas) 
    {
        BufferedReader br = null;
        try 
        {
            // Primera lectura, solamente interpreta cada linea para asignarla a un contador de personas.
            br = new BufferedReader(new FileReader(archivoReglas));
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) 
            {
                contador++;
            }

            // Inicializar el arreglo de personas con su debido tamano
            cantidadPersonas = contador;
            personas = new Persona[cantidadPersonas];

            // Segunda lectura, para rellenar el arreglo e interpretar los datos del archivo
            br.close(); // Se cierra antes de reabrirlo
            br = new BufferedReader(new FileReader(archivoReglas));

            int indice = 0;
            String[] partes;
            while ((linea = br.readLine()) != null && indice < cantidadPersonas) {
                personas[indice] = new Persona();
                partes = linea.split(",");

                for (String parte : partes) { // Este for se lee como "para cada parte en la lista de partes"
                    if (parte.contains("nombre") && !parte.contains("al_lado")) {
                        personas[indice].setNombre(parte);
                    }
                    else if (parte.contains("edad")) {
                        personas[indice].setEdad(parte);
                    }
                    else if (parte.contains("fila")) {
                        personas[indice].setFila(parte);
                    }
                    else if (parte.contains("columna")) {
                        personas[indice].setColumna(parte);
                    }
                    else if (parte.contains("huele_a")) {
                        personas[indice].setHueleA(parte);
                    }
                    else if (parte.contains("tiene")) {
                        personas[indice].setTiene(parte);
                    }
                    else if (parte.contains("al_lado")) {
                        personas[indice].setAlLado(parte);
                    }
                    else if (parte.contains("odia_olor")) {
                        personas[indice].setOdiaOlor(parte);
                    }
                }
                indice++;
            }
        } 
        catch(FileNotFoundException e) 
        {
            System.out.println("Archivo no encontrado: " + e.getMessage());            
        } 
        catch (IOException e) 
        {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } 
        finally 
        {
            // Cerrar el BufferedReader si se abrió
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

    // Getters
    public static Persona[] getPersonas() {
        return personas;
    }

    public static int getCantidadPersonas() {
        return cantidadPersonas;
    }
}
