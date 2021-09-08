package vo222dq_assign1;

public class Arrays {
    public static int average(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum / arr.length;
    }

    public static int max(int[] arr) {
        int maxNum = 0;

        for (int i : arr) {
            maxNum = i > maxNum ? i : maxNum;
        }

        return maxNum;
    }

    public static int[] addN(int[] arr, int n) {
        int[] newArr = new int[arr.length];        

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] + n;   
        }

        return newArr;
    }

    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        int x = 0;
        for (int i = arr.length; i > 0; i--) {
            newArr[x] = arr[i - 1];
            x++;
        }

        return newArr;
    }

    public static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

   public static int[] sort(int[] arr) {
        int[] arrClone = arr.clone();

        int top = 0;

        for (int i = 0; i < arrClone.length; i++) {
           for (int j = i + 1; j < arrClone.length; j++) {
                if (arrClone[i] > arrClone[j]) {
                    top = arrClone[i];
                    arrClone[i] = arrClone[j];
                    arrClone[j] = top;
                }
           }
        }
        return arrClone;
   }

    public static boolean hasSubString(int[] arr, int[] sub) {
        String arrString = intArrayToString(arr);
        String subString = intArrayToString(sub);

        return arrString.indexOf(subString) != -1;
    }

    public static int[] absDif(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Both arrays  must be of the same length");
        }

        int[] newArr = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                newArr[i] = arr1[i] - arr2[i];
            } else {
                newArr[i] = arr2[i] - arr1[i];
            }
        }

        return newArr;
    }

    private static String intArrayToString(int[] arr) {
        String arrString = "";

        for (int i = 0; i < arr.length; i++) {
            arrString += Integer.toString(arr[i]);
        }

        return arrString;
    }
}
