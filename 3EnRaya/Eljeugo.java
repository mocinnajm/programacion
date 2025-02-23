import java.util.Random;
import java.util.Scanner;

public class Eljeugo {
    private Tablero tablero;
    private char jugadorActual;
    private boolean ganador;
    private Scanner entrada;
    

    public Eljeugo() {
        
        jugadorActual = 'X';
        ganador = false;
        entrada = new Scanner(System.in);
        
    }
   
    
      

    public void jugar() {
        System.out.println("¡Bienvenido al Tres en Raya! ");
        int tamañoTablero = elegirTamañoTablero();
        tablero = new Tablero(tamañoTablero); // Crea un tablero con el tamaño elegido
        ganador = false;
        elegirTamañoTablero();

        elegirJugadorInicial() ;

        while (!ganador && !tablero.esEmpate()) {
            tablero.imprimir();
            turnoActual();
            ganador = tablero.hayGanador(jugadorActual);

            if (!ganador) {
                cambiarTurno();
            }
        }

        tablero.imprimir();
        if (ganador) {
            System.out.println("¡Felicidades! El jugador " + jugadorActual + " ha ganado.");
        } else {
            System.out.println("¡Empate!");
        }
        entrada.close();
    }
    public void elegirJugadorInicial() {
        System.out.println(" ¿Quién quiere empezar primero? (X / O): ");
        String eleccion = entrada.next();

        if (eleccion.equals("X") || eleccion.equals("x")) {
            jugadorActual = 'X';
        } else if (eleccion.equals("O") || eleccion.equals("o")) {
            jugadorActual = 'O';
        } else {
            System.out.println("Entrada inválida. Introduce 'X' o 'O'.");
            elegirJugadorInicial(); // Volver a preguntar si la entrada es incorrecta
            return;
        }

        System.out.println("El jugador " + jugadorActual + " empieza primero.");
    }

    public void turnoActual() {
        int fila, columna;

        
        for (boolean movimientoValido = false; !movimientoValido; ) {
            System.out.println("Jugador " + jugadorActual + ", introduce número de fila (0-2):");
            fila = entrada.nextInt();
            System.out.println("Jugador " + jugadorActual + ", introduce número de columna (0-2):");
            columna = entrada.nextInt();

            // Intenta colocar la marca
            movimientoValido = tablero.poner(fila, columna, jugadorActual);

            if (!movimientoValido) {
                System.out.println(" Posición ocupada o inválida. Inténtalo de nuevo.");
            }
        }
    }
     public void hacerMovimientoIA() {
        Random rand = new Random();
        int fila, columna;

        // Buscar una posición vacía para colocar la marca de la IA
        do {
            fila = rand.nextInt(tablero.getTamañoTablero());
            columna = rand.nextInt(tablero.getTamañoTablero());
        } while (tablero.getTablero()[fila][columna] != '-');  // Repite hasta encontrar un espacio vacío

        // Coloca la marca de la IA
        tablero.poner(fila, columna, 'O');
        System.out.println("La IA ha colocado su ficha en la fila " + fila + ", columna " + columna);
    }

    public void cambiarTurno() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    public int elegirTamañoTablero() {
        System.out.println("🏓 Elige el tamaño del tablero (3-10): ");
        int tamañoTablero = entrada.nextInt();

        // Usar un solo if-else para la validación
        if (tamañoTablero >= 3 && tamañoTablero <= 10) {
            return tamañoTablero; // Si el tamaño es válido, lo devuelve
        } else {
            // Si el tamaño no es válido, imprime un mensaje y retorna un tamaño predeterminado
            System.out.println("⚠️ Tamaño inválido. Elige un tamaño entre 3 y 10.");
            return 3; // Retorna un tamaño predeterminado (en caso de error)
        }
    }

    

        

    
}
