package com.revature.monitor;

import java.io.File;

import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.micrometer.core.instrument.Counter;

public class Monitor {
	private Counter login = Counter
			.builder("path_to_login")
			.description("Track number of logins")
			.tag("purpose", "login tracking")
			.register(registry);
	public static PrometheusMeterRegistry registry = 
			new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

	@SuppressWarnings("resource")
	public Monitor() {
		super();
		registry.config().commonTags("application","My-First-Monitored-App");
		new ClassLoaderMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmGcMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new UptimeMetrics().bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
		new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
	}

	
	public void loginCounter() {
		this.login.increment(1);
	}
}
