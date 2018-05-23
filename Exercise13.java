package Chapter11;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

public class Exercise13
{
    /*
    Write a method isUnique that accepts a map whose keys and values are strings as a
     parameter and returns true if no two keys map to the same value (and false if any
      two or more keys do map to the same value). For example, if the map contains the
      following key/value pairs, your method would return true:{Marty=Stepp, Stuart=Reges,
       Jessica=Miller, Amanda=Camp, Hal=Perkins}. But calling it on the following map would
        return false, because of two mappings for Perkins and Reges: {Kendrick=Perkins,
         Stuart=Reges, Jessica=Miller, Bruce=Reges, Hal=Perkins}.
     */

    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();

        map.put("Thomas", "Helmig");
        map.put("Steen", "Aldermand");
        map.put("Kaj", "Bøje");
        map.put("Anders", "Helmig");

        System.out.println(isUnique(map));

    }

    public static boolean isUnique(Map<String, String> map)
    {
        boolean isUnique = true;
        Map<String, String> copyMap = map;

        try
        {
            for (Map.Entry<String, String> m : map.entrySet())
            {
                copyMap.remove(m.getKey());
                if (copyMap.containsValue(m.getValue()) == true)
                {
                    isUnique = false;
                }
            }
        }

        catch(ConcurrentModificationException CMe)
        {
            return isUnique;
        }

        return isUnique;
    }



}
