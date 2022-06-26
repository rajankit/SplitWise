package services;

import SplitStrategy.*;
import enums.SplitType;
import models.Expense;
import repository.ExpenseManagerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManagerService {
    private static Map<String, Map<String, Double>> emMap = ExpenseManagerRepository.getEmMap();

    private void settleBalance() {
        // todo settle up balance
    }

    public void splitExpense(Expense expense) {
        String payerId = expense.getPayerId();
        int amountPaid = expense.getAmount();

        ArrayList<String> payeeIds = expense.getPayeeIds();

        SplitType splitType = expense.getSplitType();

        ArrayList<Integer> splitShare = expense.getSplitShare();
        ArrayList<Double> finalAmount;
        Split splitMethod = null;

        switch (splitType) {
            case EQUAL:
                splitMethod = new SplitByEqual(amountPaid, payeeIds.size());
                break;
            case PERC:
                splitMethod = new SplitByPerc(amountPaid, splitShare);
                break;
            case RATIO:
                splitMethod = new SplitByShare(amountPaid, splitShare);
                break;
            case EXACT:
                splitMethod = new SplitByExact(amountPaid, splitShare);
                break;
        }

        finalAmount = splitMethod.split();

        for(int i = 0; i < payeeIds.size(); i++) {
            String payeeId = payeeIds.get(i);
            if (payeeIds.get(i) == payerId) continue;

            Double updatedOweAmountPayeePayer = 0.0;
            Double updatedOweAmountPayerPayee = 0.0;

            // check if payeeId Exist
            if (!emMap.containsKey(payeeId)) {
                emMap.put(payeeId, new HashMap<>());
            }

            // check if payerId Exist
            if (!emMap.containsKey(payerId)) {
                emMap.put(payerId, new HashMap<>());
            }

            // check if any owe expense added earlier for payee
            if (!emMap.get(payeeId).containsKey(payerId)) {
                emMap.get(payeeId).put(payerId, 0.0);
            }

            // check if any owe amount added earlier fot payer
            if (!emMap.get(payerId).containsKey(payeeId)) {
                emMap.get(payerId).put(payeeId, 0.0);
            }

            updatedOweAmountPayeePayer = emMap.get(payeeId).get(payerId) + finalAmount.get(i);
            updatedOweAmountPayerPayee = emMap.get(payerId).get(payeeId);

            if (updatedOweAmountPayeePayer > updatedOweAmountPayerPayee) {
                emMap.get(payerId).put(payeeId, 0.0);
                emMap.get(payeeId).put(payerId, updatedOweAmountPayeePayer - updatedOweAmountPayerPayee);
            } else if (updatedOweAmountPayeePayer < updatedOweAmountPayerPayee){
                emMap.get(payeeId).put(payerId, 0.0);
                emMap.get(payerId).put(payeeId, updatedOweAmountPayerPayee - updatedOweAmountPayeePayer);
            } else {
                emMap.get(payerId).put(payeeId, 0.0);
                emMap.get(payeeId).put(payerId, 0.0);
            }
        }

        settleBalance();
    }

    public void show() {
        for(String id : emMap.keySet()) {
            show(id);
        }
    }

    public void show(String userId) {
        if (!emMap.containsKey(userId)) {
            System.out.println("user not found");
            return;
        }

        for(String id : emMap.get(userId).keySet()) {
            Double amount = emMap.get(userId).get(id);
            if (amount == 0.0) continue;

            System.out.println(userId + " owes " + id + " " + amount);
        }
    }
}
