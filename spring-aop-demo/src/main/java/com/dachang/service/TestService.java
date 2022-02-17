package com.dachang.service;

import com.dachang.entity.ServiceResultTO;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 17:49
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
public interface TestService {


    /**
     * 异常
     * @author Evan
     * @date 2022/2/11 19:03
     * @return com.dachang.entity.ServiceResultTO<java.lang.Boolean>
     */
    ServiceResultTO<Boolean> test();

    /**
     *  吃萝卜
     * @author Evan
     * @date 2022/2/11 17:49
     */
    void eatCarrot();

    /**
     *  吃蘑菇
     * @author Evan
     * @date 2022/2/11 17:49
     */
    void eatMushroom();


    /**
     *  吃白菜
     * @author Evan
     * @date 2022/2/11 17:49
     */
    void eatCabbage();
}
