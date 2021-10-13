package com.example.demo;

import com.example.demo.bean.ExportTemperatureDto;
import com.example.demo.util.ParseFile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


@SpringBootApplication
class DemoApplicationTests {

    @Test
    void contextLoads() {
//        File file=new File("E:\\360MoveData\\Users\\77027\\Documents\\Tencent Files\\770272091\\FileRecv\\_______o5iltc.html");
//        new ParseFile().readHtml(file);
//        String str="<div xmlns=\"\" id=\"idm576458645-container\" style=\"margin: 0 0 45px 0;\" class=\"section-wrapper\"><div class=\"clear\"></div></div>";
//        System.out.println(str.length());
        int[] res=new int[]{5,-3,5};
        MsTest.maxSubarraySumCircular(res);
        List<ExportTemperatureDto> list=new ArrayList<>();
        list.add(new ExportTemperatureDto(1,"haha"));
        list.add(new ExportTemperatureDto(1,"haha121"));
        list.add(new ExportTemperatureDto(2,"gffg"));
        list.add(new ExportTemperatureDto(3,"dasdeas"));
        ArrayList<ExportTemperatureDto> ress = list.stream().collect(collectingAndThen(
                toCollection(
                        () -> new TreeSet<>(comparing(ExportTemperatureDto::getPersonId))
                ),
                ArrayList::new
        ));
        for (ExportTemperatureDto ex:ress){
            System.out.println(ex.toString());
        }


    }

}
