package com.cloud;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.cloud.akka.MyWork;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AkkaTest {

    @Test
    public void test() throws IOException {
        //初始化 ActorSystem
        final ActorSystem system = ActorSystem.create("MySystem");

        //创建第一个 Actor
        final ActorRef firstActor = system.actorOf(MyWork.props(), "firstActor");

        System.out.println(firstActor.path());

        //向第一个 Actor 发送消息
        firstActor.tell(MyWork.Msg.WORKING, ActorRef.noSender());

        System.out.println(">>> Press ENTER to exit <<<");
        try {
            System.in.read();
        } finally {
            system.terminate();
        }
    }
}
