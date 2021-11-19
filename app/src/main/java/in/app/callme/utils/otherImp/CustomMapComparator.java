package in.app.callme.utils.otherImp;

import java.util.Comparator;
import java.util.Map;

public class CustomMapComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1,
                       Map.Entry<String, Integer> o2) {
        {
            Integer count1 = o1.getValue();
            Integer count2 = o2.getValue();
            return count1 - count2;
        }
    }


    @Override
    public boolean equals(Object o) {
        return false;
    }
}
