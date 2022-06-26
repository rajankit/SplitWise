import enums.SplitType;
import services.ExpenseManagerService;
import services.ExpenseService;
import services.UserService;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Here is my split wise");

        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService();
        ExpenseManagerService expenseManagerService = new ExpenseManagerService();
        ArrayList<String> payee = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();

        userService.addUser("u1", "User1", "user1@email.com", "99898979791");
        userService.addUser("u2", "User2", "user2@email.com", "99898979792");
        userService.addUser("u3", "User3", "user3@email.com", "99898979793");
        userService.addUser("u4", "User4", "user4@email.com", "99898979794");


        payee.clear();
        payee.add("u1");payee.add("u2");payee.add("u3");payee.add("u4");
        expenseService.addExpense("e1", "u1", 1000, payee, SplitType.EQUAL);

        payee.clear();
        dist.clear();
        payee.add("u2");payee.add("u3");
        dist.add(370);dist.add(880);
        expenseService.addExpense("e2", "u1", 1250, payee, SplitType.EXACT, dist);

        payee.clear();
        dist.clear();
        payee.add("u1");payee.add("u2");payee.add("u3");payee.add("u4");
        dist.add(40);dist.add(20);dist.add(20);dist.add(20);
        expenseService.addExpense("e3", "u4", 1200, payee, SplitType.PERC, dist);

        System.out.println();
        expenseManagerService.show();
        System.out.println();
        expenseManagerService.show("u1");
    }
}

/*

add_user u1 A
add_user u2 B
add_user u3 C
show_users
add_transaction u1 1200 EQUAL 2 u2 u3
 */
