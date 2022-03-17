package hu.webuni.hr.itatti.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix="hr")
@Component
public class HrConfigProperties {
	
	private Salary salary = new Salary();
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public static class Salary{
		private Percent percent;
		public Percent getPercent() {
			return percent;
		}
		public void setPercent(Percent percent) {
			this.percent = percent;
		}
		public Year getYear() {
			return year;
		}
		public void setYear(Year year) {
			this.year = year;
		}
		private Year year= new Year();
		private Def def= new Def();
		public Def getDef() {
			return def;
		}
		public void setDef(Def def) {
			this.def = def;
		}
	}
	
	public static class Def{
		private double percent;

		public double getPercent() {
			return percent;
		}

		public void setPercent(double percent) {
			this.percent = percent;
		}
	}
	
	public static class Percent{
		private double low;
		private double mid;
		private double high;
		private double superhigh;
		
		public double getSuperhigh() {
			return superhigh;
		}
		public void setSuperhigh(double superhigh) {
			this.superhigh = superhigh;
		}
		public double getLow() {
			return low;
		}
		public void setLow(double low) {
			this.low = low;
		}
		public double getMid() {
			return mid;
		}
		public void setMid(double mid) {
			this.mid = mid;
		}
		public double getHigh() {
			return high;
		}
		public void setHigh(double high) {
			this.high = high;
		}
		
	} 

	public static class Year{
		private double low;
		private double mid;
		private double high;
		public double getLow() {
			return low;
		}
		public void setLow(double low) {
			this.low = low;
		}
		public double getMid() {
			return mid;
		}
		public void setMid(double mid) {
			this.mid = mid;
		}
		public double getHigh() {
			return high;
		}
		public void setHigh(double high) {
			this.high = high;
		}
		
	} 
	
}
