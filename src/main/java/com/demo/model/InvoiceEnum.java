package com.demo.model;

/**
 * 电子发票相关枚举类
 */
public class InvoiceEnum {


    /**
     * 发票状态：
     *      2 :开票完成（最终状态）；
     *      20:开票中;
     *      21:开票成功签章中;
     *      22:开票失败;
     *      24: 开票成功签章失败;
     *      3:发票已作废;
     *      31: 发票作废中;
     * 备注：
     *      22、24状态时，无需再查询，请确认开票失败原因以及签章失败原因；
     *      3、31只针对纸票;
     * 注：请以该状态码区分发票状态;
     *
     */
    public enum InvoiceStatus{
        INVOICING_COMPLETED(2,"开票完成"),
        INVOICING(20,"开票中"),
        INVOICING_SUCCESS_SIGNED(21,"开票成功签章中"),
        INVOICING_FAILED(22,"开票失败"),
        INVOICING_SUCCESS_SIGN_FAILED(24,"开票成功签章失败"),
        INVOICE_ABOLISHED(3,"发票已作废"),
        INVOICE_ABOLISHING(31,"发票作废中"),
        ;

        private int code;
        private String desc;


        InvoiceStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;

        }

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

    }





}
