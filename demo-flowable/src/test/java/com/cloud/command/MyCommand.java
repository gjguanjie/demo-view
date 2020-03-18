package com.cloud.command;

import org.flowable.engine.common.impl.interceptor.Command;
import org.flowable.engine.common.impl.interceptor.CommandContext;
import org.flowable.task.api.Task;

public class MyCommand implements Command<Task> {
    @Override
    public Task execute(CommandContext commandContext) {
        return null;
    }
}
