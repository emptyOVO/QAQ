package dan.dan2;

public class Mythread implements Runnable{

private int[] arr;
private Object object;

    public Mythread(int[] arr, Object object) {
        this.arr = arr;
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i : arr) {
                System.out.print(i+" ");
                try {
                    this.object.notify();
                    Thread.sleep(1000);
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.object.notify();

        }
    }
}
