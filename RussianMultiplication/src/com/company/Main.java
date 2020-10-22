package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int a = 26;
	int b = 47;
	int p=0;

	while(a>1){
	    if (a%2==0){
	        a = a/2;
	        b = b*2;
        }else{
	        p += b;
	        a = a/2;
	        b = b*2;
        }
    }
		System.out.println(b);
		System.out.println(p);
        System.out.println(b+p);
    }
}
