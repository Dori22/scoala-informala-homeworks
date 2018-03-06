package ro.siit.java10;

public class GreenBonusProgram {

    private static int budget = 10000000;
    private static Purchase[] purchasesHistory=new Purchase[1000];   // 1000 cars per year as per bonus limit

    public static boolean availability() {

        if (budget > 0) {
            return true;
            //there are still funds available
        } else return false;


    }


}
