public class Tablero {
    private char[][] tablero;
    private int tamañoTablero;

    public Tablero(int tamaño) {
        tamañoTablero = tamaño;
        tablero = new char[tamañoTablero][tamañoTablero];
        inicializarTablero();
    }
    public int getTamañoTablero() {
        return tamañoTablero;
    }

    // Inicializa el tablero con espacios vacíos
    private void inicializarTablero() {
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    // Muestra el tablero en la consola con mejor formato
    public void imprimir() {
        System.out.println("----------------------------");
        for (int i = 0; i < tamañoTablero; i++) {
            System.out.print("| ");
            for (int j = 0; j < tamañoTablero; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------------------");
        }
    }

    // Intenta colocar una marca en el tablero
    public boolean poner(int fila, int columna, char valor) {
        if (fila >= 0 && fila < tamañoTablero && columna >= 0 && columna < tamañoTablero && tablero[fila][columna] == '-') {
            tablero[fila][columna] = valor;
            return true; 
        }
        return false; 
    }

    
    public boolean hayGanador(char valor) {
        
        for (int i = 0; i < tamañoTablero; i++) {
            if (tablero[i][0] == valor && tablero[i][1] == valor && tablero[i][2] == valor) return true; // Filas
            if (tablero[0][i] == valor && tablero[1][i] == valor && tablero[2][i] == valor) return true; // Columnas
        }
        
        if (tablero[0][0] == valor && tablero[1][1] == valor && tablero[2][2] == valor) return true;
        if (tablero[0][2] == valor && tablero[1][1] == valor && tablero[2][0] == valor) return true;
        return false;
    }

   
    public boolean esEmpate() {
        for (int i = 0; i < tamañoTablero; i++) {
            for (int j = 0; j < tamañoTablero; j++) {
                if (tablero[i][j] == '-') return false;
            }
        }
        return true;
    }
    public char[][] getTablero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTablero'");
    }
}
