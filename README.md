## spring security实现oauth2.0

### 演示步骤

#### 1.启动项目

#### 2.浏览器访问 
http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://www.xwdx.site

会自动跳转到到登录页面，随意输入用户名，密码123

#### 3.获取授权码code

登录成功后浏览器会重定向到

http://www.xwdx.site/?code=3HcqVW

可以看到已获取到授权码code

#### 4.通过code获取access_token

推荐使用postman

url http://localhost:8080/oauth/token

```shell
curl --location --request POST 'http://localhost:8080/oauth/token' --header 'Authorization: Basic Y2xpZW50OnNlY3JldA==' --header 'Content-Type: application/x-www-form-urlencoded' --data-urlencode 'code=ISyyMM' --data-urlencode grant_type=authorization_code' --data-urlencode 'redirect_uri=http://www.xwdx.site'
```

postman截图

![image-20220407211102662](C:\Users\metinkong\AppData\Roaming\Typora\typora-user-images\image-20220407211102662.png)



注意请求头需要填写获取授权的client_id和client_secret，由于认证方式依赖spring security，因此需要按此方式填写

![image-20220407211217228](C:\Users\metinkong\AppData\Roaming\Typora\typora-user-images\image-20220407211217228.png)