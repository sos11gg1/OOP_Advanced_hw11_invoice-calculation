package com.example.lib;

import java.util.Scanner;

public class PrizeNumber {
    private String BonusNumber[];
    private Scanner scanner = new Scanner(System.in);
    private String JudgeNumber = "";
    private static final int OneThousandW = 0;
    private static final int TwoHundredW = 1;
    private static final int TwentyW1 = 2;
    private static final int TwentyW2 = 3;
    private static final int TwentyW3 = 4;
    private static final int TwoHundred1 = 5;
    private static final int TwoHundred2 = 6;

    public PrizeNumber(String address) {
        ReadTxt readTxt = new ReadTxt(address);
        this.BonusNumber = readTxt.getInvoiceNumber();
    }

    public void Judge() {
        System.out.println("請輸入發票號碼:");
        JudgeNumber = scanner.next();
        while (JudgeNumber.length() != 8) {
            System.out.println("請重新輸入號碼，應要8碼");
            JudgeNumber = scanner.next();
        }
        if (JudgeNumber.matches(BonusNumber[OneThousandW])) {
            System.out.println("獎金1000萬");
        } else if (JudgeNumber.matches(BonusNumber[TwoHundredW])) {
            System.out.println("獎金200萬");
        } else {
            if(!TwoHundred_Judge() && !TwentyW_Judge()){
                System.out.println("難過ㄟ~沒中獎");
            }
        }
    }

    private boolean TwentyW_Judge() {
        boolean getprize = false;
        for (int i = 0; i < 6; i++) {
            if (JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW1].substring(i, 8))
                    || JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW2].substring(i, 8))
                    || JudgeNumber.substring(i, 8).matches(BonusNumber[TwentyW3].substring(i, 8))) {
                switch (i) {
                    case 0:
                        System.out.println("恭喜獎金20萬元");
                        break;
                    case 1:
                        System.out.println("恭喜獎金4萬元");
                        break;
                    case 2:
                        System.out.println("恭喜獎金1萬元");
                        break;
                    case 3:
                        System.out.println("恭喜獎金4千元");
                        break;
                    case 4:
                        System.out.println("恭喜獎金1千元");
                        break;
                    case 5:
                        System.out.println("恭喜獎金2百元");
                        break;
                }
                getprize = true;
                break;
            } else {
                getprize = false;
            }
        }
        return getprize;
    }

    private boolean TwoHundred_Judge() {
        boolean getprize;
        String Last3 =JudgeNumber.substring(0, 8);
        if (Last3.matches(BonusNumber[TwoHundred1]) || Last3.matches(BonusNumber[TwoHundred2])) {
            System.out.println("恭喜獎金2百元");
            getprize = true;
        } else {
            getprize = false;
        }
        return getprize;
    }
}
