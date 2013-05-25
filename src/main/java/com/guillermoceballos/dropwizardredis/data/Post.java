package com.guillermoceballos.dropwizardredis.data;

import org.hibernate.validator.constraints.NotEmpty;

public class Post
{
	public static String ID_KEY = "counter:posts";
	public static String POST_KEY = "posts:";

	private Long id;

	@NotEmpty
    private String message;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
