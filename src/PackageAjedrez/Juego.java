package PackageAjedrez;
import java.util.Scanner;


public class Juego {
    private Tablero tablero;
    private ColorFicha turnoActual;
    private boolean juegoTerminado;

    public Juego() {
        tablero = new Tablero();
        turnoActual = ColorFicha.BLANCO;
        juegoTerminado = false;
        inicializarPosicionesFichas();
    }

    private void inicializarPosicionesFichas() {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Ficha ficha = tablero.getTablero()[fila][columna];
                if (ficha != null) {
                    ficha.setPosicion(new Posicion(fila, columna));
                }
            }
        }
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        while (!juegoTerminado) {
            imprimirTablero();
            System.out.println("Turno de las " + turnoActual + ".");


            System.out.println("Ingresa la fila de la ficha a mover (0-7):");
            int filaOrigen = scanner.nextInt();
            System.out.println("Ingresa la columna de la ficha a mover (0-7):");
            int columnaOrigen = scanner.nextInt();


            Posicion origen = new Posicion(filaOrigen, columnaOrigen);
            if (filaOrigen < 0 || filaOrigen > 7 || columnaOrigen < 0 || columnaOrigen > 7) {
                System.out.println("Posición de origen inválida. Las coordenadas deben ser entre 0 y 7.");
                continue;
            }

            Ficha fichaSeleccionada = tablero.getTablero()[filaOrigen][columnaOrigen];
            if (fichaSeleccionada == null || !fichaSeleccionada.getColorFicha().equals(turnoActual)) {
                System.out.println("Movimiento inválido. No hay ficha en esa posición o no es tu turno.");
                continue;
            }

            System.out.println("Ingresa la fila de destino (0-7):");
            int filaDestino = scanner.nextInt();
            System.out.println("Ingresa la columna de destino (0-7):");
            int columnaDestino = scanner.nextInt();

            Posicion destino = new Posicion(filaDestino, columnaDestino);

            if (!fichaSeleccionada.validarPosicionDentroDelTablero(destino)) {
                System.out.println("Movimiento inválido. La posición de destino está fuera del tablero.");
                continue;
            }

            Ficha fichaEnDestino = tablero.getTablero()[filaDestino][columnaDestino];

            if (fichaSeleccionada.mover(destino, tablero)) {
                if (fichaEnDestino instanceof Rey) {
                    System.out.println("¡Jaque al Rey! Las " + turnoActual + " han ganado el juego.");
                    juegoTerminado = true;
                    break;
                }

                tablero.getTablero()[filaDestino][columnaDestino] = fichaSeleccionada;
                tablero.getTablero()[filaOrigen][columnaOrigen] = null;
                fichaSeleccionada.setPosicion(destino);


                turnoActual = (turnoActual == ColorFicha.BLANCO) ? ColorFicha.NEGRO : ColorFicha.BLANCO;
            } else {
                System.out.println("Movimiento inválido para esta ficha.");
            }
        }
        scanner.close();
    }

    private void imprimirTablero() {
        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.println("-----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 8; j++) {
                Ficha ficha = tablero.getTablero()[i][j];
                if (ficha == null) {
                    System.out.print(" _ ");
                } else {
                    String representacion = " ";
                    if (ficha.getColorFicha() == ColorFicha.BLANCO) {
                        if (ficha instanceof Peon) representacion = " PB";
                        else if (ficha instanceof Torre) representacion = " TB";
                        else if (ficha instanceof Caballo) representacion = " CB";
                        else if (ficha instanceof Alfil) representacion = " AB";
                        else if (ficha instanceof Reina) representacion = " QB";
                        else if (ficha instanceof Rey) representacion = " RB";
                    } else {
                        if (ficha instanceof Peon) representacion = " PN";
                        else if (ficha instanceof Torre) representacion = " TN";
                        else if (ficha instanceof Caballo) representacion = " CN";
                        else if (ficha instanceof Alfil) representacion = " AN";
                        else if (ficha instanceof Reina) representacion = " QN";
                        else if (ficha instanceof Rey) representacion = " RN";
                    }
                    System.out.print(representacion);
                }
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}