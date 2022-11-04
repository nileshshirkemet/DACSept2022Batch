namespace Met.Banking;

//a class defined with static modifier can only contain
//static members and as such it cannot be activated nor
//can be used as a base-class
public static class Banker
{
    private static long nid;

    static Banker()
    {
        nid = DateTime.Now.Ticks % 1000000L;
    }

    public static Account OpenCurrentAccount()
    {
        var acc = new CurrentAccount();
        acc.Id = ++nid + 100000000L;
        return acc;
    }

    public static Account OpenSavingsAccount()
    {
        SavingsAccount acc = new();
        acc.Id = ++nid + 200000000L;
        return acc;
    }

    public static void FreezeAccount(Account acc)
    {
        acc.Id = -acc.Id;
    }

}
