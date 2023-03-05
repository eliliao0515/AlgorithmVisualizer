package Algorithms;

import Array.SortArray;

public class InsertionSort implements IsAlgorithm{
    @Override
    public String getName() {
        return "InsertionSort";
    }

    @Override
    public void runSort(SortArray data) {
        for (int i = 0; i < data.arraySize(); i++) {
            int curr = i;
            while (curr>=1) {
                if (data.getValue(curr) < data.getValue(curr-1)) {
                    data.swap(curr, curr-1, 2);
                    curr--;
                } else {
                    break;
                }
            }
        }
    }
}
