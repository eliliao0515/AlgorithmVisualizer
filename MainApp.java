import Algorithms.IsAlgorithm;
import Algorithms.SelectionSort;
import Array.SortArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainApp extends JFrame {
    private JButton startButton = new JButton("Start sorting");
    private JButton shuffleButton = new JButton("Shuffle");
    private SortArray panel;
    private String[] options;

    public MainApp() {
        IsAlgorithm algorithm = new SelectionSort();

        setName(algorithm.getName());

        panel = new SortArray(100);

        Listener listener = new Listener(panel);

        startButton.addActionListener(listener);
        shuffleButton.addActionListener(listener);

        // Get all algorithms
        options = panel.getAlgorithms();

        JComboBox<String> comboBox = new JComboBox<>(options);

        comboBox.addActionListener(e -> panel.changeAlgorithm((String) comboBox.getSelectedItem()));

        panel.add(comboBox);

        panel.add(startButton);
        panel.add(shuffleButton);

        add(panel);

    }

    public void run() {
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}

class Listener implements ActionListener {
    SortArray panel;
    public Listener(SortArray panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();
        if (buttonText == "Start sorting") {
            panel.sort();
        }
        else if (buttonText == "Shuffle") {
            panel.shuffleArray();
        }
    }
}