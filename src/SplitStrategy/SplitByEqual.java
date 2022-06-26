package SplitStrategy;

import java.util.ArrayList;

public class SplitByEqual implements Split {
    private int amount;
    private int groupSize;

    public SplitByEqual(int amount, int groupSize) {
        this.amount = amount;
        this.groupSize = groupSize;
    }

    @Override
    public ArrayList<Double> split() {
        ArrayList<Double> finalAmount = new ArrayList<>();

        for(int i = 0 ; i < groupSize; i++) {
            finalAmount.add(((double) this.amount / (double) this.groupSize));
        }

        return finalAmount;
    }
}
