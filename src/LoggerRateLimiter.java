import java.util.HashMap;
import java.util.Map;

/**
 * <h1>359. Logger Rate Limiter</h1>
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example: Logger logger = new Logger();
 * <p>
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * logger.shouldPrintMessage(11,"foo"); returns true;
 *
 * @author Jerry
 * @since 2/28/17
 */
public class LoggerRateLimiter {
    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
