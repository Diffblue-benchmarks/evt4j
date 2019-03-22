package io.everitoken.sdk.java.abi;

import com.alibaba.fastjson.annotation.JSONField;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import io.everitoken.sdk.java.dto.PushableAction;

public class CancelSuspendAction extends Abi implements PushableAction {

    @JSONField(deserialize = false, serialize = false)
    private static final String domain = ".suspend";
    private static final String name = "cancelsuspend";

    private CancelSuspendAction(String proposalName) {
        super(name, proposalName, domain);
    }

    @NotNull
    @Contract("_ -> new")
    public static CancelSuspendAction of(String proposalName) {
        return new CancelSuspendAction(proposalName);
    }

    @Override
    @JSONField(name = "name")
    public String getKey() {
        return super.getKey();
    }

    @Override
    @JSONField(name = "key")
    public String getName() {
        return super.getName();
    }
}
