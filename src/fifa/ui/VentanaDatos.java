package fifa.ui;

import javax.swing.*;
import fifa.modelo.Analizador;
import fifa.modelo.Partido;
import java.awt.*;
import java.util.ArrayList;

public class VentanaDatos extends JFrame {

    public VentanaDatos(Analizador analizador) {
        setTitle("Datos Generales — FIFA");
        setSize(900, 500);

        String[] columnas = {"Fecha","Local","Visitante","Goles Local","Goles Visitante","Torneo"};
        ArrayList<Partido> lista = analizador.getPartidos();

        String[][] datos = new String[lista.size()][6];

        for (int i = 0; i < lista.size(); i++) {
            Partido p = lista.get(i);
            datos[i][0] = p.getFecha();
            datos[i][1] = p.getHome();
            datos[i][2] = p.getAway();
            datos[i][3] = String.valueOf(p.getHomeGoals());
            datos[i][4] = String.valueOf(p.getAwayGoals());
            datos[i][5] = p.getTorneo();
        }

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
