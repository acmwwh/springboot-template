package com.example.acmwwh.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 集合工具类
 *
 * @author acmwwh
 * @since 2024/2/18
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtils {

    /**
     * 判断集合是否为空
     *
     * @param collection 待判断的集合
     * @param <T>        数据类型
     * @return true:空集合
     */
    public static <T> boolean isEmpty(Collection<T> collection) {

        return null == collection || collection.isEmpty();
    }

    /**
     * 将集合转化为 map，其中集合内的元素类型与 map 内的值元素类型相同，键冲突时默认替换成新的值
     *
     * @param collection 集合
     * @param keyMapper  映射函数
     * @param <T>        集合元素类型 & map值元素类型
     * @param <K>        map键元素类型
     * @return map
     */
    public static <T, K> Map<K, T> toMap(Collection<T> collection, Function<? super T, ? extends K> keyMapper) {
        return toMap(collection, keyMapper, Function.identity());
    }

    /**
     * 将集合转化为 map，其中集合内的元素类型与 map 内的值元素类型相同，键冲突时默认替换成新的值
     *
     * @param collection    集合
     * @param keyFunction   键映射函数
     * @param valueFunction 值映射函数
     * @param <T>           集合元素类型
     * @param <K>           map 键元素类型
     * @param <V>           map 值元素类型
     * @return map
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        return toMap(collection, keyFunction, valueFunction, pickSecond());
    }

    /**
     * 将集合转化为 map，其中集合内的元素类型与 map 内的值元素类型相同
     *
     * @param collection    集合
     * @param keyFunction   键映射函数
     * @param valueFunction 值映射函数
     * @param mergeFunction 合并函数，键冲突时执行
     * @param <T>           集合元素类型
     * @param <K>           map 键元素类型
     * @param <V>           map 值元素类型
     * @return map
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {

        if (isEmpty(collection)) {
            return new HashMap<>(0);
        }

        return collection.stream().collect(Collectors.toMap(keyFunction, valueFunction, mergeFunction));
    }

    /**
     * 转化 map 的值，(v) -> {}
     *
     * @param originMap      原始 map
     * @param valueConverter 值映射函数
     * @param <K>            原 map 键元素类型
     * @param <V>            原 map 值元素类型
     * @param <C>            目标 map 值元素类型
     * @return map 目标 map
     */
    public static <K, V, C> Map<K, C> convertMapValue(Map<K, V> originMap, BiFunction<K, V, C> valueConverter) {
        return convertMapValue(originMap, valueConverter, pickSecond());
    }

    public static <K, V, C> Map<K, C> convertMapValue(Map<K, V> map, BiFunction<K, V, C> valueFunction, BinaryOperator<C> mergeFunction) {
        if (null == map) {
            return new HashMap<>();
        }
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> valueFunction.apply(e.getKey(), e.getValue()), mergeFunction));
    }

    public static <T> List<T> toList(Collection<T> collection) {

        return map2List(collection, Function.identity());
    }

    public static <T, R> List<R> map2List(Collection<T> collection, Function<T, R> mapper) {

        if (null == collection) {
            return new ArrayList<>();
        }

        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T> Set<T> toSet(Collection<T> collection) {

        return map2Set(collection, Function.identity());
    }

    public static <T, R> Set<R> map2Set(Collection<T> collection, Function<T, R> mapper) {

        if (null == collection) {
            return new HashSet<>();
        }

        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    public static <T> BinaryOperator<T> pickFirst() {
        return (k1, k2) -> k1;
    }

    public static <T> BinaryOperator<T> pickSecond() {
        return (k1, k2) -> k2;
    }
}
