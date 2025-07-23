package org.uade.util;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueue;

public class QueueUtil {
    public static QueueADT copy(QueueADT queue) {
        QueueADT temp= new DynamicQueue();
        QueueADT result= new DynamicQueue();

        while (!queue.isEmpty()) {
            temp.add(queue.getElement());
            result.add(queue.getElement());
            queue.remove();
        }

        while (!temp.isEmpty()) {
            queue.add(temp.getElement());
            temp.remove();
        }
        return result;
    }

    public static void print(QueueADT queue) {
        QueueADT aux= QueueUtil.copy(queue);

        while(!aux.isEmpty()) {
            System.out.println(aux.getElement());
            aux.remove();
        }

    }
}
