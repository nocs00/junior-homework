package com.ofg.loans.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by pdudenkov on 12.05.2016.
 */
public abstract class IPHistory {
    private static Map<String, Integer> ipMap = new HashMap<>();

    //This data comes from Controller
    public static void addAttempt(String ip) {
        if (ipMap.containsKey(ip))
            ipMap.put(ip, ipMap.get(ip) + 1);
        else
            ipMap.put(ip, 1);
    }

    public static void init(Map<String, Integer> injectedMap) {
        ipMap = injectedMap;
    }

    public static Integer checkIp(String ip) {
        return ipMap.getOrDefault(ip, 0);
    }

    public static void clearHistory() {
        ipMap.clear();
    }
}
