package com.example.acmwwh.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 字节数组工具类
 *
 * @author acmwwh
 * @since 2024/2/18
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BytesUtils {

    public static byte[] getSubArray(byte[] sourceArray, int startIndexInclusive, int endIndexExclusive) {
        if (startIndexInclusive < 0 || endIndexExclusive > sourceArray.length || endIndexExclusive <= startIndexInclusive) {
            throw new IllegalArgumentException("Invalid start or end index");
        }

        // 计算子数组的长度
        int subArrayLength = endIndexExclusive - startIndexInclusive;

        // 创建目标数组
        byte[] targetArray = new byte[subArrayLength];

        // 复制子数组
        System.arraycopy(sourceArray, startIndexInclusive, targetArray, 0, subArrayLength);

        return targetArray;
    }

    public static int bytes2Int(byte[] bytes) {

        // 创建一个字节缓冲区，并设置其字节顺序为小端
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);

        // 将字节缓冲区读取为int类型
        return buffer.getInt();
    }

    public static byte[] int2Bytes(int value) {
        // 创建一个字节缓冲区，并设置其字节顺序为小端
        ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);

        // 将int类型写入字节缓冲区
        buffer.putInt(value);

        // 返回字节缓冲区的字节数组
        return buffer.array();
    }

    public static byte[] concat(byte[]... arrays) {

        int totalLength = 0;
        for (byte[] array : arrays) {
            totalLength += array.length;
        }

        byte[] result = new byte[totalLength];
        int currentIndex = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, currentIndex, array.length);
            currentIndex += array.length;
        }
        return result;
    }

    // 截取数据部分的方法
    public static byte[] trimArray(byte[] originalArray) {
        int lastNonZeroIndex = originalArray.length - 1;
        // 找到最后一个非零元素的索引
        for (int i = originalArray.length - 1; i >= 0; i--) {
            if (originalArray[i] != 0) {
                lastNonZeroIndex = i;
                break;
            }
        }

        // 截取数组
        return Arrays.copyOfRange(originalArray, 0, lastNonZeroIndex + 1);
    }

    /**
     * 在数组末尾添加 0 到指定长度
     *
     * @param originalArray 原数组
     * @param totalLen      指定长度
     * @return 新数组
     */
    public static byte[] appendZeros(byte[] originalArray, int totalLen) {

        final int originLen = originalArray.length;
        if (originLen == totalLen) {
            return originalArray;
        }
        if (originLen > totalLen) {
            throw new IllegalArgumentException("originalArray length is larger than totalLen");
        }

        byte[] newArray = new byte[totalLen];
        // 将原始数组的内容复制到新数组的前部
        System.arraycopy(originalArray, 0, newArray, 0, originLen);

        // 新数组剩余部分填充0
        for (int i = originLen; i < totalLen; i++) {
            newArray[i] = 0;
        }

        return newArray;
    }

    /**
     * 判断 byte 数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(byte[] array) {

        return null == array || 0 == array.length;
    }
}
