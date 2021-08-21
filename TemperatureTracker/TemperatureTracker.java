package Projects.InterviewCake; /**
 * Created by Jesper Lundin on 13 Nov 2016.
 */

import java.util.Arrays;

public class TemperatureTracker{
    int[] occurences;
    int n;

    private Integer min;
    private Integer max;
    private Float mean;
    private Integer mode;


    int modeOccurences;
    public TemperatureTracker() {
        occurences = new int[111];
        mode = null;
        modeOccurences = 0;

        min = null;
        max = null;
        mean = null;
        n = 0;
    }
    public void insert(int t) {
        min = (min == null) ? t: Math.min(t, min);
        max = (max == null) ? t: Math.max(t, max);
        mean = (mean == null) ? t:
                (mean*n+t) / (n + 1);
        occurences[t]++;
        if (occurences[t] > modeOccurences) {
            modeOccurences = occurences[t];
            mode = t;
        }
        n++;
        System.out.println(t + " is added");
    }
    public Integer getMax() {
        return max;
    }
    public Integer getMin() {
        return min;
    }
    public Float getMean() {
        return mean;
    }
    public Integer getMode() {
        return mode;
    }
    public String toString() {
        return occurences.toString();
    }

    public static void main(String[] args) {
        TemperatureTracker tt = new TemperatureTracker();
        int n = 100;
        int[] temp = new int[n];
        int[] oc = new int[111];
        float total = 0f;
        for (int i=0; i<n; i++) {
            int t = (int)(Math.random()*111);
            temp[i] = t;
            tt.insert(t);
            total += (float)t;
            oc[t]++;
        }
        Arrays.sort(temp);


        System.out.println("Temperature tracker");
        System.out.println("min:  " + tt.getMin());
        System.out.println("max:  " + tt.getMax());
        System.out.println("mean: " + tt.getMean());
        System.out.println("mode: " + tt.getMode());
        System.out.println("Array");
        System.out.println("min:  " + temp[0]);
        System.out.println("max:  " + temp[n-1]);
        double mean = total/(float)n;
        System.out.println("mean: " + mean);
        System.out.println();

        int maxOc = 0;
        int maxOcTemp = 0;
        for (int i = 0; i<n; i++) {
            if (oc[i] > maxOc) {
                maxOcTemp = i;
            }
            maxOc = Math.max(maxOc, oc[i]);
        }
        System.out.println(maxOc);
        System.out.println(maxOcTemp);
        System.out.println();

        System.out.println(oc[maxOcTemp]);



    }
}
