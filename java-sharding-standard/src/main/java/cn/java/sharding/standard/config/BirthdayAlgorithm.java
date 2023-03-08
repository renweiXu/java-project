package cn.java.sharding.standard.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.*;

public class BirthdayAlgorithm implements PreciseShardingAlgorithm<Date> {

    List<Date> dateList = new ArrayList<>();

    {
//        Calendar instance1 = Calendar.getInstance();
//        instance1.set(2020,1,1,0,0,0);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(2024,1,1,0,0,0);
        Calendar instance3 = Calendar.getInstance();
        instance3.set(2025,1,1,0,0,0);
//        dateList.add(instance1.getTime());
        dateList.add(instance2.getTime());
        dateList.add(instance3.getTime());
    }

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        // 获取属性数据库的真实值
        Date date = preciseShardingValue.getValue();
        // 获取数据源的名称信息列表
        Iterator<String> iterator = collection.iterator();
        String target = null;
        for (Date s : dateList) {
            target = iterator.next();
            // 如果晚于指定的日期直接返回
            if (date.before(s)){
                break;
            }
        }
        // 返回的是ds0 ds1
        return target;
    }
}
