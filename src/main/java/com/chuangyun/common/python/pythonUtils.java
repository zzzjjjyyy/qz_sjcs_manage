package com.chuangyun.common.python;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class pythonUtils {
    public static void main(String[] args) {
        String data1 = "";
                List<String> list = getResult("Python","G://classify.py",data1);
    }
    public static List<String> getResult(String pythonPath, String path, String data) {
        List<String> lines = new ArrayList<String>();
        try {
//            String data1 = "[{'consNo': '1762004450', 'date': '2019-01-01', 'projectName': '1', 'sum': '40.272'}, {'consNo': '19756104884', 'date': '2019-01-02', 'projectName': '1', 'sum': '155.394'}, {'consNo': '1769003100', 'date': '2019-01-01', 'projectName': '1', 'sum': '207.156'}, {'consNo': '1769001465', 'date': '2019-01-04', 'projectName': '1', 'sum': '51.513000000000005'}, {'consNo': '1769003680', 'date': '2019-01-05', 'projectName': '1', 'sum': '157.71800000000002'}, {'consNo': '20024439604', 'date': '2019-01-06', 'projectName': '1', 'sum': '69.93'}, {'consNo': '1762004449', 'date': '2019-01-07', 'projectName': '1', 'sum': '101.24199999999999'}, {'consNo': '1762004449', 'date': '2019-01-08', 'projectName': '1', 'sum': '22.76'}, {'consNo': '1762004450', 'date': '2019-01-09', 'projectName': '1', 'sum': '163.358'}]";
            // String url="http://blog.csdn.net/thorny_v/article/details/61417386";
            System.out.println("start");
            String[] args1 = new String[]{pythonPath, path, data};
            Process pr = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream(),"gbk"));
            String line;
            System.out.println("-----------------------------------------------");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
            System.out.println("-----------------------------------------------");
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            System.out.println("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        return lines;
    }

}
