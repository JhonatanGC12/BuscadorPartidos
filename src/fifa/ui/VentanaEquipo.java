package fifa.ui;

import javax.swing.*;
import fifa.modelo.Analizador;
import java.awt.*;

public class VentanaEquipo extends JFrame {

    public VentanaEquipo(Analizador analizador) {
        setTitle("Buscar Equipo — FIFA");
        setSize(400, 300);
        setLayout(new FlowLayout());

        JLabel lbl = new JLabel("Equipo:");
        JTextField txt = new JTextField(15);
        JButton buscar = new JButton("Buscar");

        JLabel vict = new JLabel("Victorias: ");
        JLabel der = new JLabel("Derrotas: ");
        JLabel emp = new JLabel("Empates: ");
        JLabel gols = new JLabel("Goles a favor: ");

        buscar.addActionListener(e -> {
            String eq = txt.getText();
            vict.setText("Victorias: " + analizador.getVictorias(eq));
            der.setText("Derrotas: " + analizador.getDerrotas(eq));
            emp.setText("Empates: " + analizador.getEmpates(eq));
            gols.setText("Goles a favor: " + analizador.getGolesAFavor(eq));
        });

        add(lbl);
        add(txt);
        add(buscar);
        add(vict);
        add(der);
        add(emp);
        add(gols);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
