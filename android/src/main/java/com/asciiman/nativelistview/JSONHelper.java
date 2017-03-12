package oley.tayfun.com.oleybulletintest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by typhoon on 12/03/2017.
 */

public class JSONHelper {

    public static String getString(JSONObject jsonObject, String name) {
        try {
            return jsonObject.getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInt(JSONObject jsonObject, String name) {
        try {
            return jsonObject.getInt(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static JSONObject getObjectAt(JSONArray jsonArray, int index) {
        try {
            return (JSONObject) jsonArray.get(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
