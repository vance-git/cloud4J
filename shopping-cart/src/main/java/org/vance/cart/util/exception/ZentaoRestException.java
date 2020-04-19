package org.vance.cart.util.exception;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class ZentaoRestException extends Exception{

    public ZentaoRestException (String msg) {
        super(msg);
    }

    public ZentaoRestException (String msg, Throwable cause) {
        super(msg, cause);
    }
}
