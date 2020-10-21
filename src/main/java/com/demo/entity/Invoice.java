package com.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发票信息表
 * @author wyx
 */
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发票id
     */
    private Integer invoiceId;

    /**
     * 24位申请单号:12位金税盘编号+12位该红字信息表请求时间 (YYMMDDHHMMSS)
     */
    private String billNo;

    /**
     * 购方名称
     */
    private String buyerName;

    /**
     * 购方税号
     */
    private String buyerTaxNo;

    /**
     * 购方电话
     */
    private String buyerTel;

    /**
     * 购方地址
     */
    private String buyerAddress;

    /**
     * 购方银行账号及开户行地址
     */
    private String buyerAccount;

    /**
     * 收票人邮箱。若填入，会收到发票推送邮件
     */
    private String buyerEmail;

    /**
     * 收票人手机（开票成功会短信提醒购方，不受推送方式影响）
     */
    private String buyerPhone;

    /**
     * 发票抬头类型:1：个人/政府事业单位；2：企业
     */
    private Integer headType;

    /**
     * 开票类型:1,正票;2,红票
     */
    private Integer invoiceType;

    /**
     * 发票种类:p,普通发票(电票)(默认);c,普通发票(纸票);s,增值税专用发票;e,收购发票(电票);f,收购发票(纸质)
     */
    private String invoiceKind;

    /**
     * 发票代码
     */
    private String invoiceCode;

    /**
     * 发票号码
     */
    private String invoiceNum;

    /**
     * 对应蓝票代码，红票时有值，不满 12 位请左补0
     */
    private String oldInvoiceCode;

    /**
     * 对应蓝票号码，红票时有值，不满8位请左补0
     */
    private String oldInvoiceNum;

    /**
     * 销方名称
     */
    private String sellerName;

    /**
     * 销方税号
     */
    private String sellerTaxNo;

    /**
     * 销方电话
     */
    private String sellerTel;

    /**
     * 销方地址
     */
    private String sellerAddress;

    /**
     * 销方银行账号和开户行地址
     */
    private String sellerAccount;

    /**
     * 商品税额
     */
    private BigDecimal taxAmount;

    /**
     * 商品金额(不含税)
     */
    private BigDecimal taxExcludedAmount;

    /**
     * 含税金额(税额+不含税金额)
     */
    private BigDecimal taxIncludedAmount;

    /**
     * 成品油标志:0,非成品油;1,成品油
     */
    private Boolean productOilFlag;

    /**
     * 清单标志:0,根据项目名称数，自动产生清单;1,将项目信息打印至清单
     */
    private Boolean listFlag;

    /**
     * 清单项目名称:打印清单时对应发票票面项目名称（listFlag为1时，此项为必填，默认为“详见销货清单”）
     */
    private String listName;

    /**
     * 发票请求流水号
     */
    private String serialNo;

    /**
     * 交易订单号（每个企业唯一）
     */
    private String orderNo;

    /**
     * 申请说明：1100000000,购方申请-已抵扣;1010000000,购方申请-未抵扣; 0000000100,销方申请(默认)
     */
    private String applyRemark;

    /**
     * 申请标识：0，开票失败，1，开票成功
     */
    private Boolean applyFlag;

    /**
     * 订单下单时间
     */
    private Date orderDate;

    /**
     * 发票状态:2:开票完成（最终状态）;20:开票中;21:开票成功签章中;22:开票失败;24:开票成功签章失败;3:发票已作废;31:发票作废中;备注:22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；3、31只针对纸票;注：请以该状态码区分发票状态
     */
    private Integer status;

    /**
     * 发票状态描述
     */
    private String statusMsg;

    /**
     * 失败原因
     */
    private String failCause;

    /**
     * 发票密文
     */
    private String cipherText;

    /**
     * 发票pdf地址
     */
    private String pdfUrl;

    /**
     * 发票图片地址
     */
    private String pictureUrl;

    /**
     * 纸票pdf地址
     */
    private String paperPdfUrl;

    /**
     * ofd地址
     */
    private String ofdUrl;

    /**
     * 图片地址（多个图片以逗号隔开）
     */
    private String imgUrls;

    /**
     * 开票时间
     */
    private Date invoiceTime;

    /**
     * 部门门店id（诺诺系统中的id）
     */
    private String deptId;

    /**
     * 开票员id（诺诺系统中的id）
     */
    private String clerkId;

    /**
     * 开票员
     */
    private String clerk;

    /**
     * 收款人
     */
    private String payee;

    /**
     * 复核人
     */
    private String checker;

    /**
     * 校验码
     */
    private String checkCode;

    /**
     * 二维码
     */
    private String qrCode;

    /**
     * 税控设备号（机器编码）
     */
    private String machineCode;

    /**
     * 推送方式:-1,不推送;0,邮箱;1,手机（默认）;2,邮箱、手机
     */
    private String pushMode;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 分机号
     */
    private String extensionNum;

    /**
     * 终端号
     */
    private String terminalNum;

    /**
     * 代开标志:0非代开;1代开。代开蓝票时备注要求填写文案：代开企业税号:***,代开企业名称:***；代开红票时备注要求填写文案：对应正数发票代码:***号码:***代开企业税号:***代开企业名称:***
     */
    private Boolean proxyInvoiceFlag;

    /**
     * 是否删除 0:未删除 1:已删除
     */
    private Boolean del;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除操作者
     */
    private Integer deleteUser;

    /**
     * 删除时间
     */
    private Date deleteTime;


    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public Integer getHeadType() {
        return headType;
    }

    public void setHeadType(Integer headType) {
        this.headType = headType;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceKind() {
        return invoiceKind;
    }

    public void setInvoiceKind(String invoiceKind) {
        this.invoiceKind = invoiceKind;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getOldInvoiceCode() {
        return oldInvoiceCode;
    }

    public void setOldInvoiceCode(String oldInvoiceCode) {
        this.oldInvoiceCode = oldInvoiceCode;
    }

    public String getOldInvoiceNum() {
        return oldInvoiceNum;
    }

    public void setOldInvoiceNum(String oldInvoiceNum) {
        this.oldInvoiceNum = oldInvoiceNum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public void setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
    }

    public String getSellerTel() {
        return sellerTel;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTaxExcludedAmount() {
        return taxExcludedAmount;
    }

    public void setTaxExcludedAmount(BigDecimal taxExcludedAmount) {
        this.taxExcludedAmount = taxExcludedAmount;
    }

    public BigDecimal getTaxIncludedAmount() {
        return taxIncludedAmount;
    }

    public void setTaxIncludedAmount(BigDecimal taxIncludedAmount) {
        this.taxIncludedAmount = taxIncludedAmount;
    }

    public Boolean getProductOilFlag() {
        return productOilFlag;
    }

    public void setProductOilFlag(Boolean productOilFlag) {
        this.productOilFlag = productOilFlag;
    }

    public Boolean getListFlag() {
        return listFlag;
    }

    public void setListFlag(Boolean listFlag) {
        this.listFlag = listFlag;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public Boolean getApplyFlag() {
        return applyFlag;
    }

    public void setApplyFlag(Boolean applyFlag) {
        this.applyFlag = applyFlag;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getFailCause() {
        return failCause;
    }

    public void setFailCause(String failCause) {
        this.failCause = failCause;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPaperPdfUrl() {
        return paperPdfUrl;
    }

    public void setPaperPdfUrl(String paperPdfUrl) {
        this.paperPdfUrl = paperPdfUrl;
    }

    public String getOfdUrl() {
        return ofdUrl;
    }

    public void setOfdUrl(String ofdUrl) {
        this.ofdUrl = ofdUrl;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getPushMode() {
        return pushMode;
    }

    public void setPushMode(String pushMode) {
        this.pushMode = pushMode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtensionNum() {
        return extensionNum;
    }

    public void setExtensionNum(String extensionNum) {
        this.extensionNum = extensionNum;
    }

    public String getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(String terminalNum) {
        this.terminalNum = terminalNum;
    }

    public Boolean getProxyInvoiceFlag() {
        return proxyInvoiceFlag;
    }

    public void setProxyInvoiceFlag(Boolean proxyInvoiceFlag) {
        this.proxyInvoiceFlag = proxyInvoiceFlag;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(Integer deleteUser) {
        this.deleteUser = deleteUser;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Invoice other = (Invoice) that;
        return (this.getInvoiceId() == null ? other.getInvoiceId() == null : this.getInvoiceId().equals(other.getInvoiceId()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getBuyerName() == null ? other.getBuyerName() == null : this.getBuyerName().equals(other.getBuyerName()))
            && (this.getBuyerTaxNo() == null ? other.getBuyerTaxNo() == null : this.getBuyerTaxNo().equals(other.getBuyerTaxNo()))
            && (this.getBuyerTel() == null ? other.getBuyerTel() == null : this.getBuyerTel().equals(other.getBuyerTel()))
            && (this.getBuyerAddress() == null ? other.getBuyerAddress() == null : this.getBuyerAddress().equals(other.getBuyerAddress()))
            && (this.getBuyerAccount() == null ? other.getBuyerAccount() == null : this.getBuyerAccount().equals(other.getBuyerAccount()))
            && (this.getBuyerEmail() == null ? other.getBuyerEmail() == null : this.getBuyerEmail().equals(other.getBuyerEmail()))
            && (this.getBuyerPhone() == null ? other.getBuyerPhone() == null : this.getBuyerPhone().equals(other.getBuyerPhone()))
            && (this.getHeadType() == null ? other.getHeadType() == null : this.getHeadType().equals(other.getHeadType()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getInvoiceKind() == null ? other.getInvoiceKind() == null : this.getInvoiceKind().equals(other.getInvoiceKind()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getInvoiceNum() == null ? other.getInvoiceNum() == null : this.getInvoiceNum().equals(other.getInvoiceNum()))
            && (this.getOldInvoiceCode() == null ? other.getOldInvoiceCode() == null : this.getOldInvoiceCode().equals(other.getOldInvoiceCode()))
            && (this.getOldInvoiceNum() == null ? other.getOldInvoiceNum() == null : this.getOldInvoiceNum().equals(other.getOldInvoiceNum()))
            && (this.getSellerName() == null ? other.getSellerName() == null : this.getSellerName().equals(other.getSellerName()))
            && (this.getSellerTaxNo() == null ? other.getSellerTaxNo() == null : this.getSellerTaxNo().equals(other.getSellerTaxNo()))
            && (this.getSellerTel() == null ? other.getSellerTel() == null : this.getSellerTel().equals(other.getSellerTel()))
            && (this.getSellerAddress() == null ? other.getSellerAddress() == null : this.getSellerAddress().equals(other.getSellerAddress()))
            && (this.getSellerAccount() == null ? other.getSellerAccount() == null : this.getSellerAccount().equals(other.getSellerAccount()))
            && (this.getTaxAmount() == null ? other.getTaxAmount() == null : this.getTaxAmount().equals(other.getTaxAmount()))
            && (this.getTaxExcludedAmount() == null ? other.getTaxExcludedAmount() == null : this.getTaxExcludedAmount().equals(other.getTaxExcludedAmount()))
            && (this.getTaxIncludedAmount() == null ? other.getTaxIncludedAmount() == null : this.getTaxIncludedAmount().equals(other.getTaxIncludedAmount()))
            && (this.getProductOilFlag() == null ? other.getProductOilFlag() == null : this.getProductOilFlag().equals(other.getProductOilFlag()))
            && (this.getListFlag() == null ? other.getListFlag() == null : this.getListFlag().equals(other.getListFlag()))
            && (this.getListName() == null ? other.getListName() == null : this.getListName().equals(other.getListName()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getApplyRemark() == null ? other.getApplyRemark() == null : this.getApplyRemark().equals(other.getApplyRemark()))
            && (this.getApplyFlag() == null ? other.getApplyFlag() == null : this.getApplyFlag().equals(other.getApplyFlag()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusMsg() == null ? other.getStatusMsg() == null : this.getStatusMsg().equals(other.getStatusMsg()))
            && (this.getFailCause() == null ? other.getFailCause() == null : this.getFailCause().equals(other.getFailCause()))
            && (this.getCipherText() == null ? other.getCipherText() == null : this.getCipherText().equals(other.getCipherText()))
            && (this.getPdfUrl() == null ? other.getPdfUrl() == null : this.getPdfUrl().equals(other.getPdfUrl()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getPaperPdfUrl() == null ? other.getPaperPdfUrl() == null : this.getPaperPdfUrl().equals(other.getPaperPdfUrl()))
            && (this.getOfdUrl() == null ? other.getOfdUrl() == null : this.getOfdUrl().equals(other.getOfdUrl()))
            && (this.getImgUrls() == null ? other.getImgUrls() == null : this.getImgUrls().equals(other.getImgUrls()))
            && (this.getInvoiceTime() == null ? other.getInvoiceTime() == null : this.getInvoiceTime().equals(other.getInvoiceTime()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getClerkId() == null ? other.getClerkId() == null : this.getClerkId().equals(other.getClerkId()))
            && (this.getClerk() == null ? other.getClerk() == null : this.getClerk().equals(other.getClerk()))
            && (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
            && (this.getChecker() == null ? other.getChecker() == null : this.getChecker().equals(other.getChecker()))
            && (this.getCheckCode() == null ? other.getCheckCode() == null : this.getCheckCode().equals(other.getCheckCode()))
            && (this.getQrCode() == null ? other.getQrCode() == null : this.getQrCode().equals(other.getQrCode()))
            && (this.getMachineCode() == null ? other.getMachineCode() == null : this.getMachineCode().equals(other.getMachineCode()))
            && (this.getPushMode() == null ? other.getPushMode() == null : this.getPushMode().equals(other.getPushMode()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getExtensionNum() == null ? other.getExtensionNum() == null : this.getExtensionNum().equals(other.getExtensionNum()))
            && (this.getTerminalNum() == null ? other.getTerminalNum() == null : this.getTerminalNum().equals(other.getTerminalNum()))
            && (this.getProxyInvoiceFlag() == null ? other.getProxyInvoiceFlag() == null : this.getProxyInvoiceFlag().equals(other.getProxyInvoiceFlag()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteUser() == null ? other.getDeleteUser() == null : this.getDeleteUser().equals(other.getDeleteUser()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInvoiceId() == null) ? 0 : getInvoiceId().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getBuyerName() == null) ? 0 : getBuyerName().hashCode());
        result = prime * result + ((getBuyerTaxNo() == null) ? 0 : getBuyerTaxNo().hashCode());
        result = prime * result + ((getBuyerTel() == null) ? 0 : getBuyerTel().hashCode());
        result = prime * result + ((getBuyerAddress() == null) ? 0 : getBuyerAddress().hashCode());
        result = prime * result + ((getBuyerAccount() == null) ? 0 : getBuyerAccount().hashCode());
        result = prime * result + ((getBuyerEmail() == null) ? 0 : getBuyerEmail().hashCode());
        result = prime * result + ((getBuyerPhone() == null) ? 0 : getBuyerPhone().hashCode());
        result = prime * result + ((getHeadType() == null) ? 0 : getHeadType().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getInvoiceKind() == null) ? 0 : getInvoiceKind().hashCode());
        result = prime * result + ((getInvoiceCode() == null) ? 0 : getInvoiceCode().hashCode());
        result = prime * result + ((getInvoiceNum() == null) ? 0 : getInvoiceNum().hashCode());
        result = prime * result + ((getOldInvoiceCode() == null) ? 0 : getOldInvoiceCode().hashCode());
        result = prime * result + ((getOldInvoiceNum() == null) ? 0 : getOldInvoiceNum().hashCode());
        result = prime * result + ((getSellerName() == null) ? 0 : getSellerName().hashCode());
        result = prime * result + ((getSellerTaxNo() == null) ? 0 : getSellerTaxNo().hashCode());
        result = prime * result + ((getSellerTel() == null) ? 0 : getSellerTel().hashCode());
        result = prime * result + ((getSellerAddress() == null) ? 0 : getSellerAddress().hashCode());
        result = prime * result + ((getSellerAccount() == null) ? 0 : getSellerAccount().hashCode());
        result = prime * result + ((getTaxAmount() == null) ? 0 : getTaxAmount().hashCode());
        result = prime * result + ((getTaxExcludedAmount() == null) ? 0 : getTaxExcludedAmount().hashCode());
        result = prime * result + ((getTaxIncludedAmount() == null) ? 0 : getTaxIncludedAmount().hashCode());
        result = prime * result + ((getProductOilFlag() == null) ? 0 : getProductOilFlag().hashCode());
        result = prime * result + ((getListFlag() == null) ? 0 : getListFlag().hashCode());
        result = prime * result + ((getListName() == null) ? 0 : getListName().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getApplyRemark() == null) ? 0 : getApplyRemark().hashCode());
        result = prime * result + ((getApplyFlag() == null) ? 0 : getApplyFlag().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusMsg() == null) ? 0 : getStatusMsg().hashCode());
        result = prime * result + ((getFailCause() == null) ? 0 : getFailCause().hashCode());
        result = prime * result + ((getCipherText() == null) ? 0 : getCipherText().hashCode());
        result = prime * result + ((getPdfUrl() == null) ? 0 : getPdfUrl().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getPaperPdfUrl() == null) ? 0 : getPaperPdfUrl().hashCode());
        result = prime * result + ((getOfdUrl() == null) ? 0 : getOfdUrl().hashCode());
        result = prime * result + ((getImgUrls() == null) ? 0 : getImgUrls().hashCode());
        result = prime * result + ((getInvoiceTime() == null) ? 0 : getInvoiceTime().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getClerkId() == null) ? 0 : getClerkId().hashCode());
        result = prime * result + ((getClerk() == null) ? 0 : getClerk().hashCode());
        result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
        result = prime * result + ((getChecker() == null) ? 0 : getChecker().hashCode());
        result = prime * result + ((getCheckCode() == null) ? 0 : getCheckCode().hashCode());
        result = prime * result + ((getQrCode() == null) ? 0 : getQrCode().hashCode());
        result = prime * result + ((getMachineCode() == null) ? 0 : getMachineCode().hashCode());
        result = prime * result + ((getPushMode() == null) ? 0 : getPushMode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getExtensionNum() == null) ? 0 : getExtensionNum().hashCode());
        result = prime * result + ((getTerminalNum() == null) ? 0 : getTerminalNum().hashCode());
        result = prime * result + ((getProxyInvoiceFlag() == null) ? 0 : getProxyInvoiceFlag().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteUser() == null) ? 0 : getDeleteUser().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", billNo=").append(billNo);
        sb.append(", buyerName=").append(buyerName);
        sb.append(", buyerTaxNo=").append(buyerTaxNo);
        sb.append(", buyerTel=").append(buyerTel);
        sb.append(", buyerAddress=").append(buyerAddress);
        sb.append(", buyerAccount=").append(buyerAccount);
        sb.append(", buyerEmail=").append(buyerEmail);
        sb.append(", buyerPhone=").append(buyerPhone);
        sb.append(", headType=").append(headType);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", invoiceKind=").append(invoiceKind);
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", invoiceNum=").append(invoiceNum);
        sb.append(", oldInvoiceCode=").append(oldInvoiceCode);
        sb.append(", oldInvoiceNum=").append(oldInvoiceNum);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", sellerTaxNo=").append(sellerTaxNo);
        sb.append(", sellerTel=").append(sellerTel);
        sb.append(", sellerAddress=").append(sellerAddress);
        sb.append(", sellerAccount=").append(sellerAccount);
        sb.append(", taxAmount=").append(taxAmount);
        sb.append(", taxExcludedAmount=").append(taxExcludedAmount);
        sb.append(", taxIncludedAmount=").append(taxIncludedAmount);
        sb.append(", productOilFlag=").append(productOilFlag);
        sb.append(", listFlag=").append(listFlag);
        sb.append(", listName=").append(listName);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", applyRemark=").append(applyRemark);
        sb.append(", applyFlag=").append(applyFlag);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", status=").append(status);
        sb.append(", statusMsg=").append(statusMsg);
        sb.append(", failCause=").append(failCause);
        sb.append(", cipherText=").append(cipherText);
        sb.append(", pdfUrl=").append(pdfUrl);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", paperPdfUrl=").append(paperPdfUrl);
        sb.append(", ofdUrl=").append(ofdUrl);
        sb.append(", imgUrls=").append(imgUrls);
        sb.append(", invoiceTime=").append(invoiceTime);
        sb.append(", deptId=").append(deptId);
        sb.append(", clerkId=").append(clerkId);
        sb.append(", clerk=").append(clerk);
        sb.append(", payee=").append(payee);
        sb.append(", checker=").append(checker);
        sb.append(", checkCode=").append(checkCode);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", machineCode=").append(machineCode);
        sb.append(", pushMode=").append(pushMode);
        sb.append(", remark=").append(remark);
        sb.append(", extensionNum=").append(extensionNum);
        sb.append(", terminalNum=").append(terminalNum);
        sb.append(", proxyInvoiceFlag=").append(proxyInvoiceFlag);
        sb.append(", del=").append(del);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteUser=").append(deleteUser);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}