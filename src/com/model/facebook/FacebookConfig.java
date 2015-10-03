package com.model.facebook;

/**
 * Created by heitor on 02/10/15.
 */
public class FacebookConfig {
    private String appID;
    private String appSecret;
    private String accessToken;

    public FacebookConfig(String appID, String appSecret, String accessToken) {
        super();
        this.appID = appID;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
