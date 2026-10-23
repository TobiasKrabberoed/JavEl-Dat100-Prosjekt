package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {

        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0;

    }

    public void computeAmount() {

        if (c.getAgreement() == PowerAgreementType.NORGESPRICE) {
            amount = MonthlyPower.computeNorgesPrice(usage);
        } else if (c.getAgreement() == PowerAgreementType.POWERSUPPORT) {
            amount = MonthlyPower.computeSpotPrice(usage, prices)
                    - MonthlyPower.computePowerSupport(usage, prices);
        } else {
            amount = MonthlyPower.computeSpotPrice(usage, prices);
        }

    }

    public void printInvoice() {

        System.out.println(c);
        System.out.println();
        System.out.println("Month: " + month);
        System.out.printf("Usage:  %10.2f kWh%n", MonthlyPower.computePowerUsage(usage));
        System.out.printf("Amount: %10.2f NOK%n", amount);

    }
}
