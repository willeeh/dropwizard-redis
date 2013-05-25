package com.guillermoceballos.dropwizardredis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration
{
	@Valid
    @NotNull
    @JsonProperty
    private RedisConfiguration redis = new RedisConfiguration();

	public RedisConfiguration getRedis()
	{
		return redis;
	}
}
