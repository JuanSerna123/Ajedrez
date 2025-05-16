package PackageAjedrez;

public class Peon extends Ficha {

    public Peon(ColorFicha colorFicha) {
        super(colorFicha);
    }

    @Override
    public boolean mover(Posicion destino, Tablero tablero) {


        boolean posicionDentroDelTablero = this.validarPosicionDentroDelTablero(destino);

        if (getPosicion() == null || destino == null) {
            return false;
        }

        int filaActual = getPosicion().getFila();
        int columnaActual = getPosicion().getColumna();
        int filaDestino = destino.getFila();
        int columnaDestino = destino.getColumna();
        int direccion = (getColorFicha() == ColorFicha.BLANCO) ? 1 : -1;

        if (ColorFicha.BLANCO.equals(this.colorFicha) && this.getPosicion().getFila() == 6) {
            if ((filaDestino == 4 || filaDestino == 5) && tablero.getTablero()[destino.getFila()][destino.getColumna()] == null)
                return true;
        } else if (filaDestino == this.getPosicion().getFila() - 1 && ColorFicha.BLANCO.equals(this.colorFicha) && columnaDestino == getPosicion().getColumna())
            return true;
        if (tablero.getTablero()[destino.getFila()][destino.getColumna()].colorFicha.equals(ColorFicha.NEGRO) && this.getPosicion().getColumna() - 1 == destino.getColumna() + 1)
            return true;

        if (ColorFicha.NEGRO.equals(this.colorFicha) && this.getPosicion().getFila() == 1) {
            if ((filaDestino == 2 || filaDestino == 3) && tablero.getTablero()[destino.getFila()][destino.getColumna()] == null)
                return true;
        } else if (filaDestino == this.getPosicion().getFila() + 1 && ColorFicha.NEGRO.equals(this.colorFicha) && columnaDestino == getPosicion().getColumna())
            return true;
        if (tablero.getTablero()[destino.getFila()][destino.getColumna()].colorFicha.equals(ColorFicha.BLANCO) && this.getPosicion().getColumna() - 1 == destino.getColumna() + 1)
            return true;
        return false;
    }

}
