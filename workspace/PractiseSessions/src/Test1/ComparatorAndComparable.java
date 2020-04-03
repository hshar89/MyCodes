package Test1;

import java.util.Comparator;

public class ComparatorAndComparable implements Comparable{
	private int orderId;
	
	private int amount;
	
	private String customer;
	
	ComparatorAndComparable(int orderId, int amount, String customer){
		this.orderId = orderId;
		this.amount= amount;
		this.customer = customer;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.orderId>((ComparatorAndComparable)o).amount?1:(this.orderId)<((ComparatorAndComparable)o).orderId?-1:0;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	static class OrderByAmount implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			if(((ComparatorAndComparable)o1).amount>((ComparatorAndComparable)o2).amount) {
				return 1;
			}else if(((ComparatorAndComparable)o1).amount<((ComparatorAndComparable)o2).amount) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}
   static class OrderByName implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			return ((ComparatorAndComparable)o1).customer.compareTo(((ComparatorAndComparable)o2).customer);
		}
		
	}
@Override
public String toString() {
	return "ComparatorAndComparable [orderId=" + orderId + ", amount=" + amount + ", customer=" + customer + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + amount;
	result = prime * result + ((customer == null) ? 0 : customer.hashCode());
	result = prime * result + orderId;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ComparatorAndComparable other = (ComparatorAndComparable) obj;
	if (amount != other.amount)
		return false;
	if (customer == null) {
		if (other.customer != null)
			return false;
	} else if (!customer.equals(other.customer))
		return false;
	if (orderId != other.orderId)
		return false;
	return true;
}
   
}
