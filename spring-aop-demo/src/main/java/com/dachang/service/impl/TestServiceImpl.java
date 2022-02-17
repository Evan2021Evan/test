package com.dachang.service.impl;

import com.dachang.annotation.GlobalErrorCatch;
import com.dachang.entity.ServiceResultTO;
import com.dachang.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 17:50
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    @GlobalErrorCatch
    public ServiceResultTO<Boolean> test() {

            // 此处写服务里的执行逻辑
            return ServiceResultTO.buildSuccess(Boolean.FALSE);

    }

    @Override
    public void eatCarrot() {
        System.out.println("吃萝卜");
    }

    @Override
    public void eatMushroom() {
        System.out.println("吃蘑菇");
    }

    @Override
    public void eatCabbage() {
        System.out.println("吃白菜");
    }
}
