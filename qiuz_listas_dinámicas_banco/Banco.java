import java.util.Scanner;

public class Banco {
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            boolean abierto = true;
            ColaDePrioridades cola = new ColaDePrioridades();
            while (abierto) {
                System.out.println("¿Que va a pasar ahora?\n1. Llegó un cliente\n2. Se atiende a un cliente\n3. El banco cierra");
                int caso = sc.nextInt();
                switch (caso) {
                    case 1:
                        System.out.println("Bienvenido al banco, por favor digite su nombre: ");
                        sc.nextLine();
                        String nombre = sc.nextLine();
                        System.out.println("Por favor, digite su nivel de prioridad: \n1. Adulto Mayor\n2. Embarazada\n3. Persona con necesidades especiales\n4. Regular");
                        int prioridad = sc.nextInt();
                        cola.agregar(nombre, prioridad);
                        break;
                    case 2:
                        cola.sacar();
                        break;
                    case 3:
                        System.out.println("El banco ha cerrado.");
                        abierto = false;
                        cola.imprimirPersonasRestantes();
                        break;
                    default:
                        System.out.println("Por favor digite un escenario válido.");
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
