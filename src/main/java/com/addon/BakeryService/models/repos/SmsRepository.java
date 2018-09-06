package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.addon.BakeryService.models.Sms;
import com.addon.BakeryService.models.UOM;

public interface SmsRepository extends CrudRepository<Sms, Long> {

}
