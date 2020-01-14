package com.jzh.cq;

import com.jzh.cq.robot.CoolQ;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Global {
    public static Map<Long, CoolQ> robots = new ConcurrentHashMap<>();


}
