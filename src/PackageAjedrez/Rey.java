package PackageAjedrez;

public class Rey extends Ficha{

    public Rey(ColorFicha colorFicha) {
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
        int direccion = (getColorFicha() == ColorFicha.BLANCO)? 1 : -1;

        if ((filaDestino == filaActual - 1 && columnaDestino == columnaActual) ||
                (filaDestino == filaActual + 1 && columnaDestino == columnaActual) ||
                (filaDestino == filaActual && columnaDestino == columnaActual - 1) ||
                (filaDestino == filaActual && columnaDestino == columnaActual + 1) ||
                (filaDestino == filaActual - 1 && columnaDestino == columnaActual - 1) ||
                (filaDestino == filaActual - 1 && columnaDestino == columnaActual + 1) ||
                (filaDestino == filaActual + 1 && columnaDestino == columnaActual - 1) ||
                (filaDestino == filaActual + 1 && columnaDestino == columnaActual + 1)) {

            if (tablero.getTablero()[filaDestino][columnaDestino] == null ||
                    !tablero.getTablero()[filaDestino][columnaDestino].getColorFicha().equals(this.colorFicha)) {
                return true;
            }
        }
        return false;
    }
}
