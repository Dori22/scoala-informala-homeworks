package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class GreenBonusProgram {
    private static int budget = 10000000;
    public static final  int FUNDS_PER_CAR = 10000;

    private static List<Purchase> purchasesHistory = new ArrayList<Purchase>();  // 1000 cars per year as per bonus limit
    public static boolean areFundsAvailable() {

        if (budget > 0) {
            return true;
            //there are still funds available
        } else return false;
    }

    public static int retrievedApprovedBudget(Purchase purchase){
        if (areFundsAvailable()) {
            budget -= FUNDS_PER_CAR;
            purchasesHistory.add(purchase);
            return FUNDS_PER_CAR;
        }
        return 0;
    }





}
