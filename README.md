# Sectoral-Balance-Project
I wrote this programme to calculate the balance sheets of each of the four sectors of the economy based on an MMT understanding of the monetary system. 

Just run main in order to get print-out of the balance sheets. Having commited no actions, it will look like this:

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

Each sector has methods corresponding to actions by that particular sector. For example, the treasury can spend a particular amount of money. This will show up as changes in the balance sheets of all the other sectors, as well as the treasury's. In the below example the treasury has spent 100 units of currency:

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
  Liabilities = 0 {Central Bank Bonds = 0, Public Sector Bonds = 0, Banking Sector Bonds = 0, Loans = 0}
  Equity = -100

  Keep in mind that the above action by the treasury is (I believe) technically illegal, as the treasury cannot go into overdraft with its account at the central bank. Therefore it must use a combination of taxation and so-called 'borrowing' in order to rectify this. First we will tax 90 units of currency:

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
  Liabilities = 0 {Central Bank Bonds = 0, Public Sector Bonds = 0, Banking Sector Bonds = 0, Loans = 0}
  Equity = -10

  As you can see, the treasury only has an overdraft of 10. Note that the Public Sector (by this I mean the non-bank public, which may be considered the private sector elsewhere) has lost 90 units since the last transaction. The key takeaway here is the loss of purchasing power that taxation represents. To get those final 10 units out of the treasury's overdraft, we will 'borrow' 10 units of currency by selling 10 units worth of treasury bonds to the banking sector:

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
  Liabilities = 10 {Central Bank Bonds = 0, Public Sector Bonds = 0, Banking Sector Bonds = 10, Loans = 0}
  Equity = -10

  At this point, the public still has that remaining 10 units of purchasing power, while the treasury is freed from its overdraft. Instead of an overdraft, the treasury now has 10 units worth of liabilities in the form of treasury bonds. The difference between this and the overdraft at the central bank is seemingly really an institutional one designed to halt overspending. However this design mystifies the monetary economy and the language surrounding it becomes misleading. At this point the banking sector can sell all 10 units worth of those bonds if it wishes:

  Banking Sector
  Assets = 0 {Reserves=0, Bonds=0, Loans=0}
  Liabilities = 0 {Deposits = 0}
  Equity = 0
Public Sector
  Assets = 10 {Deposits=0, Bonds=10}
  Liabilities = 0 {Loans = 0}
  Equity = 10
Central Bank
  Assets = 0 {Bonds=0, Loans=0}
  Liabilities = 0 {Reserves = 0, Treasury Account = 0}
  Equity = 0
Treasury
  Assets = 0 {Treasury Account=0}
  Liabilities = 10 {Central Bank Bonds = 0, Public Sector Bonds = 10, Banking Sector Bonds = 0, Loans = 0}
  Equity = -10

  Here we can really get a feel for the insights that the sectoral balance approach provides. Where does money come from and where does it go? Essentially, money is the liabilities of the banking sector. Since the public have spent their banking sector liabilities (deposits/the money in their accounts) on treasury bonds, there is no money in this system anymore (in a sense - in another sense, those bonds themselves could be counted as simply interest bearing money that needs to be quickly converted to the non-interest-bearing kind for use). If this ever happened (an unlikely scenario), the central bank might want to step in to increase the stock of money in an economy. It could do this by buying those bonds: 

  Banking Sector
  Assets = 10 {Reserves=10, Bonds=0, Loans=0}
  Liabilities = 10 {Deposits = 10}
  Equity = 0
Public Sector
  Assets = 10 {Deposits=10, Bonds=0}
  Liabilities = 0 {Loans = 0}
  Equity = 10
Central Bank
  Assets = 10 {Bonds=10, Loans=0}
  Liabilities = 10 {Reserves = 10, Treasury Account = 0}
  Equity = 0
Treasury
  Assets = 0 {Treasury Account=0}
  Liabilities = 10 {Central Bank Bonds = 10, Public Sector Bonds = 0, Banking Sector Bonds = 0, Loans = 0}
  Equity = -10

  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  I plan on expanding and improving this programme, but for now it has been useful in understanding how sectoral flows work. It was largely inspired by the post-Keynesian economist Steve Keen and his Minsky programme. I wanted a programme that simplifies the model for my own understanding.
