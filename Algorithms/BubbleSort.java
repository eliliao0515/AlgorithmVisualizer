package Algorithms;

import Array.SortArray;

public class BubbleSort implements IsAlgorithm {
    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public void runSort(SortArray data) {
        for (int i = 0; i < data.arraySize(); i++) {
            boolean change = false;
            for (int j = i+1; j < data.arraySize(); j++) {
                if (data.getValue(i) > data.getValue(j)) {
                    data.swap(i, j, 2);
                    if (!change) {
                        change = true;
                    }
                }
            }
            if (!change) {
                break;
            }
        }
    }
}
