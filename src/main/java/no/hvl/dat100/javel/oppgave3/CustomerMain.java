package no.hvl.dat100.javel.oppgave3;


public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        Customer c = new Customer("Alice Smith", "alice@example.com", 1001, PowerAgreementType.SPOTPRICE);
        System.out.println(c);
        if (!c.getName().equals("Alice Smith") || !c.getEmail().equals("alice@example.com")
                || c.getCustomer_id() != 1001 || c.getAgreement() != PowerAgreementType.SPOTPRICE) {
            throw new AssertionError("Incorrect customer values");
        }
        c.setName("Bob Johnson");
        c.setEmail("bob@example.com");
        c.setCustomer_id(1002);
        c.setAgreement(PowerAgreementType.NORGESPRICE);
        if (!c.getName().equals("Bob Johnson") || !c.getEmail().equals("bob@example.com")
                || c.getCustomer_id() != 1002 || c.getAgreement() != PowerAgreementType.NORGESPRICE) {
            throw new AssertionError("Customer setters failed");
        }
        String expected = "Customer number 1002\nName  Bob Johnson\nEmail bob@example.com\nAgreement NORGESPRICE";
        if (!c.toString().equals(expected)) {
            throw new AssertionError("Incorrect customer text");
        }
        System.out.println(c);
        System.out.println("Customer checks passed.");
    }
}
