package Projects.InterviewCake;

import java.util.ArrayList;

// This code has not been reviewed
// https://www.interviewcake.com/question/java/find-rotation-point

/**
 * Created by Jesper Lundin on 10 Dec 2016.
 */
public class FindRotationPoint {
    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        int firstIndex = findStart(dict);
    }

    static public int findStart(ArrayList<String> dict) {
        int k = 2;

        int f = 0;
        String first = dict.get(f);
        int m = (int)Math.floor(dict.size()/2);
        String middle = dict.get(m);

        int l, h;
        String low, high;
        int increment = 1;

        if (middle.compareTo(first) > 0) {
            l = m;
            h = m + increment;
            low = dict.get(l);
            high = dict.get(h);
            while (high.compareTo(low) > 0) {
                l = l + increment;
                increment = increment*k;
                h = h + increment;
                low = dict.get(l);
                high = dict.get(h);
            }
        } else {
            h = m;
            l = m - increment;
            low = dict.get(l);
            high = dict.get(h);
            while (high.compareTo(low) > 0) {
                h = h + increment;
                increment = increment*k;
                l = l - increment*k;
                high = dict.get(h);
                low = dict.get(l);
            }
        }

        while (increment != 1) {
            m = (l+h)/2;
            middle = dict.get(m);
            if (middle.compareTo(low) > 0) {
                l = m;
                low = dict.get(l);
            } else {
                h = m;
                high = dict.get(h);
            }
            increment = increment/k;
        }
        return l;
    }
}
