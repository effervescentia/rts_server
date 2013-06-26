package server_battle;

import java.util.concurrent.PriorityBlockingQueue;

public class OrderQueue {

	private class OEWrapper implements Comparable<OEWrapper> {

		public final Order order;
		public final long executionTime;

		public OEWrapper(Order order, long executionTime) {
			this.order = order;
			this.executionTime = executionTime;
		}

		@Override
		public int compareTo(OEWrapper other) {
			return Long.compare(this.executionTime, other.executionTime);
		}

		@Override
		public boolean equals(Object other) {
			if(other instanceof OEWrapper || other instanceof Order) {
				return this.order.equals(other);
			}
			return false;
		}
	}

	private final PriorityBlockingQueue<OEWrapper> inner;

	public OrderQueue() {
		inner = new PriorityBlockingQueue<OEWrapper>();
	}

	public void add(Order order, long executionWait) {
		inner.put(new OEWrapper(order, System.currentTimeMillis() + executionWait));
	}
	public void remove(long order_id){
		for(OEWrapper x: inner){
			if(x.order.getOrder_ID() == order_id){
				inner.remove(x);
			}
		}
	}

	public Order take() {
		for (;;) {
			OEWrapper order = inner.peek();
			if(order != null && order.executionTime <= System.currentTimeMillis()) {
				return inner.poll().order;
			}
		}
	}
}

