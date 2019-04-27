public class Main {

    public static void main(String[] a) {
        DataWrapper wrapper = new DataWrapper(0);

        class ObservableRunnable implements Runnable, DataObserver {

            @Override
            public void run() {
                wrapper.addObserver(this);
            }

            @Override
            public void onValueChanged(int val) {
                System.out.println("Called from thread2 value is changed " + val);
            }
        }
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                wrapper.setVal(i);
            }
        });

        Thread thread2 = new Thread(new ObservableRunnable());
        thread2.start();
        thread1.start();
    }
}
