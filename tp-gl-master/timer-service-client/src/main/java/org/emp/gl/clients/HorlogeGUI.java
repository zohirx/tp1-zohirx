package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private TimerService timerService;
    private JLabel heureLabel;
    private JLabel dateLabel;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);

        initUI();
    }

    private void initUI() {
        setTitle("Horloge Digitale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        // Label pour l'heure
        heureLabel = new JLabel("", SwingConstants.CENTER);
        heureLabel.setFont(new Font("Digital-7", Font.BOLD, 72));
        heureLabel.setForeground(Color.GREEN);

        // Label pour la date
        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dateLabel.setForeground(Color.LIGHT_GRAY);

        panel.add(heureLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        add(panel);

        // Afficher l'heure initiale
        updateDisplay();
    }

    private void updateDisplay() {
        SwingUtilities.invokeLater(() -> {
            String heure = String.format("%02d:%02d:%02d",
                    timerService.getHeures(),
                    timerService.getMinutes(),
                    timerService.getSecondes());
            heureLabel.setText(heure);

            java.time.LocalDate date = java.time.LocalDate.now();
            dateLabel.setText(date.toString());
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (SECONDE_PROP.equals(evt.getPropertyName())) {
            updateDisplay();
        }
    }
}