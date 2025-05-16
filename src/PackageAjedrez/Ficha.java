package PackageAjedrez;

public abstract class Ficha {
    protected ColorFicha colorFicha;
    protected Posicion posicion;

    public Ficha(ColorFicha colorFicha) {
        this.colorFicha = colorFicha;
        this.posicion = null;
    }

    public ColorFicha getColorFicha() {
        return colorFicha;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean validarPosicionDentroDelTablero(Posicion posicion){
        if(posicion.getColumna() > 7 || posicion.getColumna() < 0) return  false;
        if(posicion.getFila() > 7 || posicion.getFila() < 0) return  false;
        return  true;

    }

    public abstract boolean mover(Posicion destino, Tablero tablero);
}