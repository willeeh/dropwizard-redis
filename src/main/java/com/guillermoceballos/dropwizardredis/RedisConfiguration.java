package com.guillermoceballos.dropwizardredis;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RedisConfiguration
{
	@NotEmpty
    @JsonProperty
	private String hostname;

	@Min(1)
    @Max(65535)
    @JsonProperty
	private Integer port;

	public String getHostname()
	{
		return hostname;
	}

	public void setHostname(String hostname)
	{
		this.hostname = hostname;
	}

	public Integer getPort()
	{
		return port;
	}

	public void setPort(Integer port)
	{
		this.port = port;
	}

}
