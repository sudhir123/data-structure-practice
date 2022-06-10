package com.prac.home.tests.old;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// user1 -> trade1{ 123, 1,user1, buy, 100, flase }  , trade1{ 123, 2,user1, buy, 50, flase } , trade1{ 123,3,user1, buy, 50, true }
//          trade1{ 234, 1,user1, buy, 50, flase }
@Data
class TradeObj {
    Integer id;
    Integer versionId; //1,2,3,4
    Integer accountId;
    String buySell;
    Integer quantity;
    Boolean cancel;
}

public class Trade{

    Map<Integer, List<TradeObj>> map;
    public static void main(String[] args) {

    }

    public List<TradeObj> generateReportEod(){
        return new ArrayList<>();
    }

    public List<TradeObj> generateReport(Integer accountId){

        Map<Integer, List<TradeObj>> intrimMap = new HashMap<>();

        Integer totalQuantity=0;
        for (TradeObj t:
            map.get(accountId)) {

            if(t.cancel){
                break;
            }else {
                if(t.buySell=="buy"){
                    totalQuantity = totalQuantity+t.quantity  ;
                }else
                    totalQuantity = totalQuantity-t.quantity  ;
            }
        }
        return new ArrayList<>();
    }

    public Map<Integer, List<TradeObj>>  addingToMapCont(TradeObj trade){
        if(map.get(trade.getAccountId())!=null){
            List<TradeObj> tObj = map.get(trade.getAccountId());
            tObj.add(trade);
            map.put(trade.getAccountId(), tObj);
        }else{
            List<TradeObj> tObj = new ArrayList<>();
            tObj.add(trade);
            map.put(trade.getAccountId(), tObj);
        }
        return map;
    }
}


