package repository;

import models.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {
    private static Map<String, Expense> expenseMap;

    private ExpenseRepository() {}

    public static Map<String, Expense> getExpenseMap() {
        if (expenseMap == null) {
            expenseMap = new HashMap<>();
        }
        return expenseMap;
    }
}
