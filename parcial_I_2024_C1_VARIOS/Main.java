public class Main {
    public static void main(String[] args) {

        Agente a1 = new Agente();
        Agente a2 = new Agente();
        Agente a3 = new Agente();
        Agente a4 = new Agente();
        Agente a5 = new Agente();
        
        ColaDeMensajes canal = new ColaDeMensajes();
        MatrizConComida comida = new MatrizConComida();

        comida.asignarACeldasAleatorias();

    }
}
