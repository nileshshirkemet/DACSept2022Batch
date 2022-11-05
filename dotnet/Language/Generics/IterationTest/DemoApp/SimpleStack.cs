class SimpleStack<V> 
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

    //to enable standard enumeration (iteration) an object
    //must support public GetEnumerator() method which returns
    //an object whose type supports MoveNext() method and Current
    //property as defined in System.Collections.Generic.IEnumerator 
    //interface
    public IEnumerator<V> GetEnumerator()
    {
        for(Node n = top; n != null; n = n.below)
        {
            //the 'yield return' statement returns multiple values
            //one-by-one through an implementation of standard
            //enumeration interface specified as return type of
            //the method
            yield return n.value;
        }
    }
}