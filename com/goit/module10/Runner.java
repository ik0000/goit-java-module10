package com.goit.module10;


import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println("\t \t Hello %Username%");
        System.out.println("This 'software' provides you with the possibility to encrypt or decrypt messages");
        System.out.println("If you received decrypted message you can encrypt it if you know the 'key'. ");
        System.out.println("If you want to send the message you will need to encrypt it to be safe. ");
        System.out.println("\n To encrypt file press '1', to decrypt file press '2', to exit press '3'  ");

        Scanner input = new Scanner(System.in);
        //String entered = input.nextLine();
        //System.out.println("Wow:");
        //System.out.println(entered);
        int i = input.nextInt();
        switch (i) {
            case 1:
                System.out.println("Enter text:");
                Scanner input1 = new Scanner(System.in);
                String entered = input1.nextLine();
                System.out.println("Enter 'KEY':");
                Scanner input2 = new Scanner(System.in);
                int shuffle = input2.nextInt();
                FileUtil.fileEncrypt(entered,shuffle);
                break;
            case 2:
                System.out.println("Enter 'KEY':");
                Scanner input3 = new Scanner(System.in);
                shuffle = input3.nextInt();
                FileUtil.fileDecrypt(shuffle);
                break;
            case 3:
                break;
        }
        System.out.println("\n \t \t Thank you and Good Bye!");
        }
}
