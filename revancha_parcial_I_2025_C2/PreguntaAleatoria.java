public class PreguntaAleatoria {
    private int operacion;
    private int op1;
    private int op2;
    private String enunciado;
    private int[] opciones;
    private int correcto;
    private int indexCorrecto;

    public PreguntaAleatoria() {
        this.operacion = (int)(Math.random()*4);
        this.op1 = (int)(Math.random()*101);
        this.op2 = (int)(Math.random()*101);
        this.opciones = new int[3];
    }

    public String definirOperacion() {
        String op = "";
        if (operacion == 0) {
            op = "suma";
        }
        else if (operacion == 1) {
            op = "resta";
        }
        else if (operacion == 2) {
            op = "multiplicación";
        }
        else {
            op = "división";
        }
        return op;
    }

    public int respuestaAleatoria() {
        int ran = 0;
        if (operacion == 0) {
            int x = (int)(Math.random()*2);
            if (x == 0){
                ran = (op1+op2)+((int)(Math.random()*21));
            }
            else {
                ran = op1+op2+5;
            }
        }
        else if (operacion == 1) {
           int x = (int)(Math.random()*2);
            if (x == 0){
                ran = op1+op2;
            }
            else {
                ran = op1-op2+((int)(Math.random()*11));
            }        
        }
        else if (operacion == 2) {
           int x = (int)(Math.random()*2);
            if (x == 0){
                ran = (op1*op2)+((int)(Math.random()*51));
            }
            else {
                ran = (op1*op2)+op1;
            } 
        }
        else {
           int x = (int)(Math.random()*2);
            if (x == 0){
                ran = (op1/op2)+((int)(Math.random()*5));
            }
            else {
                ran = op1%op2+((int)(Math.random()*11));
            }  
        }
        return ran;
    }

    public String definirOperacionExpresada() {
        String op = "";
        if (operacion == 0) {
            op = "más";
        }
        else if (operacion == 1) {
            op = "menos";
        }
        else if (operacion == 2) {
            op = "por";
        }
        else {
            op = "entre";
        }
        return op;
    }

    public void setEnunciado() {
        this.enunciado = "El resultado al aplicar la "+definirOperacion()+" de "+op1+" "+definirOperacionExpresada()+" "+op2+" es:";
    }

    public boolean verificarResta() {
        boolean valido = true;
        if (op1-op2<0) {
            valido = false;
        }
        return valido;
    }

    public int verificarDivision() {
        int caso = 0;
        if (op2 == 0) {
            caso = 1;
        }
        else if (op1%op2!=0) {
            caso = 2;
        }
        return caso;
    }

    public void evaluarResta() {
        boolean valido = verificarResta();
        if (!valido) {
            int temp = op1;
            this.op1 = this.op2;
            this.op2 = temp;
        }
    }

    public void evaluarDivision() {
        int caso = verificarDivision();
        if (caso == 1) {
            while (op2 == 0) {
                this.op2 = (int)(Math.random()*101);
            }
            evaluarDivision();
        }
        else if (caso == 2) {
            while (op1%op2 != 0) {
                while (op2 == 0) {
                    this.op2 = (int)(Math.random()*101);
                }
            }
        }
    }

    public void setCorrecto() {
        int correcto = 0;
        if (operacion == 0) {
            correcto = op1+op2;
        }
        else if (operacion == 1) {
            evaluarResta();
            correcto = op1-op2;
        }
        else if (operacion == 2) {
            correcto = op1*op2;
        }
        else {
            evaluarDivision();
            correcto = op1/op2;
        }
        this.correcto = correcto;
    }

    public void inicializarOpciones() {
        opciones[0] = this.correcto;
        int ran;
        for (int i=1; i<opciones.length; i++) {
            ran = respuestaAleatoria();
            opciones[i] = ran;
        }
    }

    public void shuffleOpciones() {
        int veces = (int)(Math.random()*12);
        int temp;
        for (int i=0; i<=veces; i++) {
            temp = opciones[0];
            opciones[0] = opciones[1];
            opciones[1] = opciones[2];
            opciones[2] = temp;
        }
        setIndexCorrecto();
    }

    public void setIndexCorrecto() {
        int i = 0;
        while (opciones[i] != correcto && i<opciones.length) {
            i++;
        }
        indexCorrecto = i;
    }

    public int getIndexCorrecto() {
        return indexCorrecto;
    }

    @Override
    public String toString() {
        return enunciado+"\n1. "+opciones[0]+"\n2. "+opciones[1]+"\n3. "+opciones[2]+"\n4. No sabe o no responde\nRespuesta: ";
    }
}
