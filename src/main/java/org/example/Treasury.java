package org.example;

public class Treasury extends Sector{

    // Assets
    private int treasuryAccount;

    // Liabilities - all bonds are liabilities of the treasury, and can be owned by any of the other sectors. Loans refers to
    // the treasury borrowing from the central bank (which it owns anyway)
    private int bondsBankingSector;
    private int bondsPublicSector;
    private int bondsCentralBank;
    private int loans;

    public Treasury() {
        this.assets = 0;
        this.liabilities = 0;
        this.equity = 0;
        this.treasuryAccount = 0;
        this.bondsBankingSector = 0;
        this.bondsPublicSector = 0;
        this.bondsCentralBank = 0;
        this.loans = 0;
    }

    public void calculateAssets() {
        this.assets = this.treasuryAccount;
    }

    public void calculateLiabilities() {
        this.liabilities = this.bondsBankingSector + this.bondsPublicSector + this.bondsCentralBank;
    }

    public int getTreasuryAccount() {
        return treasuryAccount;
    }

    public void addTreasuryAccount(int treasuryAccount) {
        this.treasuryAccount += treasuryAccount;
        this.calculateAll();
    }

    public int getBondsBankingSector() {
        return bondsBankingSector;
    }

    public void addBondsBankingSector(int bondsBankingSector) {
        this.bondsBankingSector += bondsBankingSector;
        this.calculateAll();
    }

    public int getBondsPublicSector() {
        return bondsPublicSector;
    }

    public void addBondsPublicSector(int bondsPublicSector) {
        this.bondsPublicSector += bondsPublicSector;
        this.calculateAll();
    }

    public int getBondsCentralBank() {
        return bondsCentralBank;
    }

    public void addBondsCentralBank(int bondsCentralBank) {
        this.bondsCentralBank += bondsCentralBank;
        this.calculateAll();
    }

    public int getLoans() {
        return loans;
    }

    public void addLoans(int loans) {
        this.loans += loans;
        this.calculateAll();
    }

    // All transactions must be entered twice (e.g. a deposit is a public sector asset and a banking sector liability)
    // Each sector must thus have two entries. After the first 6 entries, the calculateAll() method is used to fill in the gaps
    public void spend(int amount, PublicSector publicSector, BankingSector bankingSector, CentralBank centralBank) {
        publicSector.addDeposits(amount);
        bankingSector.addDeposits(amount);

        bankingSector.addReserves(amount);
        centralBank.addReserves(amount);

        centralBank.addTreasuryAccount(-amount);
        this.addTreasuryAccount(-amount);

        this.calculateAll();
        publicSector.calculateAll();
        bankingSector.calculateAll();
        centralBank.calculateAll();
    }

    public void tax(int amount, PublicSector publicSector, BankingSector bankingSector, CentralBank centralBank) {
        publicSector.addDeposits(-amount);
        bankingSector.addDeposits(-amount);

        bankingSector.addReserves(-amount);
        centralBank.addReserves(-amount);

        centralBank.addTreasuryAccount(amount);
        this.addTreasuryAccount(amount);

        this.calculateAll();
        publicSector.calculateAll();
        bankingSector.calculateAll();
        centralBank.calculateAll();
    }

    // The banking sector buys bonds, with reserves, adding that amount of reserves to the treasury's account
    public void sellBonds(int amount, BankingSector bankingSector, CentralBank centralBank) {
        bankingSector.addBonds(amount);
        this.addBondsBankingSector(amount);

        bankingSector.addReserves(-amount);
        centralBank.addReserves(-amount);

        centralBank.addTreasuryAccount(amount);
        this.addTreasuryAccount(amount);

        this.calculateAll();
        bankingSector.calculateAll();
        centralBank.calculateAll();
    }

    public void payInterestToBanks(int amount, BankingSector bankingSector, CentralBank centralBank) {
        bankingSector.addReserves(amount);
        centralBank.addReserves(amount);

        this.addTreasuryAccount(-amount);
        centralBank.addTreasuryAccount(-amount);

        this.addBondsBankingSector(amount);
        bankingSector.addBonds(amount);

        this.calculateAll();
        bankingSector.calculateAll();
        centralBank.calculateAll();
    }

    public void borrowFromCB(int amount, CentralBank centralBank) {
        centralBank.addTreasuryAccount(amount);
        this.addTreasuryAccount(amount);

        centralBank.addLoans(amount);
        this.addLoans(amount);

        centralBank.calculateAll();
        this.calculateAll();
    }

    @Override
    public String toString() {
        return "Treasury\n" +
                "  Assets = " + assets +
                " {Treasury Account=" + treasuryAccount +
                "}\n" +
                "  Liabilities = " + liabilities + " {Central Bank Bonds = " + bondsCentralBank +
                ", Public Sector Bonds = " + bondsPublicSector +
                ", Banking Sector Bonds = " + bondsBankingSector + ", Loans = " + loans +
                "}\n " +
                " Equity = " + equity;
    }
}