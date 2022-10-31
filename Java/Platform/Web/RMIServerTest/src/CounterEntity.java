package shopping;

import javax.persistence.*;

@Entity
@Table(name="counters")
public class CounterEntity implements java.io.Serializable {

	@Id
	@Column(name="ctr_name")
	private String name;

	@Column(name="cur_val")
	private int currentValue;

	public String getName() { return name; }
	public void setName(String value) { name = value; }

	public int getCurrentValue() { return currentValue; }
	public void setCurrentValue(int value) { currentValue = value; }

	public int getNextValue() { return ++currentValue; }

}

