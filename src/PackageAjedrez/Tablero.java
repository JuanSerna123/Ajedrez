package PackageAjedrez;

public class Tablero {
    private Ficha[][] tablero;

    public Tablero() {
        tablero = new Ficha[8][8];
        inicializarTablero();
    }

    private void inicializarTablero() {
        tablero[0][0] = new Torre(ColorFicha.BLANCO);
        tablero[0][1] = new Caballo(ColorFicha.BLANCO);
        tablero[0][2] = new Alfil(ColorFicha.BLANCO);
        tablero[0][3] = new Reina(ColorFicha.BLANCO);
        tablero[0][4] = new Rey(ColorFicha.BLANCO);
        tablero[0][5] = new Alfil(ColorFicha.BLANCO);
        tablero[0][6] = new Caballo(ColorFicha.BLANCO);
        tablero[0][7] = new Torre(ColorFicha.BLANCO);

        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(ColorFicha.BLANCO);
        }
        tablero[7][0] = new Torre(ColorFicha.NEGRO);
        tablero[7][1] = new Caballo(ColorFicha.NEGRO);
        tablero[7][2] = new Alfil(ColorFicha.NEGRO);
        tablero[7][3] = new Reina(ColorFicha.NEGRO);
        tablero[7][4] = new Rey(ColorFicha.NEGRO);
        tablero[7][5] = new Alfil(ColorFicha.NEGRO);
        tablero[7][6] = new Caballo(ColorFicha.NEGRO);
        tablero[7][7] = new Torre(ColorFicha.NEGRO);

        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(ColorFicha.NEGRO);
        }

    }

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }
}