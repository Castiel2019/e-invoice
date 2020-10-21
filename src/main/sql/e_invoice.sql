/*
Navicat MySQL Data Transfer

Source Server         : e_invoice
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : e_invoice

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-10-21 10:19:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发票id',
  `bill_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '24位申请单号:12位金税盘编号+12位该红字信息表请求时间 (YYMMDDHHMMSS)',
  `buyer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购方名称',
  `buyer_tax_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购方税号',
  `buyer_tel` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购方电话',
  `buyer_address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购方地址',
  `buyer_account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购方银行账号及开户行地址',
  `buyer_email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收票人邮箱。若填入，会收到发票推送邮件',
  `buyer_phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收票人手机（开票成功会短信提醒购方，不受推送方式影响）',
  `head_type` int(11) DEFAULT NULL COMMENT '发票抬头类型:1：个人/政府事业单位；2：企业',
  `invoice_type` int(11) DEFAULT NULL COMMENT '开票类型:1,正票;2,红票',
  `invoice_kind` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票种类:p,普通发票(电票)(默认);c,普通发票(纸票);s,增值税专用发票;e,收购发票(电票);f,收购发票(纸质)',
  `invoice_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票号码',
  `old_invoice_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '对应蓝票代码，红票时有值，不满 12 位请左补0',
  `old_invoice_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '对应蓝票号码，红票时有值，不满8位请左补0',
  `seller_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销方名称',
  `seller_tax_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销方税号',
  `seller_tel` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销方电话',
  `seller_address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销方地址',
  `seller_account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '销方银行账号和开户行地址',
  `tax_amount` decimal(18,2) DEFAULT NULL COMMENT '商品税额',
  `tax_excluded_amount` decimal(18,2) DEFAULT NULL COMMENT '商品金额(不含税)',
  `tax_included_amount` decimal(18,2) DEFAULT NULL COMMENT '含税金额(税额+不含税金额)',
  `product_oil_flag` tinyint(1) DEFAULT NULL COMMENT '成品油标志:0,非成品油;1,成品油',
  `list_flag` tinyint(1) DEFAULT NULL COMMENT '清单标志:0,根据项目名称数，自动产生清单;1,将项目信息打印至清单',
  `list_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '清单项目名称:打印清单时对应发票票面项目名称（listFlag为1时，此项为必填，默认为“详见销货清单”）',
  `serial_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票请求流水号',
  `order_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '交易订单号（每个企业唯一）',
  `apply_remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '申请说明：1100000000,购方申请-已抵扣;1010000000,购方申请-未抵扣; 0000000100,销方申请(默认)',
  `apply_flag` tinyint(1) DEFAULT NULL COMMENT '申请标识：0，开票失败，1，开票成功',
  `order_date` datetime DEFAULT NULL COMMENT '订单下单时间',
  `status` int(11) DEFAULT NULL COMMENT '发票状态:2:开票完成（最终状态）;20:开票中;21:开票成功签章中;22:开票失败;24:开票成功签章失败;3:发票已作废;31:发票作废中;备注:22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；3、31只针对纸票;注：请以该状态码区分发票状态',
  `status_msg` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票状态描述',
  `fail_cause` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '失败原因',
  `cipher_text` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票密文',
  `pdf_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票pdf地址',
  `picture_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发票图片地址',
  `paper_pdf_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '纸票pdf地址',
  `ofd_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'ofd地址',
  `img_urls` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址（多个图片以逗号隔开）',
  `invoice_time` datetime DEFAULT NULL COMMENT '开票时间',
  `dept_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门门店id（诺诺系统中的id）',
  `clerk_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '开票员id（诺诺系统中的id）',
  `clerk` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '开票员',
  `payee` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收款人',
  `checker` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '复核人',
  `check_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '校验码',
  `qr_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '二维码',
  `machine_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '税控设备号（机器编码）',
  `push_mode` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '推送方式:-1,不推送;0,邮箱;1,手机（默认）;2,邮箱、手机',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `extension_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分机号',
  `terminal_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '终端号',
  `proxy_invoice_flag` tinyint(1) DEFAULT '0' COMMENT '代开标志:0非代开;1代开。代开蓝票时备注要求填写文案：代开企业税号:***,代开企业名称:***；代开红票时备注要求填写文案：对应正数发票代码:***号码:***代开企业税号:***代开企业名称:***',
  `del` tinyint(1) DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作者',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`invoice_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='电子发票表';

-- ----------------------------
-- Records of invoice
-- ----------------------------

-- ----------------------------
-- Table structure for invoice_detail
-- ----------------------------
DROP TABLE IF EXISTS `invoice_detail`;
CREATE TABLE `invoice_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编码',
  `goods_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `goods_code_abb` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编码简称',
  `self_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '企业自编码',
  `unit` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `price` decimal(18,2) DEFAULT NULL COMMENT '单价(含税)为正数，如单价含税标志withTaxFlag=1，则此项必填。',
  `tax_excluded_price` decimal(18,2) DEFAULT NULL COMMENT '单价(不含税)为正数，如单价含税标志 withTaxFlag=0，则此项必填。',
  `tax_rate` decimal(18,2) DEFAULT NULL COMMENT '税率',
  `num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '数量',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '商品金额(含税)',
  `tax_excluded_amount` decimal(18,2) DEFAULT NULL COMMENT '商品金额(不含税)',
  `tax_amount` decimal(18,2) DEFAULT NULL COMMENT '商品税额',
  `spec_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '规格型号',
  `with_tax_flag` tinyint(1) DEFAULT NULL COMMENT '单价含税标志:0,不含税;1,含税',
  `deduction` decimal(18,2) DEFAULT NULL COMMENT '扣除额，小数点后两位。差额票时有值',
  `zero_rate_flag` int(11) DEFAULT NULL COMMENT '零税率标识:空,非零税率;1,免税;2,不征税;3,普通零税率',
  `favoured_policy_flag` tinyint(1) DEFAULT NULL COMMENT '优惠政策标识:0,不使用;1,使用',
  `favoured_policy_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '优惠政策名称:即征即退、免税、简易征收等, 当优惠政策标识favouredPolicyFlag为1时，则此项必填。',
  `invoice_line_property` int(11) DEFAULT NULL COMMENT '发票行性质：0, 正常行;1,折扣行;2,被扣行',
  `del` tinyint(1) DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_user` int(11) DEFAULT NULL COMMENT '删除操作者',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='电子发票明细表';

-- ----------------------------
-- Records of invoice_detail
-- ----------------------------

-- ----------------------------
-- Table structure for invoice_token
-- ----------------------------
DROP TABLE IF EXISTS `invoice_token`;
CREATE TABLE `invoice_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'token值',
  `expires_in` bigint(20) DEFAULT NULL COMMENT 'token的有效时间',
  `creat_time` datetime DEFAULT NULL COMMENT 'token的获取时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of invoice_token
-- ----------------------------
