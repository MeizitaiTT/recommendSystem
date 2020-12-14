package com.bupt.recommend.controller;

import com.bupt.recommend.service.DataIntoMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataIntoMysqlController {

    @Autowired
    DataIntoMysqlService dataIntoMysqlService;

    @RequestMapping("/data/intoMysql")
    public void DataInsert(){
        dataIntoMysqlService.DataInsert();
        return ;
    }
}
