# web测试报告
# 目录
## 0. 版本管理
## 1. 引言
### 1.1 目的
### 1.2 背景
### 1.3 参考文献
## 2. 总体描述
### 2.1 测试方法
### 2.2 测试范围
## 3. 测试结果

### 3.1 客户测试结果
#### 3.1.1 客户注册账号
#### 3.1.2 客户浏览、修改个人基本信息
#### 3.1.3 客户浏览酒店信息
##### 3.1.3.1 客户浏览首页、选择酒店
##### 3.1.3.2 客户浏览酒店名称、地址、星级、酒店简介、房间信息等
##### 3.1.3.3 客户浏览酒店详情
#### 3.1.4 客户预订酒店
##### 3.1.4.1 选择酒店、选择房间
##### 3.1.4.2 填写入住信息、选择优惠策略
##### 3.1.4.3 判断VIP优惠
#### 3.1.5 客户在入住两天以前撤销订单
#### 3.1.6 客户在入住前一天撤销订单
#### 3.1.7 客户入住后评价订单
#### 3.1.8 客户查看订单详情

### 3.2 酒店工作人员测试结果
#### 3.2.1 酒店工作人员更改订单状态
##### 3.2.1.1 更改为已预订
##### 3.2.1.2 更改为已入住
##### 3.2.1.3 更改为已评价
#### 3.2.2 酒店工作人员撤销订单
#### 3.2.3 酒店工作人员删除订单
#### 3.2.4 酒店工作人员创建酒店
#### 3.2.5 酒店工作人员录入房间
#### 3.2.6 酒店工作人员删除酒店
#### 3.2.7 酒店工作人员删除房间
#### 3.2.8 酒店工作人员查看订单详情

### 3.4 营销人员测试结果
#### 3.4.1 营销人员添加优惠策略
##### 3.4.1.1 添加多间优惠
##### 3.4.1.2 添加满减优惠
##### 3.4.1.3 添加限时优惠

### 3.4 管理人员测试结果
#### 3.4.1 管理人员添加酒店工作人员账号
#### 3.4.2 管理人员注销酒店工作人员账号

## 4. 结论
##5. 附件：缺陷详细描述

## 0. 版本管理
| 组员 | 修改时间 | 修改原因 | 版本 |
| :------: | -------- | ---- | ---- |
| 戎鑫 | 6.20 | 填写内容  | 1.0 |
| 戎鑫 | 7.2 | 修改内容  | 2.0 |
## 1. 引言
### 1.1 目的
>编写本web测试报告的目的是为了测试现阶段的互联网酒店预订系统(IHRS)具备哪些功能。  
>在测试功能的同时，也将缺陷记录下来。
### 1.2 背景
>随着工作和生活节奏的加快，人们的差旅出行需要迅速提升，但是传统上的线下 酒店预订模式有着很多不方便之处：
>>* 因为目的地往往是外地，无法全面了解当地的酒店情况，选择范围大大受限， 难以选择到最适合的酒店；
>>* 提前预订的双方都有风险，酒店担心恶意预订，顾客担心酒店不符合预期；
>>* 酒店要及时掌握预订顾客的行程变化也会比较麻烦，需要频繁的长途联系；
>>* 虽然过去的体验能够给未来带来参考，但是时间一长很多信息就会被遗忘掉， 过去的参考作用就受到限制。（事实上，过去的出行体验会大大影响人们未来 的选择）
### 1.3 参考文献
>* IEEE标准
>* 软件工程2大作业需求

## 2. 总体描述
### 2.1 测试方法
>在本地建立数据库后，运行系统，在浏览器登录创建的站点，进行一系列相关操作
>，查看互联网酒店预订系统(IHRS)具备的功能数量、内容、操作结果。
### 2.2 测试范围
>在小组成员完善、补充、添加一些列功能后，互联网酒店预订系统(IHRS)所具备的功能。

## 3. 测试结果
### 3.1 客户测试结果
#### 3.1.1 客户注册账号
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/1.png)    
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/23.png)  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/2.png)  
#### 3.1.2 客户浏览、修改个人基本信息
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/3.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/11.png)  
#### 3.1.3 客户浏览酒店信息
##### 3.1.3.1 客户浏览首页、选择酒店
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/4.png)  
##### 3.1.3.2 客户通过搜索酒店名，选择酒店
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/42.png)
##### 3.1.3.3 客户通过搜索商圈，选择酒店
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/43.png)
##### 3.1.3.4 客户浏览酒店名称、地址、星级、酒店简介、房间信息等
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/5.png)  
##### 3.1.3.5 客户浏览酒店详情
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/6.png)  
#### 3.1.4 客户预订酒店
##### 3.1.4.1 选择酒店、选择房间
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/7.png)  
##### 3.1.4.2 填写入住信息、选择优惠策略
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/8.png)  
##### 3.1.4.3 判断VIP优惠
>不是VIP  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/9.png)  
>是VIP  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/10.png)  
>结果:成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/12.png)  
#### 3.1.5 客户在入住两天以前撤销订单
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/13.png)  
>结果：成功，信用值没用扣除  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/14.png)  
#### 3.1.6 客户在入住前一天撤销订单
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/13.png)  
>结果：成功，信用值扣除量为订单价值的一半  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/14.png)  
#### 3.1.7 客户入住后评价订单
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/15.png)  
>结果：成功，信用值增加  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/16.png)  
>状态改为已评价，评价按钮消失  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/17.png)  
#### 3.1.8 客户查看订单详情
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/18.png)  
>结果：成功  

### 3.2 酒店工作人员测试结果
#### 3.2.1 酒店工作人员更改订单状态
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/19.png)
##### 3.2.1.1 更改为已预订
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/20.png)
##### 3.2.1.2 更改为已入住
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/21.png)
##### 3.2.1.3 更改为已评价
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/22.png)
#### 3.2.2 酒店工作人员撤销订单
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/24.png)
>结果：成功，信用值减少量为订单价值
#### 3.2.3 酒店工作人员删除订单
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/25.png)
#### 3.2.4 酒店工作人员创建酒店
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/26.png)
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/27.png)
#### 3.2.5 酒店工作人员录入房间
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/28.png)
#### 3.2.6 酒店工作人员删除酒店
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/29.png)
#### 3.2.7 酒店工作人员删除房间
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/44.png)
#### 3.2.8 酒店工作人员查看订单详情
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/30.png)

### 3.4 营销人员测试结果
#### 3.4.1 营销人员添加优惠策略
##### 3.4.1.1 添加多间优惠
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/31.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/32.png) 
##### 3.4.1.2 添加满减优惠
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/33.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/34.png) 
##### 3.4.1.3 添加限时优惠
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/35.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/36.png) 
#### 3.4.2 营销人员删除优惠策略
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/40.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/41.png) 

### 3.4 管理人员测试结果
#### 3.4.1 管理人员添加酒店工作人员账号
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/37.png)  
>结果：成功  
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/38.png)
#### 3.4.2 管理人员注销酒店工作人员账号
![icon](https://ruangong2020.oss-cn-beijing.aliyuncs.com/39.png)

## 4. 结论
>对客户而言，互联网酒店预订系统(IHRS)已经具备基础的预定酒店功能，能完整地完成选择优惠、删除订单、评价等一些列相关操作。  
>对酒店工作人员而言，互联网酒店预订系统(IHRS)能方便地完成改变订单状态，且能添加酒店，录入房间，添加优惠策略等，能完整地建立一个酒店的服务系统。  
>对管理员而言，互联网酒店预订系统(IHRS)能方便地添加、删除酒店工作人员账户。  

##5. 附件：缺陷详细描述
###5.1 可维护性较差
>互联网酒店预订系统(IHRS)能浏览酒店详情等。
但目前并不能对其进行修改，只能通过删除、重新创建来改正错误，操作比较繁琐。
###5.2 可靠性不足
>在进行数据的下载和上传中，如果网络故障，系统很可能出现故障。