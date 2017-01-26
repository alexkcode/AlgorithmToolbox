import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by omni on 1/26/2017.
 */
public class MaxPairwiseProductTest {

    public void generateRandNumbers() throws Exception {
        while(true) {
            int n = new Random().nextInt(10) + 2;

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i=0; i<n; i++){
                arr.add(new Random().nextInt(10000));
            }
            System.out.println(arr);
            
        }
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getMaxPairwiseProduct() throws Exception {

    }

    @Test
    public void getMaxPairwiseProductFast() throws Exception {

    }

}