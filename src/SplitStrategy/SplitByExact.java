package SplitStrategy;

import java.util.ArrayList;

public class SplitByExact implements Split {
    private int amount;
    private ArrayList<Integer> splitShare;

    public SplitByExact(int amount, ArrayList<Integer> splitShare) {
        this.amount = amount;
        this.splitShare = splitShare;
    }

    @Override
    public ArrayList<Double> split() {
        ArrayList<Double> finalAmount = new ArrayList<>();

        for(Integer share : splitShare) {
            finalAmount.add((double)share);
        }

        return finalAmount;
    }
}
