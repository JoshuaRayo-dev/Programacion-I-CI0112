public class Main 
{
    public static void main(String[] args) 
    {
        lectorCSV lector = new lectorCSV("Reglas.csv", "Distribucion.csv");
        //Muestra de funcionalidad
        for (int i = 0; i < 6; i++)
        {
            System.out.println("Persona " + (i+1));
            lector.printPersona(i);
            System.out.println();
        }
        

        Sala cine = new Sala("8x11x2");
        cine.visualizador();

        Persona persona1 = lector.getPersona(0);
        cine.acomodador(persona1, 0, 0);
    }
}
