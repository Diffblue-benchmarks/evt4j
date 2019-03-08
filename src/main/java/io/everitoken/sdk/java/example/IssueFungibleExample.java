package io.everitoken.sdk.java.example;

import io.everitoken.sdk.java.PublicKey;
import io.everitoken.sdk.java.abi.IssueFungibleAction;
import io.everitoken.sdk.java.dto.TransactionData;
import io.everitoken.sdk.java.exceptions.ApiResponseException;
import io.everitoken.sdk.java.param.NetParams;
import io.everitoken.sdk.java.param.TestNetNetParams;
import io.everitoken.sdk.java.provider.KeyProvider;
import io.everitoken.sdk.java.service.TransactionConfiguration;
import io.everitoken.sdk.java.service.TransactionService;

import java.util.Arrays;

public class IssueFungibleExample {
    public static void main(String[] args) {
        NetParams netParam = new TestNetNetParams();

        IssueFungibleAction issueFungibleAction = IssueFungibleAction.of(
                "200.00000 S#20",
                "EVT6Qz3wuRjyN6gaU3P3XRxpnEZnM4oPxortemaWDwFRvsv2FxgND",
                "test from java"
        );

        try {
            TransactionService transactionService = TransactionService.of(netParam);
            TransactionConfiguration trxConfig = new TransactionConfiguration(
                    1000000,
                    PublicKey.of("EVT6Qz3wuRjyN6gaU3P3XRxpnEZnM4oPxortemaWDwFRvsv2FxgND"),
                    KeyProvider.of("5J1by7KRQujRdXrurEsvEr2zQGcdPaMJRjewER6XsAR2eCcpt3D")
            );

            TransactionData txData = transactionService.push(trxConfig, Arrays.asList(issueFungibleAction));
            System.out.println(txData.getTrxId());
        } catch (ApiResponseException ex) {
            System.out.println(ex.getRaw());
        }
    }
}
