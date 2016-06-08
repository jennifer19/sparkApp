package com.kong.core;

import com.kong.exception.CacheException;

import java.io.Serializable;

/**
 * 消费者队列接口
 * Created by kong on 2016/4/30.
 */
public interface AyscQueue extends Serializable{

    String AyscQueueKey = "Share:AyscQueue";

    Object popAyscQueue() throws CacheException;
}
