package com.example.boot_schedule;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class XXTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入总数N：");
        int N = in.nextInt();
        int h1 = 1;
        int yCount = 1;
        for (int i = 1; i < N; i++) {
            int count = i * i * 2 - (2 * i - 1);
            if (count > N)
                break;
            h1 = i;
            yCount = count;
        }
        int n = h1 * 2 - 1;
        for (int i = 1; i <= (n + 1) / 2; i++) { // 上半行
            for (int j = 1; j <= (n + 1) / 2 - i; j++) { // 上半行空格
                System.out.print(" ");
            }
            for (int m = 1; m < 2 * i; m++) { // 按照规律1，3，5，7。。。。输入每行的*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k = (n + 1) / 2 - 1; k >= 1; k--) { // 下半行
            for (int b = 1; b <= (n + 1) / 2 - k; b++) { // 下半行空格
                System.out.print(" ");
            }
            for (int c = (n + 1) / 2 - k; c <= (n + 1) / 2 - 2 + k; c++) { // 按照规律。。。7，5，3，1输入每行的*
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("剩余:"+(N - yCount));
    }


    /**
     * 打印m行
     *
     * @param n
     */

    void name2(int n) {
        for (int i = 1; i <= (n + 1) / 2; i++) { // 上半行
            for (int j = 1; j <= (n + 1) / 2 - i; j++) { // 上半行空格
                System.out.print(" ");
            }
            for (int m = 1; m < 2 * i; m++) { // 按照规律1，3，5，7。。。。输入每行的*
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k = (n + 1) / 2 - 1; k >= 1; k--) { // 下半行
            for (int b = 1; b <= (n + 1) / 2 - k; b++) { // 下半行空格
                System.out.print(" ");
            }
            for (int c = (n + 1) / 2 - k; c <= (n + 1) / 2 - 2 + k; c++) { // 按照规律。。。7，5，3，1输入每行的*
                System.out.print("*");
            }
            System.out.println();

        }
    }


//    SELECT name  FROM tbl_middle_student WHERE id IN (SELECT stu_id FROM tbl_middle_score WHERE score = 100) ORDER BY NAME

//    SELECT DISTINCT st.name from  tbl_middle_student st,tbl_middle_score sc WHERE sc.score = 100 AND sc.stu_id = st.id ORDER BY st.name

//    SELECT DISTINCT st.name FROM tbl_middle_student st INNER JOIN  tbl_middle_score sc ON st.id = sc.stu_id AND sc.score = 100 ORDER BY st.name

//    SELECT c.name,stt.name,stt.height from tbl_middle_class c,(select max(height) as height, classid,name from tbl_middle_student group by classid)stt
//    WHERE c.id = stt.classid
}
