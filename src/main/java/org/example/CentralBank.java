package org.example;

public class CentralBank extends Sector {

    // Assets
    private int loans;
    private int bonds;

    // Liabilities
    private int reserves;
    private int treasuryAccount;

    @Override
    public void calculateAssets() {
        this.assets = loans + bonds;
    }

    @Override
    public void calculateLiabilities() {
        this.liabilities = reserves + treasuryAccount;
    }

    public int getLoans() {
        return loans;
    }

    public void addLoans(int loans) {
        this.loans += loans;
        this.calculateAll();
    }

    public int getBonds() {
        return bonds;
    }

    public void addBonds(int bonds) {
        this.bonds += bonds;
        this.calculateAll();
    }

    public int getReserves() {
        return reserves;
    }

    public void addReserves(int amount) {
        this.reserves += amount;
        this.calculateAll();
    }

    public int getTreasuryAccount() {
        return treasuryAccount;
    }

    public void addTreasuryAccount(int amount) {
        this.treasuryAccount += amount;
        this.calculateAll();
    }

    // When the treasury pays interest, it borrows from the central bank, increasing the treasury's account balance but also increasing its loans (debt) to
    // the central bank (which is an asset of the central bank)
    public void purchaseBondsBanks(int amount, Treasury treasury, BankingSector bankingSector) {
       this.addBonds(amount);
       bankingSector.addBonds(-amount);

       treasury.addBondsPublicSector(amount);
       treasury.addBondsBankingSector(-amount);

       this.addReserves(amount);
       bankingSector.addReserves(amount);

       this.calculateAll();
       treasury.calculateAll();
       bankingSector.calculateAll();
    }

    public void purchaseBondsPublic(int amount, Treasury treasury, BankingSector bankingSector, PublicSector publicSector) {
        this.addBonds(amount);
        publicSector.addBondsPublic(-amount);

        treasury.addBondsPublicSector(-amount);
        treasury.addBondsCentralBank(amount);

        publicSector.addDeposits(amount);
        bankingSector.addDeposits(amount);

        this.addReserves(amount);
        bankingSector.addReserves(amount);
    }

    @Override
    public String toString() {
        return "Central Bank\n" +
                "  Assets = " + assets +
                " {Bonds=" + bonds +
                ", Loans=" + loans +
                "}\n" +
                "  Liabilities = " + liabilities + " {Reserves = " + reserves +
                ", Treasury Account = " + treasuryAccount +
                "}\n " +
                " Equity = " + equity;
    }
}
