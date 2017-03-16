/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017-02-19 20:30:18                          */
/*==============================================================*/


drop table if exists T_ARTICLE;

drop table if exists T_CATEGORY;

drop table if exists T_RE_ARTICLE_TAG;

drop table if exists T_RE_USER_ROLE;

drop table if exists T_ROLE;

drop table if exists T_TAG;

drop table if exists T_USER;

/*==============================================================*/
/* Table: T_ARTICLE                                             */
/*==============================================================*/
create table T_ARTICLE
(
   id                   bigint not null auto_increment comment '主键id',
   title                varchar(64) not null comment '文章标题',
   categoryName         varchar(16) not null comment '文章类别名称',
   author               varchar(32) not null comment '文章作者',
   summary              varchar(256) not null comment '文章摘要',
   contentFile          varchar(64) not null comment '文章正文对应的文件名',
   coverFile            varchar(64) not null comment '文章封面对应的文件名',
   itOrLife             varchar(2) not null comment 'IT/Life(01:IT技术,02:Life随笔)',
   visitCount           int not null default 0 comment '访问量',
   commentCount         int not null default 0 comment '评论量',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   updateTime           datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '上次更新时间',
   primary key (id),
   unique key AK_contentFile (contentFile)
);

alter table T_ARTICLE comment '文章表';

/*==============================================================*/
/* Table: T_CATEGORY                                            */
/*==============================================================*/
create table T_CATEGORY
(
   id                   bigint not null auto_increment comment '主键id',
   categoryName         varchar(16) not null comment '类别名称',
   itOrLife             varchar(2) not null comment 'IT/Life(01:IT技术,02:Life随笔)',
   creator              varchar(16) comment '创建者',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id),
   unique key AK_categoryName (categoryName)
);

alter table T_CATEGORY comment '文章类别表';

/*==============================================================*/
/* Table: T_RE_ARTICLE_TAG                                      */
/*==============================================================*/
create table T_RE_ARTICLE_TAG
(
   id                   bigint not null auto_increment comment '主键id',
   articleId            bigint comment '文章Id',
   tagId                bigint comment '标签id',
   primary key (id)
);

alter table T_RE_ARTICLE_TAG comment '文章标签关系表';

/*==============================================================*/
/* Table: T_RE_USER_ROLE                                        */
/*==============================================================*/
create table T_RE_USER_ROLE
(
   id                   bigint not null auto_increment comment '主键id',
   roleId               varchar(4) not null comment '角色id',
   userId               varchar(32) not null comment '用户id',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

alter table T_RE_USER_ROLE comment '用户角色权限关系表';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   id                   bigint not null auto_increment comment '主键id',
   roleId               varchar(4) not null comment '角色id',
   roleName             varchar(10) not null comment '角色名称',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id),
   unique key AK_roleId (roleId)
);

alter table T_ROLE comment '用户角色表';

/*==============================================================*/
/* Table: T_TAG                                                 */
/*==============================================================*/
create table T_TAG
(
   id                   bigint not null auto_increment comment '主键id',
   tagName              varchar(16) not null comment '标签名称',
   creator              varchar(16) comment '创建者',
   itOrLife             varchar(2) not null comment 'IT/Life(01:IT技术,02:Life随笔)',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id),
   unique key AK_tagName (tagName)
);

alter table T_TAG comment '文章标签表';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   id                   bigint not null auto_increment comment '主键id',
   userId               varchar(32) not null comment '用户id',
   userName             varchar(32) comment '用户名',
   userPassword         varchar(100) not null comment '用户密码',
   createTime           datetime default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id),
   unique key AK_userId (userId),
   unique key AK_userName (userName)
);

alter table T_USER comment '用户表';

