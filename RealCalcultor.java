package com.codestates.seb.calculator;
import java.text.DecimalFormat;
import java.util.Scanner;
// [더 정밀한 계산기]
// 1. 사용자가 종료할 때 까지 게속해서 사용할 수 있는 로직
// 2. 연산자의 종류는 +,-,*,/,%
// 3. 소수점 계산 가능 하지만 소수점으로 떨어지지 않을 경우 소수점 제거(Math.round)
// 4. 사용자가 연산을 끝내기 전까지는 계속해서 연산을 수행한다.
public class RealCalcultor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isEnd = true;

        while (true) {
            Menual(); // 메뉴얼
            int Input = sc.nextInt();
            if(Input == 2) //시스템 종료 구문
            {
                isEnd = false;
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            Ep(); //계산기 사용방법;
            System.out.println("1. 첫번째 숫자를 입력하세요.");
            double num1 = sc.nextDouble(); // 첫번째 숫자 입력
            System.out.println("2. 연산자를 입력하세요.");
            String cal = sc.next(); //연산자 입력
            System.out.println("1. 두번째 숫자를 입력하세요.");
            double num2 = sc.nextDouble(); // 두번째 숫자 입력
            System.out.println("연산을 계속하시겠습니까? YES or END(대문자 소문자 상관없습니다!)");
            String retry = sc.next();
            retry.toLowerCase(); // 연산문 대소문자 구분없이 입력하면 실행하는 구문
            double result =  Calculate(num1, num2, cal); //계산기 함수 구문

            if(result == 0) //만약 잘못된 입력값이 들어가면 게산기 함수부분에서 결과값을 0 리턴함
            {
                System.out.println("잘못된 오류값입니다. 다시입력해주십시오.");
            }

            if(retry.equals("yes")) {
                DecimalFormat df=new DecimalFormat("#.#######");
                System.out.println("결과값은 : " + df.format(result));
            }
            else{
                DecimalFormat df=new DecimalFormat("#.#######");
                System.out.println("결과값은 : " + df.format(result));
                break;
            }
        }
    }

    public static double Calculate(double num1, double num2, String cal){
        double result = 0;


        if(cal.equals("+")){
            result = num1 + num2;
        }
        else if(cal.equals("-")){
            result = num1 - num2;
        }
        else if(cal.equals("*")){
            result = num1 * num2;
        }
        else if(cal.equals("/")){
            result = num1 / num2;
        }
        else if(cal.equals("%")){
            result = num1 % num2;
        }
        else{
            result = result * 0;
        }

        return result;

    }



    public static void Menual(){
        System.out.println("======================================");
        System.out.println("=                계산기                =");
        System.out.println("======================================");
        System.out.println("|       1. 계산기 실행      2. 종료      |");
        System.out.println("======================================");
    }
    public static void Ep(){
        System.out.println("======================================");
        System.out.println("|             계산기 정보사항             |");
        System.out.println("======================================");
        System.out.println(" 소숫점은 7번째자리 이후는 자동 반올림 됩니다 ^.^ ");
        System.out.println("======================================");
        System.out.println("               -주의 사항-               ");
        System.out.println("   연산자를 잘못 입력할시 결과값은 초기화 됩니다.  ");
        System.out.println("======================================");
    }
}
