package fifa;
import fifa.modelo.Analizador;
import fifa.ui.VentanaPrincipal;

public class App {

    public static void main(String[] args) {
        Analizador analizador = new Analizador();
        analizador.cargarCSV("results.csv"); 

        new VentanaPrincipal(analizador);
    }
}
