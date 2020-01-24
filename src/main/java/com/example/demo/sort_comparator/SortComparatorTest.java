package com.example.demo.sort_comparator;

import org.json.JSONArray;

import java.util.*;

public class SortComparatorTest {
	public static void main(String[] args) {
		Integer[] numbers = {6, 3, 2, 9, 11, 32, 63};
		Collections.sort(Arrays.asList(numbers), new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println(Arrays.asList(numbers));
		
		
		String jsonArray = "[\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"410000\",\r\n" + 
				"          \"name\": \"河南省\",\r\n" + 
				"          \"center\": \"113.665412,34.757975\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"440000\",\r\n" + 
				"          \"name\": \"广东省\",\r\n" + 
				"          \"center\": \"113.280637,23.125178\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"150000\",\r\n" + 
				"          \"name\": \"内蒙古自治区\",\r\n" + 
				"          \"center\": \"111.670801,40.818311\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"230000\",\r\n" + 
				"          \"name\": \"黑龙江省\",\r\n" + 
				"          \"center\": \"126.642464,45.756967\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"650000\",\r\n" + 
				"          \"name\": \"新疆维吾尔自治区\",\r\n" + 
				"          \"center\": \"87.617733,43.792818\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"420000\",\r\n" + 
				"          \"name\": \"湖北省\",\r\n" + 
				"          \"center\": \"114.298572,30.584355\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"210000\",\r\n" + 
				"          \"name\": \"辽宁省\",\r\n" + 
				"          \"center\": \"123.429096,41.796767\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"370000\",\r\n" + 
				"          \"name\": \"山东省\",\r\n" + 
				"          \"center\": \"117.000923,36.675807\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"320000\",\r\n" + 
				"          \"name\": \"江苏省\",\r\n" + 
				"          \"center\": \"118.767413,32.041544\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"610000\",\r\n" + 
				"          \"name\": \"陕西省\",\r\n" + 
				"          \"center\": \"108.948024,34.263161\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"021\",\r\n" + 
				"          \"adcode\": \"310000\",\r\n" + 
				"          \"name\": \"上海市\",\r\n" + 
				"          \"center\": \"121.472644,31.231706\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"520000\",\r\n" + 
				"          \"name\": \"贵州省\",\r\n" + 
				"          \"center\": \"106.713478,26.578343\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"023\",\r\n" + 
				"          \"adcode\": \"500000\",\r\n" + 
				"          \"name\": \"重庆市\",\r\n" + 
				"          \"center\": \"106.504962,29.533155\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"540000\",\r\n" + 
				"          \"name\": \"西藏自治区\",\r\n" + 
				"          \"center\": \"91.132212,29.660361\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"340000\",\r\n" + 
				"          \"name\": \"安徽省\",\r\n" + 
				"          \"center\": \"117.283042,31.86119\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"350000\",\r\n" + 
				"          \"name\": \"福建省\",\r\n" + 
				"          \"center\": \"119.306239,26.075302\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"430000\",\r\n" + 
				"          \"name\": \"湖南省\",\r\n" + 
				"          \"center\": \"112.982279,28.19409\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"460000\",\r\n" + 
				"          \"name\": \"海南省\",\r\n" + 
				"          \"center\": \"110.33119,20.031971\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"630000\",\r\n" + 
				"          \"name\": \"青海省\",\r\n" + 
				"          \"center\": \"101.778916,36.623178\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"450000\",\r\n" + 
				"          \"name\": \"广西壮族自治区\",\r\n" + 
				"          \"center\": \"108.320004,22.82402\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"640000\",\r\n" + 
				"          \"name\": \"宁夏回族自治区\",\r\n" + 
				"          \"center\": \"106.278179,38.46637\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"360000\",\r\n" + 
				"          \"name\": \"江西省\",\r\n" + 
				"          \"center\": \"115.892151,28.676493\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"330000\",\r\n" + 
				"          \"name\": \"浙江省\",\r\n" + 
				"          \"center\": \"120.153576,30.287459\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"130000\",\r\n" + 
				"          \"name\": \"河北省\",\r\n" + 
				"          \"center\": \"114.502461,38.045474\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"1852\",\r\n" + 
				"          \"adcode\": \"810000\",\r\n" + 
				"          \"name\": \"香港特别行政区\",\r\n" + 
				"          \"center\": \"114.173355,22.320048\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"1886\",\r\n" + 
				"          \"adcode\": \"710000\",\r\n" + 
				"          \"name\": \"台湾省\",\r\n" + 
				"          \"center\": \"121.509062,25.044332\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"1853\",\r\n" + 
				"          \"adcode\": \"820000\",\r\n" + 
				"          \"name\": \"澳门特别行政区\",\r\n" + 
				"          \"center\": \"113.54909,22.198951\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"620000\",\r\n" + 
				"          \"name\": \"甘肃省\",\r\n" + 
				"          \"center\": \"103.823557,36.058039\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"510000\",\r\n" + 
				"          \"name\": \"四川省\",\r\n" + 
				"          \"center\": \"104.065735,30.659462\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"220000\",\r\n" + 
				"          \"name\": \"吉林省\",\r\n" + 
				"          \"center\": \"125.3245,43.886841\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"022\",\r\n" + 
				"          \"adcode\": \"120000\",\r\n" + 
				"          \"name\": \"天津市\",\r\n" + 
				"          \"center\": \"117.190182,39.125596\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"530000\",\r\n" + 
				"          \"name\": \"云南省\",\r\n" + 
				"          \"center\": \"102.712251,25.040609\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": \"010\",\r\n" + 
				"          \"adcode\": \"110000\",\r\n" + 
				"          \"name\": \"北京市\",\r\n" + 
				"          \"center\": \"116.405285,39.904989\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"citycode\": [],\r\n" + 
				"          \"adcode\": \"140000\",\r\n" + 
				"          \"name\": \"山西省\",\r\n" + 
				"          \"center\": \"112.549248,37.857014\",\r\n" + 
				"          \"level\": \"province\",\r\n" + 
				"          \"districts\": []\r\n" + 
				"        }\r\n" + 
				"      ]";
		JSONArray jsonArrayObject = new JSONArray(jsonArray);
		List<Object>  jsonObjectList = jsonArrayObject.toList();
		Collections.sort(jsonObjectList, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Map<String, Object> o1Map = (HashMap<String, Object>)o1;
				Map<String, Object> o2Map = (HashMap<String, Object>)o2;
				String code1=  (String) o1Map.get("adcode");
				String code2=  (String) o2Map.get("adcode");
				return Integer.valueOf(code1) - Integer.valueOf(code2);
			}
		});
		System.out.println(jsonObjectList);
	}
}
