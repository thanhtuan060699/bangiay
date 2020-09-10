package bandat.api.customer;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.CartDTO;
import bandat.dto.CustomerDTO;
import bandat.service.IOrderService;
import bandat.util.SessionUtil;

@RestController

@RequestMapping(value = "/api/checkout")
public class CheckOutAPI {

	@Autowired
	private JavaMailSender mailSender;
	
	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "nguyenthanhhlal123@gmail.com";
	
	@Autowired IOrderService orderService;
	
	
	@PostMapping
	public @ResponseBody Integer addOrder(@RequestBody CustomerDTO customerDTO,HttpServletRequest request) {
		List<CartDTO> cartDTOs=(List<CartDTO>) SessionUtil.getInstance().getValue(request, "carts");
		orderService.addOrderSneaker(customerDTO,cartDTOs,request);
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				emailSubject = "Bạn đã đặt hàng từ AllStore \n";
				emailMessage ="Ban da dat hang cua chung toi \n!! Đơn hàng của bạn bao gồm : \n";
				for(CartDTO cartDTO:cartDTOs) {
					emailMessage=emailMessage+" 1 doi "+cartDTO.getSneakerName()+"\n";
				}
				emailMessage=emailMessage+" Chúng tôi xin cảm ơn !! Hàng sẽ giao tới sớm nhất cho bạn";
				
				emailToRecipient = customerDTO.getEmail();

				mailSender.send(new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws Exception {

						MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
						mimeMsgHelperObj.setTo(emailToRecipient);
						mimeMsgHelperObj.setFrom(emailFromRecipient);				
						mimeMsgHelperObj.setText(emailMessage);
						mimeMsgHelperObj.setSubject(emailSubject);

						// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
					}
				});
				System.out.println("\nMessage Send Successfully.... Hurrey!\n");
				
			}
		});
		thread.start();
		SessionUtil.getInstance().removeValue(request, "carts");
		SessionUtil.getInstance().removeValue(request, "amounts");
		return 1;
	}
}
