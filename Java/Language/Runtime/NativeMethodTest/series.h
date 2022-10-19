//Namespace is a named scope containing related symbols grouped 
//together to avoid collisions between their names and the names
//of other symbols not belonging to their group. A member M of
//a namespace N is referred by its qualified name N::M outside of N
namespace Series
{
	//Abstract data type (ADT) is a class which has at least one
	//pure virtual function. It does not support creation of instances
	//but can be used as a reference/pointer type to indirect to an
	//instance of its derived class which has overridden its 
	//pure virtual functions.
	class Sequence
	{
	public:
		//pure virtual function does not provide any implementation
		//within the class in which it is defined
		virtual double Next() = 0;

		double Sum(int);
	};

	class Resetable
	{
	public:
		virtual void Reset() = 0;
	};

	class LinearSequence : public Sequence
	{
	public:

		LinearSequence(float, float);

		double Next();

	private:
		double current;
		float step;
	};

	//Multiple inheritance (MI) allows a class to be derived
	//directly from two or more base classes
	class PowerSequence : public Sequence, public Resetable
	{
	public:
		
		PowerSequence(float);

		double Next();

		void Reset();

	private:
		double current;
		float factor;
	};
}

