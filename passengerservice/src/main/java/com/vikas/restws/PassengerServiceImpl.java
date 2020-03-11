package com.vikas.restws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.vikas.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;

	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println(firstName);
		System.out.println(lastName);

		System.out.println(agent);
		
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> keyHeaders = allHeaders.keySet();
		
		for (String key : keyHeaders) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKeySet = cookies.keySet();
		for (String cookieKey : cookieKeySet) {
			System.out.println("******************************Cookies*************************************");
			System.out.println(cookieKey);
			System.out.println(cookies.get(cookieKey).getValue());
		}
	}

}
