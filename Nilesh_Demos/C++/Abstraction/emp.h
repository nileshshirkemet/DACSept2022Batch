class Employee
{
   public:
		Employee()
		{
			eid = 100;
			age = 21;
			hours = 180;
			rate = 100;
		}

        Employee(int id, int age, int hrs, float rate)
		{
			eid = id;
			this->age = age;
			hours = hrs;
			this->rate = rate;
		}
        // Employee::GetNetIncome(Employee* this)
		double GetNetIncome()
		{                   //this->hours
			double income = hours * rate;

			if ((hours-180) > 0)
					income = income + (hours - 180) * 250;

			return income;
        }

		int GetEid()
		{
			return eid;
		}

		void SetEid(int id)
		{
			eid = id;
		}

   private:
		int eid;
		int age;
		int hours;  
		float rate;

};
