static class Worker
{
    public static int DoWork(int count, int initial, int scale)
    {
        int future = Environment.TickCount + count / 1000;
        while(Environment.TickCount < future);
        return initial + scale * count;
    }
}