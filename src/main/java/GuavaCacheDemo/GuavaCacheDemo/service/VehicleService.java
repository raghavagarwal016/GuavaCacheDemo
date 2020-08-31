package GuavaCacheDemo.GuavaCacheDemo.service;

import GuavaCacheDemo.GuavaCacheDemo.entity.Vehicle;

public interface VehicleService {
  String addVehicle(Vehicle vehicle);
  Vehicle getVehicle(String modelCode);
  Vehicle updateVehicle(Vehicle vehicle);
  String deleteVehicle(String modelCode);
}
