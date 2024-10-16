
# Sectoral Balance Project

This Java project models the balance sheets of four sectors of the economy using concepts from Modern Monetary Theory (MMT). Inspired by Steve Keen's *The New Economics*, the program simulates monetary flows and interactions between the Banking Sector, Public Sector, Central Bank, and Treasury. The program highlights sectoral balance sheets and how various actions—such as government spending, taxation, and bond issuance—affect these sectors.

## Overview

The **Sectoral Balance Project** calculates the balance sheets for the following sectors:

- **Banking Sector**
- **Public Sector**
- **Central Bank**
- **Treasury**

This simulation is based on MMT principles and helps illustrate how monetary flows between sectors operate in an economy. The project can also serve as a learning tool to understand the complexities of fiscal policy, sectoral balances, and monetary economics.

## Getting Started

### Prerequisites
- Java 8 or above
- A Java IDE or command line tools to compile and run the project

### Running the Project

To run the program and observe the balance sheets of each sector, simply execute the `main` method.

```bash
javac SectoralBalanceProject.java
java SectoralBalanceProject
```

Upon starting, without any actions taken, the balance sheets of each sector will appear as:

```plaintext
Banking Sector
  Assets = 0 {Reserves=0, Bonds=0, Loans=0}
  Liabilities = 0 {Deposits = 0}
  Equity = 0

Public Sector
  Assets = 0 {Deposits=0, Bonds=0}
  Liabilities = 0 {Loans = 0}
  Equity = 0

Central Bank
  Assets = 0 {Bonds=0, Loans=0}
  Liabilities = 0 {Reserves = 0, Treasury Account = 0}
  Equity = 0

Treasury
  Assets = 0 {Treasury Account=0}
  Liabilities = 0 {Central Bank Bonds = 0, Public Sector Bonds = 0, Banking Sector Bonds = 0, Loans = 0}
  Equity = 0
```

## Simulation: Actions and Effects

Each sector has methods that correspond to actions they can take (e.g., government spending or bond issuance). These actions will reflect changes in the balance sheets of all sectors.

### Example: Treasury Spending

When the Treasury spends 100 units of currency, the balance sheets adjust as follows:

```plaintext
Banking Sector
  Assets = 100 {Reserves=100, Bonds=0, Loans=0}
  Liabilities = 100 {Deposits = 100}
  Equity = 0

Public Sector
  Assets = 100 {Deposits=100, Bonds=0}
  Liabilities = 0 {Loans = 0}
  Equity = 100

Central Bank
  Assets = 0 {Bonds=0, Loans=0}
  Liabilities = 0 {Reserves = 100, Treasury Account = -100}
  Equity = 0

Treasury
  Assets = -100 {Treasury Account=-100}
  Liabilities = 0 {Bonds = 0}
  Equity = -100
```

### Example: Taxation and Borrowing

To reduce the Treasury's overdraft, taxation and bond issuance are used. After taxing 90 units:

```plaintext
Banking Sector
  Assets = 10 {Reserves=10, Bonds=0, Loans=0}
  Liabilities = 10 {Deposits = 10}
  Equity = 0

Public Sector
  Assets = 10 {Deposits=10, Bonds=0}
  Liabilities = 0 {Loans = 0}
  Equity = 10

Central Bank
  Assets = 0 {Bonds=0, Loans=0}
  Liabilities = 0 {Reserves = 10, Treasury Account = -10}
  Equity = 0

Treasury
  Assets = -10 {Treasury Account=-10}
  Liabilities = 0
  Equity = -10
```

Finally, by issuing 10 units worth of bonds to the banking sector:

```plaintext
Banking Sector
  Assets = 10 {Reserves=0, Bonds=10, Loans=0}
  Liabilities = 10 {Deposits = 10}
  Equity = 0

Public Sector
  Assets = 10 {Deposits=10, Bonds=0}
  Liabilities = 0 {Loans = 0}
  Equity = 10

Central Bank
  Assets = 0 {Bonds=0, Loans=0}
  Liabilities = 0 {Reserves = 0, Treasury Account = 0}
  Equity = 0

Treasury
  Assets = 0 {Treasury Account=0}
  Liabilities = 10 {Bonds = 10}
  Equity = -10
```

### Example: Central Bank Intervenes

If the Central Bank steps in to buy the bonds, the balance sheets would adjust as follows:

```plaintext
Banking Sector
  Assets = 10 {Reserves=10, Bonds=0, Loans=0}
  Liabilities = 10 {Deposits = 10}
  Equity = 0

Public Sector
  Assets = 10 {Deposits=10, Bonds=0}
  Liabilities = 0
  Equity = 10

Central Bank
  Assets = 10 {Bonds=10, Loans=0}
  Liabilities = 10 {Reserves=10, Treasury Account=0}
  Equity = 0

Treasury
  Assets = 0 {Treasury Account=0}
  Liabilities = 10 {Bonds = 10}
  Equity = -10
```

This highlights how money circulates and affects sectoral balances, and how institutions manage the flow of currency.

## Key Insights

- **Money as Liabilities**: The program demonstrates that money originates as liabilities within the banking sector. Treasury bonds, in this case, can be considered interest-bearing money, emphasizing the role of institutions in shaping monetary flows.
- **Role of Central Bank**: The Central Bank can step in to regulate the money supply by purchasing treasury bonds, thereby affecting the overall balance sheets of all sectors.

## Future Improvements

Planned features include:
- Extending sector actions for more complex economic scenarios.
- Implementing interest rates and inflation effects.
- Visualizing balance sheet flows with a graphical interface.

## References

This project is inspired by:
- *The New Economics: A Manifesto* by Steve Keen
- Post-Keynesian economics
- The Minsky Project

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
