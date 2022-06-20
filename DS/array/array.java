import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Something
{
    public int attributeInt;
    public String attributeString;

    //Constructor
    Something(int attributeInt, String attributeString)
    {
        this.attributeInt = attributeInt;
        this.attributeString = attributeString;
    }

    private static int  SOME_INT = 1;

    public static void main(String[] args)
    {
        // int example
        int[] name; // declare
        name = new int[20]; // allocate 20 memory slots
        
        // Populate
        int[] tenInts = new int[5]; // default 0
        variable[0] = SOME_INT;

        int[] manualInt = {1,2,3,4,5,6,7,8,9,10};
        
        int[] forInt;
        for (int i = 0; i < forInt.length; i++) forInt[i] = i;

        // Print
        for (int k = 0; k < tenInts.length; k++)
        {
            System.out.println(tenInts[k]);
        }
        String tenIntsString = Arrays.toString(tenInts);
        System.out.println(tenIntsString);

        // create ArrayList
        ArrayList<Integer> integerList = new ArrayList<Integer>(Arrays.asList(tenInts));
        // List<Integer> integerList = new Arrays.asList(tenInts);

        // Arraylist to array
        int[] arrayFromList = new int[integerList.size()];
        integerList.toArray(arrayFromList);

        // check if contain value
        int value = 0;
        Boolean containsValue = false;
        int indexValue = -1;
        for (int j = 0; j < tenInts.length; j++)
        {
            if(tenInts[j]==value)
            {
                containsValue = true;
                indexValue = j;
            }
        }

        for (int oneOfTen : tenInts)
        {
            if(oneOfTen==value) containsValue = true;
        }

        containsValue = integerList.contains(value);

        // concatenate two arrays
        int[] first = {1,2,3};
        int[] second = {4,5,6};
        int[] both = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, both, first.length, second.length);

        // declare array inline
        int[] inlineArray = new int[]{1,2,3,4,5};

        // array to set
        Set<Integer> integerSet = new HashSet<Integer>(Arrays.asList(inlineArray));

        // sort array ascending
        Arrays.sort(inlineArray);
        
        // sort arrey descending
        Arrays.sort(inlineArray, Collections.reverseOrder());
    }
}