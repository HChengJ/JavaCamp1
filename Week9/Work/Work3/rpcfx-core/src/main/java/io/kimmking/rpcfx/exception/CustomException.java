package io.kimmking.rpcfx.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    private String message;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
