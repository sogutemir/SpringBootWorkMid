package org.work.springbootwork.core.results;

public class SuccessDataResult <T> extends DataResult<T> {
    public SuccessDataResult(T data , String message){
        super(true, message, data);
    }
    public SuccessDataResult(T data){
        super(data, true);
    }
    public SuccessDataResult(String message){
        super(null, true);
    }
    public SuccessDataResult(){
        super(null, true);
    }
}
