package repository;

import java.util.HashMap;
import java.util.Map;

public class ExpenseManagerRepository {
    private static Map<String, Map<String, Double>> emMap;

    private ExpenseManagerRepository() {}

    public static Map<String, Map<String, Double>> getEmMap() {
        if (emMap == null) {
            emMap = new HashMap<>();
        }

        return emMap;
    }
}
