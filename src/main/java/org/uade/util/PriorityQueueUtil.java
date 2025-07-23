package org.uade.util;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.dynamic.DynamicPriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueUtil {
    public static PriorityQueueADT copy( PriorityQueueADT queue){
        PriorityQueueADT temp= new DynamicPriorityQueue();
        PriorityQueueADT result= new DynamicPriorityQueue();

        while(!queue.isEmpty()){
            temp.add(queue.getElement(), queue.getPriority());
            result.add(queue.getElement(), queue.getPriority());
            queue.remove();
        }
        while(!temp.isEmpty()){
            queue.add(temp.getElement(), temp.getPriority());
            temp.remove();
        }
        return result;

    }

    public static void print(PriorityQueueADT queue){
        PriorityQueueADT aux= PriorityQueueUtil.copy(queue);

        while(!aux.isEmpty()){
            System.out.println("Elemento:"+aux.getElement()+",Prioridad:"+aux.getPriority());
            aux.remove();
        }

    }
}
