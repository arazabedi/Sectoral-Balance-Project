package org.example;

public class BankingSector extends Sector {

    // Assets
    private int reserves;
    private int bonds;
    private int loans;

    // Liabilities
    private int deposits;

    @Override
    public void calculateAssets() {
        this.assets = reserves + bonds + loans;
    }

    @Override
    public void calculateLiabilities() {
        this.liabilities = deposits;
    }


    public int getReserves() {
        return reserves;
    }

    public void addReserves(int reserves) {
        this.reserves += reserves;
        this.calculateAll();
    }

    public int getBonds() {
        return bonds;
    }

    public void addBonds(int bonds) {
        this.bonds += bonds;
        this.calculateAll();
    }

    public int getLoans() {
        return loans;
    }

    public void addLoans(int loans) {
        this.loans += loans;
        this.calculateAll();
    }

    public int getDeposits() {
        return deposits;
    }

    public void addDeposits(int deposits) {
        this.deposits += deposits;
        this.calculateAll();
    }

    public void sellBonds(int amount, PublicSector publicSector, CentralBank centralBank, Treasury treasury) {
        this.addBonds(-amount);
        publicSector.addBondsPublic(amount);

        publicSector.addDeposits(-amount);
        this.addDeposits(-amount);

        treasury.addBondsBankingSector(-amount);
        treasury.addBondsPublicSector(amount);

        this.calculateAll();
        publicSector.calculateAll();
        centralBank.calculateAll();
    }

    @Override
    public String toString() {
        return "Banking Sector\n" +
                "  Assets = " + assets +
                " {Reserves=" + reserves +
                ", Bonds=" + bonds +
                ", Loans=" + loans +
                "}\n" +
                "  Liabilities = " + liabilities +
                " {Deposits = " + deposits +
                "}\n " +
                " Equity = " + equity;
    }

}
