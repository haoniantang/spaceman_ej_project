package com.briup.apps.ej.bean;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotBlank;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.order_time
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    private Long orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.total
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    @ApiParam(value = "价格",required = true)
    @NotBlank(message="价格不能为空")
    private Double total;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.customer_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    @ApiParam(value = "顾客",required = true)
    @NotBlank(message="顾客id不能为空")
    private Long customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.waiter_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    private Long waiterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_order.address_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    private Long addressId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.id
     *
     * @return the value of ej_order.id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.id
     *
     * @param id the value for ej_order.id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.order_time
     *
     * @return the value of ej_order.order_time
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Long getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.order_time
     *
     * @param orderTime the value for ej_order.order_time
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.total
     *
     * @return the value of ej_order.total
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Double getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.total
     *
     * @param total the value for ej_order.total
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.customer_id
     *
     * @return the value of ej_order.customer_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.customer_id
     *
     * @param customerId the value for ej_order.customer_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.waiter_id
     *
     * @return the value of ej_order.waiter_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Long getWaiterId() {
        return waiterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.waiter_id
     *
     * @param waiterId the value for ej_order.waiter_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_order.address_id
     *
     * @return the value of ej_order.address_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_order.address_id
     *
     * @param addressId the value for ej_order.address_id
     *
     * @mbg.generated Mon Jun 10 11:22:11 CST 2019
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}