package CourseraJavaToolbox.week1;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;

import CourseraJavaToolbox.week1.MaxPairwiseProduct;

import static org.junit.Assert.*;

public class MaxPairwiseProductTest {
//    here we are testing for time/memory limits
//    given that there is an unique answe to a problem

    //    test generation
    @Test
    public void generateRandNumbers() throws Exception {
        while(true) {
            int n = new Random().nextInt(10) + 2;

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i=0; i<n; i++){
                arr.add(new Random().nextInt(10000));
            }
            System.out.println(arr);

            long test1 = MaxPairwiseProduct.getMaxPairwiseProduct(arr);
            long test2 = MaxPairwiseProduct.getMaxPairwiseProductFast(arr);

            assertEquals(test1, test2);
        }
    }
}