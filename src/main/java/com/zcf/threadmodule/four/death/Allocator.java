package com.zcf.threadmodule.four.death;

import java.util.ArrayList;
import java.util.List;

public class Allocator {
    private List<Account> list = new ArrayList<>();

    public synchronized boolean applyLock(Account from, Account to) {
        if (list.contains(from) || list.contains(to)) {
            return false;
        }

        list.add(from);
        list.add(to);
        return true;
    }

    public synchronized void removeLock(Account from, Account to) {
        list.remove(from);
        list.remove(to);

    }

}
