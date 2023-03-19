import java.io.*;

/**
 * Created by tuannt7 on 19/03/2023
 */
public class DoubleTest {
    public static void main(String[] args) throws Exception {
        long a = 0b0100000_00000000_00000000_00000000_00000000_00000000_00000000L; // 2^53
        long b = 0b1000000_00000000_00000000_00000000_00000000_00000000_00000000L; // 2^54
        System.out.printf("a: %d, b: %d\n", a, b);

        WorkerThreadTick workerThreadTick = new WorkerThreadTick();
        BufferedWriter bufferedWriter = getBufferWriter("output-double.txt");

        workerThreadTick.start();
        long startTime = System.currentTimeMillis();
        for (long d = a; d <= b; d++) {
            bufferedWriter.write(String.format("d:%08d, double:%8.1f\n", d, (double)d));
            bufferedWriter.flush();
        }
        long endTime = System.currentTimeMillis();
        workerThreadTick.stopTick();

        bufferedWriter.write(String.format("done in: %d seconds", (endTime - startTime) / 1000));
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    private static BufferedWriter getBufferWriter(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0);
            raf.close();
        }
        return new BufferedWriter(new FileWriter(file, true));
    }

    static class WorkerThreadTick extends Thread {
        private static final long startTime = System.currentTimeMillis();
        private static boolean needRun;

        public WorkerThreadTick() {
            needRun = true;
        }

        public void stopTick() {
            needRun = false;
        }

        @Override
        public void run() {
            try {
                while (needRun) {
                    long currentTime = System.currentTimeMillis();
                    System.out.printf("exec_time: %d seconds\n", (currentTime - startTime) / 1000);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted");
                e.printStackTrace();
            }
        }

    }
}
