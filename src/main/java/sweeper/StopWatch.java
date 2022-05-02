package sweeper;

public class StopWatch {

    private long startTime =0;
    private long stopTime =0;

    public StopWatch(){
        startTime = System.currentTimeMillis();
    }

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        stopTime = System.currentTimeMillis();
    }

    public long getTimeSecs() {
        return (stopTime - startTime) / 1000;
    }
}
