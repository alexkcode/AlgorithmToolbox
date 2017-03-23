package CourseraJavaToolbox.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
//    changed types of methods and input to account for larger numbers
//    as indicated in exercise

    public static long getMaxPairwiseProduct(ArrayList<Integer> numbers) {
//        naive solution
        long result = 0;
        int n = numbers.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers.get(i) * numbers.get(j) > result) {
                    result = (long) numbers.get(i) * numbers.get(j);
                }
            }
        }
        return result;
    }

    public static long getMaxPairwiseProductFast(ArrayList<Integer> numbers) {
//        faster solution
        int n = numbers.size();

        int max_index1 = -1;
        for (int i = 0; i < n; ++i)
            if ((max_index1 == -1) || ((long) numbers.get(i) > numbers.get(max_index1)))
                max_index1 = i;

        int max_index2 = -1;
        for (int j = 0; j < n; ++j)
            if (((long) numbers.get(j) != numbers.get(max_index1)) && ((max_index2 == -1) || (numbers.get(j) > numbers.get(max_index2))))
                max_index2 = j;

        return (long) numbers.get(max_index1) * numbers.get(max_index2);
    }

    public static void main(String[] args) {
//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        for (int i = 0; i < n; ++i) {
//            numbers.add(i, scanner.nextInt());
//        }
//        System.out.println(getMaxPairwiseProduct(numbers));
//        System.out.println(getMaxPairwiseProductFast(numbers));
        try{
            equivalencyTest();
            integerOverflowTest();
            timeLimitTest();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static ArrayList<Integer> generateRandNumbers(Integer arraySize, Integer elementSize) throws Exception {
//        int n = new Random().nextInt(arraySize) + 2;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<arraySize; i++){
            arr.add(new Random().nextInt(elementSize));
        }
        return arr;
    }

    public static void equivalencyTest() throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        long test1 = MaxPairwiseProduct.getMaxPairwiseProduct(arr);
        long test2 = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);

        System.out.println(String.format("Product1 : %1$d\nProduct2 : %2$d", test1, test2));

        if (test1 != test2){
            System.out.println("Pairwise products are not equal!");
        }
    }

    public static void integerOverflowTest() throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        long test1 = MaxPairwiseProduct.getMaxPairwiseProduct(arr);
        long test2 = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);

        System.out.println(String.format("Product1 : %1$d\nProduct2 : %2$d", test1, test2));

        if (test1 != test2){
            System.out.println("Pairwise products are not equal!");
        }
    }

    public static void timeLimitTest() throws Exception {
        ArrayList<Integer> arr = generateRandNumbers(200000, 100);
        Date time1 = new Date();
        long test = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);
        Date time2 = new Date();
        long timeDel = time2.getTime() - time1.getTime();

        System.out.println(String.format("Product1 : %1$d\nProduct2 : %2$d", time1, time2));
        System.out.println(String.format("Time Delta : %1d", timeDel));

        if (timeDel > 1000000) {
            System.out.println("Pairwise product time limit test failed!");
        }
    }
}