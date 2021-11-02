package com.example.demo.util;

import java.io.*;

/**
 * @NAME: ParseFile
 * @USER: WangJie
 * @DATE: 2021/9/26
 * @TIME: 15:54
 */
public class ParseFile {
    /**
     * 解析html文件
     *
     * @param file
     * @return
     */
    public String readHtml(File file) {
        String body = "";
        try {
            FileInputStream iStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(iStream);
            BufferedReader htmlReader = new BufferedReader(reader);

            String line;
            boolean found = false;
            while (!found && (line = htmlReader.readLine()) != null) {
                if (line.toLowerCase().indexOf("<body") != -1) { // 在<body>的前面可能存在空格
                    found = true;
                }
            }

            found = false;
            while (!found && (line = htmlReader.readLine()) != null) {
                if (line.toLowerCase().indexOf("</body") != -1) {
                    found = true;
                } else {
                    if (line.indexOf("id=\"id") == -1 && line.indexOf("class=\"#d43f3a") == -1 && line.indexOf("class=\"#ee9336") == -1 && line.indexOf("class=\"#fdc431") == -1) {
                        continue;
                    }

                    if (line.indexOf("id=\"id") != -1) {
                        if (line.length() > 126&&line.length()<135) {
                            body = body + line.substring(93, 106).replaceAll("<", "").replaceAll("d", "").replaceAll("i", "").replaceAll(">","") + "\n";
                        }
                    }
                    if (line.indexOf("class=\"#d43f3a") != -1) {
                        int CRITICAL = Integer.parseInt(line.substring(225, 227).replaceAll("<", ""));
                        if (CRITICAL > 0) {
                            body = body + "CRITICAL:" + CRITICAL + "\n";
                        }

                    }
                    if (line.indexOf("class=\"#ee9336") != -1) {
                        int HIGH = Integer.parseInt(line.substring(225, 227).replaceAll("<", ""));
                        if (HIGH > 0) {
                            body = body + "HIGH:" + HIGH + "\n";
                        }
                    }
                    if (line.indexOf("class=\"#fdc431") != -1) {
                        int MEDIUM = Integer.parseInt(line.substring(225, 227).replaceAll("<", ""));
                        if (MEDIUM > 0) {
                            body = body + "MEDIUM:" + MEDIUM + "\n";
                        }
                    }
                }
            }
            htmlReader.close();
            //        System.out.println(body);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        return body;
    }


}
