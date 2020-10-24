package com.example.demo.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONArrayDemo {
    public static void main(String[] args) {
        String homepageBlockJsonString = "{\"title\":\"超人推荐\",\"isSetBabyAge\":false,\"list\":[{\"toyStockNum\":3,\"image\":\"https://ts.zlimg.com/t/10360720142/h0.png\",\"toySKUDepot\":[{\"toyStockNum\":3,\"depotName\":\"北京\"},{\"toyStockNum\":5,\"depotName\":\"上海\"}],\"toyId\":10360720142,\"brandName\":\"Melissa&Doug\",\"toyName\":\"丹尼医生角色扮演套装\",\"ageRange\":\"3岁~6岁\"},{\"toyStockNum\":0,\"image\":\"https://ts.zlimg.com/t/10120600016/h0.png\",\"toySKUDepot\":[{\"toyStockNum\":0,\"depotName\":\"北京\"},{\"toyStockNum\":1,\"depotName\":\"上海\"}],\"toyId\":10120600016,\"brandName\":\"伟易达\",\"toyName\":\"北京-神奇轨道车消防局\",\"ageRange\":\"2岁~5岁\"},{\"toyStockNum\":6,\"image\":\"https://ts.zlimg.com/t/10240480013/h0.png\",\"toySKUDepot\":[{\"toyStockNum\":6,\"depotName\":\"北京\"},{\"toyStockNum\":3,\"depotName\":\"上海\"}],\"toyId\":10240480013,\"brandName\":\"小泰克\",\"toyName\":\"三轮滑板车（粉色）\",\"ageRange\":\"2岁~4岁\"},{\"toyStockNum\":2,\"image\":\"https://ts.zlimg.com/t/10240960016/h0.png\",\"toySKUDepot\":[{\"toyStockNum\":2,\"depotName\":\"北京\"},{\"toyStockNum\":0,\"depotName\":\"上海\"}],\"toyId\":10240960016,\"brandName\":\"培生\",\"toyName\":\"“趣鼠系列”幼儿英文启蒙中级/三鼠A(6本套装)\",\"ageRange\":\"4岁~5岁\"},{\"toyStockNum\":1,\"image\":\"https://ts.zlimg.com/t/10480720007/h0.png\",\"toySKUDepot\":[{\"toyStockNum\":1,\"depotName\":\"北京\"},{\"toyStockNum\":0,\"depotName\":\"上海\"}],\"toyId\":10480720007,\"brandName\":\"Educo\",\"toyName\":\"蒙特梭利卡片分类游戏-找方向\",\"ageRange\":\"4岁~6岁\"}],\"hpmt\":15}";
        JSONObject homepageBlockJson = new JSONObject(homepageBlockJsonString);

        System.out.println(homepageBlockJson.getJSONArray("list").length());

        JSONArray a = new JSONArray();
        a.put(100L);
        a.put(200L);
        a.put(300L);
        a.put(400L);
        a.put(500L);
        a.put(700L);
        String aString = a.toString();
        System.out.println(aString);
        JSONArray b = new JSONArray(aString);
        System.out.println(b.toString());
        for(int i = 0;i<b.length();i++){
            //JSON converts stringLong to Integer
            System.out.println((Long)b.get(i));
        }
    }
}
