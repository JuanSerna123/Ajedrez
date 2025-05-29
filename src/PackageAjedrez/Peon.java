package PackageAjedrez;

public class Peon extends Ficha {

    public Peon(ColorFicha colorFicha) {
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

        if (!validarPosicionDentroDelTablero(destino)) {
            return false;
        }

        if (columnaDestino == columnaActual) {
            if (filaDestino == filaActual + direccion && tablero.getTablero()[filaDestino][columnaDestino] == null) {
                return true;
            }
            if ((filaActual == 1 && getColorFicha() == ColorFicha.BLANCO && filaDestino == filaActual + 2 && tablero.getTablero()[filaActual + 1][columnaActual] == null && tablero.getTablero()[filaDestino][columnaDestino] == null) ||
                    (filaActual == 6 && getColorFicha() == ColorFicha.NEGRO && filaDestino == filaActual - 2 && tablero.getTablero()[filaActual - 1][columnaActual] == null && tablero.getTablero()[filaDestino][columnaDestino] == null)) {
                return true;
            }
        }

        if (Math.abs(columnaDestino - columnaActual) == 1 && filaDestino == filaActual + direccion) {
            Ficha fichaEnDestino = tablero.getTablero()[filaDestino][columnaDestino];
            if (fichaEnDestino != null && fichaEnDestino.getColorFicha() != this.getColorFicha()) {
                return true;
            }
        }

        return false;
    }
}
