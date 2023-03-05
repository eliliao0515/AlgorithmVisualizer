package Algorithms;

import Array.SortArray;

public class SelectionSort implements IsAlgorithm{
    @Override
    public String getName() {
        return "SelectionSort";
    }

    @Override
    public void runSort(SortArray data) {
        for (int i = 0; i < data.arraySize(); i++) {
            int currSmall = data.getValue(i);
            int smallIndex = i;
            for (int j = i + 1; j < data.arraySize(); j++) {
                if (data.getValue(j) < currSmall) {
                    currSmall = data.getValue(j);
                    smallIndex = j;
                }
            }
            data.swap(i, smallIndex, 10);
        }
    }
}
