package org.my.java8.samples.chapter03.lambdaexpressions;

import org.my.java8.samples.chapter03.lambdaexpressions.exceptions.BufferedReaderExceptionProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: NIpuni Perera
 * This class demonstrates the usage of lambda expressions with a customized functional interfaces.
 */
public class CustomInterfaceDemo {

    public static void main(String []args) {
        BufferedReaderExceptionProcessor bufferedReaderExceptionProcessor = (BufferedReader br) -> br.readLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/test.txt"));
            //This will print the first line read from text file above.
            System.out.println(processFile(br, bufferedReaderExceptionProcessor));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String processFile(BufferedReader bufferedReader,
                                   BufferedReaderExceptionProcessor bufferedReaderExceptionProcessor)
            throws IOException {
        String result = "";
        String temp = bufferedReaderExceptionProcessor.readFile(bufferedReader);
        if(!(temp.isEmpty() || temp.equals(""))){
            result += temp;
        }
        return result;
    }
}
