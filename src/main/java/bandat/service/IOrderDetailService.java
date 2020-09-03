package bandat.service;

import java.util.List;

import bandat.dto.OrderDetailDTO;

public interface IOrderDetailService {
	public List<OrderDetailDTO> listOrderDetail(Long orderId);
}
