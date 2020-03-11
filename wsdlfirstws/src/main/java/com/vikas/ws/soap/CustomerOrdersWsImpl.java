package com.vikas.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;
import org.example.customerorders.CreateOrdersRequest;
import org.example.customerorders.CreateOrdersResponse;
import org.example.customerorders.CustomerOrdersPortType;
import org.example.customerorders.DeleteOrderRequest;
import org.example.customerorders.DeleteOrderResponse;
import org.example.customerorders.GetOrderRequest;
import org.example.customerorders.GetOrderResponse;
import org.example.customerorders.Order;
import org.example.customerorders.Product;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<BigInteger, List<Order>>();
	int currentId;

	public CustomerOrdersWsImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));

		Product product = new Product();
		product.setId("1");
		product.setDescription("Iphone");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}

	@Override
	public GetOrderResponse getOrders(GetOrderRequest request) {
		BigInteger customerId = request.getId();
		List<Order> orders = customerOrders.get(customerId);

		GetOrderResponse response = new GetOrderResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		Order order = request.getOrder();
		List<Order> orders = customerOrders.get(customerId);
		orders.add(order);

		customerOrders.put(customerId, orders);
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(Boolean.TRUE);
		return response;
	}

	@Override
	public DeleteOrderResponse deleteOrders(DeleteOrderRequest request) {
		BigInteger customerId = request.getId();
		customerOrders.remove(customerId);
		DeleteOrderResponse response = new DeleteOrderResponse();
		response.setResult(Boolean.TRUE);
		return response;
	}

}
