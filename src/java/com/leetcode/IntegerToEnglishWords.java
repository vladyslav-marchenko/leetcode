package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/integer-to-english-words/?envType=daily-question&envId=2024-08-07
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        System.out.println(numberToWords(1_000_010));
    }

    public static String numberToWords(int num) {
        return IntegerToEnglishWordsHandler
                .numberToWords(num);
    }

    public static class IntegerToEnglishWordsHandler {

        private static final Map<Integer, String> tripleZero2Word;
        private static final Map<Integer, String> number2Word;
        private static final Map<Integer, String> int2Number;
        private static final String END_TY = "ty";
        private static final String END_TEEN = "teen";
        private static final String ZERO = "Zero";
        private static final String TEN = "Ten";
        private static final String ELEVEN = "Eleven";
        private static final String TWELVE = "Twelve";
        private static final String THIRTEEN = "Thirteen";
        private static final String FIFTEEN = "Fifteen";
        private static final String EIGHTEEN = "Eighteen";
        private static final String TWENTY = "Twenty";
        private static final String THIRTY = "Thirty";
        private static final String FORTY = "Forty";
        private static final String FIFTY = "Fifty";
        private static final String EIGHTY = "Eighty";

        static {
            tripleZero2Word = new HashMap<>();
            tripleZero2Word.put(1, "Thousand");
            tripleZero2Word.put(2, "Million");
            tripleZero2Word.put(3, "Billion");

            number2Word = new HashMap<>();
            number2Word.put(0, "");
            number2Word.put(1, "One");
            number2Word.put(2, "Two");
            number2Word.put(3, "Three");
            number2Word.put(4, "Four");
            number2Word.put(5, "Five");
            number2Word.put(6, "Six");
            number2Word.put(7, "Seven");
            number2Word.put(8, "Eight");
            number2Word.put(9, "Nine");

            int2Number = new HashMap<>();
            int2Number.put(1, "Thousand");
            int2Number.put(2, "Million");
            int2Number.put(3, "Billion");
        }

        public static String numberToWords(int num) {
            StringBuilder numberAsWord = new StringBuilder();

            if (num == 0) {
                return ZERO;
            }
            int tripleZeros = getTripleZeros(num);
            if (tripleZeros == 0) {
                return numberToWords(num, tripleZeros)
                        .toString()
                        .trim();
            }
            while (tripleZeros > 0) {
                if (num == 0 || num < getMultiplier(tripleZeros)) {
                    break;
                }
                numberAsWord
                        .append(numberToWords(num, tripleZeros))
                        .append(int2Number.get(tripleZeros))
                        .append(" ");
                num %= getMultiplier(tripleZeros);
                tripleZeros--;
            }

            numberAsWord
                    .append(numberToWords(num % 1000, 0));

            return numberAsWord
                    .toString()
                    .trim()
                    .replace("  ", " ");
        }

        private static int getTripleZeros(int num) {
            int tripleZerosCount = 0;
            while (num / 1000 > 0) {
                tripleZerosCount++;
                num /= 1000;
            }
            return tripleZerosCount;
        }
        private static StringBuilder numberToWords(int num, int tripleZeros) {
            StringBuilder words = new StringBuilder();
            int numberToProcess = tripleZeros == 0 ?
                    num :
                    num / getMultiplier(tripleZeros);
            return words
                    .append(numberToWordsLessThanHundred(numberToProcess));
        }

        private static int getMultiplier(int tripleZeros) {
            int multiplier = 1;
            while (tripleZeros > 0) {
                multiplier *= 1000;
                tripleZeros--;
            }
            return multiplier;
        }

        private static StringBuilder numberToWordsLessThanHundred(int num) {
            StringBuilder words = new StringBuilder();
            if (num < 10) {
                return numberLessThanTen(num);
            } else if (num < 20) {
                return numberLessThanTwentyAndMoreThanHundred(num);
            } else if (num < 100) {
                return numberLessThanHundredMoreThanTwenty(num);
            } else {
                int hundreds = num / 100;
                return words
                        .append(number2Word.get(hundreds))
                        .append(" ")
                        .append("Hundred")
                        .append(" ")
                        .append(numberToWordsLessThanHundred(num % 100));
            }
        }

        private static StringBuilder numberLessThanTen(int num) {
            StringBuilder words = new StringBuilder();
            String word = number2Word.get(num);
            return words
                    .append(word)
                    .append(" ");
        }

        private static StringBuilder numberLessThanTwentyAndMoreThanHundred(int num) {
            StringBuilder words = new StringBuilder();
            if (num == 10) {
                return words
                        .append(TEN)
                        .append(" ");
            } else if (num == 11) {
                return words
                        .append(ELEVEN)
                        .append(" ");
            } else if (num == 12) {
                return words
                        .append(TWELVE)
                        .append(" ");
            } else if (num == 13) {
                return words
                        .append(THIRTEEN)
                        .append(" ");
            } else if (num == 15) {
                return words
                        .append(FIFTEEN)
                        .append(" ");
            } else if (num == 18) {
                return words
                        .append(EIGHTEEN)
                        .append(" ");
            } else {
                return words
                        .append(number2Word.get(num % 10))
                        .append(END_TEEN)
                        .append(" ");
            }
        }

        private static StringBuilder numberLessThanHundredMoreThanTwenty(int num) {
            StringBuilder words = new StringBuilder();
            int tenth = num / 10;
            if (tenth == 2) {
                words.append(TWENTY);
            } else if (tenth == 3) {
                words.append(THIRTY);
            } else if (tenth == 4) {
                words.append(FORTY);
            } else if (tenth == 5) {
                words.append(FIFTY);
            } else if (tenth == 8) {
                words.append(EIGHTY);
            } else {
                words.append(number2Word.get(tenth))
                        .append(END_TY);
            }
            return words
                    .append(" ")
                    .append(numberLessThanTen(num % 10));
        }

    }

}
