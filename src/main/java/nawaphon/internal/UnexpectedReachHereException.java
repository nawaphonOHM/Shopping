package nawaphon.internal;


public class UnexpectedReachHereException extends RuntimeException {
    public UnexpectedReachHereException() {
        super("Unexpected reach here!!! may be you miss something before...");
    }
}
