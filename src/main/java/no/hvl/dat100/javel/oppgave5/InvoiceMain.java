package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        Customer alice = new Customer("Alice Smith", "alice@example.com", 1001, PowerAgreementType.SPOTPRICE);
        Customer bob = new Customer("Bob Johnson", "bob@example.com", 1002, PowerAgreementType.NORGESPRICE);
        Customer charlie = new Customer("Charlie Rose", "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        Invoice[] invoices = {
                new Invoice(alice, "January", CustomerPowerUsageData.usage_month_customer1, MonthPowerData.powerprices_month),
                new Invoice(bob, "January", CustomerPowerUsageData.usage_month_customer2, MonthPowerData.powerprices_month),
                new Invoice(charlie, "January", CustomerPowerUsageData.usage_month_customer3, MonthPowerData.powerprices_month)
        };
        Invoices.processInvoices(invoices);

        // Expected amounts: spot price 8.75, Norgespris 3.00, with support 5.15 NOK.
        double[][] usage = {{2, 4}};
        double[][] prices = {{0.5, 1.9375}};
        Invoice[] examples = {
                new Invoice(alice, "Test", usage, prices),
                new Invoice(bob, "Test", usage, prices),
                new Invoice(charlie, "Test", usage, prices)
        };
        Invoices.processInvoices(examples);

    }
}
