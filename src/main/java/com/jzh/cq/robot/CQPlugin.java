package com.jzh.cq.robot;

import com.jzh.cq.event.message.CQDiscussMessageEvent;
import com.jzh.cq.event.message.CQPrivateMessageEvent;
import com.jzh.cq.event.notice.*;
import com.jzh.cq.event.request.CQFriendRequestEvent;
import com.jzh.cq.event.request.CQGroupRequestEvent;
import org.springframework.stereotype.Component;
import com.jzh.cq.event.message.CQGroupMessageEvent;
import com.jzh.cq.event.meta.CQHeartBeatEvent;
import com.jzh.cq.event.notice.*;

public class CQPlugin {
    public static final int MESSAGE_BLOCK = 1;
    public static final int MESSAGE_IGNORE = 0;

    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onDiscussMessage(CoolQ cq, CQDiscussMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupUploadNotice(CoolQ cq, CQGroupUploadNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupAdminNotice(CoolQ cq, CQGroupAdminNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupDecreaseNotice(CoolQ cq, CQGroupDecreaseNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupIncreaseNotice(CoolQ cq, CQGroupIncreaseNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupBanNotice(CoolQ cq, CQGroupBanNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onFriendAddNotice(CoolQ cq, CQFriendAddNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onFriendRequest(CoolQ cq, CQFriendRequestEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupRequest(CoolQ cq, CQGroupRequestEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onHeartBeatMeta(CoolQ cq, CQHeartBeatEvent event) {
        return MESSAGE_IGNORE;
    }
}
