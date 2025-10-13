public class Asiento {
    private boolean esPasillo;
    private boolean esCentral;
    private boolean oupado;
    private Persona persona;

    public Asiento(boolean esPasillo) {
        this.esPasillo = esPasillo;
        this.esCentral = false;
    }

    public boolean getEsPasillo() {
        return this.esPasillo;
    }

    public boolean getEsCentral() {
        return this.esCentral;
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
                estadoActual = ("\u001B[32m" + "O" + "\u001B[0m");
            }
            else {
                estadoActual = ("\u001B[31m" + "X" + "\u001B[0m");
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

    //
    public void setEsCentral(boolean b) {
        this.esCentral = b;
    }
}
