package com.cloudcross.adcross.model;

import java.util.Date;

public class CustBean {

	/* 该类只对广告主资质超管审核通过后向媒体发送及媒体审核信息的记录 */
	// 用户资质信息
	private Long customerId; // 广告主ID
	private String advertiserName; // 广告主名称
	private String contactPhone; // 联系手机
	private String customerName; // 客户名称
	private String oganizationCode; // 组织机构证号
	private String oganizationLicense; // 组织机构扫描件
	private String businessLicense; // 营业执照照片
	private String businessMd5; // 营业执照md5
	private String legalpersonIdentity; // 法人代表身份证照片
	private String taxregCert; // 完税证照片
	private String internetCulture; // 网络文化经营许可证
	private String internetMd5; // 网络文化经营许可证md5
	private String siteName; // 广告主网站名
	private String siteUrl; // 广告主网站URL
	private String companyAddress; // 公司地址
	private String capital; // 公司注册资金
	private String regAddress; // 公司注册地区
	private String brandName; // 品牌名称
	private String publishCategory; // 经营/发布产品类别
	private String extLicense; // 扩展资质文件
	private Date deadline; // 期望最晚审核时间
	// 接口信息
	private String adxApi;
	private String dspId;
	private String token;
	private String apiType;
	// 媒体审核信息
	private Long zoneid;
	private String advertiserId; // 媒体返回的广告主 id,ku6广告主id、sohu的customer key
	private String apiExtra; // 媒体返回的信息
	private Integer apiStatus; // 媒体审核状态 -1（接口请求不了），2（待审核），3（审核未通过），4（审核通过）
	private String apiRefusereason; // 媒体审核未通过的原因
	private Long updated; // 修改时间

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOganizationCode() {
		return oganizationCode;
	}

	public void setOganizationCode(String oganizationCode) {
		this.oganizationCode = oganizationCode;
	}

	public String getOganizationLicense() {
		return oganizationLicense;
	}

	public void setOganizationLicense(String oganizationLicense) {
		this.oganizationLicense = oganizationLicense;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getBusinessMd5() {
		return businessMd5;
	}

	public void setBusinessMd5(String businessMd5) {
		this.businessMd5 = businessMd5;
	}

	public String getLegalpersonIdentity() {
		return legalpersonIdentity;
	}

	public void setLegalpersonIdentity(String legalpersonIdentity) {
		this.legalpersonIdentity = legalpersonIdentity;
	}

	public String getTaxregCert() {
		return taxregCert;
	}

	public void setTaxregCert(String taxregCert) {
		this.taxregCert = taxregCert;
	}

	public String getInternetCulture() {
		return internetCulture;
	}

	public void setInternetCulture(String internetCulture) {
		this.internetCulture = internetCulture;
	}

	public String getInternetMd5() {
		return internetMd5;
	}

	public void setInternetMd5(String internetMd5) {
		this.internetMd5 = internetMd5;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getPublishCategory() {
		return publishCategory;
	}

	public void setPublishCategory(String publishCategory) {
		this.publishCategory = publishCategory;
	}

	public String getExtLicense() {
		return extLicense;
	}

	public void setExtLicense(String extLicense) {
		this.extLicense = extLicense;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getAdxApi() {
		return adxApi;
	}

	public void setAdxApi(String adxApi) {
		this.adxApi = adxApi;
	}

	public String getDspId() {
		return dspId;
	}

	public void setDspId(String dspId) {
		this.dspId = dspId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public Long getZoneid() {
		return zoneid;
	}

	public void setZoneid(Long zoneid) {
		this.zoneid = zoneid;
	}

	public String getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}

	public String getApiExtra() {
		return apiExtra;
	}

	public void setApiExtra(String apiExtra) {
		this.apiExtra = apiExtra;
	}

	public Integer getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(Integer apiStatus) {
		this.apiStatus = apiStatus;
	}

	public String getApiRefusereason() {
		return apiRefusereason;
	}

	public void setApiRefusereason(String apiRefusereason) {
		this.apiRefusereason = apiRefusereason;
	}

	public Long getUpdated() {
		return updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

}
