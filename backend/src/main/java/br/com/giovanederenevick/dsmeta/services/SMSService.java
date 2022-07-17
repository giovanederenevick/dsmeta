package br.com.giovanederenevick.dsmeta.services;

import br.com.giovanederenevick.dsmeta.entities.Sale;
import br.com.giovanederenevick.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        StringBuffer msg = new StringBuffer();
        msg.append("O vendedor ").append(sale.getSellerName());
        msg.append(" foi destaque em ").append(sale.getDate().getMonthValue()).append("/").append(sale.getDate().getYear());
        msg.append(" com um total de R$ ").append((String.format("%.2f", sale.getAmount())));

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg.toString()).create();

        log.info("twilioSid:" + twilioSid);
        log.info("twilioKey:" + twilioKey);
        log.info("twilioPhoneFrom:" + twilioPhoneFrom);
        log.info("twilioPhoneTo:" + twilioPhoneTo);
        log.info(message.getSid());
    }
}
