import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
public class ContadorLinea
{
    private String reglas;
    private String distribución;
    private int numeroPersonas;
    private int numeroDistribución;
    public ContadorLinea(String reglas, String distribución)
    {

        this.reglas = reglas;
        this.distribución = distribución;
        LineNumberReader numLineasRegla = null;
        LineNumberReader numLineasDistribucion = null;
        try 
        { 
            numLineasRegla = new LineNumberReader(new FileReader(this.reglas));
                while (numLineasRegla.readLine() != null)
                {
                    int numeroLineas = numLineasRegla.getLineNumber();
                    if (numeroLineas > 0)
                    {
                    this.numeroPersonas = numeroLineas;
                    }
                 
                } 
            numLineasDistribucion = new LineNumberReader(new FileReader(this.distribución));
                while (numLineasDistribucion.readLine() != null)
                {
                    int numeroLineasDis = numLineasDistribucion.getLineNumber();
                    if (numeroLineasDis > 0)
                    {
                    this.numeroDistribución= numeroLineasDis;
                    }
                 
                } 
        }
        catch (IOException e)
        {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        finally 
        {
            // Cerrar el BufferedReader si se abrió
            if (numLineasRegla != null) 
            {
                try 
                {
                    numLineasRegla.close();
                } 
                catch (IOException e) 
                {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }    
        }
    }    
    public int getNumeroPersonas()
    {
        return this.numeroPersonas;
    }
    public int getNumeroDistribución()
    {
        return this.numeroDistribución;
    }
    public String getReglas()
    {
        return this.reglas;
    }
    public String getDistribución()
    {
        return this.distribución;
    }
}
