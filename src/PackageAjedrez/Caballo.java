package PackageAjedrez;

public class Caballo extends Ficha {

    public Caballo(ColorFicha colorFicha) {
        super(colorFicha);
    }

    @Override
    public boolean mover(Posicion destino, Tablero tablero) {
        if (getPosicion() == null || destino == null) {
            return false;
        }

        int filaActual = getPosicion().getFila();
        int columnaActual = getPosicion().getColumna();
        int filaDestino = destino.getFila();
        int columnaDestino = destino.getColumna();
        int direccion = (getColorFicha() == ColorFicha.BLANCO) ? 1 : -1;
        int deltaFila = filaDestino - filaActual;
        int deltaColumna = columnaDestino - columnaActual;

        boolean movimientoValido =
                (deltaFila == 2 && (deltaColumna == 1 || deltaColumna == -1)) ||
                        (deltaFila == -2 && (deltaColumna == 1 || deltaColumna == -1)) ||
                        (deltaColumna == 2 && (deltaFila == 1 || deltaFila == -1)) ||
                        (deltaColumna == -2 && (deltaFila == 1 || deltaFila == -1));

        if (!movimientoValido) {
            return false;
        }

        Ficha fichaDestino = tablero.getTablero()[filaDestino][columnaDestino];

        if (fichaDestino != null && fichaDestino.getColorFicha() == this.getColorFicha()) {
            return false;
        }


        tablero.getTablero()[filaActual][columnaActual] = null;
        tablero.getTablero()[filaDestino][columnaDestino] = this;
        setPosicion(destino);

        return true;
    }


}
