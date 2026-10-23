package no.hvl.dat100.javel.oppgave1;


public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println();

        DailyPower.printPowerPrices(powerprices_day);
        DailyPower.printPowerUsage(powerusage_day);
        System.out.printf("Usage: %.2f kWh%n", DailyPower.computePowerUsage(powerusage_day));
        System.out.printf("Spot price: %.2f NOK%n", DailyPower.computeSpotPrice(powerusage_day, powerprices_day));
        System.out.printf("Support: %.2f NOK%n", DailyPower.computePowerSupport(powerusage_day, powerprices_day));
        System.out.printf("Norgespris: %.2f NOK%n", DailyPower.computeNorgesPrice(powerusage_day));
        System.out.printf("Peak: %.2f kWh%n", DailyPower.findPeakUsage(powerusage_day));
        System.out.printf("Average: %.2f kWh%n", DailyPower.findAvgPower(powerusage_day));

        // Small values make the expected results easy to check by hand.
        double[] usage = {2, 4};
        double[] prices = {0.5, 1.9375};
        check(DailyPower.computePowerUsage(usage), 6);
        check(DailyPower.computeSpotPrice(usage, prices), 8.75);
        check(DailyPower.computePowerSupport(usage, prices), 3.6);
        check(DailyPower.computeNorgesPrice(usage), 3);
        check(DailyPower.findPeakUsage(usage), 4);
        check(DailyPower.findAvgPower(usage), 3);
        check(DailyPower.computePowerSupport(new double[]{2}, new double[]{0.9375}), 0);
        System.out.println("Daily checks passed.");

    }
    private static void check(double actual, double expected) {
        if (Math.abs(actual - expected) > 0.000001) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }
}
