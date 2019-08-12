package ru.job4j.array;

import java.util.LinkedList;
/**
 * Class PriorityQueue решение задачи части 003 - урок 2. Очередь с приоритетом на LinkedList.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var taskNew = task;
        if (this.tasks.size() != 0) {
            for (var i = 0; i < this.tasks.size(); i++) {
                if (taskNew.getPriority() < tasks.get(i).getPriority()) {
                    tasks.add(i, taskNew);
                    return;
                }
                tasks.add(i + 1, task);
                return;
            }
        } else {
            tasks.add(0, task);
        }
    }
    public Task take() {
        return this.tasks.poll();
    }
}
