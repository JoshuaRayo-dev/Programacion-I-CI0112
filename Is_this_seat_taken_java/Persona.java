public class Persona {
    private String nombre;
    private int edad;
    private String fila;
    private String columna;
    private String huele_a;
    private String tiene;
    private String al_lado;
    private String odia_olor;
    private boolean esFeliz;
    private String[] datos; // Indispensable para el log
    private int problemas;
    private int variableAlegria;

    public Persona() {
        this.variableAlegria = 0;
        this.datos = new String[10];
        this.nombre = "";
        this.edad = 1;
        this.fila = "";
        this.columna = "";
        this.huele_a = "";
        this.tiene = "";
        this.al_lado = "";
        this.odia_olor = "";
        this.problemas = 0;
        this.esFeliz = false;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = extraerValor(nombre);
    }

    public void setEdad(String edad) {
        int nuevaEdad = Integer.parseInt(extraerValor(edad));
        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
        }
        else {
            System.out.println("Edad inválida.Edad predeterminada aplicada: 1");
        }
    }

    public void setFila(String fila) {
        this.fila = extraerValor(fila);
    }

    public void setColumna(String columna) {
        this.columna = extraerValor(columna);
    }

    public void setHueleA(String huele_a) {
        this.huele_a = extraerValor(huele_a);
    }

    public void setTiene(String tiene) {
        this.tiene = extraerValor(tiene);
    }

    public void setAlLado(String al_lado) {
        this.al_lado = extraerValor(al_lado);
    }

    public void setOdiaOlor(String odia_olor) {
        this.odia_olor = extraerValor(odia_olor);
    }
    public void setEsFeliz(boolean b) {
        this.esFeliz = b;
    }

    // Este metodo interno simplifica la extraccion de valores, para no repetir lo mismo en cada setter
    private String extraerValor(String campo) {
        String[] partes = campo.split(":");
        return partes[partes.length-1];
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public int getEdad() { 
        return edad; 
    }
    public String getFila() {
        return fila;
    }
    public String getColumna() {
        return columna;
    }
    public String getHueleA() {
        return huele_a;
    }
    public String getTiene() {
        return tiene;
    }
    public String getAlLado() {
        return al_lado;
    }
    public String getOdiaOlor() {
        return odia_olor;
    }
    public boolean getEsFeliz() {
        return this.esFeliz;
    }

    // Metodos relacionados al inspector
    public void setEstadoAlegria(String estadoAlegria, int cantidadProblemas) {
        this.problemas += cantidadProblemas;
        if(this.problemas == 0) {
            this.datos[this.variableAlegria] = (this.nombre + " es feliz");
            this.esFeliz = true;
        }
        else {
            this.datos[this.variableAlegria] = (estadoAlegria);
            this.variableAlegria++;
            this.esFeliz = false;
        }
    }
}
