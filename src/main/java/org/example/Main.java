package org.example;

public class Main {
    public static void main(String[] args) {
        PublicSector publicSector = new PublicSector();
        CentralBank centralBank = new CentralBank();
        Treasury treasury = new Treasury();
        BankingSector bankingSector = new BankingSector();

        treasury.spend(100, publicSector, bankingSector, centralBank);
//        treasury.tax(90, publicSector, bankingSector, centralBank);
//        treasury.sellBonds(10, bankingSector, centralBank);
//        bankingSector.sellBonds(10, publicSector,centralBank, treasury);
//        centralBank.purchaseBondsPublic(10, treasury, bankingSector, publicSector);

        System.out.println("-----------------------");
        System.out.println(bankingSector.toString());
        System.out.println(publicSector.toString());
        System.out.println(centralBank.toString());
        System.out.println(treasury.toString());

        String balanceSheets = printBalanceSheets(publicSector, centralBank, treasury, bankingSector);
//        System.out.println(treasury.getTreasuryAccount());
//        System.out.println(centralBank.getTreasuryAccount());
//        System.out.println(balanceSheets);
    }

    public static String printBalanceSheets(PublicSector publicSector, CentralBank centralBank, Treasury treasury, BankingSector bankingSector) {

        return "Public Sector Balance Sheet:\n" +
                "Assets: " + publicSector.getAssets() + " Liabilities: " + publicSector.getLiabilities() + " Equity: " + publicSector.getEquity() + "\n" +
                "Treasury Balance Sheet:\n" +
                "Assets: " + treasury.getAssets() + " Liabilities: " + treasury.getLiabilities() + " Equity: " + treasury.getEquity() + "\n" +
                "Central Bank Balance Sheet:\n" +
                "Assets: " + centralBank.getAssets() + " Liabilities: " + centralBank.getLiabilities() + " Equity: " + centralBank.getEquity() + "\n" +
                "Banking Sector Balance Sheet:\n" +
                "Assets: " + bankingSector.getAssets() + " Liabilities: " + bankingSector.getLiabilities() + " Equity: " + bankingSector.getEquity() + "\n";
    }
}
