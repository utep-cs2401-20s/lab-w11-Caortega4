public class newSorting {
    static void mergeSort(int[] a, int left, int right){
        if (left < right){

            int middle = (left + right) / 2;

            mergeSort(a, left, middle);

            mergeSort(a, middle + 1, right);

            merge(a, left, middle, right);
        }
    }

    static void merge(int[] a, int left, int middle, int right) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] lArray = new int[leftSize];
        int[] rArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            lArray[i] = a[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rArray[j] = a[middle + j + 1];
        }

        int leftIndex = 0; int rightIndex = 0;

        int mergedArrayIndex = left;

        while (leftIndex < leftSize && rightIndex < rightSize){
            if(lArray[leftIndex] <= rArray[rightIndex] ){
                a[mergedArrayIndex] = lArray[leftIndex];
                leftIndex++;
            }else{
                a[mergedArrayIndex] = rArray[rightIndex];
                rightIndex++;
            }
            mergedArrayIndex++;
        }

        while (leftIndex < leftSize){
            a[mergedArrayIndex] = lArray[leftIndex];
            leftIndex++;
            mergedArrayIndex++;
        }

        while (rightIndex < rightSize){
            a[mergedArrayIndex] = rArray[rightIndex];
            rightIndex++;
            mergedArrayIndex++;
        }


    }

    static  void quickSort(int[] nums, int first, int last){

        if (first >= last){
            return;
        }

        int k = partition(nums, first, last);



        quickSort(nums, first, k);

        quickSort(nums, k + 1, last);
    }

    static int partition(int[] numbers, int first, int last){

        int less = first + 1;
        int more = last;
        int pivot = numbers[first];
        int temp = 0;

        while(less <= more){
            while (less <= last && numbers[less] <= pivot){
                less++;
            }

            while (more >= first && numbers[more] > pivot){
                more--;
            }

            if (less < more){
                temp = numbers[less];
                numbers[less] = numbers[more];
                numbers[more] = temp;

            }
        }

        temp = numbers[first];
        numbers[first] = numbers[more];
        numbers[more] = temp;

        return more;
    }
    static void newSorting(int[] A, int size){
        if(A.length <= size){
            quickSort(A, 0, A.length-1);
            System.out.println("Sorted: ");
            printArray(A);
        }else{
            int halfIndex = A.length/2;
            int[] leftArray = new int[(A.length+1)/2];
            int[] rightArray = new int[A.length - leftArray.length];

            for (int i = 0; i < leftArray.length ; i++) {
                leftArray[i] = A[i];
            }

            newSorting(leftArray, size);

            for (int i = 0; i < rightArray.length ; i++) {
                rightArray[i] = A[i + leftArray.length];
            }
            newSorting(rightArray, size);

            mergeSortedHalves(A, leftArray, rightArray);
        }


        }

    private static void mergeSortedHalves(int[] A, int[] leftArray, int[] rightArray) {
        System.out.println("left Array: ");
        printArray(leftArray);
        System.out.println("Right Array: ");
        printArray(rightArray);
        int i = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        System.out.println(rightArray.length +leftArray.length);

        while (leftPointer <  leftArray.length && rightPointer < rightArray.length){
            System.out.println("i is: " + i);
            if(leftArray[leftPointer] <= rightArray[rightPointer]  ){
                A[i] = leftArray[leftPointer];
                leftPointer++;
            }else{
                A[i] = rightArray[rightPointer];
                rightPointer++;
            }
            i++;
        }

        System.out.println("i after loops:" + i);

        while(leftPointer < leftArray.length){
            System.out.println("left");
            A[i] = leftArray[leftPointer];
            i++;
            leftPointer++;
        }

        while(rightPointer < rightArray.length){
            System.out.println("right");
            A[i] = rightArray[rightPointer];
            i++;
            rightPointer++;
        }



        System.out.println("Last i: "+ i);

    }

    public static void printArray(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = {1,5,3};
        int[] b = {4,2,6};

        int[] yikes = {1,5,3,4,2,6};//new int[6];

        mergeSortedHalves(yikes, a, b);

        printArray(yikes);

    }
}

