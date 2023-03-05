package Algorithms;

import Array.SortArray;

public class MergeSort implements IsAlgorithm{
    @Override
    public String getName() {
        return "MergeSort";
    }

    @Override
    public void runSort(SortArray data) {
        merge(data, 0, data.arraySize()-1);
    }

    public void merge(SortArray data, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low)/2;

        merge(data, low, mid);
        merge(data, mid+1, high);

        int left = low;
        int right = mid + 1;
        while (left < right && right <= high) {
            if (data.getValue(left) > data.getValue(right)) {
                for (int k = right-1; k >= left; k--) {
                    data.swap(k, k+1, 2);
                }
                right++;
            }
            left++;
        }
    }
}
