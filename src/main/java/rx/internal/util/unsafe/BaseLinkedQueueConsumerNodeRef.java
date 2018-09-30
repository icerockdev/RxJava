package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

import static rx.internal.util.unsafe.UnsafeAccess.UNSAFE;

@SuppressAnimalSniffer
public abstract class BaseLinkedQueueConsumerNodeRef<E> extends BaseLinkedQueuePad1<E> {
    protected final static long C_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;
    protected final void spConsumerNode(LinkedQueueNode<E> node) {
        consumerNode = node;
    }

    @SuppressWarnings("unchecked")
    protected final LinkedQueueNode<E> lvConsumerNode() {
        return (LinkedQueueNode<E>) UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
    }

    protected final LinkedQueueNode<E> lpConsumerNode() {
        return consumerNode;
    }
}
