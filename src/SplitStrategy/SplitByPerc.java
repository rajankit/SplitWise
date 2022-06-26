package SplitStrategy;

import java.util.ArrayList;

public class SplitByPerc implements Split{
    private int amount;
    private ArrayList<Integer> percs;

    public SplitByPerc(int amount, ArrayList<Integer> percs) {
        this.amount = amount;
        this.percs = percs;
    }

    @Override
    public ArrayList<Double> split() {
        ArrayList<Double> sharedAmount = new ArrayList<>();
        int totalPerc = 0;

        for(Integer share : this.percs) {
            totalPerc += share;
        }

        if (totalPerc != 100 ){
            // add exceptions
            System.out.println("Incorrect split %");
            return null;
        }

        for(int i = 0; i < this.percs.size(); i++){
            double shareAmount = (double)this.amount * ((double)this.percs.get(i) / 100.0);
            sharedAmount.add(shareAmount);
        }

        return sharedAmount;
    }
}
