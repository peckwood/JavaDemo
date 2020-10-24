package com.bladespear.demo.double11;

import java.time.LocalDateTime;

/**
 * 筛子奖励记录表
 */
public class DicePrizeRecord {
    /**
     * 筛子点数
     */
    private int pointCount;
    /**
     * 奖励名称
     */
    private String prizeName;
    /**
     * 获取时间
     */
    private LocalDateTime timeGained;
    /**
     * 是否已使用
     */
    private Boolean used;
}
