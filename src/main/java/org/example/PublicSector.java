package org.example;

public class PublicSector extends Sector{

    // Assets
    private int deposits;
    private int bondsPublic;
    // Liabilities
    private int loans;

    public PublicSector() {
        this.assets = 0;
        this.liabilities = 0;
        this.equity = 0;
        this.deposits = 0;
        this.bondsPublic = 0;
        this.loans = 0;
    }

    @Override
    public void calculateAssets() {
        this.assets = deposits + bondsPublic;
    }
    @Override
    public void calculateLiabilities() {
        this.liabilities = loans;
    }

    public int getDeposits() {
        return deposits;
    }

    public void addDeposits(int deposits) {
        this.deposits += deposits;
        this.calculateAll();
    }

    public int getBondsPublic() {
        return bondsPublic;
    }

    public void addBondsPublic(int bondsPublic) {
        this.bondsPublic += bondsPublic;
        this.calculateAll();
    }

    public int getLoans() {
        return loans;
    }

    public void addLoans(int loans) {
        this.loans += loans;
        this.calculateAll();
    }

    @Override
    public String toString() {
        return "Public Sector\n" +
                "  Assets = " + assets +
                " {Deposits=" + deposits +
                ", Bonds=" + bondsPublic +
                "}\n  Liabilities = " + liabilities +
                " {Loans = " + loans +
                "}\n " +
                " Equity = " + equity;
    }
}
