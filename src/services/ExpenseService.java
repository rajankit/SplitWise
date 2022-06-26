package services;

import enums.SplitType;
import models.Expense;
import repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.Map;

public class ExpenseService {
    private ExpenseManagerService emService = new ExpenseManagerService();
    private static Map<String, Expense> expenseMap = ExpenseRepository.getExpenseMap();

    public void addExpense(String id, String payerId, Integer amount, ArrayList<String> payeeIds, SplitType splitType) {
        Expense expense = new Expense(id, payerId, amount, payeeIds, splitType);

        expenseMap.put(id, expense);
        emService.splitExpense(expense);
    }

    public void addExpense(String id, String payerId, Integer amount, ArrayList<String> payeeIds, SplitType splitType, ArrayList<Integer> splitShare) {
        Expense expense = new Expense(id, payerId, amount, payeeIds, splitType, splitShare);

        expenseMap.put(id, expense);
        emService.splitExpense(expense);
    }
}
