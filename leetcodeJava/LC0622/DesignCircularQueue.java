class MyCircularQueue {
    private int[] A;
    private int front = -1;
    private int rear = -1;
    public MyCircularQueue(int k) {
        int[] queue = new int[k];
        this.A = queue;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) return false;
        else if(this.isEmpty())
        {
            this.front = 0;
            this.rear = 0;
        }
        else this.rear =(this.rear+1)%this.A.length;
        this.A[this.rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty()) return false;
        else if(this.rear==this.front)
        {
            this.rear = -1;
            this.front = -1;
        }
        else this.front =(this.front+1)%this.A.length;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty()) return this.front;
        return this.A[this.front];
    }
    
    public int Rear() {
        if(this.isEmpty()) return this.rear;
        return this.A[this.rear];
    }
    
    public boolean isEmpty() {
        return(this.A==null || this.rear == -1 || this.front == -1);
    }
    
    public boolean isFull() {
        return (this.rear+1)%this.A.length == this.front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */