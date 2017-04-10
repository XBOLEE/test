import java.util.*;
 
public class testinput
{
    public static void main(String[] args)
    {
    	Map<String, Long> map = new HashMap<String, Long>();
    	long a = 31231;
    	long b = 4545;
        map.put("A", a);
        map.put("B", b);
        //map.toString();
        System.out.println(map.toString());
        Map<String, Long> newmap = StringToMap(map.toString());
        System.out.println(newmap.toString());
    }
    
    /** 
     * String转换Map 
     *  
     * @param mapText 
     *            :需要转换的字符串 
     * @param KeySeparator 
     *            :字符串中的分隔符每一个key与value中的分割 
     * @param ElementSeparator 
     *            :字符串中每个元素的分割 
     * @return Map<?,?> 
     */  
    public static Map<String, Long> StringToMap(String mapText) {  
   
    	String str1 = mapText.replaceAll("\\{|\\}", "");
        String str2 = str1.replaceAll(" ", "");  
        String str3 = str2.replaceAll(",", "&");  
  
  
        Map<String, Long> map = null;  
        if ((null != str3) && (!"".equals(str3.trim())))  
        {  
        	String[] resArray = str3.split("&");  
        	if (0 != resArray.length)  
        	{  
        		map = new HashMap<String, Long>(resArray.length);  
        		for (String arrayStr : resArray) {  
        			if ((null != arrayStr) && (!"".equals(arrayStr.trim())))  
        			{  
        				int index = arrayStr.indexOf("=");  
        				if (-1 != index) {  
        					map.put(arrayStr.substring(0, index), Long.parseLong(arrayStr.substring(index + 1)));  
        				}  
        			}  
        		}  
        	}  
        }  
  
        return map;  
    }
}