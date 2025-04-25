package PackageAjedrez;

public class Peon extends Ficha {

    public Peon(String colorFicha) {
        super(colorFicha);
    }

    @Override
    public int movimiento() {
        return 0;
    }
}
