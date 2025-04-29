package PackageAjedrez;

public class Tablero {
    private Ficha[][] tablero;

    public Tablero () {
        tablero = new Ficha[8][8];
        inicializarTablero();
    }
    private void inicializarTablero (){
        tablero[0][0] = new Torre("Blanco");
        tablero[0][1] = new Caballo("Blanco");
        tablero[0][2] = new Alfil("Blanco");
        tablero[0][3] = new Reina("Blanco");
        tablero[0][4] = new Rey("Blanco");
        tablero[0][5] = new Alfil("Blanco");
        tablero[0][6] = new Caballo("Blanco");
        tablero[0][7] = new Torre("Blanco");

        for (int i = 0;  i < 8; i++){
            tablero [1][i] = new Peon("Blanco");
        }
        tablero[7][0] = new Torre("Negro");
        tablero[7][1] = new Caballo("Negro");
        tablero[7][2] = new Alfil("Negro");
        tablero[7][3] = new Reina("Negro");
        tablero[7][4] = new Rey("Negro");
        tablero[7][5] = new Alfil("Negro");
        tablero[7][6] = new Caballo("Negro");
        tablero[7][7] = new Torre("Negro");

        for (int i = 0;  i < 8; i++) {
            tablero[6][i] = new Peon("Negro");
        }

    }

}
