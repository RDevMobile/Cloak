package com.RDev.cloak.app;

import com.parse.Parse;
import com.parse.PushService;

public class Application extends android.app.Application {

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "xgsso9bGb2buDFUcIsGY2tGXYUTVXlBKHIqc496i", "lFGorxlMddZv2TRbkp0aGfLSi1CHDxSe2PRS5c4u");


        PushService.setDefaultPushCallback(this, MainActivity.class);
    }
}



