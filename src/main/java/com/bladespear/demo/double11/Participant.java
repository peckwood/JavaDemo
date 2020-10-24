package com.bladespear.demo.double11;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Participant {
    private Long userId;
    /**
     * 是否已支付定金
     */
    private boolean paidDownPayment;
    /**
     * 翻倍卡个数
     */
    private Integer numberOfMagnificationCards;
    /**
     * 好友助力记录列表, key为好友ID
     */
    private Map<Long, PromoteRecord> friendPromoteRecords;
    /**
     * 进入乐园剩余次数
     */
    private Integer gameTicketsCount;
    /**
     * 乐园剩余次数所属的日期
     */
    private LocalDate gameTicketsDate;
    /**
     * 筛子奖励获取记录列表
     */
    private List<DicePrizeRecord> dicePrizeRecord;














}
