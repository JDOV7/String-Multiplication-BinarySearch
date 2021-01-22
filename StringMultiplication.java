/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.ArrayList;
//a = "732883"      "347389403175232"
//b = "474003904"

public class StringMultiplication {

    public void StringMultiplication() {
        String a = "732883", b = "474003904";
        int i = 0;
        StringBuilder sReturn = new StringBuilder(a);
        StringBuilder sSum = new StringBuilder();
        boolean bA = false, bB = false;
        if (sReturn.indexOf("-") != -1) {
            sReturn.deleteCharAt(0);
            bA = true;
        }
        a = sReturn.reverse().toString();
        sReturn = new StringBuilder(b);
        if (sReturn.indexOf("-") != -1) {
            sReturn.deleteCharAt(0);
            bB = true;
        }
        b = sReturn.toString();
        for (char c : a.toCharArray()) {

            sSum = new StringBuilder(sum(sSum.toString(), multiplication(c, b, i)));
            System.out.println(sSum.toString());
            i++;
        }
        if (bB == true && bA == true) {
            System.out.println(sSum.toString());
        } else if (bB == true || bA == true) {
            System.out.println("-" + sSum.toString());
        } else {
            System.out.println(sSum.toString());
        }

    }

    public String multiplication(char cValue, String sValue, int i) {
        StringBuilder sReturn = new StringBuilder();
        int iComodin = 0;
        for (int j = sValue.length() - 1; j > 0; j--) {
            int iFirst = Integer.parseInt("" + cValue);
            int iSecond = Integer.parseInt("" + sValue.charAt(j));
            int iValue = (iFirst * iSecond) + iComodin;
            if (iValue >= 10) {
                sReturn.append(Integer.toString(iValue % 10));
                iComodin = iValue / 10;
            } else {
                sReturn.append(Integer.toString(iValue));
                iComodin = 0;
            }
        }
        int iFirst = Integer.parseInt("" + cValue);
        int iSecond = Integer.parseInt("" + sValue.charAt(0));
        int iValue = (iFirst * iSecond) + iComodin;
        return (iValue + sReturn.reverse().toString() + ceros(i));
    }

    public String ceros(int i) {
        StringBuilder sReturn = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sReturn.append("0");
        }
        return sReturn.toString();
    }

    public String sum(String sFirst, String sSecond) {
        int iMin = Math.max(sFirst.length(), sSecond.length()) - Math.min(sFirst.length(), sSecond.length());
        if (sFirst.length() > sSecond.length()) {
            sSecond = ceros(iMin) + sSecond;
        } else {
            sFirst = ceros(iMin) + sFirst;
        }
        sFirst = new StringBuilder(sFirst).reverse().toString();
        sSecond = new StringBuilder(sSecond).reverse().toString();
        StringBuilder sReturn = new StringBuilder();
        int iComodin = 0;
        for (int i = 0; i < sSecond.length() - 1; i++) {
            int iFirts = Integer.parseInt(new String("" + sFirst.charAt(i)));
            int iSecond = Integer.parseInt(new String("" + sSecond.charAt(i)));
            int iValue = ((iFirts) + (iSecond)) + iComodin;
            if (iValue >= 10) {
                sReturn.append(Integer.toString(iValue % 10));
                iComodin = iValue / 10;
            } else {
                sReturn.append(Integer.toString(iValue));
                iComodin = 0;
            }
        }
        int iFirst = Integer.parseInt("" + sFirst.charAt(sFirst.length() - 1));
        int iSecond = Integer.parseInt("" + sSecond.charAt(sSecond.length() - 1));
        int iValue = (iFirst + iSecond) + iComodin;
        return (iValue + sReturn.reverse().toString());
    }
}
