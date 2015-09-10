package com.he.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
//https://www.hackerearth.com/capillary-java-hiring-challenge-2015/problems/d5e68cd5426446ebb7634356efa89ba8/
public class LargeNumberSUM {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        BigInteger bi1 = new BigInteger(str[0].trim());
        BigInteger bi2 = new BigInteger(str[1].trim());
        BigInteger n = (bi2.subtract(bi1).add(new BigInteger("1")));
        BigInteger result = (n.multiply((bi1.multiply(new BigInteger("2")).add(n.subtract(new BigInteger("1"))))).divide(new BigInteger("2")));
        System.out.println(result.toString());
    }

}
