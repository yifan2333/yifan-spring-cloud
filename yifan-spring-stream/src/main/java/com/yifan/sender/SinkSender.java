package com.yifan.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * The interface Sink sender.
 *
 * @author wuyifan
 * @date 2020年01月19日 15:13
 */
public interface SinkSender {

    /**
     * The constant OUTPUT. 绑定的管道名称
     */
    String OUTPUT = "input";

    /**
     * Output message channel.
     *
     * @return the message channel
     * @author wuyifan
     * @date 2020年01月19日 15:13
     */
    @Output(SinkSender.OUTPUT)
    MessageChannel output();

}
