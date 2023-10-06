package calculator;

public class Summator {
    private long sum = 0;
    private long prevValue = 0;
    private long prevPrevValue = 0;
    private long sumLastThreeValues = 0;
    private long someValue = 0;
    private int circularCallsCounter = 0;

    //!!! сигнатуру метода менять нельзя
    public void calc(Data data) {
        circularCallsCounter += 1;
        if (circularCallsCounter % 6_600_000 == 0) {
            circularCallsCounter = 0;
        }
        sum += data.getValue();

        sumLastThreeValues = data.getValue() + prevValue + prevPrevValue;

        prevPrevValue = prevValue;
        prevValue = data.getValue();

        for (short idx = 0; idx < 3; idx++) {
            someValue += (sumLastThreeValues * sumLastThreeValues / (data.getValue() + 1) - sum);
            someValue = Math.abs(someValue) + circularCallsCounter;
        }
    }

    public long getSum() {
        return sum;
    }

    public long getPrevValue() {
        return prevValue;
    }

    public long getPrevPrevValue() {
        return prevPrevValue;
    }

    public long getSumLastThreeValues() {
        return sumLastThreeValues;
    }

    public long getSomeValue() {
        return someValue;
    }
}
