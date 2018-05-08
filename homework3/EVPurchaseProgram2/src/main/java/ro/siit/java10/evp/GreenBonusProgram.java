package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class GreenBonusProgram {
    private static int budget = 10000000;
    public static final int FUNDS_PER_CAR = 10000;

    private static List<Purchase> purchasesHistory = new ArrayList<Purchase>();  // 1000 cars per year as per bonus limit

    public static boolean areFundsAvailable(String clientName) throws AlreadyUsedGreenProgramException {
        for (Purchase purchase : purchasesHistory) {
            if (purchase.getClientName().equals(clientName)) {
                throw new AlreadyUsedGreenProgramException("This client has already used the Green Bonus Program");
            }
        }

        if (budget > 0) {
            return true;
            //there are still funds available
        } else return false;
    }

    public static int retrievedApprovedBudget(Purchase purchase) {
            try {
            if (areFundsAvailable(purchase.getClientName())) {
                budget -= FUNDS_PER_CAR;
                purchasesHistory.add(purchase);
                return FUNDS_PER_CAR;
            }
        } catch (AlreadyUsedGreenProgramException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static void listPurchases() {
        for (Purchase purchase : purchasesHistory) {
            System.out.println(purchase);
        }
    }

    public static int getBudget() {
        return budget;
    }


}
