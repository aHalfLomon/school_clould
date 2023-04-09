# 校园百事通（暂定）数据库相关

## 1.用户相关

#### 1.用户信息（s_user）（不分先后顺序）

用户ID （user_ID) varchar 32 系统生成 (主键)

用户昵称（user_name）varchar <24字符

用户类别 （user_type)  varchar 3字符 包括 管理员 学生 校媒体

用户头像 （user_avatar）varchar 255字符 图床的url

用户密码 （user_passward） varchar 64

用户邮箱 (user_email) vchar 24

用户手机（user_phone）varchar 13

用户自我介绍 （user_introduct）varchar 220

创建时间 （user_create_time）data

用户状态 （user_status）int 1,2 1正常 2 异常

用户性别 （user_sex） varchar 1字符

+++++++++++++++++++++++

用户学校 （user_school) varchar 24

用户年龄   （user_age)  int

更新时间   （user_update_time）data



## 2.	学习论坛（字段不分前后）

#### 发帖相关（s_t）

帖子编号 （t_id）  varchar 32  由系统生成（主键）

发帖人id （t_uid） varchar 32 记录发帖人的ID，以展示发帖人的部分信息

发帖带的图片（t_img）varchar 255 （若考虑一个帖子里面存在多个图片，可以建立一个imgURL表 来按照ID存储帖子里的所有图片的URL）

发帖内容 （t_source）varchar 255（根据需求可能会采用更多的字段）

发帖日期（t_data）data

+++++++++++++++++++++++

帖子收藏数量 （t_usc_count）

帖子点赞数量    (t_like_count)

帖子状态 （t_status)

####  评论相关(s_tk)

评论的ID （tk_id）  varchar 32 系统自动生成 （主键）

评论的用户id （tk_uid）bigint 由此来展示评论用户的具体信息

评论内容 (tk_source) varchar 255 可以使用更多的字段

评论时间（tk_data）data 发表评论的时间

#### 点赞相关(s-like)

帖子ID  （like_sid） varchar 32（主） 

点赞用户ID （like_uid） varchar 32

点赞时间 （like_data）data 可用来按时间排序，来展示用户的点赞帖子

#### 收藏相关（s_usc）

收藏帖子ID  （usc_sid） varchar 32（主） 

点赞用户ID （usc_uid） varchar 32

点赞时间 （usc_data）data 可用来按时间排序，来展示用户的收藏帖子

## 3.二手市场

### 商品相关

#### 商品信息（shop_mess）

商品ID （shop)_id） varchar 32(主键)

商品名称（shop_name）varchar 64

商品介绍 （shop_intuoduct）varchar 255

发售用户ID （shop_uid）  varchar 32

是否被购买 （shop_buy） int  1 

发售时间（shop_data） data

+++++++++++++++++++++++++++++++++++++++++++++

商品价格 (shop_price)

#### 购买信息（buy_mess）

订单号（buy_id） varchar 32(主键)

购买用户（buy_uid） varchar 32

交易状态 （buy)_state）int 1

购买时间（buy_data）data

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

商品ID （shop)_id） varchar 32(主键)

商品名称（shop_name）varchar 64

商品介绍 （shop_intuoduct）varchar 255

商品图片url （s_img_url）varcahr 255

#### 商品图片相关（shop_img）

图片url （s_img_url）varcahr 255

图片所属商品ID（s_img_sid） varchar 32

图片编号 （s_img）int 在商品详情页展示的顺序

## 4.求助，反馈相关

### 求助信息(hlep_mess)

求助，反馈ID（h_id） varchar 32

求助，反馈人 （h_uid） varchar 32展示发起人的部分基本信息

求助，反馈内容 （h_source）varchar 255

解决状态 （h_state）int 1字节 0待解决 1解决

求助、反馈时间（h_data）data

#### 求助，反馈图片相关(hlep_img)

图片url （h_img_url）varcahr 255

图片所属求助反馈ID（h_img_sid） varchar 32

图片编号 （h_img）int 在求助，反馈详情页展示的顺序

#### 求助，反馈解决（hlep_sove）

求助，反馈ID（h_id） varchar 32

解决状态 （h_state）int 1字节 0待解决 1解决

解决方案（h_s_fa）varchar 255 可加

## 5.校园大事件/新闻

### 事件/新闻相关

#### 事件/新闻信息（evn_mess）

事件/新闻ID（evn_mess）  varchar 32

事件/新闻时间 （evn_data）data

事件/新闻简介 （evn_title）varchar 255

事件/新闻I图片 （evn_img） varchar 255

