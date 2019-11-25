package EffectiveJava;

import java.util.Date;

public final class Period{
    private final Date start;
    private final Date end;

    /**
     *
     * @param start
     * @param end
     * @throws  NullPointerException
     * @throws IllegalAccessException
     */
    public Period(Date start,Date end) throws IllegalAccessException {
        /*if(start.compareTo(end)>0){
            throw new IllegalAccessException(start+"after"+end);
        }
        this.start = start;
        this.end = end;*/
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if(this.start.compareTo(this.end)>0){
            throw new IllegalAccessException(start+"after"+end);
        }
    }
    public Date getStart(){
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
