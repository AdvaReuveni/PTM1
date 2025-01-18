package test;

import java.util.Date;
import java.util.function.BinaryOperator;

import test.TopicManagerSingleton.TopicManager;

public class BinOpAgent implements Agent{
    String nameOfAgent;
    String topic1;
    String topic2;
    String topicResult;
    BinaryOperator<Double> binaryOperator;
    TopicManager tm;
    double x,y;

    public BinOpAgent(String nameOfAgent, String topic1, String topic2, String topicResult, BinaryOperator<Double> binaryOperator){
        this.nameOfAgent = nameOfAgent;
        this.topic1 = topic1;
        this.topic2 = topic2;
        this.topicResult = topicResult;
        this.binaryOperator = binaryOperator;
        tm = TopicManagerSingleton.get();
        tm.getTopic(topic1).subscribe(this);
        tm.getTopic(topic2).subscribe(this);
        tm.getTopic(topicResult).addPublisher(this);
        //binaryOperator.apply(x,y);
        //Message m = new Message(binaryOperator.apply(x,y));
        //tm.getTopic(topicResult).publish(m);

        //tm.getTopic(result).addPublisher(this);
    }


    @Override
    public String getName() {
        return nameOfAgent;
    }

    @Override
    public void reset() {
        x=0.0;
        y=0.0;
    }

    @Override
    public void callback(String topic, Message msg) {
        if (topic.equals(topic1)){
            x=msg.asDouble;
        }
        if (topic.equals(topic2)){
            y=msg.asDouble;
        }
        if(!Double.isNaN(x) && ! Double.isNaN(y))
            tm.getTopic(topicResult).publish(new Message(""+binaryOperator.apply(x, y)));
    }


    @Override
    public void close() {

    }
}
