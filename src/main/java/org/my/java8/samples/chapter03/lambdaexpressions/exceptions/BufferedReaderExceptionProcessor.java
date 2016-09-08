package org.my.java8.samples.chapter03.lambdaexpressions.exceptions;


import java.io.BufferedReader;
import java.io.IOException;

/**
 * User: Nipuni Perera
 * This is a customize functional interface, that can use when the code need to throw and exception
 */
public interface BufferedReaderExceptionProcessor {
      String readFile(BufferedReader bufferedReader) throws IOException;
}
