package io.seanyinx.github.unit.scaffolding;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Poller {
    private final int timeoutMillis;
    private final int pollingIntervalMillis;

    public Poller(int timeoutMillis, int pollingIntervalMillis) {
        this.timeoutMillis = timeoutMillis;
        this.pollingIntervalMillis = pollingIntervalMillis;
    }

    public void assertEventually(Predicate predicate) {
        assertEventually(predicate, "");
    }

    private void assertEventually(Predicate predicate, String description) {
        long startTime = System.currentTimeMillis();
        try {
            while (notInterrupted() &&
                    notTimeout(startTime) &&
                    !predicate.isSatisfied()) {
                sleep();
            }
        } finally {
            assertThat(description, predicate.isSatisfied(), is(true));
        }
    }

    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(pollingIntervalMillis);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }

    private boolean notInterrupted() {
        return !Thread.currentThread().isInterrupted();
    }

    private boolean notTimeout(long startTime) {
        return System.currentTimeMillis() < startTime + timeoutMillis;
    }

    public interface Predicate {
        boolean isSatisfied();
    }
}
