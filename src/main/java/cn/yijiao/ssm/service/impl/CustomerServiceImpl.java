package cn.yijiao.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yijiao.ssm.mapper.CustomerMapper;
import cn.yijiao.ssm.po.Customer;
import cn.yijiao.ssm.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public int selectCount(Customer customer) {
		return customerMapper.selectCount(customer);
	}
	

}
