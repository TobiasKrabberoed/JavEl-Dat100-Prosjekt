package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {

        this.customers = new Customer[size];

    }

    // b) count number of non-null references
    public int countNonNull() {


        int count = 0;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                count++;
            }
        }

        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {

        boolean funnet = false;
        Customer c = null;

        int i = 0;
        while (i < customers.length && !funnet) {
            if (customers[i] != null && customers[i].getCustomer_id() == customer_id) {
                c = customers[i];
                funnet = true;
            }
            i++;
        }

        return c;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {

        boolean inserted = false;

        int i = 0;
        while (i < customers.length && !inserted) {
            if (customers[i] == null && c != null) {
                customers[i] = c;
                inserted = true;
            }
            i++;
        }

        return inserted;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        int i = 0;
        while (i < customers.length && !deleted) {
            if (customers[i] != null && customers[i].getCustomer_id() == customer_id) {
                c = customers[i];
                customers[i] = null;
                deleted = true;
            }
            i++;
        }

        return c;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {

        Customer[] customers = null;

        customers = new Customer[countNonNull()];
        int next = 0;
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i] != null) {
                customers[next] = this.customers[i];
                next++;
            }
        }

        return customers;
    }
}