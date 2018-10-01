
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

 
public class treeMap 
{
 
    public static void main(String a[])
    {
       
        Map<Empl,Empl> hm=new HashMap<Empl,Empl>();
        //Map<Empl,Empl> map = new TreeMap<Empl, Empl>(hm);
        Scanner in =new Scanner(System.in);
        char ans,ans1;
        do
        {
        	System.out.println("TreeMap");
        	System.out.println("1. Create");
        	System.out.println("2. Display");
        	System.out.println("3. Sort");
        	System.out.println("4. Search");
        	System.out.println("Enter your choice: ");
        	int choice=in.nextInt();
        	switch(choice)
        	{
        	case 1:do
        			{
	    	        System.out.println("Treemap Creation:");
	    	        System.out.println("Enter ID: ");
	    			Integer id=in.nextInt();
	    			System.out.println("Enter Name: ");
	    			String name=in.next();
	    			System.out.println("Enter Age: ");
	    			int age=in.nextInt();
	    			System.out.println("Enter Salary ");
	    			int salary=in.nextInt();
	    			Empl emp1=new Empl(id,name,age,salary);
	    			hm.put(emp1, emp1);
	    			System.out.println("Do you want to add more..?");
	    			ans=in.next().charAt(0);
        			}while(ans=='y');
        			break;
        	case 2:Map<Empl, Empl> tm = new TreeMap<>(hm);
		            System.out.println("Display: ");
		            for(Map.Entry<Empl, Empl> entry :  tm.entrySet())
		            {
		            	Empl emp=(Empl)entry.getValue();
		    			 System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
		            }
        			break;
        	case 3:System.out.println("Sort: ");
        			Sort(hm);
        			break;
        	case 4:System.out.println("Search: ");
		            System.out.println("Enter ID: ");
		    		Integer id=in.nextInt();
		    		System.out.println("Enter Name: ");
		    		String name=in.next();
		    		Empl e=new Empl(id,name,0,0);
		    		Empl temp = hm.get(e);
		    	    System.out.println("Employee Present " +temp.getId() +" "+ temp.getName()+" "+ temp.getSalary()+" "+ temp.getAge());
        			break;
        	}
        	System.out.println("Do you want to continue..?");
			ans1=in.next().charAt(0);
        }while(ans1=='y');
        
        /*System.out.println("HashMap Keys and Values");
        for (Map.Entry<Empl,Empl> key :hm.entrySet()) 
		{
			Empl emp=(Empl)key.getValue();
			 System.out.println(emp.getName()+" "+emp.getId()+" "+emp.getAge()+" "+emp.getSalary());
	    }
        
       */
        
        
        
        
     }   
    public static void Sort(Map<Empl, Empl> hm)
	{
		Map<Empl,Empl> tm=new TreeMap<Empl,Empl>(hm);
	
		    for (Map.Entry<Empl,Empl> key :tm.entrySet()) 
		{
			 Empl emp=(Empl)key.getValue();
			 System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
	    }
		
	}
}


 

class Empl implements Comparable<Empl>
{
     
    public String name;
    public int id;
    public int age;
	public String Department;
	public int salary;
	
     
    public Empl( int Id, String name,int age,int salary)
    {
        this.id=Id;
    	this.name = name;
    
		this.age=age;
		this.salary=salary;
        
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary)
	{
		this.salary=salary;
	}
	public int getSalary() 
	{
		return this.salary;
	}
	public void setId(int Id)
	{
		this.id=Id;
	}
	public int getId()
	{
		return this.id;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge() 
	{
		return this.age;
	}
	public boolean equals(Object o){
	    if(o instanceof Empl){
	    	Empl em = (Empl)o;
	        return ((em.name.equals(name)) && (em.id==id));
	    }
	    return false;

	}
	//@Override
	/*public int compareTo(Object o) 
	{
		Empl em=(Empl) o;
		return this.getName().compareTo(em.getName());
	}  
	
	*/
	public int compareTo(Empl d)
	{
	    if(this.id>d.id)
	        return 1;
	    else if(this.id<d.id)
	        return -1;
	    else
	        return 0;
	}
	
	public int hashCode() {
		int hashcode = Integer.valueOf(id).hashCode(); 
				hashcode = hashcode + name.hashCode();
        return hashcode;
    }
    public String toString()
    {
        return "ID:"+this.id+"Name: "+this.name;
    }
}