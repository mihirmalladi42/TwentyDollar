import java.util.Scanner;
public class TwentyDollar {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static int[] availDen = {20, 50, 100};
    public static int num100 = 0;
    public static int num50 = 0;
    public static int num20 = 0;
    public static int inpOut4000;
    public static int inpOut20;
    public static int leftover;
    public static boolean checker(int inp) {
        if (inp > 4000) {
            inpOut4000 = inp;
            return false;
        } else if (inp < 20) {
            leftover = inp;
            inpOut20 = inp;
            return false;
        } else {
            inpOut20 = inp;
            while (inp != 0) {
                if (inp - availDen[2] >= 0 && inp - availDen[1] >= 0 && inp - availDen[0] >= 0) {
                    inp -= availDen[2];
                    num100++;
                } else if (!(inp - availDen[2] >= 0) && inp - availDen[1] >= 0 && inp - availDen[0] >= 0) {
                    num50++;
                    inp -= availDen[1];
                } else if (!(inp - availDen[2] >= 0) && !(inp - availDen[1] >= 0) && inp - availDen[0] >= 0) {
                    num20++;
                    inp -= availDen[0];
                } else if (!(inp - availDen[2] >= 0) && !(inp - availDen[1] >= 0) && !(inp - availDen[0] >= 0)) {
                    if (inp != 0) {
                            leftover = inp;
                            return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return true; 
    }
    public static void main(String[] args) {
        Scanner withdrawAmt = new Scanner(System.in);
        System.out.println(YELLOW + "How much money do you want to withdraw? (Denominations available: $20, $50, $100): " + RESET);
        int moneyAns = withdrawAmt.nextInt();
        boolean run = checker(moneyAns);
        if (run && inpOut4000 < 4000) {
            System.out.println(GREEN + "It is possible to give the withdrawl amount. There is/are " + num100 + " one hundred dollar bill(s), " + num50 + " fifty dollar bill(s), and " + num20 + " twenty dollar bill(s)." + RESET);
        } else if ((!run && inpOut4000 > 4000) || (!run && inpOut4000 > 4000)) {
            System.out.println(RED + "Please enter a withdrawl that is at maximum $4000." + RESET);
        } else if (!run && !(inpOut4000 > 4000) && !(inpOut20 < 20)) {
            System.out.println(RED + "It is not possible to give the withdrawl amount. There is/are " + num100 + " one hundred dollar bill(s), " + num50 + " fifty dollar bill(s), and " + num20 + " twenty dollar bill(s) with " + leftover + " dollar(s) left over." + RESET);
        } else if (!run && (inpOut20 < 20)) {
            System.out.println(RED + "Please enter a withdrawl that is at minimum $20." + RESET);
        }
    }
}
