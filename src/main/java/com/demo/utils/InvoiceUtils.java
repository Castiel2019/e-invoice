package com.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.constant.InvoiceConstants;
import com.demo.entity.Invoice;
import com.demo.entity.InvoiceToken;
import com.demo.model.ResultBean;
import com.demo.service.InvoiceService;
import com.demo.service.InvoiceTokenService;
import nuonuo.open.sdk.NNOpenSDK;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class InvoiceUtils {

    @Autowired
    private InvoiceTokenService invoiceTokenService;
    @Autowired
    private InvoiceService invoiceService;



    /**
     * 获取token的方法
     * @return
     */
    private String getInvoiceToken() {
        String token;
        InvoiceToken appToken = new InvoiceToken();
        InvoiceToken appToken2 = invoiceTokenService.selectByPrimaryKey(1);
        if (null == appToken2) {
            String json = NNOpenSDK.getIntance().getMerchantToken(InvoiceConstants.TEST_APP_KEY, InvoiceConstants.TEST_APP_SECRET);
            JSONObject newresult = JSONObject.parseObject(json);
            token = (String) newresult.get("access_token");
            Integer expiresIn = (Integer) newresult.get("expires_in");
            appToken.setAccessToken(token);
            appToken.setExpiresIn(expiresIn);
            int insert = invoiceTokenService.insert(appToken);
            System.out.println(insert);
        } else {
            long expiresIn2 = ((Number) appToken2.getExpiresIn()).longValue();
            Date creatTime = appToken2.getCreatTime();
            Calendar dateOne = Calendar.getInstance();
            Calendar dateTwo = Calendar.getInstance();
            dateOne.setTime(new Date());
            dateTwo.setTime(creatTime);
            long timeOne = dateOne.getTimeInMillis();
            long timeTwo = dateTwo.getTimeInMillis();
            long minute = (timeOne - timeTwo) / 1000;
            if (expiresIn2 < minute) {
                String json = NNOpenSDK.getIntance().getMerchantToken(InvoiceConstants.TEST_APP_KEY, InvoiceConstants.TEST_APP_SECRET);
                JSONObject newresult = JSONObject.parseObject(json);
                token = (String) newresult.get("access_token");
                Integer expiresIn = (Integer) newresult.get("expires_in");
                appToken.setAccessToken(token);
                appToken.setExpiresIn(expiresIn);
                appToken.setId(1);
                int insert = invoiceTokenService.updateByPrimaryKey(appToken);
                System.out.println(insert);
            } else {
                token = appToken2.getAccessToken();
            }
        }
        return token;
    }


    /**
     * 开具发票
     * @param request
     * @return
     */
    public ResultBean<String> makeInvoice(HttpServletRequest request) {
    ResultBean<String> resultBean = new ResultBean<>();
    resultBean.setCode(-1);
    String flowNo = request.getParameter("flowNo");
    String loginName = request.getParameter("loginName");
    if (StringUtils.isBlank(flowNo)) {
        resultBean.setMessage("流水号不能为空");
        return resultBean;
    }
    Map<String, Object> map = invoiceService.getAllInvoiceInfoByFlowNo(flowNo);
    NNOpenSDK sdk = NNOpenSDK.getIntance();
    String token = getInvoiceToken();
    String invoiceHead = (String) map.get("invoiceHead");
    String dutyParagraph = map.get("dutyParagraph").toString();
    String goodsName= map.get("goodsName").toString();
    String phone = map.get("phone").toString();
    String email = map.get("email").toString();
    String buyerAccount = (String) map.get("buyerAccount");
    String buyerAddress = (String) map.get("buyerAddress");
    //因为如果字符为null，会直接显示在发票上，显得很不正规，所以这里统一做判断，赋值为空字符串
    if (dutyParagraph == null) {
        dutyParagraph = "";
    }
    if (buyerAddress == null) {
        buyerAddress = "";
    }
    if (buyerAccount == null) {
        buyerAccount = "";
    }
    String num = map.get("num").toString();
    double price = Double.parseDouble(map.get("price").toString()) * 4;
    String nickname = map.get("nickname").toString();
    String flowTime = map.get("flowTime").toString();
    String receivableAmount = map.get("receivableAmount").toString();
    //一定要带转义字符标识，不然会报格式不正确
    String content = "{\"order\":"
            + "{\"invoiceDetail\":[" + "{"
            + "\"taxRate\":\"" + InvoiceConstants.TAX_RATE + "\","
            + "\"invoiceLineProperty\":\"" + InvoiceConstants.INVOICE_LINE_PROPERTY + "\","
            + "\"goodsName\":\"" + goodsName+ "\","
            + "\"specType\":\"" + InvoiceConstants.SPEC_TYPE + "\","
            + "\"taxExcludedAmount\":\"" + InvoiceConstants.TAX_EXCLUDED_AMOUNT + "\","
            + "\"favouredPolicyFlag\":\"" + InvoiceConstants.FAVOURED_POLICY_FLAG + "\","
            + "\"favouredPolicyName\":\"" + InvoiceConstants.FAVOURED_POLICY_NAME + "\","
            + "\"withTaxFlag\":\"" + InvoiceConstants.WITH_TAX_FLAG + "\","
            + "\"num\":\"" + num + "\","
            + "\"tax\":\"" + InvoiceConstants.TAX + "\","
            + "\"unit\":\"" + InvoiceConstants.UNIT + "\","
            + "\"deduction\":\"" + InvoiceConstants.DEDUCTION + "\","
            + "\"price\":\"" + price + "\","
            + "\"zeroRateFlag\":\"" + InvoiceConstants.ZERO_RATE_FLAG + "\","
            // 商品编码（商品税收分类编码开发者自行填写） N
            + "\"goodsCode\":\"" + "" + "\","
            // 自行编码（可不填） N
            + "\"selfCode\":\"" + "" + "\","
            // 含税金额，[不含税金额] + [税额] = [含税金额]，红票为负。 N
            // 不含税金额、税额、含税金额任何一个不传时，会根据传入的单价，数量进行计算，可能和实际数值存在误差，建议都传入
            + "\"taxIncludedAmount\":\"" + receivableAmount + "\"}],"
            // 购方电话 N
            + "\"buyerTel\":\"" + "" + "\","
            // 购方名称 Y
            + "\"buyerName\":\"" + invoiceHead + "\","
            // 购方地址 N
            + "\"buyerAddress\":\"" + buyerAddress + "\","
            // 购方税号（企业要填，个人可为空） N
            + "\"buyerTaxNum\":\"" + dutyParagraph + "\","
            + "\"invoiceType\":\"" + InvoiceConstants.INVOICE_TYPE + "\","
            + "\"invoiceKind\":\"" + InvoiceConstants.INVOICE_KIND + "\","
            // 购方银行账号及开户行地址 N
            + "\"buyerAccount\":\"" + buyerAccount + "\","
            + "\"listFlag\":\"" + InvoiceConstants.LIST_FLAG + "\","
            + "\"pushMode\":\"" + InvoiceConstants.PUSH_MODE + "\","
            // 购方手机（开票成功会短信提醒购方，不受推送方式影响） Y
            + "\"buyerPhone\":\"" + phone + "\","
            + "\"email\":\"" + email + "\","
            // 部门门店id（诺诺系统中的id） N
            + "\"departmentId\":\"" + "" + "\","
            // 开票员id（诺诺系统中的id） N
            + "\"clerkId\":\"" + loginName + "\","
            // 复核人 N
            + "\"checker\":\"" + "" + "\","
            // 冲红时，在备注中注明“对应正数发票代码:XXXXXXXXX号码:YYYYYYYY”文案，
            // 其中“X”为发票代码，“Y”为发票号码，可以不填，接口会自动添加该文案 N
            + "\"remark\":\"备注信息\","
            + "\"payer\":\"" + nickname + "\","
            + "\"salerAccount\":\"" + InvoiceConstants.TEST_SALER_ACCOUNT + "\","
            + "\"salerAddress\":\"" + InvoiceConstants.TEST_SALER_ADDRESS + "\","
            // 订单号（每个企业唯一） Y
            + "\"orderNo\":\"" + flowNo + "\","
            + "\"salerTel\":\"" + InvoiceConstants.TEST_SALER_TEL + "\","
            // 订单时间 Y
            + "\"invoiceDate\":\"" + flowTime + "\","
            // 冲红时填写的对应蓝票发票代码（红票必填，不满12位请左补0） N
            + "\"invoiceCode\":\"\","
            // 冲红时填写的对应蓝票发票号码（红票必填，不满8位请左补0） N
            + "\"invoiceNum\":\"\","
            // 开票员 Y
            + "\"clerk\":\"" + "" + "\","
            + "\"productOilFlag\":\"" + InvoiceConstants.PRODUCT_OIL_FLAG + "\","
            + "\"salerTaxNum\":\"" + InvoiceConstants.TEST_SALER_TAX_NUM + "\","
            // 清单项目名称:打印清单时对应发票票面项目名称
            // （listFlag为1时，此项为必填，默认为“详见销货清单”） N
            + "\"listName\":\"" + "" + "\","
            + "\"proxyInvoiceFlag\":\"" + InvoiceConstants.PROXY_INVOICE_FLAG + "\"}}";
    String senid = UUID.randomUUID().toString().replace("-", "");
    String result = sdk.sendPostSyncRequest(InvoiceConstants.TEST_URL, senid, InvoiceConstants.TEST_APP_KEY, InvoiceConstants.TEST_APP_SECRET, token, InvoiceConstants.TAX_NUM, InvoiceConstants.APPLY_METHOD, content);
    JSONObject newresult = JSONObject.parseObject(result);
    String code = newresult.getString("code");
    String describe = newresult.getString("describe");
    String result1 = newresult.getString("result");
    if (InvoiceConstants.APPLY_SUCCESS_CODE.equals(code)) {
        JSONObject newresult1 = JSONObject.parseObject(result1);
        String invoiceSerialNum = newresult1.getString("invoiceSerialNum");
        //通过发票流水号查询发票信息
        Map<String, String> map2 = getInvoiceUrlByInvoiceSerialNum(invoiceSerialNum);
        String code1 = map2.get("code");
        String statusMsg = map2.get("statusMsg");
        if (InvoiceConstants.APPLY_SUCCESS_CODE.equals(code1)) {
            String status = map2.get("status");
            Invoice invoice = new Invoice();
            invoice.setStatus(status);
            invoice.setStatusMsg(statusMsg);
            invoice.setFlowNo(flowNo);
            if (InvoiceConstants.SUCCESS_CODE.equals(status)) {
                String invoiceFileUrl = map2.get("invoiceFileUrl");
                String invoiceImageUrl = map2.get("invoiceImageUrl");
                invoice.setInvoiceSerialNum(invoiceSerialNum);
                invoice.setInvoiceFileUrl(invoiceFileUrl);
                invoice.setInvoiceImageUrl(invoiceImageUrl);
            }
            invoiceService.updateInvoice(invoice);
            resultBean.setCode(0);
            resultBean.setMessage("发票申请提交成功");
        } else {
            resultBean.setMessage(statusMsg);
        }
    } else {
        resultBean.setMessage(describe);
    }
    return resultBean;
}

    /**
     * 通过发票流水号查询发票信息
     * @param invoiceSerialNum
     * @return
     */
    public Map<String, String> getInvoiceUrlByInvoiceSerialNum(String invoiceSerialNum) {
        Map<String, String> map = new HashMap<>();
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String token = getInvoiceToken();
        String content = "{" + "\"invoiceSerialNum\":[" + invoiceSerialNum + "]" + "}";
        String senid = UUID.randomUUID().toString().replace("-", "");
        String result = sdk.sendPostSyncRequest(InvoiceConstants.TEST_URL, senid, InvoiceConstants.TEST_APP_KEY, InvoiceConstants.TEST_APP_SECRET, token, InvoiceConstants.TAX_NUM, InvoiceConstants.CHECK_METHOD, content);
        System.out.println(result);
        JSONObject newresult = JSONObject.parseObject(result);
        String code = newresult.getString("code");
        String describe = newresult.getString("describe");
        map.put("code", code);
        if (InvoiceConstants.APPLY_SUCCESS_CODE.equals(code)) {
            JSONArray eventInfoData = (JSONArray) newresult.get("result");
            JSONObject jsonArray = eventInfoData.getJSONObject(0);
            String invoiceImageUrl = jsonArray.getString("invoiceImageUrl");
            String invoiceFileUrl = jsonArray.getString("invoiceFileUrl");
            String status = jsonArray.getString("status");
            String statusMsg = jsonArray.getString("statusMsg");
            map.put("status", status);
            map.put("statusMsg", statusMsg);
            if (InvoiceConstants.SUCCESS_CODE.equals(status)) {
                map.put("invoiceFileUrl", invoiceFileUrl);
                map.put("invoiceImageUrl", invoiceImageUrl);
            }
            return map;
        } else {
            map.put("statusMsg", describe);
        }
        return map;
    }

    /**
     * 通过订单号查询发票信息
     * @param request
     * @return
     */
    public ResultBean<String> updateInvoiceStatus(HttpServletRequest request) {
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setCode(-1);
        String flowNo = request.getParameter("flowNo");
        String status = request.getParameter("status");
        if (StringUtils.isBlank(flowNo)) {
            resultBean.setMessage("流水号不能为空！");
            return resultBean;
        }
        if (StringUtils.isBlank(status)) {
            resultBean.setMessage("当前开票状态不能为空！");
            return resultBean;
        }else if(InvoiceConstants.SUCCESS_CODE.equals(status)){
            resultBean.setMessage("已经开过发票了，无需再次查询！");
            return resultBean;
        }
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String token = getInvoiceToken();
        System.out.println(token);
        String content = "{" + "\"orderNo\":[" + flowNo + "]" + "}";
        String senid = UUID.randomUUID().toString().replace("-", "");
        String result = sdk.sendPostSyncRequest(InvoiceConstants.TEST_URL, senid, InvoiceConstants.TEST_APP_KEY,
                InvoiceConstants.TEST_APP_SECRET, token, InvoiceConstants.TAX_NUM, InvoiceConstants.QUERY_METHOD, content);
        System.out.println(result);
        JSONObject newresult = JSONObject.parseObject(result);
        String code = newresult.getString("code");
        String describe = newresult.getString("describe");
        if (InvoiceConstants.APPLY_SUCCESS_CODE.equals(code)) {
            JSONArray eventInfoData = (JSONArray) newresult.get("result");
            JSONObject jsonArray = eventInfoData.getJSONObject(0);
            String invoiceSerialNum = jsonArray.getString("invoiceSerialNum");
            String invoiceImageUrl = jsonArray.getString("invoiceImageUrl");
            String invoiceFileUrl = jsonArray.getString("invoiceFileUrl");
            // 开票状态：2为开票成功，其他状态分别为0:未开票;1:开票中;3:开票失败;
            String status1 = jsonArray.getString("status");
            String statusMsg = jsonArray.getString("statusMsg");
            Invoice invoice = new Invoice();
            invoice.setFlowNo(flowNo);
            invoice.setStatus(status1);
            invoice.setStatusMsg(statusMsg);
            if (InvoiceConstants.SUCCESS_CODE.equals(status1)) {
                invoice.setInvoiceSerialNum(invoiceSerialNum);
                invoice.setInvoiceFileUrl(invoiceFileUrl);
                invoice.setInvoiceImageUrl(invoiceImageUrl);
            }
            invoiceService.updateInvoice(invoice);
            resultBean.setCode(0);
            resultBean.setMessage("查询开票结果成功");
        } else {
            resultBean.setMessage(describe);
        }
        return resultBean;
    }



}
