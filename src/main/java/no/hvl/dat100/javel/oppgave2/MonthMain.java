package no.hvl.dat100.javel.oppgave2;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");
        System.out.println();

        MonthlyPower.print_PowerUsage(power_usage_month);
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.printf("Usage: %.2f kWh%n", MonthlyPower.computePowerUsage(power_usage_month));
        System.out.printf("Spot price: %.2f NOK%n", MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month));
        System.out.printf("Support: %.2f NOK%n", MonthlyPower.computePowerSupport(power_usage_month, power_prices_month));
        System.out.printf("Norgespris: %.2f NOK%n", MonthlyPower.computeNorgesPrice(power_usage_month));
        System.out.println("Above 1000 kWh: " + MonthlyPower.exceedThreshold(power_usage_month, 1000));

        double[][] usage = {{2, 4}, {2, 4}};
        double[][] prices = {{0.5, 1.9375}, {0.5, 1.9375}};
        check(MonthlyPower.computePowerUsage(usage), 12);
        check(MonthlyPower.computeSpotPrice(usage, prices), 17.5);
        check(MonthlyPower.computePowerSupport(usage, prices), 7.2);
        check(MonthlyPower.computeNorgesPrice(usage), 6);
        if (!MonthlyPower.exceedThreshold(usage, 11)
                || MonthlyPower.exceedThreshold(usage, 12)
                || MonthlyPower.exceedThreshold(usage, 13)) {
            throw new AssertionError("Incorrect threshold result");
        }
        System.out.println("Monthly checks passed.");

    }
    private static void check(double actual, double expected) {
        if (Math.abs(actual - expected) > 0.000001) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }
}