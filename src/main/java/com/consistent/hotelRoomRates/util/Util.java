package com.consistent.hotelRoomRates.util;


import java.io.IOException;
import java.util.HashSet;

import javax.xml.stream.XMLStreamException;

import com.consistent.hotelRoomRates.constants.Constants;
import com.consistent.hotelRoomRates.interfaces.Mapping;
import com.consistent.hotelRoomRates.interfaces.SAX;
import com.consistent.hotelRoomRates.sax.HotelMapping;
import com.consistent.hotelRoomRates.sax.MarcaMapping;
import com.consistent.hotelRoomRates.sax.RateMapping;
import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Util extends RateMapping implements SAX{
	
	//private static final Log log = LogFactoryUtil.getLog(Util.class);

	@Override
	public String getXML() throws PortalException, XMLStreamException, IOException {
		// Se iteran los rates para la inserción en marca
				final HashSet<RateMapping> rates = getArticlesByCodeBrand();
				final HotelMapping hotels = new HotelMapping();
				final Mapping mapping = new MarcaMapping("", Constants.CODIGODEMARCA, Constants.getNameBrand(Constants.CODIGODEMARCA), "", Constants.LENGUAJE, rates, hotels.getHotels());
				return mapping.getMapping();
	}	  
}


