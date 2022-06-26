package models;

import enums.SplitType;

import java.util.ArrayList;

public class Expense {
    private String id;
    private String payerId;
    private Integer amount;
    private ArrayList<String> payeeIds;
    private SplitType splitType;
    private ArrayList<Integer> splitShare;

    public Expense(String id, String payerId, Integer amount, ArrayList<String> payeeIds, SplitType splitType) {
        this.id = id;
        this.payerId = payerId;
        this.amount = amount;
        this.payeeIds = payeeIds;
        this.splitType = splitType;
    }

    public Expense(String id, String payerId, Integer amount, ArrayList<String> payeeIds, SplitType splitType, ArrayList<Integer> splitShare) {
        this.id = id;
        this.payerId = payerId;
        this.amount = amount;
        this.payeeIds = payeeIds;
        this.splitType = splitType;
        this.splitShare = splitShare;
    }

    public String getId() {
        return id;
    }

    public String getPayerId() {
        return payerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public ArrayList<String> getPayeeIds() {
        return payeeIds;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public ArrayList<Integer> getSplitShare() {
        return splitShare;
    }
}
