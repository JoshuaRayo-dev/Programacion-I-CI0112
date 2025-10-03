public class Mensaje {
    private int idFuente;
    private int idEmisor;
    private int idDestinatario;
    private String contenido;

    public Mensaje() {
        this.idFuente = 0;
        this.idEmisor = 0;
        this.idDestinatario = 0;
        this.contenido = "";
    }

    public int getIdDestinatario() {
        return this.idDestinatario;
    }
}
