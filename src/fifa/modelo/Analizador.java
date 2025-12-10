package fifa.modelo;

import java.io.*;
import java.util.*;

public class Analizador {

    private ArrayList<Partido> partidos = new ArrayList<>();

    public void cargarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");

                String fecha = d[0];
                String home = d[1];
                String away = d[2];
                int homeGoals = Integer.parseInt(d[3]);
                int awayGoals = Integer.parseInt(d[4]);
                String torneo = d[5];

                partidos.add(new Partido(fecha, home, away, homeGoals, awayGoals, torneo));
            }

        } catch (Exception e) {
            System.out.println("Error cargando CSV: " + e.getMessage());
        }
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public int getVictorias(String equipo) {
        int v = 0;
        for (Partido p : partidos) {
            if (p.getHome().equalsIgnoreCase(equipo) && p.getHomeGoals() > p.getAwayGoals()) v++;
            if (p.getAway().equalsIgnoreCase(equipo) && p.getAwayGoals() > p.getHomeGoals()) v++;
        }
        return v;
    }

    public int getDerrotas(String equipo) {
        int d = 0;
        for (Partido p : partidos) {
            if (p.getHome().equalsIgnoreCase(equipo) && p.getHomeGoals() < p.getAwayGoals()) d++;
            if (p.getAway().equalsIgnoreCase(equipo) && p.getAwayGoals() < p.getHomeGoals()) d++;
        }
        return d;
    }

    public int getEmpates(String equipo) {
        int e = 0;
        for (Partido p : partidos) {
            if ((p.getHome().equalsIgnoreCase(equipo) || p.getAway().equalsIgnoreCase(equipo))
                    && p.getHomeGoals() == p.getAwayGoals()) e++;
        }
        return e;
    }

    public int getGolesAFavor(String equipo) {
        int g = 0;
        for (Partido p : partidos) {
            if (p.getHome().equalsIgnoreCase(equipo)) g += p.getHomeGoals();
            if (p.getAway().equalsIgnoreCase(equipo)) g += p.getAwayGoals();
        }
        return g;
    }
}
