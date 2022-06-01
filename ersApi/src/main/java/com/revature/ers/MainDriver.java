package com.revature.ers;

import com.revature.controller.RequestMapper;
import com.revature.monitor.Monitor;

import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;

public class MainDriver {
	
	public static void main(String...args) {
		Monitor monitor = new Monitor();
		Javalin app = Javalin.create(
				config -> {
					config.registerPlugin(new MicrometerPlugin(Monitor.registry));
				}
				).start(7500);
		RequestMapper requestMapper = new RequestMapper();
		requestMapper.configureRoutes(app, monitor);
		
	}
}
