package com.api.bank.accounting.mapper;

import com.api.bank.accounting.model.domain.AddressModel;
import com.api.bank.accounting.model.domain.ContactModel;
import com.api.bank.accounting.model.domain.CustomerModel;
import com.api.bank.accounting.model.dto.AddressDto;
import com.api.bank.accounting.model.dto.ContactDto;
import com.api.bank.accounting.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public static CustomerModel toSaveCustomerModel(CustomerDto customerDto, AddressDto addressDto,
                                                    ContactDto contactDto) {
        var customerModel = new CustomerModel();
        customerModel.setName(customerDto.getName());
        customerModel.setSurname(customerDto.getSurname());
        customerModel.setBirthday(customerDto.getBirthday());

        var addressModel = new AddressModel();
        addressModel.setNeighborhood(addressDto.getNeighborhood());
        addressModel.setStreet(addressDto.getStreet());
        addressModel.setStreetNumber(addressDto.getStreetNumber());
        addressModel.setCustomer(customerModel);

        var contactModel = new ContactModel();
        contactModel.setPhonePrefix(contactDto.getPhonePrefix());
        contactModel.setPhoneNumber(contactDto.getPhoneNumber());
        contactModel.setEmail(contactDto.getEmail());
        contactModel.setCustomer(customerModel);

        customerModel.setAddress(addressModel);
        customerModel.setContact(contactModel);
        return customerModel;
        /*return new CustomerModel(customerDto.getName(),
                customerDto.getSurname(),
                customerDto.getBirthday(),
                addressModel,contactModel);*/
    }

    public static CustomerModel toUpdateCustomerModel(CustomerDto customerDto, AddressDto addressDto,
                                                      ContactDto contactDto, CustomerModel customerModelOptional) {
        var customerModel = customerModelOptional;
        customerModel.setId(customerModelOptional.getId());
        customerModel.setName(customerDto.getName());
        customerModel.setSurname(customerDto.getSurname());
        customerModel.setBirthday(customerDto.getBirthday());

        var addressModel = new AddressModel();
        addressModel.setId(customerModelOptional.getAddress().getId());
        addressModel.setNeighborhood(addressDto.getNeighborhood());
        addressModel.setStreet(addressDto.getStreet());
        addressModel.setStreetNumber(addressDto.getStreetNumber());
        addressModel.setCustomer(customerModel);

        var contactModel = new ContactModel();
        contactModel.setId(customerModelOptional.getContact().getId());
        contactModel.setPhonePrefix(contactDto.getPhonePrefix());
        contactModel.setPhoneNumber(contactDto.getPhoneNumber());
        contactModel.setEmail(contactDto.getEmail());
        contactModel.setCustomer(customerModel);

        customerModel.setAddress(addressModel);
        customerModel.setContact(contactModel);
        return customerModel;
    }

    /*public static CustomerDto toCustomerDto() {
        var customerDto = new CustomerDto();
        return customerDto;
    }*/
}
