package com.bladespear.demo.double11;

import java.time.LocalDate;

public class TasksStatus {
    /**
     * 是否已分享到朋友圈
     */
    private Boolean sharedToFriendZone;
    /**
     * 是否已领取分享到朋友圈奖励
     */
    private Boolean gotSharedReward;
    /**
     * 是否已签到
     */
    private Boolean checkedIn;
    /**
     * 是否已领取签到奖励
     */

    private Boolean getCheckedInReward;

    /**
     * 是否已支付订单
     */
    private Boolean orderPaid;
    /**
     * 是否已领取支付订单奖励
     */
    private Boolean gotOrderPaidReward;

    /**
     * 任务状态日期
     */
    private LocalDate taskStatusDate;


}
