package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

import static rx.internal.util.unsafe.UnsafeAccess.UNSAFE;

/**
 * Created by Aleksey Mikhailov <Aleksey.Mikhailov@icerockdev.com> on 30.09.2018.
 */
@SuppressAnimalSniffer
public abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    public final static long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");

    protected LinkedQueueNode<E> producerNode;
    protected final void spProducerNode(LinkedQueueNode<E> node) {
        producerNode = node;
    }

    @SuppressWarnings("unchecked")
    protected final LinkedQueueNode<E> lvProducerNode() {
        return (LinkedQueueNode<E>) UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    protected final LinkedQueueNode<E> lpProducerNode() {
        return producerNode;
    }
}