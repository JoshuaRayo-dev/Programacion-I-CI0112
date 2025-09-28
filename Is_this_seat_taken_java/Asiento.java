public class Asiento 
{
    private boolean esPasillo;
    private boolean ocupado;
    private Persona persona;

    public Asiento(boolean esPasillo)
    {
        this.esPasillo = esPasillo;
    }

    //Método para saber si un asiento es pasillo o no
    public boolean getEsPasillo() 
    {
        return this.esPasillo;
    }

    //Metodo para saber si un asiento está ocupado o no
    public boolean getOcupado()
    {
        return this.ocupado;
    }

    //Método para cambiar el estado de ocupado
    public void setOcupado(boolean ocupado) 
    {
        this.ocupado = ocupado;
    }
    //Determina si un asiento está libre o no
    public boolean estaLibre()
    {
        return !esPasillo && persona == null;
        //Para que esté libre necesita no ser un pasillo y no tener una persona
    }

    //Método acomodar para luego usar un acomodador
    public void acomodar(Persona personaActual)
    {
        if (!esPasillo && persona == null)
        {
            persona = personaActual;
        }
        else
        {
            System.out.println("¡Este espcio es un pasillo o ya está ocupado!");
        }
    }

    //Método del estado del asiento, para luego llamarlo en el visualizador
    public String estadoAsiento()
    {
        String estadoActual;
        if (esPasillo)
        {
            estadoActual = "|";
        }
        else if (persona == null)
        {
            estadoActual = ".";
        }
        else
        {
            estadoActual = "X";
        }
        return estadoActual;
    }
}