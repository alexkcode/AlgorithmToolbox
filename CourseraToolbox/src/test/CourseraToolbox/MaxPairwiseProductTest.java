package CourseraToolbox;

import CourseraToolbox.week1.MaxPairwiseProduct;
import org.junit.Before;
import org.junit.Test;

import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.management.ManagementFactory;

import static java.lang.Math.pow;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxPairwiseProductTest {

    public ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static ArrayList<Integer> generateRandInt(Integer arraySize, Integer elementSize) throws Exception {
//        int n = new Random().nextInt(arraySize) + 2;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<arraySize; i++){
//            arr.add(new Random().nextInt(elementSize));
            arr.add(ThreadLocalRandom.current().nextInt(elementSize));
        }
        return arr;
    }

    public static ArrayList<Long> generateRandLong(Integer arraySize, Long elementSize) throws Exception {
//        int n = new Random().nextInt(arraySize) + 2;

        ArrayList<Long> arr = new ArrayList<>();
        for (int i=0; i<arraySize; i++){
            arr.add(ThreadLocalRandom.current().nextLong(elementSize));
        }
        return arr;
    }

    @Before
    public void checkThreadTimingSupport() throws Exception {
        if (!threadMXBean.isCurrentThreadCpuTimeSupported()) {
            throw new Exception("Thread timing is not supported!");
        }
    }

    @Test
    public void equivalencyTest() throws Exception {
        ArrayList<Integer> arr = generateRandInt(2, 10);
        long test1 = MaxPairwiseProduct.getMaxPairwiseProduct(arr);
        long test2 = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);

        System.out.println(String.format("Product1 : %1$d\nProduct2 : %2$d", test1, test2));

        assertEquals(test1, test2);
    }

    @Test
    public void integerOverflowTest() throws Exception {
        ArrayList<Integer> arr = generateRandInt(10, (new Double(pow(10, 5)).intValue()));
        long test1 = MaxPairwiseProduct.getMaxPairwiseProduct(arr);
        long test2 = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);

        System.out.println(String.format("Product1 : %1$d\nProduct2 : %2$d", test1, test2));

        assertEquals(test1, test2);
    }

    @Test
    public void timeLimitTest() throws Exception {
        ArrayList<Integer> arr = generateRandInt(200000, 100);
//        time given in nanoseconds
        long time1 = threadMXBean.getCurrentThreadCpuTime()/1000;
        long test = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);
        long time2 = threadMXBean.getCurrentThreadCpuTime()/1000;
        long timeDel = time2 - time1;

        System.out.println(String.format("Time Delta : %1d", timeDel));

        if (timeDel >= 1000000) {
            System.out.println("Pairwise product time limit test failed!");
        }
        assertTrue(timeDel < 1000000);
    }
}
