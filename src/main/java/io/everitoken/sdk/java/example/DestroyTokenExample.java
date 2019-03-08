package io.everitoken.sdk.java.example;

import io.everitoken.sdk.java.PublicKey;
import io.everitoken.sdk.java.abi.DestroyTokenAction;
import io.everitoken.sdk.java.dto.TransactionData;
import io.everitoken.sdk.java.exceptions.ApiResponseException;
import io.everitoken.sdk.java.param.NetParams;
import io.everitoken.sdk.java.param.TestNetNetParams;
import io.everitoken.sdk.java.provider.KeyProvider;
import io.everitoken.sdk.java.service.TransactionConfiguration;
import io.everitoken.sdk.java.service.TransactionService;

import java.util.Arrays;

public class DestroyTokenExample {
    public static void main(String[] args) {
        NetParams netParam = new TestNetNetParams();

        DestroyTokenAction destroyTokenAction = DestroyTokenAction.of(
                "test1119",
                "t4"
        );

        try {
            TransactionService transactionService = TransactionService.of(netParam);
            TransactionConfiguration trxConfig = new TransactionConfiguration(
                    1000000,
                    PublicKey.of("EVT6Qz3wuRjyN6gaU3P3XRxpnEZnM4oPxortemaWDwFRvsv2FxgND"),
                    KeyProvider.of("5J1by7KRQujRdXrurEsvEr2zQGcdPaMJRjewER6XsAR2eCcpt3D")
            );

            TransactionData txData = transactionService.push(trxConfig, Arrays.asList(destroyTokenAction));
            System.out.println(txData.getTrxId());
        } catch (ApiResponseException ex) {
            System.out.println(ex.getRaw());
        }
    }
}
