package project;

import java.util.*;

class Student{
    String name;
    int age;
    double javascore;
    double algoscore;
    
    public Student(String name, int age, double javascore, double algoscore){
        this.name=name;
        this.age=age;
        this.javascore=javascore;
        this.algoscore=algoscore;
    }
    
    static ArrayList<Student> student=new ArrayList<Student>();
    static int casenum=0;
    
    public static void input(){
        Scanner scanner=new Scanner(System.in);
        String name;
        int age;
        double javascore;
        double algoscore;
        
        while(true){
            System.out.print("Name(q to quit): ");
            name=scanner.next();
            name=name.substring(0, 1).toUpperCase() + name.substring(1);
            
            if(name.equalsIgnoreCase("q")){
                System.out.println("");
                break;
            }
            
            for(int i=0;i<student.size();i++){
                if(name.equalsIgnoreCase(student.get(i).name)){
                    System.out.print("The name already exists.");
                    return;
                    }
            }
                    
            while(true){
                System.out.print("Age: ");
                age=scanner.nextInt();
                if(age<0){
                    System.out.println("Please enter a positive number");
                    continue;
                }
                else{
                    break;
                }
            }
        
            while(true){
                System.out.print("Java score(0~100): ");
                javascore=scanner.nextDouble();
                if(javascore<0 || javascore>100){
                    System.out.println("Please keep the range");
                    continue;
                }
                else{
                    break;
                }
            }
            
            while(true){
                System.out.print("Algorithm score(0~100): ");
            algoscore=scanner.nextDouble();
                if(javascore<0 || javascore>100){
                    System.out.println("Please keep the range");
                    continue;
                }
                else{
                    break;
                }
            }
        
            student.add(new Student(name,age,javascore,algoscore));
            if(casenum==4) {
            	break;
            }
            System.out.println("");
        }
    }
    
    public static void remove(){
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        printall();
        System.out.print("Name to remove: ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        
        for(int i=0;i<student.size();i++){ 
            if(student.get(i).name.equalsIgnoreCase(name)){
                student.remove(i);
                break;
            }
            
            else if(i==student.size()-1){
                System.out.println("No value");
                System.out.println("");
                return;
            }
        }
        
        System.out.println("Completed");
        System.out.println("");
    }
    
    public static void search(){
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        System.out.print("Name to search: ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        for(int i=0;i<student.size();i++){ 
            if(student.get(i).name.equalsIgnoreCase(name)){
                System.out.println("---Information(Name, Age, Java score, Algorithm score)---");
                System.out.println(i+1 + ". " + student.get(i).name + " " + student.get(i).age + " " +  student.get(i).javascore + " " + student.get(i).algoscore);
                break;
            }
            else if(i==student.size()-1){
                System.out.println("No value");
                System.out.println("");
                return;
            }
        }
        System.out.println("");
    }
    
    public static void modify(){
        int age = 0;
        double javascore = 0;
        double algoscore = 0;
        casenum=4;
        
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        printall();
        System.out.print("Index to modify: ");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        int number=0;
        String name = null;

        for(int i=0;i<student.size();i++){ 
            if(i==index-1){
            	System.out.print("What data would you modify?: ");
            	String data=scanner.next();
            	number=i;
            	if(data.equalsIgnoreCase("Name")) {
            		System.out.print("Name: ");
            		name=scanner.next();
                    name=name.substring(0, 1).toUpperCase() + name.substring(1);
                    age=student.get(i).age;
                    javascore=student.get(i).javascore;
                    algoscore=student.get(i).algoscore;
                    student.add(number,new Student(name,age,javascore,algoscore));
                    student.remove(i+1);
                    break;
            	}
            	
            	else if(data.equalsIgnoreCase("Age")) {
            		System.out.print("Age: ");
            		age=scanner.nextInt();
            		name=student.get(i).name;
            		javascore=student.get(i).javascore;
                    algoscore=student.get(i).algoscore;
                    student.add(number,new Student(name,age,javascore,algoscore));
                    student.remove(i+1);
            		break;
            	}
            	
            	else if(data.equalsIgnoreCase("Java")) {
            		System.out.print("Java score: ");
            		javascore=scanner.nextDouble();
            		name=student.get(i).name;
            		age=student.get(i).age;
            		algoscore=student.get(i).algoscore;
            		student.add(number,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
            		break;
            	}
            	
            	else if(data.equalsIgnoreCase("Algorithm")) {
            		System.out.print("Algorithm score: ");
            		algoscore=scanner.nextDouble();
            		name=student.get(i).name;
            		age=student.get(i).age;
            		javascore=student.get(i).javascore;
            		student.add(number,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
            		break;
            	}
                
                else if(data.equalsIgnoreCase("All")){
                    System.out.print("Name: ");
            		name=scanner.next();
                    name=name.substring(0, 1).toUpperCase() + name.substring(1);
                    System.out.print("Age: ");
            		age=scanner.nextInt();
                    System.out.print("Java score: ");
            		javascore=scanner.nextDouble();
                    System.out.print("Algorithm score: ");
            		algoscore=scanner.nextDouble();
                    student.add(number,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
                    break;
                }
                else{
                    System.out.println("Invalid input");
                    System.out.println("");
                    return;
                }
                
            }
            else if(i==student.size()-1){
                System.out.println("Invalid input");
                System.out.println("");
                return;
            }
        }
        System.out.println("Completed");
        System.out.println("");
    }
    
    public static void printall(){
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        System.out.println("");
        System.out.println("---Information(Name, Age, Java score, Algorithm score)---");
        for(int i=0;i<student.size();i++){
            System.out.println(i+1 + ". " + student.get(i).name + " " + student.get(i).age + " " +  student.get(i).javascore + " " + student.get(i).algoscore);
        }
        System.out.println("");
    }
    
    public static void sum(){
        double javasum=0;
        double algosum=0;
        int javacount=0;
        int algocount=0;
        
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        System.out.print("Subject to calculate(Java/Algorithm): ");
        Scanner scanner=new Scanner(System.in);
        String subject=scanner.next();
        
        if(subject.equalsIgnoreCase("Java")){
            for(int i=0;i<student.size();i++){
                double java = student.get(i).javascore;
                javasum+=java;
                javacount++;
            }
            System.out.println("Java Total score: " + javasum);
        }
        
        else if(subject.equalsIgnoreCase("Algorithm")){
            for(int i=0;i<student.size();i++){
                double algo = student.get(i).algoscore;
                algosum+=algo;
                algocount++;
            }
            System.out.println("Algorithm Total score: " + algosum);
        }
        else{
            System.out.println("Invalid input");
            System.out.println("");
            return;
        }
        System.out.println("");
    }
    
    public static void average(){
        double javasum=0;
        double algosum=0;
        double javacount=0;
        double algocount=0;
        
        if(student.isEmpty()){
            System.out.println("no value");
            System.out.println("");
            return;
        }
        
        System.out.print("Subject to calculate(Java/Algorithm): ");
        Scanner scanner=new Scanner(System.in);
        String subject=scanner.next();
        
        if(subject.equalsIgnoreCase("Java")){
            for(int i=0;i<student.size();i++){
                double java = student.get(i).javascore;
                javasum+=java;
                javacount++;
            }
            System.out.println("Java Average: " + javasum/javacount);
        }
        
        else if(subject.equalsIgnoreCase("Algorithm")){
            for(int i=0;i<student.size();i++){
                double algo = student.get(i).algoscore;
                algosum+=algo;
                algocount++;
            }
            System.out.println("Algorithm Average: " + algosum/algocount);
        }
        else{
            System.out.println("Invalid input");
                System.out.println("");
                return;
        }
        System.out.println("");
    }
        
    public static void gradeprint(){
       if(student.isEmpty()){
            System.out.println("no vlaue");
            System.out.println("");
            return;
        }
        
        System.out.print("Standard subject(Java/Algorithm): ");
        Scanner scanner=new Scanner(System.in);
        String subject=scanner.next();
        
        if(subject.equalsIgnoreCase("Java")){
            System.out.print("ASC/DESC: ");
            String order=scanner.next();
        
            if(order.equalsIgnoreCase("ASC")){
                Collections.sort(student,new JavaComparator());
            }
        
            else if(order.equalsIgnoreCase("DESC")){
                Collections.sort(student,new JavaComparator());
                Collections.reverse(student);
            }
            else{
                System.out.println("Invalid input");
                System.out.println("");
                return;
            }
            printall();
        }
        
        else if(subject.equalsIgnoreCase("Algorithm")){
            System.out.print("ASC/DESC: ");
            String order=scanner.next();
        
            if(order.equalsIgnoreCase("ASC")){
                Collections.sort(student,new AlgoComparator());
            }
        
            else if(order.equalsIgnoreCase("DESC")){
                Collections.sort(student,new AlgoComparator());
                Collections.reverse(student);
            }
            else{
                System.out.println("Invalid input");
                System.out.println("");
                return;
            }
            printall();
        }
        
        else{
            System.out.println("Invalid input");
            System.out.println("");
            return;
            }
    }
}

class JavaComparator implements Comparator<Student>{
	@Override
	public int compare(Student a,Student b){
		if(a.javascore>b.javascore) return 1;
		if(a.javascore<b.javascore) return -1;
		return 0;
	}
}

class AlgoComparator implements Comparator<Student>{
	@Override
	public int compare(Student a,Student b){
		if(a.algoscore>b.algoscore) return 1;
		if(a.algoscore<b.algoscore) return -1;
		return 0;
	}
}
    

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("=========================Information========================");
            System.out.println("1. Input(Name, Age, Java score, Algorithm score)");
            System.out.println("2. Remove");
            System.out.println("3. Search");
            System.out.println("4. Modify");
            System.out.println("5. Print all");
            System.out.println("6. Subject Total Score(Java/Algorithm)");
            System.out.println("7. Subject Average(Java/Algorithm)");
            System.out.println("8. Order by grade(ASC or DESC)");
            System.out.println("9. Quit");
            System.out.println("============================================================");
            System.out.println("Enter the number");
            System.out.print(">>> ");
            
        
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
        

            switch(number){
                case 1:
                    Student.input();
                    break;
                 case 2:
                     Student.remove();
                     break;
                 case 3:
                     Student.search();
                     break;
                 case 4:
                     Student.modify();
                     break;
                 case 5:
                     Student.printall();
                     break;
                 case 6:
                     Student.sum();
                     break;
                 case 7:
                     Student.average();
                     break;
                 case 8:
                     Student.gradeprint();
                     break;
                case 9:
                    return;
                default:
                    break;
            }
        }
    }
}
    