package org.apache.mycat.advisor.service.um.userinfo.impl;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cjl on 2016/4/6.
 */
@Component
public class MyThread extends Thread{
    List<Ext> extList = new ArrayList<>();
    int i=0;
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            Ext ext = new Ext();
            extList.add(ext);

            ext.start();
        }
        for (int i = 0; i < 4; i++) {
            try {
                extList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 4; i++) {
            i += extList.get(i).getInt();
        }

    }

    public int getInt() {
        return i;
    }
}

class Ext extends Thread{
    int i=0;
    @Override
    public void run() {
        try {

            Thread.sleep(100);
            i = new Random().nextInt(10);
            System.out.println(this.getName()+"-"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getInt(){

        return i;
    }
}
