# sells 微信点餐系统后台





测试号
appID：wxc19f4cd1f87ebf3c
appsecret：3bf784ecfb89a4c63c57976a26b2c63a

### scope为base
```$xslt
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc19f4cd1f87ebf3c&redirect_uri=http://isale.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
```
### scope为userinfo
```$xslt
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc19f4cd1f87ebf3c&redirect_uri=http://isale.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect

```

https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code