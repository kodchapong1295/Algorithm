package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String a = sc.next();
	String newA = "", newB = "";
	String b = sc.next();
	String ans="";

	//int size = (a.length()>=b.length())?a.length()+1:b.length()+1;

//        for (int i = 0; i < size-a.length(); i++) {
//            newA += "0";
//        }
//        for (int i=0;i<a.length();i++ ){
//            newA += a.charAt(i);
//        }
//
//        for (int i = 0; i < size-b.length(); i++) {
//            newB += "0";
//        }
//        for (int i=0;i<b.length();i++ ){
//            newB += b.charAt(i);
//        }

        if (a.length() > b.length()) {
            for (int i = b.length(); i < a.length(); i++) {
                b = "0"+ b;
            }
        } else if (b.length() > a.length()) {
            for (int i = a.length(); i < b.length(); i++) {
                a = "0"+ a;
            }
        }


        System.out.println(newA);
        System.out.println(newB);
        //System.out.println(newA.substring(b.length()-1,a.length()));

        int carry = 0;

        for (int i = a.length()-1; i >=  0; i--) {
//            int carry = (a.charAt(i)+b.charAt(i))%10;

            //ans = (carry+Integer.parseInt(newA.substring(i-1,i))+Integer.parseInt(newB.substring(i-1,i)))%10 + ans;
            //carry = (carry+Integer.parseInt(newA.substring(i-1,i))+Integer.parseInt(newB.substring(i-1,i)))/10;
            int aNum = Integer.parseInt(a.substring(i,i+1));
            int bNum = Integer.parseInt(b.substring(i,i+1))+carry;

            if (i == 0) {
                ans = aNum+bNum + ans;
            } else {
                ans = (aNum+bNum)%10 + ans;
                carry = (aNum+bNum)/10;
            }
        }

        System.out.println(ans);



    }
}
