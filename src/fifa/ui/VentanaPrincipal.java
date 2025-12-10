package fifa.ui;

import javax.swing.*;
import fifa.modelo.Analizador;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(Analizador analizador) {
        setTitle("Analizador de Datos FIFA");
        setSize(400, 200);
        setLayout(new GridLayout(3,1));

        JButton btnDatos = new JButton("Ver Datos Generales");
        JButton btnEquipo = new JButton("Buscar Equipo");

        btnDatos.addActionListener(e -> new VentanaDatos(analizador));
        btnEquipo.addActionListener(e -> new VentanaEquipo(analizador));

        add(new JLabel("Selecciona una opción:", SwingConstants.CENTER));
        add(btnDatos);
        add(btnEquipo);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
