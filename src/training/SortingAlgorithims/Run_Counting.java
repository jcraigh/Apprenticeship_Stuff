package training.SortingAlgorithims;

import training.Annotations.Needed_With_Method_Above;
import training.Annotations.New_Method;
import training.Annotations.Reasons;

public class Run_Counting {
    public static void main(String args[]) {
        int[] baseList = resetList();
        System.out.println(" Insertion Sort");
        Insertion(baseList);

        baseList = resetList();
        System.out.println("\n\n\n Selection Sort");
        Selection(baseList);

        baseList = resetList();
        System.out.println("\n\n\n Merge Sort");
        int size = baseList.length;
        MergeSort(baseList, size);

        baseList = resetList();
        System.out.println("\n\n\n Quick Sort");
        Quick(baseList, 0, size - 1);

        baseList = resetList();
        System.out.println("\n\n\n Bubble Sort Method");
        Bubble(baseList);
    }

    @Reasons("speed up typing out arrays")
    static void printArray(int List[]) {
        int size = List.length;
        for (int j = 0; j < size; j++) {
            System.out.print(" " + List[j]);
        }
        System.out.print("\n");
    }

    @Reasons("Reset List to be the same every time")
    static int[] resetList() {
        final int baseList[] = {13, 6, 2, 10, 7, 3, 14, 9, 1, 12, 8, 11, 5, 4};
        return baseList;
    }

    @New_Method("Insertion Sort Method")
    static void Insertion(int numbers[]) {
        int size = numbers.length;

        for (int i = 1; i < size; ++i) {
            printArray(numbers);

            int key = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
        }
        printArray(numbers);
    }

    @New_Method("Selection Sort Method")
    static void Selection(int numbers[]) {
        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {
            printArray(numbers);

            int minimun = i;

            for (int j = i + 1; j < size; j++) {
                if (numbers[j] < numbers[minimun]) {
                    minimun = j;
                }
            }
            int tempuary = numbers[minimun];
            numbers[minimun] = numbers[i];
            numbers[i] = tempuary;
        }

        printArray(numbers);
    }

    @New_Method("Bubble Sort Method")
    static void Bubble(int numbers[]){
        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {
            printArray(numbers);

            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    @New_Method("Merge Sort")
    static void MergeSort(int numbers[], int Size) {
        if (Size < 2) {
            return;
        }

        int mid = Size / 2;
        int[] leftNumbers = new int[mid];
        int[] rightNumbers = new int[Size - mid];

        for (int i = 0; i < mid; i++) {
            leftNumbers[i] = numbers[i];
        }
        for (int i = mid; i < Size; i++) {
            rightNumbers[i - mid] = numbers[i];
        }
        MergeSort(leftNumbers, mid);
        MergeSort(rightNumbers, Size - mid);

        Merge(numbers, leftNumbers, rightNumbers, mid, Size - mid);
    }

    @Needed_With_Method_Above
    static void Merge(int[] numbers, int[] leftNumbers, int[] rightNumbers, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftNumbers[i] <= rightNumbers[j]) {
                numbers[k++] = leftNumbers[i++];
            }
            else {
                numbers[k++] = rightNumbers[j++];
            }
        }
        while (i < left) {
            numbers[k++] = leftNumbers[i++];
        }
        while (j < right) {
            numbers[k++] = rightNumbers[j++];
        }
        printArray(numbers);
    }

    @New_Method("Quick Sort Method")
    static void Quick(int numbers[], int low, int high){
        if (low < high)
        {
            int index = Partition(numbers, low, high);

            Quick(numbers, low, index-1);
            Quick(numbers, index+1, high);
        }
        printArray(numbers);
    }

    @Needed_With_Method_Above
    static int Partition(int numbers[], int low, int high){
        int pivot = numbers[high];
        int t = (low-1);
        for (int l=low; l<high; l++)
        {
            if (numbers[l] < pivot)
            {
                t++;
                int temp = numbers[t];
                numbers[t] = numbers[l];
                numbers[l] = temp;
            }
        }
        int temp = numbers[t+1];
        numbers[t+1] = numbers[high];
        numbers[high] = temp;

        return t+1;
    }
}