package ro.siit.java10.evp;

import java.util.ArrayList;
import java.util.List;

public class GreenBonusProgram {

    private static int budget = 10000000;
    private static List<Purchase> purchasesHistory = new ArrayList<Purchase>();  // 1000 cars per year as per bonus limit

    public static boolean availability() {

        if (budget > 0) {
            return true;
            //there are still funds available
        } else return false;


    }
    public static int approvedBudget(Purchase purchase){
        if (availability()) {
            budget -= 10000;
            purchasesHistory.add(purchase);
            return 10000;
        }
        return 0;
    }




}
