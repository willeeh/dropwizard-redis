package com.guillermoceballos.dropwizardredis;


import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class DropwizardRedisService extends Service<ApplicationConfiguration>
{
	public static void main(String[] args) throws Exception
    {
        new DropwizardRedisService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap)
    {
        bootstrap.setName("dropwizard-redis");
        bootstrap.addBundle(GuiceBundle.newBuilder()
            .addModule(new ApplicationModule())
            .enableAutoConfig(getClass().getPackage().getName())
            .build()
        );
    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception
    {

    }
}
