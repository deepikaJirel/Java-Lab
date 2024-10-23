import java.util.Scanner;public class HappyBirthday{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birthDay;
        String birthMonth;
        int birthYear;
        System.out.println("When were you born? (use the form 1 January 1970: 10 October 2001)");
        birthDay = sc.nextInt();
        System.out.println("Day: "+birthDay);
        birthMonth=sc.next();
        System.out.println("Month: "+birthMonth);
        birthYear =sc.nextInt();
        System.out.println("Year: "+ birthYear);



    }
}