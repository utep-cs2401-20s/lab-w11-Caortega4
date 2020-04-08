public class newSorting {

    //Sorts the input array with the quickSort algorithm
    private static void quickSort(int[] nums, int first, int last) {

        //Base case if the length of the array is one
        if (first >= last) {
            return;
        }

        //Partition the input array and gets the last index of the low partition
        int k = partition(nums, first, last);

        //QuickSort the left part of the array
        quickSort(nums, first, k);

        //QuickSort the right size of the array
        quickSort(nums, k + 1, last);
    }
    /*******************************************************/
    //Helper method for quickSort that makes the partition of an array and returns thr last index of the lower partition
    private static int partition(int[] numbers, int first, int last) {

        int pivot = numbers[first]; //The pivot, the value that will be used to do the comparisons
        int less = first + 1;       //The index for the lower partition, initialized to first index to be partitioned, the one after the pivot
        int more = last;            //The index for the greater partition, initialized to the last index of the input array
        int temp = 0;               //Variable to help when swapping elements

        //Loop that goes until the partition is complete
        while (less <= more) {

            //Increment less until it reaches a value that is greater than the pivot
            while (less <= last && numbers[less] <= pivot) {
                less++;
            }

            //Decrement more until it reaches a value smaller than the pivot
            while (more >= first && numbers[more] > pivot) {
                more--;
            }

            //If less is less than more, the partition is not complete, swap their values
            if (less < more) {
                temp = numbers[less];
                numbers[less] = numbers[more];
                numbers[more] = temp;

            }
        }

        //Swap the pivot with the last  element of the lower partition
        temp = numbers[first];
        numbers[first] = numbers[more];
        numbers[more] = temp;

        //Return the index of the last element of the lower partition
        return more;
    }
    /*******************************************************/
    //Method that sorts an array recursively using mergeSortedHalves and quickSort
    public static void newSorting(int[] A, int size) {

        //Base case where the input array is bigger than the desired size
        if (A.length <= size) {
            quickSort(A, 0, A.length - 1);

        //Case where the array is divided by the half and then sort them and merge them
        } else {

            //Create the left and right array
            int[] leftArray = new int[(A.length + 1) / 2];
            int[] rightArray = new int[A.length - leftArray.length];

            //Loop copies the left part of the input array
            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = A[i];
            }

            //Call that sorts the left part by newSorting
            newSorting(leftArray, size);

            //Loop that copies the right array of the input array
            for (int i = 0; i < rightArray.length; i++) {
                rightArray[i] = A[i + leftArray.length];
            }

            //Call that sorts the right part of the array
            newSorting(rightArray, size);

            //Merges the two halves already sorted
            mergeSortedHalves(A, leftArray, rightArray);
        }


    }
    /*******************************************************/
    //Method that merges two arrays into another one

    private static void mergeSortedHalves(int[] A, int[] leftArray, int[] rightArray) {

        int i = 0;              //Index of the next element to be inserted on the array
        int leftPointer = 0;    //Index of the smallest not inserted element on the left array
        int rightPointer = 0;   //Index of the smallest not inserted element on the right array

        //Loop that inserts sorted elements in the input array until there are elements that have not been inserted in both loops
        while (leftPointer < leftArray.length && rightPointer < rightArray.length) {

            //If the element on the left array is smaller than the one on the right one, insert the one on the left array, increment leftPointer
            if (leftArray[leftPointer] <= rightArray[rightPointer]) {
                A[i] = leftArray[leftPointer];
                leftPointer++;

            }
            //Else insert the element on the right array, increment leftPointer
            else {
                A[i] = rightArray[rightPointer];
                rightPointer++;
            }
            i++;
        }

        //If there are still elements on the left array that have not been inserted, insert them
        while (leftPointer < leftArray.length) {
            A[i] = leftArray[leftPointer];
            i++;
            leftPointer++;
        }

        //If there are still ele,emts on the right array that have not been inserted, insert them
        while (rightPointer < rightArray.length) {
            A[i] = rightArray[rightPointer];
            i++;
            rightPointer++;
        }
    }
}


