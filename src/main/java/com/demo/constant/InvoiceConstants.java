package com.demo.constant;

/**
 * 电子发票常量
 * @author wyx
 */
public class InvoiceConstants {

    /**
     * 授权企业税号
     */
    public static final String TAX_NUM = "**********";
    /**
     * 生产环境
     * 平台分配给应用的appKey【消息体】
     */
    public static final String APP_KEY = "**********";
    /**
     * 生产环境
     * 授权码【消息头】
     */
    public static final String APP_SECRET = "**********";
    /**
     * 沙箱环境
     * 平台分配给应用的appKey【消息体】
     */
    public static final String TEST_APP_KEY = "**********";
    /**
     * 授权码【消息头】
     */
    public static final String TEST_APP_SECRET = "**********";
    /**
     * 申请开具发票的API方法名
     */
    public static final String APPLY_METHOD = "nuonuo.electronInvoice.requestBilling";
    /**
     * 生产环境
     * 请求地址
     */
    public static final String URL = "https://sdk.nuonuo.com/open/v1/services";
    /**
     * 沙箱请求地址
     */
    public static final String TEST_URL = "https://sandbox.nuonuocs.cn/open/v1/services";
    /**
     * 开票流水号查询发票API方法名
     */
    public static final String CHECK_METHOD = "nuonuo.electronInvoice.CheckEInvoice";
    /**
     * 根据订单号，开票流水号查询
     */
    public static final String QUERY_METHOD = "nuonuo.electronInvoice.querySerialNum";
    /**
     * 售方信息
     */
    public static final String SALER_ACCOUNT = "";
    /**
     * 沙箱环境
     * 销方银行账号和开户行地址
     */
    public static final String TEST_SALER_ACCOUNT = "杭州银行彭埠支行120200590990432278";
    /**
     * 售方地址
     */
    public static final String SALER_ADDRESS = "";
    /**
     * 沙箱环境
     * 销方地址
     */
    public static final String TEST_SALER_ADDRESS = "杭州市西湖区万塘路30号高新东方科技园";
    /**
     * 销方电话
     */
    public static final String SALER_TEL = "";
    /**
     * 沙箱环境
     * 销方电话
     */
    public static final String TEST_SALER_TEL = "0571-81029365";
    /**
     * 沙箱环境
     * 销方税号
     */
    public static final String TEST_SALER_TAX_NUM ="339901999999142";
    /**
     * 税率
     */
    public static final String TAX_RATE ="0.13";
    /**
     * 发票行性质:0,正常行;1,折扣行;2,被折扣行
     */
    public static final String INVOICE_LINE_PROPERTY ="0";
    /**
     * 产品规格型号
     * specType
     */
    public static final String SPEC_TYPE ="";
    /**
     * 不含税金额。红票为负。 N
     * 不含税金额、税额、含税金额任何一个不传时，会根据传入的单价，数量进行计算，可能和实际数值存在误差，建议都传入
     * taxExcludedAmount
     */
    public static final String TAX_EXCLUDED_AMOUNT ="";
    /**
     * 优惠政策标识:0,不使用;1,使用
     */
    public static final String FAVOURED_POLICY_FLAG ="0";
    /**
     * 增值税特殊管理（优惠政策名称）,当favouredPolicyFlag为1时，此项必填 N
     */
    public static final String FAVOURED_POLICY_NAME ="";
    /**
     * 单价含税标志：0:不含税,1:含税
     */
    public static final String WITH_TAX_FLAG ="1";
    /**
     *税额，[不含税金额] * [税率] = [税额]；税额允许误差为 0.06。红票为负。
     *不含税金额、税额、含税金额任何一个不传时，会根据传入的单价，数量进行计算，可能和实际数值存在误差，建议都传入
     */
    public static final String TAX ="";
    /**
     * 产品单位
     */
    public static final String UNIT ="***";
    /**
     * 扣除额。差额征收时填写，目前只支持填写一项
     */
    public static final String DEDUCTION ="0";
    /**
     * 零税率标识:空,非零税率;1,免税;2,不征税;3,普通零税率
     */
    public static final String ZERO_RATE_FLAG ="";
    /**
     * 开票类型:1,正票;2,红票
     */
    public static final String INVOICE_TYPE ="1";
    /**
     * 发票种类:p,普通发票(电票)(默认);c,普通发票(纸票);s,专用发票;e,收购发票(电票);f,收购发票(纸质) N
     */
    public static final String INVOICE_KIND ="p";
    /**
     * 清单标志:0,根据项目名称数，自动产生清单;1,将项目信息打印至清单 N
     */
    public static final String LIST_FLAG ="0";
    /**
     * 推送方式:-1,不推送;0,邮箱;1,手机（默认）;2,邮箱、手机 N
     */
    public static final String PUSH_MODE ="2";
    /**
     * 成品油标志:0,非成品油(默认);1,成品油 N
     */
    public static final String PRODUCT_OIL_FLAG ="0";
    /**
     * 代开标志:0非代开;1代开。 N
     * 代开蓝票时备注要求填写文案：代开企业税号:***,代开企业名称:***；
     * 代开红票时备注要求填写文案：对应正数发票代码:***号码:***代开企业税号:***代开企业名称:***
     */
    public static final String PROXY_INVOICE_FLAG ="0";
    /**
     * 发票申请成功标示
     */
    public static final String APPLY_SUCCESS_CODE ="E0000";
    /**
     * 发票申请开具成功标识
     */
    public static final String SUCCESS_CODE ="2";

}
