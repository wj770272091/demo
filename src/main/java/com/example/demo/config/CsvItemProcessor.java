package com.example.demo.config;

import com.example.demo.bean.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @NAME: CsvItemProcessor
 * @USER: 77027
 * @DATE: 2021/1/4
 * @TIME: 16:40
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException{
        super.process(item);
        if (item.getNation().equals("汉族")){
            item.setNation("01");
        }else {
            item.setNation("02");
        }
        return item;
    }
}
