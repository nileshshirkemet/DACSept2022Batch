//covariant interface over V
interface IStackReader<out V>
{
    V Pop();
    bool Empty();
}

//contra-variant interface over V
interface IStackWriter<in V>
{
    void Push(V item);
}

class SimpleStack<V> : IStackReader<V>, IStackWriter<V>
{
    private Node top;

    class Node
    {
        internal V value;
        internal Node below;

        internal Node(V value, Node below)
        {
            this.value = value;
            this.below = below;
        }
    }

    public void Push(V item)
    {
        top = new Node(item, top);
    }

    public V Pop()
    {
        V item = top.value;
        top = top.below;
        return item;
    }

    public bool Empty()
    {
        return top is null; //top == null
    }
}