package cn.mo.controller;

import cn.mo.common.MoResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 * @author: mozhihang
 * @date: 2020/3/11 23:30
 */
@Slf4j
@RestController
public class IndexController {

    @RequestMapping("/")
    public MoResult index(){
        log.error("index-error...");
        return MoResult.succeed();
    }

}
