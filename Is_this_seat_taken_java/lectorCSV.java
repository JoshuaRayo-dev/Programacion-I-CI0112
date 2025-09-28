import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Tuve que realizar otra clase para poder extraer los valores dentro del array personas y que fueran accesibles.
public class lectorCSV
{  
    private Persona[] personas;
    private int numPersonas;
    public lectorCSV(String reglas, String distribución)
    {
        ContadorLinea contador = new ContadorLinea(reglas, distribución);
        this.numPersonas = contador.getNumeroPersonas();
        this.personas = new Persona[this.numPersonas];
        BufferedReader lector = null;
        try 
        {
            lector = new BufferedReader(new FileReader(contador.getReglas()));
            String linea;
            String[] partes; 
            for (int a = 0; a < this.numPersonas; a++)
                    {
                    personas[a] = new Persona();
                    }   
            int personasEnPersonas = 0; //
            while ((linea = lector.readLine()) != null) //lector de archivos
            {
               
               partes = linea.split(","); //Separa lo que hay en cada linea 
               for (int i = 0; i < partes.length; i++)
                    {
                        //Cambia nombre pero evita que lo cambie si es un "al_lado"
                        if (partes[i].contains("nombre") && !partes[i].contains("al_lado"))
                        {
                            personas[personasEnPersonas].changeName(partes[i]);
                        }
                        else if (partes[i].contains("edad"))
                        {
                            personas[personasEnPersonas].changeEdad( partes[i]);
                        }
                        else if (partes[i].contains("fila"))
                        {
                            personas[personasEnPersonas].changeFila(partes[i]); 
                        }
                        else if (partes[i].contains("columna"))
                        {
                            personas[personasEnPersonas].changeColumna(partes[i]);
                        }
                        else if (partes[i].contains("huele"))
                        {
                            personas[personasEnPersonas].changeHuele( partes[i]);
                        }
                        else if (partes[i].contains("tiene"))
                        {
                            personas[personasEnPersonas].changeTiene(partes[i]);
                        }
                        else if (partes[i].contains("al"))
                        {
                            personas[personasEnPersonas].changeAlLado(partes[i]);
                        }
                        else if (partes[i].contains("odia"))
                        {
                            personas[personasEnPersonas].changeOdiaOlor(partes[i]);
                        }
                    }
                personasEnPersonas++;    
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
            if (lector != null) 
            {
                try 
                {
                    lector.close();
                } 
                catch (IOException e) 
                {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
    public void printPersona(int numeroDePersona)
    {
        this.personas[numeroDePersona].printPersona(); 
    }

    public Persona getPersona(int numeroDePersona)
    {
        return this.personas[numeroDePersona];
    }
}    