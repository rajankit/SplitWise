package SplitStrategy;

import java.util.ArrayList;

public class SplitByShare implements Split {
    private int amount;
    private ArrayList<Integer> shares;

    public SplitByShare(int amount, ArrayList<Integer> shares) {
        this.amount = amount;
        this.shares = shares;
    }

    @Override
    public ArrayList<Double> split() {
        ArrayList<Double> sharedAmount = new ArrayList<>();
        int totalSum = 0;

        for(Integer share : shares) {
            totalSum += share;
        }

        for(int i = 0; i < shares.size(); i++){
            double shareAmount = ((double)shares.get(i) / (double) totalSum);
            sharedAmount.add(shareAmount);
        }

        return sharedAmount;
    }
}
