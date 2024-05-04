package com.example.acmwwh.common.util;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 集合工具类测试
 *
 * @author acmwwh
 * @since 2024/2/18
 */
@Slf4j
@SpringBootTest
class CollectionUtilsTest {

    public Collection<OrderItem> coll = new HashSet<>(Arrays.asList(new OrderItem(1L, "1", 100.0), new OrderItem(2L, "2", 200.0)));

    @Test
    void toMapTest() {

        /*
         * 将 Set<OrderItem> 转换为 Map<Long, OrderItem>
         */
        Map<Long, OrderItem> map1 = CollectionUtils.toMap(coll, OrderItem::getOrderId);
        log.info("map1:{}", map1);

        /*
         * 将 Set<OrderItem> 转换为 Map<Long, Double>
         */
        Map<Long, Double> map2 = CollectionUtils.toMap(coll, OrderItem::getOrderId, OrderItem::getActPrice);
        log.info("map2:{}", map2);
    }

    @Test
    void convertMapValue() {

        Map<Long, OrderItem> map = CollectionUtils.toMap(coll, OrderItem::getOrderId);
        Map<Long, String> orderId2Name = CollectionUtils.convertMapValue(map, (id, item) -> id + item.getName());
    }

    @Test
    void toListTest() {

        /*
         * 将 Set<OrderItem> 转换为 List<OrderItem>
         */
        List<OrderItem> list1 = CollectionUtils.toList(coll);
        log.info("list1:{}", list1);

        /*
         * 将 Set<OrderItem> 转换为 List<Long>
         */
        List<Long> list2 = CollectionUtils.map2List(coll, OrderItem::getOrderId);
        log.info("list2:{}", list2);
    }

    @Test
    void toSetTest() {

        /*
         * 将 Set<OrderItem> 转换为 Set<OrderItem>
         */
        Set<OrderItem> set1 = CollectionUtils.toSet(coll);
        log.info("set1:{}", set1);

        /*
         * 将 Set<OrderItem> 转换为 Set<Long>
         */
        Set<Long> set2 = CollectionUtils.map2Set(coll, OrderItem::getOrderId);
        log.info("set2:{}", set2);
    }

    @Data
    @AllArgsConstructor
    protected class OrderItem {

        private Long orderId;
        private String name;
        private Double actPrice;
    }
}
