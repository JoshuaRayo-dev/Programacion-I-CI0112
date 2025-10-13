public class Asiento {
    private boolean esPasillo;
    private boolean oupado;
    private Persona persona;

    public Asiento(boolean esPasillo) {
        this.esPasillo = esPasillo;
    }

    public boolean getEsPasillo() {
        return this.esPasillo;
    }

    public boolean getOcupado() {
        return this.oupado;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public String estadoAsiento() {
        String estadoActual;
        if (esPasillo) {
            estadoActual = "|";
        }
        else if (persona == null) {
            estadoActual = ".";
        }
        else {
            if (persona.getEsFeliz() == true) {
                estadoActual = "O";
            }
            else {
                estadoActual = "X";
            }
        }
        return estadoActual;
    }

    // Metodo auxiliar, para luego llamar en el acomodador
    public void acomodarPersona(Persona nuevaPersona) {
        if (!esPasillo && persona==null) {
            this.persona = nuevaPersona;
        }
        else {
            System.out.println("No se puede acomodar a la persona.");
        }
    }
}
