#include <iostream>

class Fibo
{
public:
	Fibo(int n)
	{
		count = n;
	}

	//nested class
	class Iterator
	{
	public:
		Iterator(int n)
		{
			a = 0;
			b = 1;
			c = n;
		}

		bool operator!=(const Iterator& other) const
		{
			return c != other.c;
		}

		void operator++()
		{
			c -= 1;
		}

		int operator*()
		{
			a += b;
			b = a - b;
			return a;
		}
	private:
		int a, b, c;
	};

	Iterator begin() const
	{
		return Iterator(count);
	}

	Iterator end() const
	{
		return Iterator(0);
	}


private:
	int count;
};

int main(void)
{
	Fibo fib(10);

	for(int i : fib)
		std::cout << i << std::endl;
}

