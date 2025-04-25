package PackageAjedrez;

abstract class Ficha {
    protected String colorFicha;

    public Ficha(String colorFicha) {
        this.colorFicha = colorFicha;
    }
    public abstract int movimiento ();

}
