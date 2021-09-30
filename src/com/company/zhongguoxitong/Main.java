import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

//class Main implements Runnable {
//
//    /**
//     * 每条生产令牌速率
//     */
//    private Integer RATE = 2;
//
//    /**
//     * 桶令牌上限
//     */
//    private long refreshTime = System.currentTimeMillis();
//    private Integer BURST = 5;
//    /**
//     * 桶里面的水量
//     */
//    private Integer water = 0;
//
//    public void log(String info) {
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " " + info);
//    }
//
//    @Override
//    public void run() {
//        // 实现run方法
//        long now = System.currentTimeMillis();
//        long pastTime = now - refreshTime;
//        long outWater = pastTime*RATE/1000;
//        water = water - (int)outWater;
//    }
//
//    public boolean tryAcquire(Integer num) {
//        if(water<0){
//            water =0;
//        }
//        if(water<=1){
//        }
//    }
//
//    public static void main(String args[]) {
//        Main bucket = new Main();
//        Thread produce = new Thread(bucket);
//        produce.start();
//
//        for (int i=0 ; i < 20 ; i++) {
//            bucket.run();
//            int finalI = i;
//            new Thread(() -> {
//                if (bucket.tryAcquire(finalI %4)) {
//                    bucket.log(Thread.currentThread().getName() + "需要" + finalI %4 + "个令牌，获取到令牌"+"容量"+ (5-bucket.water));
//                } else {
//                    bucket.log(Thread.currentThread().getName() + "需要" + finalI %4 + "个令牌，暂无令牌");
//                }
//            }).start();
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        produce.interrupt();
//    }
//}