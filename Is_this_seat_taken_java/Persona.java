public class Persona 
{
    private String nombre;
    private String edad;
    private String fila;
    private String columna;
    private String huele_a;
    private String tiene;
    private String al_lado;
    private String odia_olor;    
    public Persona()
    {
        this.nombre = "";
        this.edad = "";
        this.fila = "";
        this.columna = "";
        this.huele_a = "";
        this.tiene = "";
        this.al_lado = "";
        this.odia_olor = "";
    }
    //Estos voids permite modificar los valores desde el lectorCSV. 
    public void changeName(String name)
    {
        this.nombre = name;
    }

     public void changeEdad(String edad)
    {
        this.edad = edad;
    }

     public void changeFila(String fila)
    {
        this.fila = fila;
    }

     public void changeColumna(String columna)
    {
        this.columna = columna;
    }

     public void changeHuele(String huele)
    {
        this.huele_a = huele;
    }

     public void changeTiene(String tiene)
    {
        this.tiene = tiene;
    }

     public void changeAlLado(String alLado)
    {

        this.al_lado = alLado;
    }
    
     public void changeOdiaOlor(String odiaOlor)
    {
        this.odia_olor = odiaOlor;
    }


    public String getNombre()
    {
        return this.nombre;
    }

    public void printPersona()
    {
        System.out.print(this.nombre +"," + this.edad +"," + this.fila +"," + this.columna +"," + this.huele_a +"," + this.tiene +"," + this.al_lado +"," + this. odia_olor + "\n"); 
    }
}  