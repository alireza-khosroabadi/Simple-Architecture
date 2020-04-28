package com.kh.mycore.data.network

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Branch.BranchDto
import com.kh.mycore.data.network.entities.lastVersion.LastVersionDto
import com.kh.mycore.data.network.entities.nowDate.ServerDateDto
import com.kh.mycore.data.network.entities.releaseNote.ReleaseNoteDto
import io.reactivex.Single
import retrofit2.http.*

internal interface ApiService {
    companion object {
        internal val BASE_URL: String = "http://test.com/customer/"
    }

    //Implemented in middle server
    @GET("branches")
    fun getFunds(@Header("testServer") testServer: Boolean): Single<BaseResponse<List<BranchDto>>>

    @GET("client")
    fun getLastClientVersion(@Query("client") client: String): Single<BaseResponse<LastVersionDto>>

    @GET("android/release/{cod}")
    fun releaseNotes(@Path("cod") versionCode: Int,@Header("testServer") testServer: Boolean): Single<BaseResponse<List<ReleaseNoteDto>>>

    @GET( "today")
    fun getNowDate(): Single<BaseResponse<ServerDateDto>>

}


//
//    // 2
//    @POST( "login")
//    fun loginSubmit(
//        @Body userCredential: UserCredential?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<LoginInfo?>?>?
//
//    // 3
//    @PUT( "changePassword")
//    fun changePassword(
//        @Body userPassword: UserPassword?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Boolean?>?>?
//
//    // 4
//    @POST( "logout")
//    fun logoutSubmit(@Header("testServer") testServer: Boolean): Single<DataWrapper<LogoutMessage?>?>?
//
//    // 5
//    @GET( "mobile/customers/statements")
//    fun getAccountTurnover(
//        @QueryMap(encoded = true) queryMap: Map<String?, String?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<AccountTurnoverDetails?>?>?>?
//
//    // 6
//    @GET("customers/orders")
//    fun getOrders(
//        @QueryMap(encoded = true) map: Map<String?, String?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<OrderList?>?>?
//
//
//    // 8
//    @GET( "fund/bankAccounts")
//    fun getBankAccounts(
//        @Query("lang") lang: String? /*, @Query("branchId") int branchId*/,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<FundBankAccount?>?>?>?
//
//    // 9
//    @GET( "fund/fundIssueTypes")
//    fun getFundIssueTypes(
//        @Query("lang") lang: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<FundIssueType?>?>?>?
//
//    // 10
//    @GET( "customers/customerInfo")
//    fun getProfileInfo(
//        @Query("nationalCode") nationalCode: String?,
//        @Query("lang") lang: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfileInfo?>?>?
//
//    @POST( "fund/saveIpo")
//    fun epaymentIpoRequest(
//        @Body ipoRequest: IpoRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<IpoEPaymentResponse?>?>?
//
//    @PUT( "fund/saveIpo")
//    fun editIpoRequest(
//        @Body editIpoRequest: EditIpoRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Int?>?>?
//
//    // 14
//    @POST( "fund/saveCancelOrder")
//    fun cancelOrder(
//        @Body revokeRequest: RevokeRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Int?>?>?
//
//    // 15
//    @PUT( "fund/saveCancelOrder")
//    fun editCancelOrder(
//        @Body editRevokeRequest: EditRevokeRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Int?>?>?
//
//    // 17
//    @GET( "banks")
//    fun getBanksList(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Call<List<FundBank?>?>?
//
//    // 18
//    @GET( "bankAccountTypes")
//    fun getBankTypeList(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Call<List<FundBankAccountType?>?>?
//
//
//
//    // 20
//    @GET( "fund/cancelledAndGages")
//    fun cancelGages(
//        @Query("orderDate") orderDate: String?,
//        @Query("fundOrderId") fundOrderId: Array<Int?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<CancelledGage?>?>?
//
//    // 21
//    @GET("customers/epBanks")
//    fun getEpaymentBankList(
//        @Query("lang") lang: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<EPaymentBankList?>?>?
//
//    // 30
//    @GET( "customers/fundLicenses")
//    fun getCustomerFundLicence(
//        @Query("showAll") showAll: Boolean,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<CustomerLicense?>?>?>?
//
//    // 31
//    @POST( "user/verificationCode")
//    fun getVerificationCode(
//        @Body verificationRequest: VerificationRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper?>?
//
//    // /user/new/verificationCode/validate
//    @POST( "user/new/verificationCode/validate")
//    fun getValidateCode(
//        @Body verifyRegisterCode: VerifyRegisterCode?,
//        @Header("testServer") testServer: Boolean
//    ): Call<Void?>?
//
//    // 32
//    @POST( "user/create")
//    fun createSiteUser(
//        @Body siteUserInfo: SiteUserInfo?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<SiteLoginInfo?>?>?
//
//    // 34
//    @GET( "fund/fundInfo")
//    fun getContactInfo(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ContactInfo?>?>?
//
//    // 35
//    @GET( "fund/customerProfits")
//    fun getCustomerProfits(@Header("testServer") testServer: Boolean): Single<DataWrapper<List<CustomerProfits?>?>?>?
//
//    @GET( "appParam/ABOUT_US")
//    fun getAboutUs(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<AboutUs?>?>?
//
//
//    @GET( "fund/fundInfo")
//    fun getFundInfo(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<FundInfo?>?>?
//
//    @GET( "fund/investmentManagers")
//    fun getInvestmentManagerName(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<InvestmentManagerName?>?>?>?
//
//
//    @PUT( "fund/fundOrder/cancel/{id}")
//    fun deleteOrderRequest(
//        @Path("id") orderId: Int,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<String?>?>?
//
//    @GET( "fund/customerRemains")
//    fun getCustomerRemains(
//        @QueryMap(encoded = true) map: Map<String?, String?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<RectChartDataItem?>?>?>?
//
//    @GET( "fund/navInfo")
//    fun getNavInfo(
//        @QueryMap(encoded = true) map: Map<String?, String?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<NavInfo?>?>?>?
//
//    @GET( "fund/customerAssets")
//    fun getCustomerAssets(
//        @QueryMap(encoded = true) map: Map<String?, Any?>?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<CustomerAssets?>?>?>?
//
//    @GET( "appParam/CHARTS_SHOWS_IN_FIRST")
//    fun getFundHomePageType(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<FundHomePageType?>?>?
//
//    @GET( "mobile/images")
//    fun getBannerList(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Call<List<String?>?>?
//
//
//    @POST( "user/new/verificationCode")
//    fun getNewVerificationCode(
//        @Body newVerificationCodeRequest: NewVerificationCodeRequest?,
//        @Header("testServer") testServer: Boolean
//    ): Call<Void?>?
//
//    @Multipart
//    @POST( "user/new/create")
//    fun registerCustomer(
//        @Part("json") customerInfo: CustomerInfo?,
//        @PartMap params: Map<String?, File?>?,
//        @Header("testServer") testServer: Boolean
//    ): Call<Int?>?
//
//
//    @GET( "clientVersion")
//    fun getLastClientVersion(@Query("client") client: String?): Single<DataWrapper<LastVersion?>?>?
//
//    @GET( "appParam/MOBF_CUST_SET_IS_PROFIT_ISSUE")
//    fun checkProfitIssueStatus(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @GET( "appParam/MOBF_ABILITY_TO_APPLY_ISSUANCE_WITH_RECEIPT")
//    fun checkAccessOrderReceip(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @GET( "appParam/MOBF_ABILITY_TO_APPLY_ISSUANCE_WITH_ONLINE_PAYMENT")
//    fun checkAccessOrderOnlinePayment(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @GET( "appParam/MOBF_ABILITY_TO_APPLY_REVOCATION")
//    fun checkCheckAccessCancelOrderkOnlinePayment(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @GET( "appParam/MOBF_REGISTER_NEW_INVESTOR")
//    fun checkAccessRegister(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @GET( "appParam/MOBF_SEND_VALIDATION_CODE")
//    fun checkAccessRevolkVerify(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//    @PUT( "customers/profitIssue")
//    fun editProfitIssueStatus(
//        @Query("dsCode") dsCode: String?,
//        @Query("nationalCode") nationalCode: String?
//        ,
//        @Body customerProfitIssue: CustomerProfitIssue?,
//        @Header("Content-Type") contentType: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Int?>?>?
//
//    @GET( "fund/order/estimateUnits")
//    fun getEstimatedUnits(
//        @Query("dsCode") dsCode: String?,
//        @Query("amount") amount: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<Int?>?>?
//
//    @GET( "mobile/mobileMessages")
//    fun getMessageList(
//        @Query("dsName") dsName: String?,
//        @Query("startShowDateFrom") startShowDateFrom: String?,
//        @Query("startShowDateTo") startShowDateTo: String?,
//        @Query("expireShowDateFrom") expireShowDateFrom: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<Message?>?>?>?
//
//
//
//    @POST( "fund/revokeOrder/verificationCode")
//    fun getVerifyRevokeOrder(
//        @Query("customerId") customerId: String?,
//        @Query("dsName") dsName: String?,
//        @Query("sendMethod") sendMethod: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<String?>?>?
//
//
//    @GET( "fund/order/estimateRevokeAmount")
//    fun getReceiveMoneyRevokedUnits(
//        @Query("revokedUnits") revokedUnits: String?,
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<String?>?>?
//
//
//    @GET( "sejam/profiles/isSejami")
//    fun isSejam(
//        @Query("dsCode") dsCode: String?,
//        @Query("nationalCode") nationalCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Call<Sejam?>?
//
//
//    @POST( "sejam/profiles/kycOtp")
//    fun otpSejam(
//        @Query("dsCode") dsCode: String?,
//        @Query("nationalCode") nationalCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Call<Sejam?>?
//
//
//
//    @GET( "customers/bankAccounts")
//    fun bankAccounts(
//        @Query("dsCode") dsCode: String?,
//        @Query("nationalCode") nationalCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<List<CustomerBankAccount?>?>?>?
//
//    @GET( "appParam/ABILITY_TO_CHOOSE_CUSTOMER_BANK_ACCOUNT_REVOKE_ORDER")
//    fun checkAccessRevolkBankAccouns(
//        @Query("dsCode") dsCode: String?,
//        @Header("testServer") testServer: Boolean
//    ): Single<DataWrapper<ProfitIssueStatus?>?>?
//
//
//    //** Support Service
//    //** Get Question
//    @GET( "fund/getQuestion")
//    fun getSupportQuestion(
//        @Query("dsCode") dsCode: String?
//        , @Query("nationalCode") nationalCode: String?
//        , @Query("size") size: String?
//        , @Query("page") page: String?
//        , @Header("testServer") testServer: Boolean
//    ): Call<Questions?>?
//
//    //** Send Question
//    @POST( "fund/saveQuestion")
//    fun sendSupportQuestion(
//        @Query("dsCode") dsCode: String?
//        , @Query("nationalCode") nationalCode: String?
//        , @Header("Content-Type") ContentType: String?
//        , @Header("testServer") testServer: Boolean
//        , @Body question: SendQuestion?
//    ): Call<String?>?
