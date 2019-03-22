package io.everitoken.sdk.java.apiResource;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.everitoken.sdk.java.param.NetParams;
import io.everitoken.sdk.java.param.TestNetNetParams;

class ApiResourceTest {

    @Test
    void get() {
        // mock Unirest to test
    }

    @Test
    void getUrl() {
        ApiResource info = new Info();
        NetParams netParams = new TestNetNetParams();
        String url = info.getUrl(netParams);
        assertTrue(url.contains("testnet1.everitoken.io"), "url of getInfo");
        assertTrue(url.endsWith("/v1/chain/get_info"), "url of getInfo");
    }

    @Test
    void equals() {
        ApiResource info = new Info();
        ApiResource info1 = new Info();
        assertTrue(info.equals(info1), "Should equal");
    }
}