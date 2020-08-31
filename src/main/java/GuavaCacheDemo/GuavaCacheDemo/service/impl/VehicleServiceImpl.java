package GuavaCacheDemo.GuavaCacheDemo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import GuavaCacheDemo.GuavaCacheDemo.config.CacheConfig;
import GuavaCacheDemo.GuavaCacheDemo.entity.Vehicle;
import GuavaCacheDemo.GuavaCacheDemo.repository.VehicleRepository;
import GuavaCacheDemo.GuavaCacheDemo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Override
  public String addVehicle(Vehicle vehicle) {
    return vehicleRepository.save(vehicle).getId();
  }

  @Override
  @Cacheable(cacheNames = CacheConfig.CACHE_ONE, key = "#modelCode", cacheManager = "cacheManager")
  public Vehicle getVehicle(String modelCode) {
    return vehicleRepository.findByModelCode(modelCode);
  }

  @Override
  @CacheEvict(cacheNames = CacheConfig.CACHE_ONE, key = "#vehicle.modelCode", cacheManager = "cacheManager")
  public Vehicle updateVehicle(Vehicle vehicle) {
    Vehicle savedVehicle = vehicleRepository.getOne(getVehicle(vehicle.getModelCode()).getId());
    BeanUtils.copyProperties(vehicle, savedVehicle, "id");
    vehicleRepository.save(savedVehicle);
    return savedVehicle;
  }

  @Override
  @CacheEvict(cacheNames = CacheConfig.CACHE_ONE, key = "#modelCode",  cacheManager = "cacheManager")
  public String deleteVehicle(String modelCode) {
   Vehicle vehicle= getVehicle(modelCode);
   vehicleRepository.delete(vehicle.getId());
   return vehicle.getId();
  }
}
