static class Worker
{
    public static long DoWork(int count)
    {
        int future = Environment.TickCount + 100 * count;
        while(Environment.TickCount < future);
        return count * count; 
    }
}