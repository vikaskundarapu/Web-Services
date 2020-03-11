package com.vikas.ws.saop;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.example.customerorders.CreateOrdersRequest;
import org.example.customerorders.CreateOrdersResponse;
import org.example.customerorders.CustomerOrdersPortType;
import org.example.customerorders.GetOrderRequest;
import org.example.customerorders.GetOrderResponse;
import org.example.customerorders.Order;
import org.example.customerorders.Product;

import com.vikas.ws.soap.CustomerOrdersWsImplService;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {

		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		GetOrderRequest request = new GetOrderRequest();
		request.setId(BigInteger.valueOf(1));
		GetOrderResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println(orders.size());

		CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
		createOrdersRequest.setCustomerId(BigInteger.valueOf(1));
		Order newOrder = new Order();
		newOrder.setId(BigInteger.valueOf(2));
		Product product = new Product();
		product.setId("1");
		product.setDescription("Mac Book Pro");
		product.setQuantity(BigInteger.valueOf(3));
		List<Product> productList = newOrder.getProduct();
		productList.add(product);

		createOrdersRequest.setOrder(newOrder);
		CreateOrdersResponse createOrdersResponse = customerOrdersWsImplPort.createOrders(createOrdersRequest);

		GetOrderResponse responseAfterCreation = customerOrdersWsImplPort.getOrders(request);
		List<Order> ordersAfterCreation = responseAfterCreation.getOrder();
		System.out.println("Size after creation of a new order:" + ordersAfterCreation.size());
	}

}
