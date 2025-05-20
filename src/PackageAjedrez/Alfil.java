package PackageAjedrez;

public class Alfil extends Ficha {

    public Alfil(ColorFicha colorFicha) {
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

        if ((filaDestino > filaActual && columnaDestino > columnaActual) ||
                (filaDestino > filaActual && columnaDestino < columnaActual) ||
                (filaDestino < filaActual && columnaDestino > columnaActual) ||
                (filaDestino < filaActual && columnaDestino < columnaActual)) {

            int pasoFila = (filaDestino > filaActual) ? 1 : -1;
            int pasoColumna = (columnaDestino > columnaActual) ? 1 : -1;


            for (int i = 1; i < Math.abs(filaDestino - filaActual); i++) {
                if (tablero.getTablero()[filaActual + i * pasoFila][columnaActual + i * pasoColumna] != null) {
                    return false;
                }
            }

            if (tablero.getTablero()[filaDestino][columnaDestino] == null ||
                    !tablero.getTablero()[filaDestino][columnaDestino].getColorFicha().equals(this.colorFicha)) {
                return true;
            }
        }
        return false;
    }
}
