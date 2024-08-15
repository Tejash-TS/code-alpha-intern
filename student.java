

import java.util.*;


 class Student {
    Scanner s=new Scanner(System.in);
    public int roll_no;
    public String name;
    public float avg;
    public String grade;
    
    public int eng;
    public int cs;
    public int bio;
    public int science;
    public int maths;

    ArrayList<Object> arr = new ArrayList<Object>();
    
  
   
   

   
    

    // public void insert(){
    //     System.out.println(roll_no + name + average() +Grade());
    // }

public void getInfo(){
   
    System.out.println("enetr no of studens data to be enter");
    int n =s.nextInt();

    for(int i=0;i<=n;i++){
        System.out.println("enter roll No");
        roll_no=s.nextInt();
        System.out.println("enter name");
        name=s.next();
        System.out.println("enter the marks of english");
        eng=s.nextInt();
        System.out.println("enter the marks of computer science");
        cs=s.nextInt();
        System.out.println("enter the marks of biology");
        bio=s.nextInt();
        System.out.println("enter the marks of science");
        science=s.nextInt();
        System.out.println("enter the marks of maths");
        maths=s.nextInt();
      
        avg= (eng+cs+bio+science+maths)/5;
        if(avg>=90 && avg<100){
            grade="A1";
         }
         else if( avg>=80 && avg<90){
             grade="A2";
         }
         else if( avg>=70 && avg<80){
             grade="B1";
         }
         else if( avg>=60 && avg<70){
             grade="B2";
         }
         else if( avg>=50 && avg<60){
             grade="C1";
         }
         else if( avg>=40 && avg<50){
             grade="C2";
         }
         else{
             grade="Fail";
         }   
           
            
        
        arr.add(roll_no);
        arr.add(name);
        arr.add(avg);
        arr.add(grade) ;  
    }
       
    for (int i = 0; i < n; i++) {
        System.out.print(arr + " ");
    }
    System.out.println();   
    

}
} 


class Student3
{

public static void main(String[] args){
   Student S=new Student();

S. getInfo();	
}
}

