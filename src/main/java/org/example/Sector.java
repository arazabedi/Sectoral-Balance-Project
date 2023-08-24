package org.example;

public abstract class Sector{
    protected int assets;
    protected int liabilities;
    protected int equity;

    public Sector() {
        this.assets = 0;
        this.liabilities = 0;
        this.equity = 0;
    }

    public int getAssets() {
        return assets;
    }

    public int getLiabilities() {
        return liabilities;
    }

    public int getEquity() {
        return equity;
    }

    // Assets and Liabilities are calculated based on specifics (e.g. deposits and publicly owned bonds make up the public sector's assets)
    public abstract void calculateAssets();

    public abstract void calculateLiabilities();

    public void calculateEquity() {
        this.equity = this.assets - this.liabilities;
    }

    // Combines the three above calculations for efficiency
    public void calculateAll() {
        this.calculateAssets();
        this.calculateLiabilities();
        this.calculateEquity();
    }
}