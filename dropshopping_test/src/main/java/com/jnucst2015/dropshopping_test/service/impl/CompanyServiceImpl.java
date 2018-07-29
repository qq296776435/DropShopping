package com.jnucst2015.dropshopping_test.service.impl;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.repository.CompanyRepository;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import com.jnucst2015.dropshopping_test.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String companyRegister(Company company) {
        String plainPwd = company.getPassword();
        company.setPassword(PasswordUtil.md5Password(plainPwd));
        companyRepository.saveAndFlush(company);
        return "";
    }

    @Override
    public String companyLogin(String username, String password, HttpSession session) {
        Company company = companyRepository.findCompanyByUsername(username);
        String pwd = company.getPassword();
        if (pwd.equals(PasswordUtil.md5Password(password))){
            session.setAttribute("companyId",company.getId());
            session.setAttribute("username",username);
            session.setAttribute("role","company");
            return "successful";
        }else {
            session.removeAttribute("username");
            session.removeAttribute("companyId");
            session.removeAttribute("role");
            return "failure";
        }
    }

    @Override
    public Company findById(Integer id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public void topup(Integer topup_num, Integer userId, String pay_pwd) {
        Company company = findById(userId);
        if (company.getPassword().equals(pay_pwd)) {
            company.setBalance(company.getBalance() + topup_num);
        }
    }

    @Override
    public void withdraw(Integer withdraw_num, Integer userId, String pay_pwd) {
        Company company = findById(userId);
        if (company.getPassword().equals(pay_pwd)) {
            company.setBalance(company.getBalance() - withdraw_num);
        }
    }
}