package com.rsawczyn.app;

import io.dropwizard.Application;
import java.io.*;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.rsawczyn.app.resources.NumbersResource;
import com.rsawczyn.app.core.Numbers;

public class NumbersApplication extends Application<NumbersConfiguration> {
    public static void main(String[] args) throws Exception {
        new NumbersApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<NumbersConfiguration> bootstrap) {
    }

    @Override
    public void run(NumbersConfiguration configuration, Environment environment) throws FileNotFoundException  {
		final Numbers  nb = new Numbers("dane.txt"); 
        final NumbersResource resource = new NumbersResource(nb);
		environment.jersey().register(resource);
    }

}