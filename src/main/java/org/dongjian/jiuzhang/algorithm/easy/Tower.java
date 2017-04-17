package org.dongjian.jiuzhang.algorithm.easy;

import java.util.Stack;

/**
 * n the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 * <p>
 * Only one disk can be moved at a time.
 * A disk is slid off the top of one tower onto the next tower.
 * A disk can only be placed on the top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class Tower {
    private Stack<Integer> disks;

    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }

    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        if (!t.getDisks().isEmpty() && t.getDisks().peek() <= disks.peek()) {
            System.out.println("Error placing disk " + disks.peek());
        } else {
            t.add(disks.pop());
        }
    }

    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0 && !disks.isEmpty()) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}

