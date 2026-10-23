package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();

        Customers customers = new Customers(2);
        Customer alice = new Customer("Alice Smith", "alice@example.com", 1001, PowerAgreementType.SPOTPRICE);
        Customer bob = new Customer("Bob Johnson", "bob@example.com", 1002, PowerAgreementType.NORGESPRICE);
        Customer charlie = new Customer("Charlie Rose", "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        if (customers.countNonNull() != 0 || customers.getCustomers().length != 0
                || customers.getCustomer(9999) != null || customers.removeCustomer(9999) != null) {
            throw new AssertionError("Empty customer table failed");
        }
        if (!customers.addCustomer(alice) || !customers.addCustomer(bob)
                || customers.addCustomer(charlie) || customers.countNonNull() != 2
                || customers.getCustomer(1002) != bob) {
            throw new AssertionError("Adding or finding customers failed");
        }
        if (customers.removeCustomer(1001) != alice || customers.getCustomer(1001) != null
                || customers.removeCustomer(1001) != null || customers.countNonNull() != 1) {
            throw new AssertionError("Removing customer failed");
        }
        Customer[] remaining = customers.getCustomers();
        if (remaining.length != 1 || remaining[0] != bob || !customers.addCustomer(charlie)) {
            throw new AssertionError("Copying customers or reusing a free space failed");
        }
        for (Customer c : customers.getCustomers()) {
            System.out.println(c);
            System.out.println();
        }
        System.out.println("Customers checks passed.");

    }
}
