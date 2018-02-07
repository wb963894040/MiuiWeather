package com.hl.policeweather.net.callback;

import com.hl.policeweather.util.LogUtil;
import com.hl.policeweather.util.StringUtil;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 汪彬 on 2018/2/5.
 */

public class ShowApiStringCallback extends StringCallback
{
    @Override
    public void onSuccess(Response<String> response)
    {
        try
        {
            JSONObject object = new JSONObject(response.body());
            String msg = object.optString("showapi_res_error");
            LogUtil.d(object.toString());
            if (object.optInt("showapi_res_code") == 0)
            {
                JSONObject data = object.optJSONObject("showapi_res_body");
                if (null != data)
                {
                    onGetDataSuccess(data.toString());
                }
                else
                {
                    onGetDataError(msg);
                }
            }
            else
            {
                onGetDataError(msg);
            }
        }
        catch (JSONException e)
        {
            onGetDataError("数据返回异常");
            e.printStackTrace();
        }
    }
    
    @Override
    public void onError(Response<String> response)
    {
        super.onError(response);
        onGetDataError(response.body());
    }
    
    public void onGetDataSuccess(String data)
    {
        
    }
    
    public void onGetDataError(String msg)
    {
        
    }
}
