import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class LogCreator 
{
    public LogCreator(String datosSala, String reglas, String Distribucion, Inspector elInspector, Sala sala)
    {
        try
        {
            File elLog = new File(datosSala+"_"+reglas+"_"+Distribucion+"_"+".txt");
            if (elLog.createNewFile())
            {
                System.out.println("El log ha sido creado exitosamente.");
            }
            else
            {
                System.out.println("El log ya existe, será reescrito a continuación.");
            }
        }
        catch(IOException e)
        {
            System.err.println("Error inesperado.");
            e.printStackTrace();
        }
    }   

    public void escribirLog(String comando,String datosSala, String reglas, String Distribucion, Inspector elInspector, Sala sala) //String [] comando
    {
        try
        {
            FileWriter elEscritor = new FileWriter(datosSala+"_"+reglas+"_"+Distribucion+"_"+".txt");
                    elEscritor.write("----------------------------------------\n");
                    elEscritor.write("inicio".toUpperCase()+"\n");
                    elEscritor.write("comando:‘java -jar ./motor.jar" +comando+"’\n\n");
                    elEscritor.write("resumen".toUpperCase()+"\n");
                    elEscritor.write("felices="+elInspector.getCantidadAlegres()+"\n");
                    elEscritor.write("tristes="+elInspector.getCantidadTristes()+"\n\n");
                    elEscritor.write("Resultados".toUpperCase()+"\n");
                    int maxColumnas = sala.getAsientos()[0].length;
                    int maxFilas = sala.getAsientos().length;
                    for (int j= 0; j < maxFilas; j++)
                    {
                        for (int i = 0; i < maxColumnas; i++)
                        {
                            if (sala.getAsientos()[j][i].getPersona()!= null)
                            {
                                elEscritor.write(sala.getAsientos()[j][i].getPersona().getEstadoAlegria());
                            }
                        }
                    }
                    elEscritor.write("----------------------------------------");
            elEscritor.close();
        }
        catch(IOException e)
        {
            System.err.println("Error inesperado.");
            e.printStackTrace();
        }

    }
}