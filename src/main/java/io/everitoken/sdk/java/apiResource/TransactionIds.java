package io.everitoken.sdk.java.apiResource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

import io.everitoken.sdk.java.exceptions.ApiResponseException;
import io.everitoken.sdk.java.param.RequestParams;

public class TransactionIds extends ApiResource {
    private static final String uri = "/v1/chain/get_transaction_ids_for_block";

    public TransactionIds() {
        super(uri);
    }

    public TransactionIds(@NotNull ApiRequestConfig apiRequestConfig) {
        super(uri, apiRequestConfig);
    }

    public JSONArray request(RequestParams requestParams) throws ApiResponseException {
        return super.makeRequest(requestParams).getArray();
    }
}
