package com.calpis.interview.netty.example.echo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/7 17:32
 */
public class demo {

    private Set<Integer> set = new HashSet<Integer>() {{
        add(6); // Friday
        add(7); // Saturday
        add(1); // Sunday
    }};

    public boolean deadLineCalculator(Date taskStartTime, int waitingHours) {
        // 是否越界
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(taskStartTime);
        boolean overflow = set.contains(calendar.get(Calendar.DAY_OF_WEEK)) && calendar.get(Calendar.HOUR_OF_DAY) >= 18;
        if (overflow) {
            return 9 * 5 > waitingHours;
        }
        return false;
    }
}
