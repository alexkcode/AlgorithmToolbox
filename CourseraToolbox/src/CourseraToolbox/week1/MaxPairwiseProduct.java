package CourseraToolbox.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
//    changed types of methods and input to account for larger numbers
//    as indicated in exercise

    public static long getMaxPairwiseProduct(ArrayList<Integer> numbers) {
//        naive solution
        long result = 0;
        int n = numbers.size();
        int max1 = 0;
        int max2 = 0;
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
            if ((max_index1 == -1) || (numbers.get(i) > numbers.get(max_index1)))
                max_index1 = i;

        int max_index2 = -1;
        for (int j = 0; j < n; ++j)
            if ((j != max_index1) && ((max_index2 == -1) || (numbers.get(j) > numbers.get(max_index2))))
                max_index2 = j;

        return (long) numbers.get(max_index1) * numbers.get(max_index2);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            numbers.add(i, scanner.nextInt());
        }
//        System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
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

}