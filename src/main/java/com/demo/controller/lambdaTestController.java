package com.demo.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/springboot123/")
@SuppressWarnings("all")
public class lambdaTestController {
    private static Logger logger = LoggerFactory.getLogger(lambdaTestController.class);

    @RequestMapping(value = "lambdaTestController", method = RequestMethod.GET)
    @Test
    public void sendMail() {
        List<String> test = new ArrayList<String>();
        Optional.ofNullable(null).map(m -> {
            return false;
        }).orElse(true);
        System.out.println("xxx");
    }

    @Test
    public void test14() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<String> strs = new ArrayList<String>();
        strs.add("一");
        strs.add("二");
        strs.add("三");
        String str = String.join(",", strs);

        list = list.stream().filter(l -> l > 2).collect(Collectors.toList());
        // 可改变对象
        list = list.stream().map((i) -> i * 3).collect(Collectors.toList());

        // 不可改变元有对象
        list.forEach(i -> i = i * 3);
        list.forEach(System.out::println);
        ;
    }
}
