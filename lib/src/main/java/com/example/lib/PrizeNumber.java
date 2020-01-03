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
        System.out.println("�п�J�o�����X:");
        JudgeNumber = scanner.next();
        while (JudgeNumber.length() != 8) {
            System.out.println("�Э��s��J���X�A���n8�X");
            JudgeNumber = scanner.next();
        }
        if (JudgeNumber.matches(BonusNumber[OneThousandW])) {
            System.out.println("����1000�U");
        } else if (JudgeNumber.matches(BonusNumber[TwoHundredW])) {
            System.out.println("����200�U");
        } else {
            if(!TwoHundred_Judge() && !TwentyW_Judge()){
                System.out.println("���L��~�S����");
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
                        System.out.println("���߼���20�U��");
                        break;
                    case 1:
                        System.out.println("���߼���4�U��");
                        break;
                    case 2:
                        System.out.println("���߼���1�U��");
                        break;
                    case 3:
                        System.out.println("���߼���4�d��");
                        break;
                    case 4:
                        System.out.println("���߼���1�d��");
                        break;
                    case 5:
                        System.out.println("���߼���2�ʤ�");
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
            System.out.println("���߼���2�ʤ�");
            getprize = true;
        } else {
            getprize = false;
        }
        return getprize;
    }
}
