package com.consistent.hotelRoomRates.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author bernardohernadez
 */
@ApplicationPath("/serv-rate")
@Component(immediate = true, 	service = Application.class
)
public class ServiceHotelRoomRatesApplication extends Application {

	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new ServiceRest());
		return singletons;
	}

}