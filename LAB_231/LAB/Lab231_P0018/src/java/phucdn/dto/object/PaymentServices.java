/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dto.object;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PaymentServices implements Serializable{
    //PayPay client_id app.
    private static final String CLIENT_ID = "AWm0YPeqgd_Kst3FPRrnMZc0BIhS8ruRJRe3cgLZ-0er0kdCVJBVBX-PMzXoa8arYVYZI_Uf8gOE9WzN";
    //PayPal client_secret app.
    private static final String CLIENT_SECRET = "EDG6RWFhrKVXHkBILIkdd9yC6lAv_1ZrREv8T4hnT3Bc3PjPAk210G-5Ew8FBvZ7gRc8XHuhluunoFVq";

    private static final String MODE = "sandbox";

    public String authorizePayment(PaymentDTO details) throws
            PayPalRESTException {

        Payer payer = getPayerInformation();

        RedirectUrls reURLs = getRedirectUrls();

        List<Transaction> listTransaction = getTransactionInformation(details);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction)
                .setRedirectUrls(reURLs)
                .setPayer(payer)
                .setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);

        System.out.println(approvedPayment);

        return getApprovalLink(approvedPayment);
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
            }
        }
        return approvalLink;
    }

    private List<Transaction> getTransactionInformation(PaymentDTO ordDetail) {
        Details detail = new Details();
        detail.setShipping(ordDetail.getShipping());
        detail.setSubtotal(ordDetail.getSubTotal());
        detail.setTax(ordDetail.getTax());

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(ordDetail.getTotal());
        amount.setDetails(detail);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(ordDetail.getBookingID());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setCurrency("USD");
        item.setName(ordDetail.getBookingID());
        item.setPrice(ordDetail.getSubTotal());
        item.setTax(ordDetail.getTax());
        item.setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("phucdo2601@gmail.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectUrls() {
        RedirectUrls reUrls = new RedirectUrls();
        reUrls.setCancelUrl("http://localhost:8084/Lab231_P0018/cancel.jsp");
        reUrls.setReturnUrl("http://localhost:8084/Lab231_P0018/review_payment");
        return reUrls;
    }

    public Payment getPaymentDetails(String paymentID) throws PayPalRESTException {
        APIContext apiContext = null;
        try {
            apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
            return Payment.get(apiContext, paymentID);
        } catch (Exception e) {
            System.out.println("Error at getPaymentDetails....");
            e.printStackTrace();
        }
        return null;
    }

    public Payment executePayment(String paymentID, String payerID) throws PayPalRESTException {
        try {
            PaymentExecution payExecution = new PaymentExecution();
            payExecution.setPayerId(payerID);

            Payment payment = new Payment();
            payment.setId(paymentID);

            APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

            return payment.execute(apiContext, payExecution);
        } catch (Exception e) {
            System.out.println("Error at executePayment....");
            e.printStackTrace();
        }
        return null;
    }
}
