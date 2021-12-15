package Class;

import java.util.Date;

public class LocalCall extends Call {
    private float costXJD;
    private float costXNoJD;

    public LocalCall(int callNumber, Date dateInit, Date dateFinish, Location locationSource, Location locationDestiny) {
        super(callNumber, dateInit, dateFinish, locationSource, locationDestiny);
        this.costXJD = (float) 0.2;
        this.costXNoJD = (float) 0.1;
    }

    public float getCostXJD() {
        return costXJD;
    }

    public void setCostXJD(float costXJD) {
        this.costXJD = costXJD;
    }

    public float getCostXNoJD() {
        return costXNoJD;
    }

    public void setCostXNoJD(float costXNoJD) {
        this.costXNoJD = costXNoJD;
    }

    @Override
    public double calculatePrice() {
        int days = this.getDateFinish().getDate() - this.getDateInit().getDate();
        Date dateInit = new Date(this.getDateInit().getYear(),this.getDateInit().getMonth(),this.getDateInit().getDate(),this.getDateInit().getHours(),this.getDateInit().getMinutes(),this.getDateInit().getSeconds());
        Date dateFinish = new Date(this.getDateFinish().getYear(),this.getDateFinish().getMonth(),this.getDateFinish().getDate(),this.getDateFinish().getHours(),this.getDateFinish().getMinutes(),this.getDateFinish().getSeconds());
        Date dateJobInit = new Date(dateInit.getYear(),dateInit.getMonth(),dateInit.getDate(),8,0,0);
        Date dateJobFinish = new Date(dateInit.getYear(),dateInit.getMonth(),dateInit.getDate(),20,0,0);
        Date varDay = new Date(dateInit.getYear(),dateInit.getMonth(),dateInit.getDate(),23,59,59);
        float price = 0;
        float increment = 0;
        long l;
        long day;
        long hour;
        long min;
        long s;
        float diff;

        for(int i = 0; i < days + 1 ; i++){
            if(i+1 > days){
                varDay = new Date(dateFinish.getYear(),dateFinish.getMonth(),dateFinish.getDate(),dateFinish.getHours(),dateFinish.getMinutes(),dateFinish.getSeconds());
            }
            if(dateInit.getDay() > 0 && dateInit.getDay() < 6){
                if(dateInit.getHours() < dateJobInit.getHours() && varDay.getHours() > dateJobFinish.getHours()){
                    l=dateJobInit.getTime()-dateInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXNoJD() * diff;

                    l=dateJobFinish.getTime()-dateJobInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXJD() * diff;

                    l=varDay.getTime()-dateJobFinish.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXNoJD() * diff;

                    price = price + increment;
                }else if(dateInit.getHours() < dateJobInit.getHours() && varDay.getHours() < dateJobFinish.getHours()){
                    l=dateJobInit.getTime()-dateInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXNoJD() * diff;

                    l=varDay.getTime()-dateJobInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXJD() * diff;

                    price = price + increment;
                }else if(dateInit.getHours() > dateJobInit.getHours() && varDay.getHours() > dateJobFinish.getHours()){

                    l=dateJobFinish.getTime()-dateInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXJD() * diff;

                    l=varDay.getTime()-dateJobFinish.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXNoJD() * diff;

                    price = price + increment;
                }else if(dateInit.getHours() > dateJobInit.getHours() && varDay.getHours() < dateJobFinish.getHours()){

                    l=varDay.getTime()-dateInit.getTime();
                    day=l/(24*60*60*1000);
                    hour=(l/(60*60*1000)-day*24);
                    min=((l/(60*1000))-day*24*60-hour*60);
                    s=(l/1000-day*24*60*60-hour*60*60-min*60);
                    diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                    increment += this.getCostXJD() * diff;

                    price = price + increment;
                }
            }else{
                l=varDay.getTime()-dateInit.getTime();
                day=l/(24*60*60*1000);
                hour=(l/(60*60*1000)-day*24);
                min=((l/(60*1000))-day*24*60-hour*60);
                s=(l/1000-day*24*60*60-hour*60*60-min*60);
                diff = (s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60) / 60;

                increment += this.getCostXNoJD() * diff;

                price = price + increment;
            }
            varDay.setDate(varDay.getDate() + 1);
            dateJobFinish.setDate(dateJobFinish.getDate() + 1);
            dateJobInit.setDate(dateJobInit.getDate() + 1);
            dateInit.setDate(dateInit.getDate() + 1);
            dateInit.setHours(0);
            dateInit.setMinutes(0);
            dateInit.setSeconds(0);
            increment = 0;
        }

        return Math.floor(price * 100)/ 100;
    }
}
