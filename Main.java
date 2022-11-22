package project;

import java.util.*;

class Student{ // Student 객체 생성(이름, 나이, 자바점수, 알고리즘점수 저장)
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
    
    static ArrayList<Student> student=new ArrayList<Student>(); // ArrayList를 이용하여 여러 학생정보를 저장, 모든 함수에서 사용할 수 있도록 static으로 선언
    
    public static void input(){ // 자료 입력, 정확한 값을 입력할 떄까지 반복한다.
        String name;
        int age;
        double javascore;
        double algoscore;
        Scanner scanner=new Scanner(System.in);
        
        while(true){ // 이름에 q를 입력할 때까지 반복
            while(true){
                boolean same=false; // 이름이 같은 경우인지 아닌지 판단하기위한 flag, 다시 반복을 시작할 때 false로 값을 변환하기위해 지역변수로 선언
                System.out.print("Name(q to quit): "); // 이름 입력
                name=scanner.next();
                name=name.substring(0, 1).toUpperCase() + name.substring(1); // 첫 문자는 대문자로 바꿔서 저장
            
                if(name.equalsIgnoreCase("q")){ // 대소문자 관계없이 q를 입력하면 자료입력 종료
                    System.out.println("Completed");
                    System.out.println("");
                    return;
                }
                
                for(int i=0;i<student.size();i++){
                    if(name.equalsIgnoreCase(student.get(i).name)){ // list에 같은 이름이 존재하는 경우
                        same=true; // 이름이 같아면 true로 변환
                        System.out.println("The name already exists.");
                        System.out.println("");
                        break;
                    }
                }
                if(same==false) // 리스트내에 같은 이름이 없다면 다음 값을 받는다
                    break;
            }
            
            while(true){ // 양수를 입력할 때까지 반복
                System.out.print("Age: "); // 나이 입력
                age=scanner.nextInt();
                if(age<0){ // 양수만 입력 가능
                    System.out.println("Please enter a positive number");
                    continue;
                }
                else{
                    break;
                }
            }
        
            while(true){ // 0~100 사이 값을 입력할 때까지 반복
                System.out.print("Java score(0~100): "); // 자바 점수 입력
                javascore=scanner.nextDouble();
                if(javascore<0 || javascore>100){ // 0~100값이 아닐경우
                    System.out.println("Please keep the range");
                    continue;
                }
                else{
                    break;
                }
            }
            
            while(true){ // 0~100 사이 값을 입력할 때까지 반복
                System.out.print("Algorithm score(0~100): "); // 알고리즘 점수 입력
                algoscore=scanner.nextDouble();
                if(algoscore<0 || algoscore>100){ // 0~100값이 아닐경우
                    System.out.println("Please keep the range");
                    continue;
                }
                else{
                    break;
                }
            }
        
            student.add(new Student(name,age,javascore,algoscore)); // 받아온 값들을 student에 추가
            System.out.println("");
        }
    }
    
    public static void remove(){ // 자료 삭제
        if(student.isEmpty()){ // student리스트가 비어있을 경우
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        printall(); // 삭제하기 용이하도록 student내 자료들을 출력
        System.out.print("Name to remove: "); // 제거할 자료의 이름 입력
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        
        for(int i=0;i<student.size();i++){ 
            if(student.get(i).name.equalsIgnoreCase(name)){ // 입력한 이름이 리스트내에 있을 경우
                student.remove(i); // 삭제
                break;
            }
            
            else if(i==student.size()-1){ // 리스트내에 이름이 없을 경우
                System.out.println("No value");
                System.out.println("");
                return;
            }
        }
        
        System.out.println("Completed");
        System.out.println("");
    }
    
    public static void search(){ // 자료 검색
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        System.out.print("Name to search: ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        for(int i=0;i<student.size();i++){ 
            if(student.get(i).name.equalsIgnoreCase(name)){ // 검색할 이름이 리스트 내에 있을 경우 해당 정보 출력
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
    
    public static void modify(){ // 자료 수정, 정확한 값을 입력할 떄까지 반복한다.
        String name = null;
        int age = 0;
        double javascore = 0;
        double algoscore = 0;
        
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        printall();
        System.out.print("Index to modify: "); // 수정할 자료의 인덱스 번호 입력
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();

        for(int i=0;i<student.size();i++){ 
            if(i==index-1){ // 입력한 인덱스 번호-1과 i가 같다면 값 수정(인덱스번호는 출력시 +1을 해서 출력하므로 -1한 값과 비교해야함)
            	System.out.print("What data would you modify?: "); // 수정할 이름, 나이, 점수, 모든 값중 선택
            	String data=scanner.next();
            	if(data.equalsIgnoreCase("Name")) { // 이름 수정
                    while(true){ // 수정을 할때도 범위를 벗어나지 않기위해 input의 조건대로 값을 입력받는다
                        boolean same=false; // 이름이 같은 경우인지 아닌지 판단하기위한 flag, 다시 반복을 시작할 때 false로 값을 변환하기위해 지역변수로 선언
                        System.out.print("Name: "); // 이름 입력
                        name=scanner.next();
                        name=name.substring(0, 1).toUpperCase() + name.substring(1); // 첫 문자는 대문자로 바꿔서 저장
                
                        for(int j=0;j<student.size();j++){
                            if(name.equalsIgnoreCase(student.get(j).name)){ // list에 같은 이름이 존재하는 경우
                                same=true; // 이름이 같아면 true로 변환
                                System.out.println("The name already exists.");
                                System.out.println("");
                                break;
                            }
                        }
                        if(same==false) // 리스트내에 같은 이름이 없다면 다음 값을 받는다
                            break;
                    }
                    age=student.get(i).age; // 이름만 수정했으므로 나머지 값들은 저장되어있던 값 그대로 둔다
                    javascore=student.get(i).javascore;
                    algoscore=student.get(i).algoscore;
                    student.add(i,new Student(name,age,javascore,algoscore)); // 지우고자했던 인덱스에 값을 추가하고
                    student.remove(i+1); // 밀려난 기존 데이터는 삭제한다
                    break;
            	}
            	
            	else if(data.equalsIgnoreCase("Age")) {
                    while(true){ // 양수를 입력할 때까지 반복
                        System.out.print("Age: "); // 나이 입력
                        age=scanner.nextInt();
                        if(age<0){ // 양수만 입력 가능
                            System.out.println("Please enter a positive number");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
            		name=student.get(i).name;
            		javascore=student.get(i).javascore;
                    algoscore=student.get(i).algoscore;
                    student.add(i,new Student(name,age,javascore,algoscore));
                    student.remove(i+1);
            		break;
            	}
            	
            	else if(data.equalsIgnoreCase("Java")) {
                    while(true){ // 0~100 사이 값을 입력할 때까지 반복
                        System.out.print("Java score(0~100): "); // 자바 점수 입력
                        javascore=scanner.nextDouble();
                        if(javascore<0 || javascore>100){ // 0~100값이 아닐경우
                            System.out.println("Please keep the range");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
            		name=student.get(i).name;
            		age=student.get(i).age;
            		algoscore=student.get(i).algoscore;
            		student.add(i,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
            		break;
            	}
            	
            	else if(data.equalsIgnoreCase("Algorithm")) {
                    while(true){ // 0~100 사이 값을 입력할 때까지 반복
                        System.out.print("Algorithm score(0~100): "); // 알고리즘 점수 입력
                        algoscore=scanner.nextDouble();
                        if(algoscore<0 || algoscore>100){ // 0~100값이 아닐경우
                            System.out.println("Please keep the range");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
            		name=student.get(i).name;
            		age=student.get(i).age;
            		javascore=student.get(i).javascore;
            		student.add(i,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
            		break;
            	}
                
                else if(data.equalsIgnoreCase("All")){ // 모든 값 수정
                    while(true){
                        boolean same=false; // 이름이 같은 경우인지 아닌지 판단하기위한 flag, 다시 반복을 시작할 때 false로 값을 변환하기위해 지역변수로 선언
                        System.out.print("Name(q to quit): "); // 이름 입력
                        name=scanner.next();
                        name=name.substring(0, 1).toUpperCase() + name.substring(1); // 첫 문자는 대문자로 바꿔서 저장
            
                        if(name.equalsIgnoreCase("q")){ // 대소문자 관계없이 q를 입력하면 자료입력 종료
                            System.out.println("Completed");
                            System.out.println("");
                            return;
                        }
                
                        for(int j=0;j<student.size();j++){
                            if(name.equalsIgnoreCase(student.get(j).name)){ // list에 같은 이름이 존재하는 경우
                                same=true; // 이름이 같아면 true로 변환
                                System.out.println("The name already exists.");
                                System.out.println("");
                                break;
                            }
                        }
                        if(same==false) // 리스트내에 같은 이름이 없다면 다음 값을 받는다
                            break;
                    }
            
                    while(true){ // 양수를 입력할 때까지 반복
                        System.out.print("Age: "); // 나이 입력
                        age=scanner.nextInt();
                        if(age<0){ // 양수만 입력 가능
                            System.out.println("Please enter a positive number");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
        
                    while(true){ // 0~100 사이 값을 입력할 때까지 반복
                        System.out.print("Java score(0~100): "); // 자바 점수 입력
                        javascore=scanner.nextDouble();
                        if(javascore<0 || javascore>100){ // 0~100값이 아닐경우
                            System.out.println("Please keep the range");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
            
                    while(true){ // 0~100 사이 값을 입력할 때까지 반복
                        System.out.print("Algorithm score(0~100): "); // 알고리즘 점수 입력
                        algoscore=scanner.nextDouble();
                        if(algoscore<0 || algoscore>100){ // 0~100값이 아닐경우
                            System.out.println("Please keep the range");
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    student.add(i,new Student(name,age,javascore,algoscore));
            		student.remove(i+1);
                    break;
                }
                
                else{
                    System.out.println("Invalid input"); // 수정할 자료의 이름을 잘못입력했을 경우
                    System.out.println("");
                    return;
                }
                
            }
            else if(i==student.size()-1){
                System.out.println("Invalid input"); // 인덱스 번호를 잘못입력했을 경우
                System.out.println("");
                return;
            }
        }
        System.out.println("Completed");
        System.out.println("");
    }
    
    public static void printall(){ // 자료 출력
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
    
    public static void sum(){ // 자료 총합
        double javasum=0;
        double algosum=0;
        
        if(student.isEmpty()){
            System.out.println("No value");
            System.out.println("");
            return;
        }
        
        System.out.print("Subject to calculate(Java/Algorithm): "); // 총합을 구할 과목 선택
        Scanner scanner=new Scanner(System.in);
        String subject=scanner.next();
        
        if(subject.equalsIgnoreCase("Java")){
            for(int i=0;i<student.size();i++){
                double java = student.get(i).javascore;
                javasum+=java;
            }
            System.out.println("Java Total score: " + javasum);
        }
        
        else if(subject.equalsIgnoreCase("Algorithm")){
            for(int i=0;i<student.size();i++){
                double algo = student.get(i).algoscore;
                algosum+=algo;
            }
            System.out.println("Algorithm Total score: " + algosum);
        }
        else{
            System.out.println("Invalid input"); // 과목이름을 잘못입력했을 경우
            System.out.println("");
            return;
        }
        System.out.println("");
    }
    
    public static void average(){ // 자료 평균
        double javasum=0;
        double algosum=0;
        double javacount=0;
        double algocount=0;
        
        if(student.isEmpty()){
            System.out.println("no value");
            System.out.println("");
            return;
        }
        
        System.out.print("Subject to calculate(Java/Algorithm): "); // 평균을 구할 과목 선택
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
            System.out.println("Invalid input"); // 과목이름을 잘못입력했을 경우
                System.out.println("");
                return;
        }
        System.out.println("");
    }
        
    public static void gradeprint(){ // 성적순으로 출력
       if(student.isEmpty()){
            System.out.println("no vlaue");
            System.out.println("");
            return;
        }
        
        System.out.print("Standard subject(Java/Algorithm): "); // 어떤 과목을 기준으로 할지 선택
        Scanner scanner=new Scanner(System.in);
        String subject=scanner.next();
        
        if(subject.equalsIgnoreCase("Java")){
            System.out.print("ASC/DESC: "); // 오름차순/내림차순 선택
            String order=scanner.next();
        
            if(order.equalsIgnoreCase("ASC")){ // 오름차순
                Collections.sort(student,new JavaComparator()); // JavaComparator라는 클래스 사용하여 오름차순으로 정렬
            }
        
            else if(order.equalsIgnoreCase("DESC")){ // 내림차순
                Collections.sort(student,new JavaComparator()); // 오름차순으로 정렬후
                Collections.reverse(student); // reverse해서 내림차순으로 만들기
            }
            else{
                System.out.println("Invalid input"); // 오름차순/내림차순 잘못입력했을 경우
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
            System.out.println("Invalid input"); // 과목이름 잘못입력했을 경우
            System.out.println("");
            return;
            }
    }
}

class JavaComparator implements Comparator<Student>{ // Comparator라는 인터페이스를 이용하여 자바점수 비교
	@Override // 인터페이스내 함수를 overriding해서 내가 원하는 대로 수행하도록 바꿈
	public int compare(Student a,Student b){ // 오름차순 정렬
		if(a.javascore>b.javascore) return 1; // 두 값을 비교하여 앞에 값이 클 경우 1 반환
		if(a.javascore<b.javascore) return -1; // 작을 경우 -1 반환
		return 0;
	}
}

class AlgoComparator implements Comparator<Student>{ // Comparator라는 인터페이스를 이용하여 알고리즘점수 비교
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
            int number=scanner.nextInt(); // 번호 입력
        
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
