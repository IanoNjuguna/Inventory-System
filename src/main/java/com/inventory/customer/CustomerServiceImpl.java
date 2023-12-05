package com.inventory.customer;

import org.springframework.stereotype.Service;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class CustomerServiceImpl implements ICustomerService {

}
