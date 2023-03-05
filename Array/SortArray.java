package Array;

import Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class SortArray extends JPanel {
    private int WINDOW_HEIGHT;
    private int WINDOW_WIDTH;
    private int NUM_BARS;
    private boolean[] colorArray;
    private IsAlgorithm algorithm;
    private HashMap<String, IsAlgorithm> algorithms;

    int [] array;
    public SortArray(int size) {
        NUM_BARS = size;
        array = new int[size];
        colorArray = new boolean[size];

        loadAlgorithms();

        algorithm = new BubbleSort();

        WINDOW_HEIGHT = 600;
        WINDOW_WIDTH = 900;

        this.algorithm = algorithm;

        setBackground(Color.darkGray);

        // Generate array values and shuffle it
        generateArrayValue();
        shuffleArray();
    }

    private void loadAlgorithms() {
        algorithms = new HashMap<>();
        algorithms.put("BubbleSort", new BubbleSort());
        algorithms.put("SelectionSort", new SelectionSort());
        algorithms.put("InsertionSort", new InsertionSort());
        algorithms.put("MergeSort", new MergeSort());
    }

    public String[] getAlgorithms() {
        Set<String> keySet = algorithms.keySet();
        String[] array = new String[keySet.size()];
        return keySet.toArray(array);
    }

    public void changeAlgorithm(String algoName) {
        if (algorithms.keySet().contains(algoName)) {
            algorithm = algorithms.get(algoName);
        }
    }

    public void sort() {
        // Sort array
        algorithm.runSort(this);
    }

    public int arraySize() {
        return array.length;
    }

    public int getValue(int index) {
        return array[index];
    }

    public void swap(int firstIndex, int secondIndex, long millisecondDelay) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;

        colorArray[firstIndex] = true;
        colorArray[secondIndex] = true;

        repaint();
        this.paintImmediately(this.getBounds());

        colorArray[firstIndex] = false;
        colorArray[secondIndex] = false;
        try {
            Thread.sleep(millisecondDelay);
        } catch (Exception e) {
            // nothing
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint all bars
        g.setColor(Color.WHITE);

        int totalLen = 2;
        int barWidth = (int)Math.round(WINDOW_WIDTH / NUM_BARS);

        for (int x = 0; x < NUM_BARS; x++) {
            int height = array[x] * 3;
            int xBegin = x + (barWidth - 1) * x;
            int yBegin = WINDOW_HEIGHT - height - 25;

            if (colorArray[x]) {
                g.setColor(Color.RED);
            }
            g.fillRect(xBegin, yBegin, barWidth, height);
            g.setColor(Color.WHITE);

            totalLen += barWidth;
        }
    }

    private void generateArrayValue() {
        for (int i = 0; i < arraySize(); i++) {
            array[i] = i + 1;
            colorArray[i] = false;
        }
    }

    public void shuffleArray() {
        Random n = new Random();
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int swapIndex = n.nextInt(length - 1);
            swap(i, swapIndex, 5);
        }
    }
}
