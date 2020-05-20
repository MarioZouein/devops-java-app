	 interface Student
	{
	     
	     public void payTuition(); 
	     
	}
	 
	 
	class StudentClass implements Student
	{
		 public double tuition;
		 
		 public StudentClass(double t)
		 {
			 this.tuition = t;
		 }
	     
		 @Override
	     public void payTuition() {
	      	System.out.println("I paid " + tuition + " LL tuition"); 
	      }
	}

	/* ------------------------------------------------------------------- */
	 
	interface Employee
	{
	     
	     public void cashPayCheck(); 
	     
	}
	 
	class EmployeeClass implements Employee
		{
		 private double salary;
		 
		 public EmployeeClass(double s)
		 {
			 this.salary = s;
		 }
		 
		 @Override
		 public void cashPayCheck() 
		 {
		 	System.out.println("I recieved " + salary + " LL salary");
		 }

	}

	/* ------------------------------------------------------------------- */

	class TeachingAssistant implements Employee, Student
	{
		 private double receiveWaiver;
		 private Student student;
		 private Employee employee;
		 
		 public TeachingAssistant(double t,double s,double w) 
		 {	 
			this.receiveWaiver = w;
			student = new StudentClass(t);
			employee = new EmployeeClass(s);
			
		 }
		 
		 @Override
		 public void cashPayCheck()
		 {
			 employee.cashPayCheck();
		 }
		 
		 @Override
		 public void payTuition()
		 {
			 student.payTuition();
		 }
		 
		 public void receiveWaiver()
		 {
			 System.out.println("I received "+receiveWaiver+" LL as Tuition Waiver");
		 }

	}

	/* ------------------------------------------------------------------- */

	public class Assignment3A{

	    public static void main(String[] args) {
	        TeachingAssistant ta = new TeachingAssistant(6000000.00, 2000000.00, 5000000.00);
	        Student s = ta;
	        s.payTuition();
	        Employee e = ta;
	        e.cashPayCheck();
	        ta.receiveWaiver();
	    }

	}
