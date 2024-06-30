package application.scenes;

import static application.screenBuilder.ScreenBuilder.createButton;

import java.awt.*;
import javax.swing.*;

import application.Application;
import application.dijkstra.Dijkstra;
import application.dijkstra.DijkstraVisualizer;
import application.scenes.graph.Graph;

public class AlghorimtVisualisationScene extends Scene {
    private final int n;
    private final int[][] matrix;

    public AlghorimtVisualisationScene(int n, int[][] matrix) {
        this.n = n;
        this.matrix = matrix;
    }

    @Override
    public void create(JFrame frame, Application app) {
        JLabel label_one = new JLabel("Граф");
        label_one.setFont(new Font("Inter", Font.ITALIC + Font.BOLD, 15));
        label_one.setBounds(50, 32, 50, 18);
        frame.getContentPane().add(label_one);

        JLabel label_two = new JLabel("Информация");
        label_two.setFont(new Font("Inter", Font.ITALIC + Font.BOLD, 15));
        label_two.setBounds(645, 32, 110, 18);
        frame.getContentPane().add(label_two);

        JLabel label_three = new JLabel("Таблица значений");
        label_three.setFont(new Font("Inter", Font.ITALIC + Font.BOLD, 15));
        label_three.setBounds(50, 286, 150, 18);
        frame.getContentPane().add(label_three);

        Graph graph = new Graph(n, matrix, 350, 198, 150);
        graph.setVertexRadius(8);
        graph.setMultiplier(0.5);
        graph.setBounds(50, 50, 350, 208);
        graph.setBackground(Color.WHITE);
        graph.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        frame.getContentPane().add(graph);

        JPanel panel_info = new JPanel();
        panel_info.setBounds(462, 50, 288, 208);
        panel_info.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        panel_info.setBackground(Color.WHITE);

        frame.getContentPane().add(panel_info);

        JPanel panel_table = new JPanel();
        panel_table.setBounds(50, 304, 700, 142);
        panel_table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        panel_table.setBackground(Color.WHITE);

        frame.getContentPane().add(panel_table);

        // Создаём кнопку
        JButton button = createButton("Следующий шаг", 20, 299, 466, 202, 84);
        frame.getContentPane().add(button);

        DijkstraVisualizer visualizer = new DijkstraVisualizer();
        Dijkstra algorithm = new Dijkstra(n, matrix, 0, visualizer);

        button.addActionListener(e -> {
            algorithm.nextStep();
        });
    }
}
