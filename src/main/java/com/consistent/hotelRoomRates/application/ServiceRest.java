package com.consistent.hotelRoomRates.application;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLStreamException;

import com.consistent.hotelRoomRates.constants.Constants;
import com.consistent.hotelRoomRates.interfaces.SAX;
import com.consistent.hotelRoomRates.portal.Portal;
import com.consistent.hotelRoomRates.util.Util;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Path("/services/posadas")
public class ServiceRest extends Portal{
	
	private static final Log log = LogFactoryUtil.getLog(ServiceRest.class);
    
	final SAX sax = new Util();
	
	@GET
	@Path("/getHotelRoomRates")
	@Produces(MediaType.APPLICATION_XML)
	public String getRate(
			@QueryParam("siteID") String siteID,
			@QueryParam("brandcode") String brandcode,
			@QueryParam("language") String languaje,
			@QueryParam("channel") String channel,
			@QueryParam("bookingdate") String bookingdate,
			@QueryParam("hotelcode") String hotelcode,
			@QueryParam("checkindate") String checkindate,
			@QueryParam("checkoutdate") String checkoutdate) throws PortalException, IOException, XMLStreamException {
		log.info("<-------- Metodo getRateList Normal getHotelRoomRates--------->");
		// Estableciendo el siteId del sitio
		Constants.SITE_ID = Long.parseLong(siteID);
		// Estableciendo la marca
		Constants.CODIGODEMARCA = brandcode;
		// Estableciendo el lenguaje
		Constants.LENGUAJE = languaje;
		log.info("language select: "+Constants.LENGUAJE);
		// Codigo del hotel
		Constants.CODIGODEHOTEL = hotelcode;
		//Estableciendo canal
		Constants.CHANNEL = channel;
		//Fechas
		Constants.CHECKINDATE = checkindate;
		Constants.CHECKOUTDATE = checkoutdate;
		
		String xml = sax.getXML();
		log.info("<-------- Proceso finalizado getHotelRoomRates--------->");
		return xml;
	}

	@GET
	@Path("/getHotelRoomRatesOptimizado")
	@Produces(MediaType.APPLICATION_XML)
	public String getRatesOptimizado(
			@QueryParam("siteID") String siteID,
			@QueryParam("brandcode") String brandcode,
			@QueryParam("language") String languaje,
			@QueryParam("channel") String channel,
			@QueryParam("bookingdate") String bookingdate,
			@QueryParam("hotelcode") String hotelcode,
			@QueryParam("checkindate") String checkindate,
			@QueryParam("checkoutdate") String checkoutdate,
			@QueryParam("contractcodes") String contractcodes) throws PortalException, IOException, XMLStreamException {
		log.info("<-------- Metodo getRateList Optimizado --------->");	
		// Estableciendo el siteId del sitio
		Constants.SITE_ID = Long.parseLong(siteID);
		// Estableciendo la marca
		Constants.CODIGODEMARCA = brandcode;
		// Estableciendo el lenguaje
		Constants.LENGUAJE = languaje;
		log.info("language select: "+Constants.LENGUAJE);
		// Estrableciendo contractcodes
		Constants.validContractCodes(contractcodes);
		// Codigo del hotel
		Constants.CODIGODEHOTEL = hotelcode;
		//Estableciendo canal
		Constants.CHANNEL = channel;
		//Fechas
		Constants.CHECKINDATE = checkindate;
		Constants.CHECKOUTDATE = checkoutdate;
		
		String xml = sax.getXML();
		log.info("<-------- Proceso finalizado --------->");
		return xml;
	}
}

