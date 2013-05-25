package com.guillermoceballos.dropwizardredis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil
{
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	public static final String toJson(Object o)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			return mapper.writeValueAsString(o);
		}
		catch (JsonProcessingException e)
		{
			logger.error("Json Processing was wrong", logger);
		}

		return null;
	}
}
