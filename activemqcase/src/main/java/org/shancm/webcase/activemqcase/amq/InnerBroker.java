package org.shancm.webcase.activemqcase.amq;

import org.apache.activemq.broker.BrokerService;

/**
 * @author shancm
 * @package org.shancm.webcase.activemqcase.amq
 * @description:
 * @date 2018/6/19
 */
public class InnerBroker {
    public static void main(String args[]) throws Exception{
        BrokerService broker = new BrokerService();
        //启用broker的JMX监控功能
        broker.setUseJmx(true);
        //设置broker名字
        broker.setBrokerName("MyBroker");
        //是否使用持久化
        broker.setPersistent(false);
        //添加连接协议，地址
        broker.addConnector("tcp://localhost:61616");
        broker.start();
    }
}
