package com.cpe.common.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class AbstractRestClient {

    @Autowired
    protected Environment environment;

    protected String getServiceUrl() {
        return environment.getRequiredProperty(getKeyServiceUrl());
    }

    protected abstract String getKeyServiceUrl();
}
