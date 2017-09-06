# v2ex-Android
## step1
简单计时器
1. 写一个单例，这个单例实现一个定时任务，每隔一秒将一个int值递增，并且这个单例可以设置回调
其他对象可以注册回调，监听这个int值变化
2. 写一个service,这个service在model里注册回调，将回调回来的int值，发送给MainActivity,MainActivity展示出这个数字