package com.guillermoceballos.dropwizardredis.resources;

import com.google.inject.Inject;
import com.guillermoceballos.dropwizardredis.data.Post;
import com.guillermoceballos.dropwizardredis.util.JsonUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
public class PostResource
{
	private final JedisPool jedisPool;

	@Inject
	public PostResource(JedisPool jedisPool)
	{
		this.jedisPool = jedisPool;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPost(Post post)
	{
		Jedis jedis = jedisPool.getResource();

		Long id = jedis.incr(Post.ID_KEY);
		post.setId(id);

		jedis.set(Post.POST_KEY+id, JsonUtil.toJson(post));

		return Response.created(UriBuilder.fromResource(PostResource.class).build(id)).build();
	}
}
